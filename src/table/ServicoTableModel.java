package table;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import model.Servico;

public class ServicoTableModel extends AbstractTableModel{
    public static final int col_idServico = 0;
    public static final int col_cpf = 1;
    public static final int col_categoria = 2;
    public static final int col_circuito = 3;
    public static final int col_DataInicio = 4;
    public static final int col_DataTermino = 5;
    public static final int col_HorarioInicio = 6;
    public static final int col_HorarioTermino = 7;
    public ArrayList<Servico> lista;
    
    public ServicoTableModel(ArrayList<Servico>l){
        lista = new ArrayList<Servico>(l);
    }
    
    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 8;
    }

    @Override
    public Object getValueAt(int linhas, int colunas) {
        Servico servico = lista.get(linhas);
        if(colunas == col_idServico)return servico.getIdServico();
        if(colunas == col_cpf)return servico.getCpf();
        if(colunas == col_categoria)return servico.getCategoria();
        if(colunas == col_circuito)return servico.getCircuito();
        if(colunas == col_DataInicio)return servico.getDataInicio();
        if(colunas == col_DataTermino)return servico.getDataTermino();
        if(colunas == col_HorarioInicio)return servico.getHorarioInicio();
        if(colunas == col_HorarioTermino)return servico.getHorarioTermino();
        return "";
    }
    
    @Override
    public String getColumnName(int colunas){
        if(colunas == col_idServico)return "ID";
        if(colunas == col_cpf)return "CPF";
        if(colunas == col_categoria)return "Categoria";
        if(colunas == col_circuito)return "Circuito";
        if(colunas == col_DataInicio)return "Data Inicio";
        if(colunas == col_DataTermino)return "Data Termino";
        if(colunas == col_HorarioInicio)return "Horario Inicio";
        if(colunas == col_HorarioTermino)return "Horario Termino";
        return "";
    }
}
