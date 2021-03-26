package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.EspacoComercial;

public class EspacoDao {

    private Connection conn;
    private PreparedStatement sttm;
    private Statement st;
    private ResultSet rs;
    private ArrayList<EspacoComercial> lista = new ArrayList<EspacoComercial>(); 
    
    
    public void inserir(EspacoComercial espaco){
        String sql = "INSERT INTO espacocomercial(idEspaco, nomeLocal, tamanhoArea, tempoContrato, valorDiaria, cpfResponsavel, nomeResponsavel) VALUES (null,?,?,?,?,?,?)";
        try{
            conn = new Conexao().getConexao();
            sttm = conn.prepareStatement(sql);
            sttm.setString(1, espaco.getNomeLocal());
            sttm.setString(2, espaco.getTamanhoArea());
            sttm.setString(3, espaco.getTempoContrato());
            sttm.setString(4, espaco.getValorDiaria());
            sttm.setString(5, espaco.getCpfResponsavel());
            sttm.setString(6, espaco.getNomeResponsavel());
            if(sttm.execute()==false)
            {                            
                JOptionPane.showMessageDialog(null,"Cadastro efetuado com sucesso!!!!","Sucesso", JOptionPane.INFORMATION_MESSAGE);
            }
                else
            {
                JOptionPane.showMessageDialog(null,"Erro no cadastro!!! \n","Erro", JOptionPane.ERROR_MESSAGE);
            }
            conn.close();
            sttm.close();
        }catch(Exception erro){
            throw new RuntimeException("erro 2:"+erro);
        }
    }
    
    public void alterar(EspacoComercial espaco){
        int id = espaco.getIdEspaco();
        String sql="update espacocomercial set nomeLocal = ?, tamanhoArea = ?, tempoContrato = ?, valorDiaria = ?, cpfResponsavel = ?, nomeResponsavel = ?  where idEspaco ="+id+"";
        try{
            conn = new Conexao().getConexao();
            sttm = conn.prepareStatement(sql);
            sttm.setString(1, espaco.getNomeLocal());
            sttm.setString(2, espaco.getTamanhoArea());
            sttm.setString(3, espaco.getTempoContrato());
            sttm.setString(4, espaco.getValorDiaria());
            sttm.setString(5, espaco.getCpfResponsavel());
            sttm.setString(6, espaco.getNomeResponsavel());
            if(sttm.execute()==false){
                JOptionPane.showMessageDialog(null,"Alteração efetuada com Sucesso!!","Sucesso", JOptionPane.INFORMATION_MESSAGE);
            }else
            {
                JOptionPane.showMessageDialog(null,"Erro na Alteração!! \n","Erro", JOptionPane.ERROR_MESSAGE);
            }
            conn.close();
            sttm.close();
        }catch(Exception erro){
            throw new RuntimeException("erro 3:"+erro);
        }
    }
    
    public void excluir(String valor){
        String sql="select * from espacocomercial where idEspaco ="+valor+"";
        int idConta = 0 ;
        try{
            conn = new Conexao().getConexao();
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){idConta = Integer.parseInt(rs.getString("idEspaco"));}
            st.close();
            st = conn.createStatement();
            String sql1="delete from espacocomercial where idEspaco = "+idConta;
            st.execute(sql1);
            conn.close();
            st.close();
        }catch(Exception erro){
            throw new RuntimeException("erro 4:"+erro);
        }
    }
    
    public ArrayList<EspacoComercial> listarTodos(){
        String sql="select * from espacocomercial";
        try{
            conn = new Conexao().getConexao();
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            lista.clear();
            while(rs.next()){
                EspacoComercial espaco = new EspacoComercial();
                
                espaco.setIdEspaco(rs.getInt("idEspaco"));
                espaco.setNomeLocal(rs.getString("nomeLocal"));
                espaco.setTamanhoArea(rs.getString("tamanhoArea"));
                espaco.setTempoContrato(rs.getString("tempoContrato"));
                espaco.setValorDiaria(rs.getString("valorDiaria"));
                espaco.setCpfResponsavel(rs.getString("cpfResponsavel"));
                espaco.setNomeResponsavel(rs.getString("nomeResponsavel"));
                lista.add(espaco);
            }
            conn.close();
            st.close();
        }catch(Exception erro){
            throw new RuntimeException("erro 5:"+erro);
        }
        return lista;
    }
    
    public String[] buscarAlterar(String valor){
        String sql="select * from espacocomercial where idEspaco ="+valor+"";
        String dados[] = new String[7];
        try{
            conn = new Conexao().getConexao();
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
                
                dados[0] = rs.getString("idEspaco");
                dados[1] = rs.getString("nomeLocal");
                dados[2] = rs.getString("tamanhoArea");
                dados[3] = rs.getString("tempoContrato");
                dados[4] = rs.getString("valorDiaria");
                dados[5] = rs.getString("cpfResponsavel");
                dados[6] = rs.getString("nomeResponsavel");
            }
            conn.close();
            st.close();
        }catch(Exception erro){
            throw new RuntimeException("erro 6:"+erro);
        }
        return dados;
    }
    
    public ArrayList<EspacoComercial> pesquisar(String valor){
        String sql="select * from espacocomercial where nomeLocal like '%"+valor+"%'";
        try{
            conn = new Conexao().getConexao();
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            lista.clear();
            while(rs.next()){
                EspacoComercial espaco = new EspacoComercial();
                
                espaco.setIdEspaco(rs.getInt("idEspaco"));
                espaco.setNomeLocal(rs.getString("nomeLocal"));
                espaco.setTamanhoArea(rs.getString("tamanhoArea"));
                espaco.setTempoContrato(rs.getString("tempoContrato"));
                espaco.setValorDiaria(rs.getString("valorDiaria"));
                espaco.setCpfResponsavel(rs.getString("cpfResponsavel"));
                espaco.setNomeResponsavel(rs.getString("nomeResponsavel"));
                lista.add(espaco);
            }
            conn.close();
            st.close();
        }catch(Exception erro){
            throw new RuntimeException("erro 7:"+erro);
        }
        return lista;
    }
    
}
