public class ContaBancaria {
    private Cliente cliente;
    private double saldoInical;
    private Movimentacao deposito;
    private Movimentacao saques;
    private Movimentacao juros;

    public void movimenta(Operacao op) {

    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getSaldoInical() {
        return saldoInical;
    }

    public void setSaldoInical(double saldoInical) {
        this.saldoInical = saldoInical;
    }

    public Movimentacao getDeposito() {
        return deposito;
    }

    public void setDeposito(Movimentacao deposito) {
        this.deposito = deposito;
    }

    public Movimentacao getSaques() {
        return saques;
    }

    public void setSaques(Movimentacao saques) {
        this.saques = saques;
    }

    public Movimentacao getJuros() {
        return juros;
    }

    public void setJuros(Movimentacao juros) {
        this.juros = juros;
    }

    

}
