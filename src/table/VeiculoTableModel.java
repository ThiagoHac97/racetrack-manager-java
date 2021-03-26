package table;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import model.Veiculo;

public class VeiculoTableModel extends AbstractTableModel{
    public static final int col_modelo = 0;
    public static final int col_marca = 1;
    public static final int col_categoria = 2;
    public static final int col_potencia = 3;
    public static final int col_numeroPlaca = 4;
    public ArrayList<Veiculo> lista;
    
    public VeiculoTableModel(ArrayList<Veiculo>l){
        lista = new ArrayList<Veiculo>(l);
    }
    
    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int linhas, int colunas) {
        Veiculo veiculo = lista.get(linhas);
        if(colunas == col_modelo)return veiculo.getModelo();
        if(colunas == col_marca)return veiculo.getMarca();
        if(colunas == col_categoria)return veiculo.getCategoria();
        if(colunas == col_potencia)return veiculo.getPotencia();
        if(colunas == col_numeroPlaca)return veiculo.getNumeroPlaca();
        return "";
    }
    
    @Override
    public String getColumnName(int colunas){
        if(colunas == col_modelo)return "Modelo";
        if(colunas == col_marca)return "Marca";
        if(colunas == col_categoria)return "Categoria";
        if(colunas == col_potencia)return "Potencia";
        if(colunas == col_numeroPlaca)return "Placa";
        return "";
    }
    
}
