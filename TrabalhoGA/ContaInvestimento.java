// Conta Investimento: permite depositos e aplicacao de juros, sem saques
public class ContaInvestimento extends ContaBancaria {

    // Data em que o investimento vence
    private Data dtVencimento;

    public void movimenta(Operacao op) {
        // Deposito: soma o valor ao saldo
        if (op.getTipo() == 'D') {
            setSaldoAtual(getSaldoAtual() + op.getValor());
            getDeposito().registrar(op.getValor());

        // Juros: calcula e aplica a taxa percentual sobre o saldo
        } else if (op.getTipo() == 'J') {
            double valorJuros = getSaldoAtual() * (op.getValor() / 100.0);
            setSaldoAtual(getSaldoAtual() + valorJuros);
            getJuros().registrar(valorJuros);
        }
    }

    // Getters e Setters
    public Data getDtVencimento() {
        return dtVencimento;
    }

    public void setDtVencimento(Data dtVencimento) {
        this.dtVencimento = dtVencimento;
    }
}