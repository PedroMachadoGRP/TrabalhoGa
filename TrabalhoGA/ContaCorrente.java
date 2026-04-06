// Conta Corrente: permite depositos e saques com limite de credito
public class ContaCorrente extends ContaBancaria {

    // Limite extra alem do saldo que o cliente pode usar
    private double limiteCredito;

    @Override
    public void movimenta(Operacao op) {
        // Deposito: soma o valor ao saldo
        if (op.getTipo() == 'D') {
            setSaldoAtual(getSaldoAtual() + op.getValor());
            getDeposito().registrar(op.getValor());

        // Saque: verifica se tem saldo + limite disponivel
        } else if (op.getTipo() == 'S') {
            if (op.getValor() > getSaldoAtual() + limiteCredito) {
                System.out.println("Saldo insuficiente!");
            } else {
                setSaldoAtual(getSaldoAtual() - op.getValor());
                getSaques().registrar(op.getValor());
            }
        }
    }

    // Getters e Setters
    public double getLimiteCredito() {
        return limiteCredito;
    }

    public void setLimiteCredito(double limiteCredito) {
        this.limiteCredito = limiteCredito;
    }
}