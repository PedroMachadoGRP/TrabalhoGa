public class ContaPoupanca extends ContaBancaria {

    private double limiteCredito;

    

    public ContaPoupanca(double limiteCredito, Cliente cliente) {
        this.limiteCredito = limiteCredito;
    }

    public ContaPoupanca(Cliente cliente) {
    }

    public void movimenta(Operacao op) {

    }

    public double getLimiteCredito() {
        return limiteCredito;
    }

    public void setLimiteCredito(double limiteCredito) {
        this.limiteCredito = limiteCredito;
    }

    
}
