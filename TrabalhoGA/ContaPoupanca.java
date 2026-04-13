// Conta Poupanca: permite depositos, saques e aplicacao de juros
public class ContaPoupanca extends ContaBancaria {

    // Dia do mes em que a poupanca rende juros
    private int diaAniversario;

    public ContaPoupanca(Cliente cliente) {
    this.setCliente(cliente);
}

    public boolean movimenta(Operacao op) {
        // Deposito: soma o valor ao saldo
        if (op.getTipo() == 'D') {
            setSaldoAtual(getSaldoAtual() + op.getValor());
            getDeposito().registrar(op.getValor());
            return true;

        // Saque: verifica se tem saldo suficiente
        } else if (op.getTipo() == 'S') {
            if (op.getValor() <= 0) {
                System.out.println("O valor de saque deve ser maior do que zero.");
                return false;
            }

            if (op.getValor() > getSaldoAtual()) {
                System.out.println("O saldo e insuficiente!");
                return false;
            }

            int[] cedulas = calcularCedulas(op.getValor());

            if (cedulas == null) {
                System.out.println("Nao foi possivel gerar esse valor com as cedulas disponiveis.");
                return false;
            }else {
                setSaldoAtual(getSaldoAtual() - op.getValor());
                getSaques().registrar(op.getValor());
                imprimirCedulas(cedulas);
                return true;
            }

        // Juros: calcula e aplica a taxa percentual sobre o saldo
        } else if (op.getTipo() == 'J') {
            double valorJuros = getSaldoAtual() * (op.getValor() / 100.0);
            setSaldoAtual(getSaldoAtual() + valorJuros);
            getJuros().registrar(valorJuros);
            return true;
        }
        return false;
    }

    // Getters e Setters
    public int getDiaAniversario() {
        return diaAniversario;
    }

    public void setDiaAniversario(int diaAniversario) {
        this.diaAniversario = diaAniversario;
    }
}
