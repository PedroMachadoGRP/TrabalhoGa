
//Classe  que representa uma data simples (dia, mês e ano).

public class Data {
    private int dia;
    private int mes;
    private int ano;

    public Data(int dia, int mes, int ano) {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    

    public int getDia() {
        return dia;
    }



    public void setDia(int dia) {
        this.dia = dia;
    }



    public int getMes() {
        return mes;
    }



    public void setMes(int mes) {
        this.mes = mes;
    }



    public int getAno() {
        return ano;
    }



    public void setAno(int ano) {
        this.ano = ano;
    }

    //Reescreve classe "toString já existente para exibir a data completa"

    @Override
    public String toString() {
        return "Dia: " + this.dia + "\n" + "mês: " + this.mes + "\n" + "ano: " + this.ano;
    }
}
