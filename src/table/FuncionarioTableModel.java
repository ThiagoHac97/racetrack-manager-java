package table;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import model.FuncionarioConta;

public class FuncionarioTableModel extends AbstractTableModel{
    public static final int col_nome = 0;
    public static final int col_cpf = 1;
    public static final int col_telefone = 2;
    public static final int col_Cargo = 3;
    public static final int col_DataContrato = 4;
    public static final int col_DataFim = 5;
    public static final int col_email = 6;
    public static final int col_tipo = 7;
    public static final int col_login = 8;
    public static final int col_senha = 9;
    public ArrayList<FuncionarioConta> lista;
    
    public FuncionarioTableModel(ArrayList<FuncionarioConta>l){
        lista = new ArrayList<FuncionarioConta>(l);
    }
    
    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 10;
    }

    @Override
    public Object getValueAt(int linhas, int colunas) {
        FuncionarioConta funcionario = lista.get(linhas);
        if(colunas == col_nome)return funcionario.getNome();
        if(colunas == col_cpf)return funcionario.getCpf();
        if(colunas == col_Cargo)return funcionario.getCargo();
        if(colunas == col_DataContrato)return funcionario.getDataContrato();
        if(colunas == col_DataFim)return funcionario.getDataFim();
        if(colunas == col_telefone)return funcionario.getTelefone();
        if(colunas == col_email)return funcionario.getEmail();
        if(colunas == col_tipo)return funcionario.getTipo();
        if(colunas == col_login)return funcionario.getLogin();
        if(colunas == col_senha)return funcionario.getSenha();
        return "";
    }
    
    @Override
    public String getColumnName(int colunas){
        if(colunas == col_nome)return "Nome";
        if(colunas == col_cpf)return "CPF";
        if(colunas == col_Cargo)return "Cargo";
        if(colunas == col_DataContrato)return "Data Contratação";
        if(colunas == col_DataFim)return "Fim do Contrato";
        if(colunas == col_telefone)return "Telefone";
        if(colunas == col_email)return "E-mail";
        if(colunas == col_tipo)return "Tipo";
        if(colunas == col_login)return "Login";
        if(colunas == col_senha)return "Senha";
        return "";
    }
}
