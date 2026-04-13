public class Main {

    public static void main(String[] args) {
        // Inicia o programa chamando a função do menu
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

            int opcao = Teclado.leInt("Escolha uma das açoes:");

            switch (opcao) {
                // Opção para o usuario criar uma conta
                case 1:
                    // Condicional para impedir que o usuario use a função tendo uma conta
                    if (contaCriada) {
                        System.out.println("Opcao desabilitada, ja tem uma conta");
                        break;
                    }
                    String nome = Teclado.leString("Qual o seu nome?");
                    String cpf = Teclado.leString("Qual o seu cpf");
                    int dia, mes, ano;
                    double depositoI;

                    // Rede de loopings para impossibilitar o usuario de inserir um tipo de dado
                    // diferente de int
                    while (true) {
                        dia = Teclado.leInt("Qual o dia do seu nascimento");
                        if (dia >= 1 && dia <= 31)
                            break;
                        System.out.println("Dia invalido!");
                    }
                    while (true) {
                        mes = Teclado.leInt("Qual o mes do seu nascimento");
                        if (mes >= 1 && mes <= 12)
                            break;
                        System.out.println("Mes invalido!");
                    }

                    while (true) {
                        ano = Teclado.leInt("Qual o ano do seu nascimento");
                        if (ano > 0)
                            break;
                        System.out.println("Ano invalido!");
                    }

                    Data dtNascimento = new Data(dia, mes, ano);

                    Cliente cliente = new Cliente(nome, cpf, dtNascimento);
                    System.out.println("Nome: " + cliente.getNome());
                    System.out.println("CPF: " + cliente.getCpf());

                    char tipoConta;

                    // Rede de looping para impossibilitar o usuario de inserir um dado diferente de
                    // (C - corrente, P - poupanca, I - investimento)
                    while (true) {
                        tipoConta = Character.toUpperCase(
                                Teclado.leChar("Tipo de conta (C - corrente, P - poupanca, I - investimento): "));

                        if (tipoConta == 'C') {
                            contaBancaria = new ContaCorrente(dia, cliente);
                            break;
                        } else if (tipoConta == 'P') {
                            contaBancaria = new ContaPoupanca(cliente);
                            break;
                        } else if (tipoConta == 'I') {
                            int diaVencimento, mesVencimento, anoVencimento;

                            while (true) {
                                diaVencimento = Teclado.leInt("Qual o dia do vencimento da conta?");
                                if (diaVencimento >= 1 && diaVencimento <= 31)
                                    break;
                                System.out.println("Dia invalido!");
                            }
                            while (true) {
                                mesVencimento = Teclado.leInt("Qual o mes do vencimento da conta?");
                                if (mesVencimento >= 1 && mesVencimento <= 12)
                                    break;
                                System.out.println("Mes invalido!");
                            }

                            while (true) {
                                anoVencimento = Teclado.leInt("Qual o ano do vencimento da conta?");
                                if (anoVencimento > 0)
                                    break;
                                System.out.println("Ano invalido!");
                            }

                            Data dtVencimento = new Data(diaVencimento, mesVencimento, anoVencimento);

                            contaBancaria = new ContaInvestimento(dtVencimento, cliente);
                            break;

                        } else {
                            System.out.println("Opcao invalida! Digite apenas C, P ou I.");
                        }
                    }
                    // Looping para negar caso o usuario tente colocar algo diferente de um double
                    while (true) {
                        depositoI = Teclado.leDouble("Qual o saldo inicial?");
                        if (depositoI > 0)
                            break;
                        System.out.println("Saldo invalido");
                    }

                    contaBancaria.setSaldoInical(depositoI);
                    contaBancaria.setSaldoAtual(depositoI);
                    System.out.println("Saldo inicial: " + contaBancaria.getSaldoInical());
                    System.out.println("Conta criada com sucesso!");
                    contaCriada = true;
                    break;

                // Opção para o usuario realizar um deposito
                case 2:
                    // Condicional para impedir que o usuario use a função sem ter uma conta
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

                // Opção para o Realizer um saque da conta
                case 3:
                    // Condicional para impedir que o usuario use a função sem ter uma conta
                    if (!contaCriada) {
                        System.out.println("Voce deve criar uma conta primeiro");
                        break;
                    }
                    // Condicional para impedir que o usuario com tipo de conta diferente do
                    // permitido utilize a função
                    if (!(contaBancaria instanceof ContaCorrente || contaBancaria instanceof ContaPoupanca)) {
                        System.out.println("Saque nao disponivel para este tipo de conta!");
                        break;
                    }
                    double valorSaque = Teclado.leDouble("Qual valor voce deseja sacar?");
                    if (valorSaque <= 0) {
                        System.out.println("O valor deve ser maior que zero.");
                        break;
                    }

                    boolean saqueRealizado = contaBancaria.movimenta(new Operacao('S', valorSaque));

                    if (saqueRealizado) {
                        System.out.println("O seu saque foi realizado com sucesso!");
                        System.out.println("Novo saldo da conta: " + contaBancaria.getSaldoAtual());
                    }
                    break;

                // Opção para o aplicar os juros a uma conta
                case 4:
                    // Condicional para impedir que o usuario use a função sem ter uma conta
                    if (!contaCriada) {
                        System.out.println("Voce deve criar uma conta primeiro");
                        break;
                    }
                    // Condicional para impedir que o usuario com tipo de conta diferente do
                    // permitido utilize a função
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

                // Opção para o exibir o extrato da conta do usuario
                case 5:
                    // Condicional para impedir que o usuario use a função sem ter uma conta
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
                    System.out.println("Depositos: " + contaBancaria.getDeposito().getQuantidade() + " - Total: R$ "
                            + contaBancaria.getDeposito().getValorTotal());
                    System.out.println("Saques: " + contaBancaria.getSaques().getQuantidade() + " - Total: R$ "
                            + contaBancaria.getSaques().getValorTotal());
                    System.out.println("Juros: " + contaBancaria.getJuros().getQuantidade() + " - Total: R$ "
                            + contaBancaria.getJuros().getValorTotal());
                    break;

                // Opção para mostrar os integrante do grupo que realizaram o trabalho
                case 6:
                    System.out.println("===== INTEGRANTES =====");
                    System.out.println("1. Joao");
                    System.out.println("2. Otto");
                    System.out.println("3. Pedro");
                    System.out.println("4. Peterson");
                    break;

                // Opção para sair do programa
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
