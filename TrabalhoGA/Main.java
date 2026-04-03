public class Main {
    public static void main(String[] args) {
        abrirMenu();
    }

    public static void abrirMenu() {
        boolean iniciar = true;
        boolean contaCriada = false;
        ContaBancaria contaBancaria = null;

        while (iniciar) {
            System.out.println(" \n1 - Abrir conta");
            System.out.println(" \n2 - Realizar depósito");
            System.out.println(" \n3 - Realizar saque");
            System.out.println(" \n4 - Aplicar Juros");
            System.out.println(" \n5 - Extrato");
            System.out.println(" \n6 - Integrantes");
            System.out.println(" \n7 - Sair");

            int opcao = Teclado.leInt(" Escolha uma das ações");

            switch (opcao) {
                case 1:
                    if (contaCriada) {
                        System.out.println("Opção desabilitada, já tem um conta");
                        break;
                    }

                    String nome = Teclado.leString("Qual o seu nome?");
                    String cpf = Teclado.leString("Qual o seu cpf");
                    int dia = Teclado.leInt("Qual o dia do seu nascimento");
                    int mes = Teclado.leInt("Qual o mes do seu nascimento");
                    int ano = Teclado.leInt("Qual o ano do seu nascimento");
                    Data dtNascimento = new Data(dia, mes, ano);
                    Cliente cliente = new Cliente(nome, cpf, dtNascimento);

                    System.out
                            .println("Seu nome é: " + cliente.getNome() + "\n" + "Seu cpf é: " + cliente.getCpf() + "\n"
                                    + "Você nasceu: " + cliente.getDtNascimento());

                    char tipoConta = Teclado
                            .leChar("tipo de conta 'C' " + "corrente, 'P' - poupança, 'I' - investimento)");

                    if (tipoConta == 'C')
                        contaBancaria = new ContaCorrente(dia, cliente);

                    if (tipoConta == 'P')
                        contaBancaria = new ContaPoupanca(cliente);

                    if (tipoConta == 'I') {
                        int diaVencimento = Teclado.leInt("Qual o dia do vencimento da conta");
                        int mesVencimento = Teclado.leInt("Qual o mes do vencimento da conta");
                        int anoVencimento = Teclado.leInt("Qual o ano do vencimento da conta");

                        Data dtVencimento = new Data(diaVencimento, mesVencimento, anoVencimento);
                        contaBancaria = new ContaInvestimento(dtVencimento, cliente);
                    }

                    double saldoI = Teclado.leDouble("Quanto é seu saldo inical? ");

                    contaBancaria.setSaldoInical(saldoI);

                    System.out.println("Seu saldo inical é de: " + contaBancaria.getSaldoInical());

                    System.out.println("Conta criada com sucesso!");
                    contaCriada = true;
                    break;
                case 2:
                    if (!contaCriada) {
                        System.out.println("Você deve criar uma conta primeiro");
                        break;
                    }
                    break;
                case 3:
                    if (!contaCriada) {
                        System.out.println("Você deve criar uma conta primeiro");
                        break;
                    }
                    break;
                case 4:
                    if (!contaCriada) {
                        System.out.println("Você deve criar uma conta primeiro");
                        break;
                    }
                    break;
                case 5:
                    if (!contaCriada) {
                        System.out.println("Você deve criar uma conta primeiro");
                        break;
                    }
                    break;
                case 6:

                    break;
                case 7:
                    System.out.println("Saindo... ");
                    iniciar = false;
                    break;

                default:
                    break;
            }
        }
    }
}