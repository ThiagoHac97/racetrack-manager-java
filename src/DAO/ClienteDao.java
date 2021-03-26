package DAO;

import model.ClienteConta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ClienteDao {
    
    private Connection conn;
    private PreparedStatement sttm;
    private Statement st;
    private ResultSet rs;
    private ArrayList<ClienteConta> lista = new ArrayList<ClienteConta>(); 
    
    
    public void inserir(ClienteConta cliente){
        String sql="insert into contas(idConta, email, tipo, login, senha) values(null, ?, ?, ?, ?)";
        String sql1 = "INSERT INTO clientes(idCliente, nome, cpf, telefone, tipoCnh, fkConta, idade) VALUES (null,?,?,?,?,LAST_INSERT_ID(),?)";
        try{
            conn = new Conexao().getConexao();
            sttm = conn.prepareStatement(sql);
            sttm.setString(1, cliente.getEmail());
            sttm.setString(2, cliente.getTipo());
            sttm.setString(3, cliente.getLogin());
            sttm.setString(4, cliente.getSenha());
            if(sttm.execute()==false)
               {
                    sttm.close();
                    sttm = conn.prepareStatement(sql1);
                    sttm.setString(1, cliente.getNome());
                    sttm.setString(2, cliente.getCpf());
                    sttm.setString(3, cliente.getTelefone());
                    sttm.setString(4, cliente.getTipoCnh());
                    sttm.setInt(5, cliente.getIdade());
                   if(sttm.execute()==false)
                        {                            
                            JOptionPane.showMessageDialog(null,"Cadastro efetuado com sucesso!!!!","Sucesso", JOptionPane.INFORMATION_MESSAGE);
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null,"Erro no cadastro!!! \n","Erro", JOptionPane.ERROR_MESSAGE);
                        }
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
    
    public void alterar(ClienteConta cliente){
        int id = cliente.getIdConta();
        String sql="update contas join clientes on contas.idConta = clientes.fkConta set nome = ?, cpf = ?, telefone = ?, tipoCnh = ?, idade = ?, email = ?, login = ?, senha = ? where idConta ="+id+"";
        try{
            conn = new Conexao().getConexao();
            sttm = conn.prepareStatement(sql);
            sttm.setString(1, cliente.getNome());
            sttm.setString(2, cliente.getCpf());
            sttm.setString(3, cliente.getTelefone());
            sttm.setString(4, cliente.getTipoCnh());
            sttm.setInt(5, cliente.getIdade());
            sttm.setString(6, cliente.getEmail());
            sttm.setString(7, cliente.getLogin());
            sttm.setString(8, cliente.getSenha());

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
        String sql="select * from clientes join contas on contas.idConta = clientes.fkConta where cpf ='"+valor+"'";
        int idConta = 0 ;
        try{
            conn = new Conexao().getConexao();
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){idConta = Integer.parseInt(rs.getString("idConta"));}
            st.close();
            st = conn.createStatement();
            String sql1="delete from clientes where fkConta = "+idConta;
            st.execute(sql1);
            st.close();
            String sql2="delete from contas where idConta = "+idConta;
            st = conn.createStatement();
            st.execute(sql2);
            conn.close();
            st.close();
        }catch(Exception erro){
            throw new RuntimeException("erro 4:"+erro);
        }
    }
    
    public ArrayList<ClienteConta> listarTodos(){
        String sql="select * from clientes join contas on clientes.fkConta = contas.idConta";
        try{
            conn = new Conexao().getConexao();
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            lista.clear();
            while(rs.next()){
                ClienteConta cliente = new ClienteConta();
                
                cliente.setNome(rs.getString("nome"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setTelefone(rs.getString("telefone"));
                cliente.setTipoCnh(rs.getString("tipoCnh"));
                cliente.setIdade(rs.getInt("idade"));
                cliente.setEmail(rs.getString("email"));
                cliente.setTipo(rs.getString("tipo"));
                cliente.setLogin(rs.getString("login"));
                cliente.setSenha(rs.getString("senha"));
                lista.add(cliente);
            }
            conn.close();
            st.close();
        }catch(Exception erro){
            throw new RuntimeException("erro 5:"+erro);
        }
        return lista;
    }
    
    public String[] buscarAlterar(String valor){
        String sql="select * from clientes join contas on contas.idConta = clientes.fkConta where cpf ='"+valor+"'";
        String dados[] = new String[11];
        try{
            conn = new Conexao().getConexao();
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
                
                dados[0] = rs.getString("nome");
                dados[1] = rs.getString("cpf");
                dados[2] = rs.getString("telefone");
                dados[3] = rs.getString("tipoCnh");
                dados[4] = rs.getString("idade");
                dados[5] = rs.getString("email");
                dados[6] = rs.getString("login");
                dados[7] = rs.getString("senha");
                dados[8] = rs.getString("idConta");
            }
            conn.close();
            st.close();
        }catch(Exception erro){
            throw new RuntimeException("erro 6:"+erro);
        }
        return dados;
    }
    
    public ArrayList<ClienteConta> pesquisar(String valor){
        String sql="select * from clientes join contas on contas.idConta = clientes.fkConta where nome like '%"+valor+"%'";
        try{
            conn = new Conexao().getConexao();
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            lista.clear();
            while(rs.next()){
                ClienteConta cliente = new ClienteConta();
                
                cliente.setNome(rs.getString("nome"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setTelefone(rs.getString("telefone"));
                cliente.setTipoCnh(rs.getString("tipoCnh"));
                cliente.setIdade(rs.getInt("idade"));
                cliente.setEmail(rs.getString("email"));
                cliente.setTipo(rs.getString("tipo"));
                cliente.setLogin(rs.getString("login"));
                cliente.setSenha(rs.getString("senha"));
                lista.add(cliente);
            }
            conn.close();
            st.close();
        }catch(Exception erro){
            throw new RuntimeException("erro 7:"+erro);
        }
        return lista;
    }
    
    public boolean verifCpf(String cpf){
        String sql = "select cpf from clientes join contas on clientes.fkConta = contas.idConta where cpf = '"+cpf+"'";
        boolean verif = false;
        try{
            conn = new Conexao().getConexao();
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
                if((rs.getString("cpf")).equals(cpf)){
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
    
}
