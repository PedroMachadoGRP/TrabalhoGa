
 //Classe que controla a quantidade e o valor total de movimentações.

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

    
    //Registra uma movimentação somando o valor ao total e incrementando a quantidade.
     

    public void registrar(double valor) {
    this.quantidade++;
    this.valorTotal += valor;
}
}
