package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Servico;

public class ServicoDao {

    private Connection conn;
    private PreparedStatement sttm;
    private Statement st;
    private ResultSet rs;
    private ArrayList<Servico> lista = new ArrayList<Servico>(); 
    
    
    public void inserir(Servico servico){
        String sql = "INSERT INTO servico(idServico, cpf, categoria, circuito, DataInicio, DataTermino, HorarioInicio, HorarioTermino, fkCliente) VALUES (null,?,?,?,?,?,?,?,LAST_INSERT_ID())";
        try{
            conn = new Conexao().getConexao();
            sttm = conn.prepareStatement(sql);
            sttm.setString(1, servico.getCpf());
            sttm.setString(2, servico.getCategoria());
            sttm.setString(3, servico.getCircuito());
            sttm.setString(4, servico.getDataInicio());
            sttm.setString(5, servico.getDataTermino());
            sttm.setString(6, servico.getHorarioInicio());
            sttm.setString(7, servico.getHorarioTermino());
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
    
    public void alterar(Servico servico){
        int id = servico.getIdServico();
        String sql="update servico set cpf = ?, categoria = ?, circuito = ?, DataInicio = ?, DataTermino = ?, HorarioInicio = ?, HorarioTermino = ? where idServico ="+id+"";
        try{
            conn = new Conexao().getConexao();
            sttm = conn.prepareStatement(sql);
            sttm.setString(1, servico.getCpf());
            sttm.setString(2, servico.getCategoria());
            sttm.setString(3, servico.getCircuito());
            sttm.setString(4, servico.getDataInicio());
            sttm.setString(5, servico.getDataTermino());
            sttm.setString(6, servico.getHorarioInicio());
            sttm.setString(7, servico.getHorarioTermino());
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
        String sql="select * from servico where idServico ="+valor+"";
        int idConta = 0 ;
        try{
            conn = new Conexao().getConexao();
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){idConta = Integer.parseInt(rs.getString("idServico"));}
            st.close();
            st = conn.createStatement();
            String sql1="delete from servico where idServico = "+idConta;
            st.execute(sql1);
            conn.close();
            st.close();
        }catch(Exception erro){
            throw new RuntimeException("erro 4:"+erro);
        }
    }
    
    public ArrayList<Servico> listarTodos(){
        String sql="select * from servico";
        try{
            conn = new Conexao().getConexao();
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            lista.clear();
            while(rs.next()){
                Servico servico = new Servico();
                
                servico.setIdServico(rs.getInt("idServico"));
                servico.setCpf(rs.getString("cpf"));
                servico.setCategoria(rs.getString("categoria"));
                servico.setCircuito(rs.getString("circuito"));
                servico.setDataInicio(rs.getString("DataInicio"));
                servico.setDataTermino(rs.getString("DataTermino"));
                servico.setHorarioInicio(rs.getString("HorarioInicio"));
                servico.setHorarioTermino(rs.getString("HorarioTermino"));
                lista.add(servico);
            }
            conn.close();
            st.close();
        }catch(Exception erro){
            throw new RuntimeException("erro 5:"+erro);
        }
        return lista;
    }
    
    public String[] buscarAlterar(String valor){
        String sql="select * from servico where idServico ="+valor+"";
        String dados[] = new String[9];
        try{
            conn = new Conexao().getConexao();
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
                
                dados[0] = rs.getString("cpf");
                dados[1] = rs.getString("cpf");
                dados[2] = rs.getString("Cargo");
                dados[3] = rs.getString("DataContrato");
                dados[4] = rs.getString("DataFim");
                dados[5] = rs.getString("telefone");
                dados[6] = rs.getString("email");
                dados[7] = rs.getString("tipo");
                dados[8] = rs.getString("login");
            }
            conn.close();
            st.close();
        }catch(Exception erro){
            throw new RuntimeException("erro 6:"+erro);
        }
        return dados;
    }
    
    public ArrayList<Servico> pesquisar(String valor){
        String sql="select * from servico where DataInicio like '%"+valor+"%'";
        try{
            conn = new Conexao().getConexao();
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            lista.clear();
            while(rs.next()){
                Servico servico = new Servico();
                
                servico.setIdServico(rs.getInt("idServico"));
                servico.setCpf(rs.getString("cpf"));
                servico.setCategoria(rs.getString("categoria"));
                servico.setCircuito(rs.getString("circuito"));
                servico.setDataInicio(rs.getString("DataInicio"));
                servico.setDataTermino(rs.getString("DataTermino"));
                servico.setHorarioInicio(rs.getString("HorarioInicio"));
                servico.setHorarioTermino(rs.getString("HorarioTermino"));
                lista.add(servico);
            }
            conn.close();
            st.close();
        }catch(Exception erro){
            throw new RuntimeException("erro 7:"+erro);
        }
        return lista;
    }
    
}
