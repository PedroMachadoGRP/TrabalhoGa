public class ContaInvestimento extends ContaBancaria {
    private Data dtVencimento;

    public void movimenta(Operacao op) {

    }

    

    public ContaInvestimento(Data dtVencimento, Cliente cliente) {
        this.dtVencimento = dtVencimento;
    }



    public Data getDtVencimento() {
        return dtVencimento;
    }

    public void setDtVencimento(Data dtVencimento) {
        this.dtVencimento = dtVencimento;
    }

    
}
