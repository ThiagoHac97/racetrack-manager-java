package table;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import model.EspacoComercial;

public class EspacoTableModel extends AbstractTableModel{
    public static final int col_idEspaco = 0;
    public static final int col_nomeLocal = 1;
    public static final int col_tamanhoArea = 2;
    public static final int col_tempoContrato = 3;
    public static final int col_valorDiaria = 4;
    public static final int col_cpfResponsavel = 5;
    public static final int col_nomeResponsavel = 6;
    public ArrayList<EspacoComercial> lista;
    
    public EspacoTableModel(ArrayList<EspacoComercial>l){
        lista = new ArrayList<EspacoComercial>(l);
    }
    
    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public Object getValueAt(int linhas, int colunas) {
        EspacoComercial espaco = lista.get(linhas);
        if(colunas == col_idEspaco)return espaco.getIdEspaco();
        if(colunas == col_nomeLocal)return espaco.getNomeLocal();
        if(colunas == col_tamanhoArea)return espaco.getTamanhoArea();
        if(colunas == col_valorDiaria)return espaco.getValorDiaria();
        if(colunas == col_tempoContrato)return espaco.getTempoContrato();
        if(colunas == col_cpfResponsavel)return espaco.getCpfResponsavel();
        if(colunas == col_nomeResponsavel)return espaco.getNomeResponsavel();
        return "";
    }
    
    @Override
    public String getColumnName(int colunas){
        if(colunas == col_idEspaco)return "ID";
        if(colunas == col_nomeLocal)return "Local";
        if(colunas == col_tamanhoArea)return "Área";
        if(colunas == col_valorDiaria)return "Diária";
        if(colunas == col_tempoContrato)return "Tempo do Contrato";
        if(colunas == col_cpfResponsavel)return "CPF";
        if(colunas == col_nomeResponsavel)return "Responsável";
        return "";
    }
}
