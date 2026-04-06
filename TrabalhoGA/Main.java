import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ContaBancaria conta = null;
        int opcao;

        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Abrir conta");
            System.out.println("2. Realizar deposito");
            System.out.println("3. Realizar saque");
            System.out.println("4. Aplicar juros");
            System.out.println("5. Extrato");
            System.out.println("6. Integrantes");
            System.out.println("7. Sair");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();

            if (opcao == 1) {
                if (conta != null) {
                    System.out.println("Ja existe uma conta aberta!");
                } else {
                    conta = abrirConta(sc);
                }
            } else if (opcao == 2) {
                if (conta == null) {
                    System.out.println("Abra uma conta primeiro!");
                } else {
                    System.out.print("Valor do deposito: ");
                    double valor = sc.nextDouble();
                    if (valor <= 0) {
                        System.out.println("Valor invalido!");
                    } else {
                        conta.movimenta(new Operacao('D', valor));
                        System.out.println("Novo saldo: " + conta.getSaldoAtual());
                    }
                }
            } else if (opcao == 3) {
                if (conta == null) {
                    System.out.println("Abra uma conta primeiro!");
                } else if (!(conta instanceof ContaCorrente || conta instanceof ContaPoupanca)) {
                    System.out.println("Saque nao disponivel para este tipo de conta!");
                } else {
                    System.out.print("Valor do saque: ");
                    double valor = sc.nextDouble();
                    if (valor <= 0) {
                        System.out.println("Valor invalido!");
                    } else {
                        conta.movimenta(new Operacao('S', valor));
                        System.out.println("Novo saldo: " + conta.getSaldoAtual());
                    }
                }
            } else if (opcao == 4) {
                if (conta == null) {
                    System.out.println("Abra uma conta primeiro!");
                } else if (!(conta instanceof ContaPoupanca || conta instanceof ContaInvestimento)) {
                    System.out.println("Juros nao disponivel para este tipo de conta!");
                } else {
                    System.out.print("Taxa de juros (%): ");
                    double taxa = sc.nextDouble();
                    if (taxa <= 0) {
                        System.out.println("Taxa invalida!");
                    } else {
                        conta.movimenta(new Operacao('J', taxa));
                        System.out.println("Novo saldo: " + conta.getSaldoAtual());
                    }
                }
            } else if (opcao == 5) {
                if (conta == null) {
                    System.out.println("Abra uma conta primeiro!");
                } else {
                    System.out.println("\n===== EXTRATO =====");
                    System.out.println(conta.getCliente().getNome());
                    System.out.println("Saldo inicial: " + conta.getSaldoInical());
                    System.out.println("Saldo atual: " + conta.getSaldoAtual());
                    System.out.println("Depositos: " + conta.getDeposito().getQuantidade() + " - Total: " + conta.getDeposito().getValorTotal());
                    System.out.println("Saques: " + conta.getSaques().getQuantidade() + " - Total: " + conta.getSaques().getValorTotal());
                    System.out.println("Juros: " + conta.getJuros().getQuantidade() + " - Total: " + conta.getJuros().getValorTotal());
                }
            } else if (opcao == 6) {
                System.out.println("\n===== INTEGRANTES =====");
                System.out.println("1. Joao");
                System.out.println("2. Otto");
                System.out.println("3. Pedro");
                System.out.println("4. Peterson");
            } else if (opcao == 7) {
                System.out.println("Encerrando...");
            } else {
                System.out.println("Opcao invalida!");
            }

        } while (opcao != 7);

        sc.close();
    }

    private static ContaBancaria abrirConta(Scanner sc) {
        sc.nextLine();
        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("CPF: ");
        String cpf = sc.nextLine();
        System.out.print("Data de nascimento (dd mm aaaa): ");
        int dia = sc.nextInt();
        int mes = sc.nextInt();
        int ano = sc.nextInt();
        Data dtNasc = new Data(dia, mes, ano);
        Cliente cliente = new Cliente(nome, cpf, dtNasc);

        System.out.print("Saldo inicial: ");
        double saldo = sc.nextDouble();

        System.out.print("Tipo de conta (C, P, I): ");
        String tipo = sc.next().toUpperCase();

        ContaBancaria conta = null;

        if (tipo.equals("C")) {
            System.out.print("Limite de credito: ");
            double limite = sc.nextDouble();
            conta = new ContaCorrente();
            conta.setCliente(cliente);
            conta.setSaldoInical(saldo);
            conta.setSaldoAtual(saldo);
            ((ContaCorrente) conta).setLimiteCredito(limite);
        } else if (tipo.equals("P")) {
            System.out.print("Dia de aniversario: ");
            int diaAniv = sc.nextInt();
            conta = new ContaPoupanca();
            conta.setCliente(cliente);
            conta.setSaldoInical(saldo);
            conta.setSaldoAtual(saldo);
            ((ContaPoupanca) conta).setDiaAniversario(diaAniv);
        } else if (tipo.equals("I")) {
            System.out.print("Data de vencimento (dd mm aaaa): ");
            int dv = sc.nextInt();
            int mv = sc.nextInt();
            int av = sc.nextInt();
            conta = new ContaInvestimento();
            conta.setCliente(cliente);
            conta.setSaldoInical(saldo);
            conta.setSaldoAtual(saldo);
            ((ContaInvestimento) conta).setDtVencimento(new Data(dv, mv, av));
        }

        System.out.println("Conta aberta com sucesso!");
        return conta;
    }
}