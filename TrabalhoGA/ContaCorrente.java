// Conta Corrente: permite depositos e saques com limite de credito
public class ContaCorrente extends ContaBancaria {

    // Limite extra alem do saldo que o cliente pode usar
    private double limiteCredito;

    public ContaCorrente(int diaAniversario, Cliente cliente) {
        this.setCliente(cliente);
    }

    public boolean movimenta(Operacao op) {
        // Deposito: soma o valor ao saldo
        if (op.getTipo() == 'D') {
            setSaldoAtual(getSaldoAtual() + op.getValor());
            getDeposito().registrar(op.getValor());
            return true;

        // Saque: verifica se tem saldo + limite disponivel
        } else if (op.getTipo() == 'S') {
            if (op.getValor() <= 0) {
            System.out.println("O valor de saque deve ser maior do que zero.");
            return false;
            }
            
            if (op.getValor() > getSaldoAtual() + limiteCredito) {
            System.out.println("O saldo é insuficiente!");
            return false;
            }

            int[] cedulas = calcularCedulas(op.getValor());

            if (cedulas == null) {
            System.out.println("Nao foi possivel gerar esse valor com as cédulas disponiveis.");
            return false;
            }
            
            setSaldoAtual(getSaldoAtual() - op.getValor());
            getSaques().registrar(op.getValor());
            imprimirCedulas(cedulas);
            return true;
            }  
            
        return false;
    }

    // Getters e Setters
    public double getLimiteCredito() {
        return limiteCredito;
    }

    public void setLimiteCredito(double limiteCredito) {
        this.limiteCredito = limiteCredito;
    }
}
