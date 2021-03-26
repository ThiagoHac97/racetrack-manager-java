package model;

public class Servico {
    private int idServico;
    private String cpf;
    private String categoria;
    private String circuito;
    private String DataInicio;
    private String DataTermino;
    private String HorarioInicio;
    private String HorarioTermino;
    private int fkCliente;

    public int getIdServico() {
        return idServico;
    }

    public void setIdServico(int idServico) {
        this.idServico = idServico;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getCircuito() {
        return circuito;
    }

    public void setCircuito(String circuito) {
        this.circuito = circuito;
    }

    public String getDataInicio() {
        return DataInicio;
    }

    public void setDataInicio(String DataInicio) {
        this.DataInicio = DataInicio;
    }

    public String getDataTermino() {
        return DataTermino;
    }

    public void setDataTermino(String DataTermino) {
        this.DataTermino = DataTermino;
    }

    public String getHorarioInicio() {
        return HorarioInicio;
    }

    public void setHorarioInicio(String HorarioInicio) {
        this.HorarioInicio = HorarioInicio;
    }

    public String getHorarioTermino() {
        return HorarioTermino;
    }

    public void setHorarioTermino(String HorarioTermino) {
        this.HorarioTermino = HorarioTermino;
    }

    public int getFkCliente() {
        return fkCliente;
    }

    public void setFkCliente(int fkCliente) {
        this.fkCliente = fkCliente;
    }
    
    
}
