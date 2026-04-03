public class ContaCorrente extends ContaBancaria {

    private int diaAniversario;

    

    public ContaCorrente(int diaAniversario, Cliente cliente) {
        this.diaAniversario = diaAniversario;
    }

    public void movimenta(Operacao op) {

    }

    public int getDiaAniversario() {
        return diaAniversario;
    }

    public void setDiaAniversario(int diaAniversario) {
        this.diaAniversario = diaAniversario;
    }

    
}
