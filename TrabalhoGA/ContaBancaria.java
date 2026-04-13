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
    public abstract boolean movimenta(Operacao op);

    public int[] calcularCedulas(double valor) {
    if (valor <= 0 || valor != Math.floor(valor)) {
    return null;
    }

    int total = (int) valor;

    for (int qtd100 = total / 100; qtd100 >= 0; qtd100--) {
        int resto100 = total - (qtd100 * 100);

    for (int qtd50 = resto100 / 50; qtd50 >= 0; qtd50--) {
        int resto50 = resto100 - (qtd50 * 50);

    for (int qtd20 = resto50 / 20; qtd20 >= 0; qtd20--) {
        int resto = resto50 - (qtd20 * 20);

        int[] restoResolvido = resolver10_5_2(resto);

        if (restoResolvido != null) {
        return new int[] {
            qtd100, qtd50, qtd20,
            restoResolvido[0], restoResolvido[1], restoResolvido[2]           
        };
        }
        }
        }       
    }
    return null;
}

private int[] resolver10_5_2(int valor) {
    for (int qtd10 = valor / 10; qtd10 >= 0; qtd10--) {
        int resto = valor - (qtd10 * 10);

        if (resto == 0) {
            return new int[] {qtd10, 0, 0};
        }

        if (resto >= 5 && (resto - 5) % 2 == 0) {
            return new int[] {qtd10, 1, (resto - 5) / 2};
        }

        if (resto % 2 == 0) {
            return new int[] {qtd10, 0, resto / 2};
        }
    }

    return null;
}

public void imprimirCedulas(int[] quantidades) {
    int[] cedulas = {100, 50, 20, 10, 5, 2};

    System.out.println("Cedulas liberadas:");
    for (int i = 0; i < cedulas.length; i++) {
        if (quantidades[i] > 0) {
            System.out.println(quantidades[i] + " notas de R$ " + cedulas[i]);
        }
    }
}

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
