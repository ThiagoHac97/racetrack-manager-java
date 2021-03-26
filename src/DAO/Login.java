package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;



public class Login {
    
    private Connection conn;
    private PreparedStatement sttm;
    private Statement st;
    private ResultSet rs;
    private String verifTipo = "";
    
    
    public boolean logar(String login, String senha){
        String sql="select * from contas where login = '"+login+"' and senha = '"+senha+"'";
        String verifSenha = "";
        String verifLogin = "";
        boolean verif = false;
        try{
            conn = new Conexao().getConexao();
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
                verifLogin = rs.getString("login");
                verifSenha = rs.getString("senha");
                verifTipo = rs.getString("tipo");
            }
            if(verifLogin.equals(login) && verifSenha.equals(senha)){
                verif = true;
            }
            conn.close();
            st.close();
        }catch(Exception erro){
            throw new RuntimeException("erro 8:"+erro);
        }
        return verif;
    }
    
    public String tipo(String login, String senha){
        String sql="select * from contas where login = '"+login+"' and senha = '"+senha+"'";
        String verif = "";
        try{
            conn = new Conexao().getConexao();
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
                verifTipo = rs.getString("tipo");
            }
            if(verifTipo.equals("Cliente")){
                verif = "Cliente";
            }else if(verifTipo.equals("Funcionario")){
                verif = "Funcionario";
            }else if(verifTipo.equals("Empresa")){
                verif = "Empresa";
            }else if(verifTipo.equals("Administrador")){
                verif = "Administrador";
            }
            conn.close();
            st.close();
        }catch(Exception erro){
            throw new RuntimeException("erro 8:"+erro);
        }
        return verif;
    }
    
}
