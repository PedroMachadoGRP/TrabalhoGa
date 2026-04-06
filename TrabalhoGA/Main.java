public class Main {
    
    public static void main(String[] args) {
        abrirMenu();
    }

    public static void abrirMenu() {
        boolean iniciar = true;
        boolean contaCriada = false;
        ContaBancaria contaBancaria = null;

        while (iniciar) {
            System.out.println("1 - Abrir conta");
            System.out.println("2 - Realizar deposito");
            System.out.println("3 - Realizar saque");
            System.out.println("4 - Aplicar Juros");
            System.out.println("5 - Extrato");
            System.out.println("6 - Integrantes");
            System.out.println("7 - Sair");

            int opcao = Teclado.leInt("Escolha uma das ações:");

            switch (opcao) {
                case 1:
                    if (contaCriada) {
                        System.out.println("Opcao desabilitada, ja tem uma conta");
                        break;
                    }
                    String nome = Teclado.leString("Qual o seu nome?");
                    String cpf = Teclado.leString("Qual o seu cpf");
                    int dia = Teclado.leInt("Qual o dia do seu nascimento");
                    int mes = Teclado.leInt("Qual o mes do seu nascimento");
                    int ano = Teclado.leInt("Qual o ano do seu nascimento");
                    Data dtNascimento = new Data(dia, mes, ano);
                    Cliente cliente = new Cliente(nome, cpf, dtNascimento);
                    System.out.println("Nome: " + cliente.getNome());
                    System.out.println("CPF: " + cliente.getCpf());

                    char tipoConta = Character.toUpperCase(Teclado.leChar("Tipo de conta (C - corrente, P - poupanca, I - investimento)"));

                    if (tipoConta == 'C')
                        contaBancaria = new ContaCorrente(dia, cliente);

                    if (tipoConta == 'P')
                        contaBancaria = new ContaPoupanca(cliente);

                    if (tipoConta == 'I') {
                        int diaVencimento = Teclado.leInt("Qual o dia do vencimento");
                        int mesVencimento = Teclado.leInt("Qual o mes do vencimento");
                        int anoVencimento = Teclado.leInt("Qual o ano do vencimento");
                        Data dtVencimento = new Data(diaVencimento, mesVencimento, anoVencimento);
                        contaBancaria = new ContaInvestimento(dtVencimento, cliente);
                    }

                    double depositoI = Teclado.leDouble("Qual o saldo inicial?");
                    contaBancaria.setSaldoInical(depositoI);
                    contaBancaria.setSaldoAtual(depositoI);
                    System.out.println("Saldo inicial: " + contaBancaria.getSaldoInical());
                    System.out.println("Conta criada com sucesso!");
                    contaCriada = true;
                    break;

                case 2:
                    if (!contaCriada) {
                        System.out.println("Voce deve criar uma conta primeiro");
                        break;
                    }
                    double valorDeposito = Teclado.leDouble("Qual valor voce deseja depositar?");
                    if (valorDeposito <= 0) {
                        System.out.println("O valor deve ser maior que zero.");
                        break;
                    }
                    contaBancaria.movimenta(new Operacao('D', valorDeposito));
                    System.out.println("Deposito realizado com sucesso!");
                    System.out.println("Novo saldo: " + contaBancaria.getSaldoAtual());
                    break;

                case 3:
                    if (!contaCriada) {
                        System.out.println("Voce deve criar uma conta primeiro");
                        break;
                    }
                    if (!(contaBancaria instanceof ContaCorrente || contaBancaria instanceof ContaPoupanca)) {
                        System.out.println("Saque nao disponivel para este tipo de conta!");
                        break;
                    }
                    double valorSaque = Teclado.leDouble("Qual valor voce deseja sacar?");
                    if (valorSaque <= 0) {
                        System.out.println("O valor deve ser maior que zero.");
                        break;
                    }
                    contaBancaria.movimenta(new Operacao('S', valorSaque));
                    System.out.println("Novo saldo: " + contaBancaria.getSaldoAtual());
                    break;

                case 4:
                    if (!contaCriada) {
                        System.out.println("Voce deve criar uma conta primeiro");
                        break;
                    }
                    if (!(contaBancaria instanceof ContaPoupanca || contaBancaria instanceof ContaInvestimento)) {
                        System.out.println("Juros nao disponivel para este tipo de conta!");
                        break;
                    }
                    double taxa = Teclado.leDouble("Qual a taxa de juros (%)?");
                    if (taxa <= 0) {
                        System.out.println("A taxa deve ser maior que zero.");
                        break;
                    }
                    contaBancaria.movimenta(new Operacao('J', taxa));
                    System.out.println("Novo saldo: " + contaBancaria.getSaldoAtual());
                    break;

                case 5:
                    if (!contaCriada) {
                    System.out.println("Você deve criar uma conta primeiro");
                    break;
                    }
                    System.out.println("===== EXTRATO =====");
                    System.out.println("Nome: " + contaBancaria.getCliente().getNome());
                    System.out.println("CPF: " + contaBancaria.getCliente().getCpf());
                    System.out.println("Nascimento: " + contaBancaria.getCliente().getDtNascimento());
                    System.out.println("Saldo inicial: " + contaBancaria.getSaldoInical());
                    System.out.println("Saldo atual: " + contaBancaria.getSaldoAtual());
                    System.out.println("Depositos: " + contaBancaria.getDeposito().getQuantidade() + " - Total: R$ " + contaBancaria.getDeposito().getValorTotal());
                    System.out.println("Saques: " + contaBancaria.getSaques().getQuantidade() + " - Total: R$ " + contaBancaria.getSaques().getValorTotal());
                    System.out.println("Juros: " + contaBancaria.getJuros().getQuantidade() + " - Total: R$ " + contaBancaria.getJuros().getValorTotal());
                    break;

                case 6:
                    System.out.println("===== INTEGRANTES =====");
                    System.out.println("1. Joao");
                    System.out.println("2. Otto");
                    System.out.println("3. Pedro");
                    System.out.println("4. Peterson");
                    break;

                case 7:
                    System.out.println("Saindo...");
                    iniciar = false;
                    break;

                default:
                    break;
            }
        }
    }
}