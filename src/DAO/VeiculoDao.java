package DAO;

import model.Veiculo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class VeiculoDao {

    private Connection conn;
    private PreparedStatement sttm;
    private Statement st;
    private ResultSet rs;
    private ArrayList<Veiculo> lista = new ArrayList<Veiculo>(); 
    
    
    public void inserir(Veiculo veiculo){
        String sql = "insert into veiculos(idVeiculo, modelo, marca, categoria, potencia, numeroPlaca, imagem) values(null, ?, ?, ?, ?, ?, ?)";
        try{
            conn = new Conexao().getConexao();
            sttm = conn.prepareStatement(sql);
            sttm.setString(1, veiculo.getModelo());
            sttm.setString(2, veiculo.getMarca());
            sttm.setString(3, veiculo.getCategoria());
            sttm.setString(4, veiculo.getPotencia());
            sttm.setString(5, veiculo.getNumeroPlaca());
            sttm.setBytes(6, veiculo.getImagem());
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
            throw new RuntimeException("erro 3:"+erro);
        }
    
    }
    
    public ArrayList<Veiculo> listarTodos(){
        String sql="select * from veiculos";
        try{
            conn = new Conexao().getConexao();
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            lista.clear();
            while(rs.next()){
                Veiculo veiculo = new Veiculo();
                
                veiculo.setMarca(rs.getString("marca"));
                veiculo.setModelo(rs.getString("modelo"));
                veiculo.setCategoria(rs.getString("categoria"));
                veiculo.setNumeroPlaca(rs.getString("numeroPlaca"));
                veiculo.setPotencia(rs.getString("potencia"));
                lista.add(veiculo);
            }
            conn.close();
            st.close();
        }catch(Exception erro){
            throw new RuntimeException("erro 5:"+erro);
        }
        return lista;
    }
    
    public byte[] exibirImagem(String valor){
        String sql="select * from veiculos where numeroPlaca ='"+valor+"'";
        byte[] dado = null;
        try{
            conn = new Conexao().getConexao();
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
                dado = rs.getBytes("imagem");
            }
            conn.close();
            st.close();
        }catch(Exception erro){
            throw new RuntimeException("erro 4:"+erro);
        }
        return dado;
    }
    
    public boolean verifPlaca(String placa){
        String sql = "select numeroPlaca from veiculos where numeroPlaca = '"+placa+"'";
        boolean verif = false;
        try{
            conn = new Conexao().getConexao();
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
                if((rs.getString("numeroPlaca")).equals(placa)){
                    verif = true;
                }
            }
            conn.close();
            st.close();
        }catch(Exception erro){
            throw new RuntimeException("erro 8:"+erro);
        }
        return verif;
    }
    
    public void excluir(String valor){
        String sql="select * from veiculos where numeroPlaca = '"+valor+"'";
        int idConta = 0 ;
        try{
            conn = new Conexao().getConexao();
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){idConta = Integer.parseInt(rs.getString("idVeiculo"));}
            st.close();
            st = conn.createStatement();
            String sql1="delete from veiculos where idVeiculo = "+idConta;
            st.execute(sql1);
            conn.close();
            st.close();
        }catch(Exception erro){
            throw new RuntimeException("erro 4:"+erro);
        }
    }
 
    public ArrayList<Veiculo> pesquisar(String valor){
        String sql="select * from veiculos where marca like '%"+valor+"%'";
        try{
            conn = new Conexao().getConexao();
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            lista.clear();
            while(rs.next()){
                Veiculo veiculo = new Veiculo();
                
                veiculo.setMarca(rs.getString("marca"));
                veiculo.setModelo(rs.getString("modelo"));
                veiculo.setCategoria(rs.getString("categoria"));
                veiculo.setNumeroPlaca(rs.getString("numeroPlaca"));
                veiculo.setPotencia(rs.getString("potencia"));
                lista.add(veiculo);
            }
            conn.close();
            st.close();
        }catch(Exception erro){
            throw new RuntimeException("erro 7:"+erro);
        }
        return lista;
    }
    
    public String[] buscarAlterar(String valor){
        String sql="select * from veiculos where numeroPlaca = '"+valor+"'";
        String dados[] = new String[6];
        try{
            conn = new Conexao().getConexao();
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
                
                dados[0] = rs.getString("marca");
                dados[1] = rs.getString("modelo");
                dados[2] = rs.getString("categoria");
                dados[3] = rs.getString("numeroPlaca");
                dados[4] = rs.getString("potencia");
                dados[5] = rs.getString("idVeiculo");
            }
            conn.close();
            st.close();
        }catch(Exception erro){
            throw new RuntimeException("erro 6:"+erro);
        }
        return dados;
    }
    
    public void alterar(Veiculo veiculo){
        int id = veiculo.getIdVeiculo();
        String sql="update veiculos set modelo = ?, marca = ?, categoria = ?, potencia = ?, numeroPlaca = ?, imagem = ? where idVeiculo ="+id+"";
        try{
            conn = new Conexao().getConexao();
            sttm = conn.prepareStatement(sql);
            sttm.setString(1, veiculo.getModelo());
            sttm.setString(2, veiculo.getMarca());
            sttm.setString(3, veiculo.getCategoria());
            sttm.setString(4, veiculo.getPotencia());
            sttm.setString(5, veiculo.getNumeroPlaca());
            sttm.setBytes(6, veiculo.getImagem());
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
    
}
