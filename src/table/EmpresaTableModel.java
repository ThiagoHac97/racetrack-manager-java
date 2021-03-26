package table;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import model.EmpresaConta;

public class EmpresaTableModel extends AbstractTableModel{
    public static final int col_idEmpresa = 0;
    public static final int col_nome = 1;
    public static final int col_nomeResposavel = 2;
    public static final int col_tipoServico = 3;
    public static final int col_telefone = 4;
    public static final int col_email = 5;
    public static final int col_login = 6;
    public static final int col_senha  = 7;
    public ArrayList<EmpresaConta> lista;
    
    public EmpresaTableModel(ArrayList<EmpresaConta>l){
        lista = new ArrayList<EmpresaConta>(l);
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
        EmpresaConta empresa = lista.get(linhas);
        if(colunas == col_idEmpresa)return empresa.getIdEmpresa();
        if(colunas == col_nome)return empresa.getNome();
        if(colunas == col_nomeResposavel)return empresa.getNomeResponsavel();
        if(colunas == col_tipoServico)return empresa.getTipoServico();
        if(colunas == col_telefone)return empresa.getTelefone();
        if(colunas == col_email)return empresa.getEmail();
        if(colunas == col_login)return empresa.getLogin();
        if(colunas == col_senha)return empresa.getSenha();
        return "";
    }
    
    @Override
    public String getColumnName(int colunas){
        if(colunas == col_idEmpresa)return "ID";
        if(colunas == col_nome)return "Nome";
        if(colunas == col_nomeResposavel)return "Responsável";
        if(colunas == col_tipoServico)return "Serviço Prestado";
        if(colunas == col_telefone)return "Telefone";
        if(colunas == col_email)return "E-mail";
        if(colunas == col_login)return "Login";
        if(colunas == col_senha)return "Senha";
        return "";
    }
}
