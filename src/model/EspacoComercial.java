package model;

public class EspacoComercial {
    private int idEspaco;
    private String nomeLocal;
    private String tamanhoArea;
    private String tempoContrato;
    private String valorDiaria;
    private int fkCliente;
    private String cpfResponsavel;
    private String nomeResponsavel;

    public String getCpfResponsavel() {
        return cpfResponsavel;
    }

    public void setCpfResponsavel(String cpfResponsavel) {
        this.cpfResponsavel = cpfResponsavel;
    }

    public String getNomeResponsavel() {
        return nomeResponsavel;
    }

    public void setNomeResponsavel(String nomeResponsavel) {
        this.nomeResponsavel = nomeResponsavel;
    }
    
    
    
    public int getIdEspaco() {
        return idEspaco;
    }

    public void setIdEspaco(int idEspaco) {
        this.idEspaco = idEspaco;
    }

    public String getNomeLocal() {
        return nomeLocal;
    }

    public void setNomeLocal(String nomeLocal) {
        this.nomeLocal = nomeLocal;
    }

    public String getTamanhoArea() {
        return tamanhoArea;
    }

    public void setTamanhoArea(String tamanhoArea) {
        this.tamanhoArea = tamanhoArea;
    }

    public String getTempoContrato() {
        return tempoContrato;
    }

    public void setTempoContrato(String tempoContrato) {
        this.tempoContrato = tempoContrato;
    }

    public String getValorDiaria() {
        return valorDiaria;
    }

    public void setValorDiaria(String valorDiaria) {
        this.valorDiaria = valorDiaria;
    }

    public int getFkCliente() {
        return fkCliente;
    }

    public void setFkCliente(int fkCliente) {
        this.fkCliente = fkCliente;
    }
    
    
}
