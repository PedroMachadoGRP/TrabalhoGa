public class Movimentacao {
    private int quantidade;
    private double valorTotal;

    public Movimentacao(int quantidade, double valorTotal) {
        this.quantidade = quantidade;
        this.valorTotal = valorTotal;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    
}
