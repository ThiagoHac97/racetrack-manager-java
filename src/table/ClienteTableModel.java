package table;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import model.ClienteConta;

public class ClienteTableModel extends AbstractTableModel{
    public static final int col_nome = 0;
    public static final int col_cpf = 1;
    public static final int col_telefone = 2;
    public static final int col_tipoCnh = 3;
    public static final int col_idade = 4;
    public static final int col_email = 5;
    public static final int col_tipo = 6;
    public static final int col_login = 7;
    public static final int col_senha = 8;
    public ArrayList<ClienteConta> lista;
    
    public ClienteTableModel(ArrayList<ClienteConta>l){
        lista = new ArrayList<ClienteConta>(l);
    }
    
    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 9;
    }

    @Override
    public Object getValueAt(int linhas, int colunas) {
        ClienteConta cliente = lista.get(linhas);
        if(colunas == col_nome)return cliente.getNome();
        if(colunas == col_cpf)return cliente.getCpf();
        if(colunas == col_telefone)return cliente.getTelefone();
        if(colunas == col_tipoCnh)return cliente.getTipoCnh();
        if(colunas == col_idade)return cliente.getIdade();
        if(colunas == col_email)return cliente.getEmail();
        if(colunas == col_tipo)return cliente.getTipo();
        if(colunas == col_login)return cliente.getLogin();
        if(colunas == col_senha)return cliente.getSenha();
        return "";
    }
    
    @Override
    public String getColumnName(int colunas){
        if(colunas == col_nome)return "Nome";
        if(colunas == col_cpf)return "CPF";
        if(colunas == col_telefone)return "Telefone";
        if(colunas == col_tipoCnh)return "Categoria CNH";
        if(colunas == col_idade)return "Idade";
        if(colunas == col_email)return "E-mail";
        if(colunas == col_tipo)return "Tipo";
        if(colunas == col_login)return "Login";
        if(colunas == col_senha)return "Senha";
        return "";
    }
    
}
