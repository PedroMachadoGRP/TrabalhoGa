// Classe base para todos os tipos de conta bancaria
public abstract class ContaBancaria {

    // Atributos da conta
    private Cliente cliente;
    private double saldoInical;
    private double saldoAtual;
    private Movimentacao deposito;
    private Movimentacao saques;
    private Movimentacao juros;

    // Construtor que inicializa as movimentacoes zeradas
    public ContaBancaria() {
        this.deposito = new Movimentacao(0, 0);
        this.saques = new Movimentacao(0, 0);
        this.juros = new Movimentacao(0, 0);
    }

    // Metodo abstrato implementado por cada tipo de conta
    public abstract void movimenta(Operacao op);

    // Getters e Setters
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

    public double getSaldoAtual() {
        return saldoAtual;
    }

    public void setSaldoAtual(double saldoAtual) {
        this.saldoAtual = saldoAtual;
    }
}