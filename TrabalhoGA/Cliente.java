public class Cliente {
    private String nome;
    private String cpf;
    private Data dtNascimento;


    public Cliente(String nome, String cpf, Data dtNascimento) {
        this.nome = nome;
        this.cpf = cpf;
        this.dtNascimento = dtNascimento;
    }


    public String getNome() {
        return nome;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }


    public String getCpf() {
        return cpf;
    }


    public void setCpf(String cpf) {
        this.cpf = cpf;
    }


    public Data getDtNascimento() {
        return dtNascimento;
    }


    public void setDtNascimento(Data dtNascimento) {
        this.dtNascimento = dtNascimento;
    }

    

}