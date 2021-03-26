package model;

public class FuncionarioConta {
    private int idFuncionario;
    private String nome;
    private int fkConta;
    private String cpf;
    private String telefone;
    private String Cargo;
    private String DataContrato;
    private String DataFim;
    

    public String getCargo() {
        return Cargo;
    }

    public void setCargo(String Cargo) {
        this.Cargo = Cargo;
    }

    public String getDataContrato() {
        return DataContrato;
    }

    public void setDataContrato(String DataContrato) {
        this.DataContrato = DataContrato;
    }

    public String getDataFim() {
        return DataFim;
    }

    public void setDataFim(String DataFim) {
        this.DataFim = DataFim;
    }
    private int idConta;
    private String senha;
    private String email;
    private String tipo;
    private String login;
    

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getFkConta() {
        return fkConta;
    }

    public void setFkConta(int fkConta) {
        this.fkConta = fkConta;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getIdConta() {
        return idConta;
    }

    public void setIdConta(int idConta) {
        this.idConta = idConta;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
    
}
