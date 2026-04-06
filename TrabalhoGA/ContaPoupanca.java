// Conta Poupanca: permite depositos, saques e aplicacao de juros
public class ContaPoupanca extends ContaBancaria {

    // Dia do mes em que a poupanca rende juros
    private int diaAniversario;

    public ContaPoupanca(Cliente cliente) {
    this.setCliente(cliente);
}

    public void movimenta(Operacao op) {
        // Deposito: soma o valor ao saldo
        if (op.getTipo() == 'D') {
            setSaldoAtual(getSaldoAtual() + op.getValor());
            getDeposito().registrar(op.getValor());

        // Saque: verifica se tem saldo suficiente
        } else if (op.getTipo() == 'S') {
            if (op.getValor() > getSaldoAtual()) {
                System.out.println("Saldo insuficiente!");
            } else {
                setSaldoAtual(getSaldoAtual() - op.getValor());
                getSaques().registrar(op.getValor());
            }

        // Juros: calcula e aplica a taxa percentual sobre o saldo
        } else if (op.getTipo() == 'J') {
            double valorJuros = getSaldoAtual() * (op.getValor() / 100.0);
            setSaldoAtual(getSaldoAtual() + valorJuros);
            getJuros().registrar(valorJuros);
        }
    }

    // Getters e Setters
    public int getDiaAniversario() {
        return diaAniversario;
    }

    public void setDiaAniversario(int diaAniversario) {
        this.diaAniversario = diaAniversario;
    }
}