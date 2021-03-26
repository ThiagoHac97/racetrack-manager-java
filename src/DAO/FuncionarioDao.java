package DAO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.FuncionarioConta;

public class FuncionarioDao {
    
    private Connection conn;
    private PreparedStatement sttm;
    private Statement st;
    private ResultSet rs;
    private ArrayList<FuncionarioConta> lista = new ArrayList<FuncionarioConta>(); 
    
    
    public void inserir(FuncionarioConta funcionario){
        String sql = "insert into contas(idConta, email, tipo, login, senha) values(null, ?, ?, ?, ?)";
        String sql1 = "INSERT INTO funcionarios(idFuncionario, nome, cpf, telefone, fkConta, Cargo, DataContrato, DataFim) VALUES (null,?,?,?,LAST_INSERT_ID(),?,?,?)";
        try{
            conn = new Conexao().getConexao();
            sttm = conn.prepareStatement(sql);
            sttm.setString(1, funcionario.getEmail());
            sttm.setString(2, funcionario.getTipo());
            sttm.setString(3, funcionario.getLogin());
            sttm.setString(4, funcionario.getSenha());
            if(sttm.execute()==false)
               {
                    sttm.close();
                    sttm = conn.prepareStatement(sql1);
                    sttm.setString(1, funcionario.getNome());
                    sttm.setString(2, funcionario.getCpf());
                    sttm.setString(3, funcionario.getTelefone());
                    sttm.setString(4, funcionario.getCargo());
                    sttm.setString(5, funcionario.getDataContrato());
                    sttm.setString(6, funcionario.getDataFim());
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
    
    public void alterar(FuncionarioConta funcionario){
        int id = funcionario.getIdConta();
        String sql="update contas join funcionarios on contas.idConta = funcionarios.fkConta set nome = ?, cpf = ?, telefone = ?, Cargo = ?, DataContrato = ?, DataFim = ?,email = ?, tipo= ?, login= ?, senha= ? where idConta ="+id+"";
        try{
            conn = new Conexao().getConexao();
            sttm = conn.prepareStatement(sql);
            sttm.setString(1, funcionario.getNome());
            sttm.setString(2, funcionario.getCpf());
            sttm.setString(3, funcionario.getTelefone());
            sttm.setString(4, funcionario.getCargo());
            sttm.setString(5, funcionario.getDataContrato());
            sttm.setString(6, funcionario.getDataFim());
            sttm.setString(7, funcionario.getEmail());
            sttm.setString(8, funcionario.getTipo());
            sttm.setString(9, funcionario.getLogin());
            sttm.setString(10, funcionario.getSenha());

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
        String sql="select * from funcionarios join contas on contas.idConta = funcionarios.fkConta where cpf ='"+valor+"'";
        int idConta = 0 ;
        try{
            conn = new Conexao().getConexao();
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){idConta = Integer.parseInt(rs.getString("idConta"));}
            st.close();
            st = conn.createStatement();
            String sql1="delete from funcionarios where fkConta = "+idConta;
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
    
    public ArrayList<FuncionarioConta> listarTodos(){
        String sql="select * from funcionarios join contas on funcionarios.fkConta = contas.idConta";
        try{
            conn = new Conexao().getConexao();
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            lista.clear();
            while(rs.next()){
                FuncionarioConta funcionario = new FuncionarioConta();
                
                funcionario.setNome(rs.getString("nome"));
                funcionario.setCpf(rs.getString("cpf"));
                funcionario.setCargo(rs.getString("Cargo"));
                funcionario.setDataContrato(rs.getString("DataContrato"));
                funcionario.setDataFim(rs.getString("DataFim"));
                funcionario.setTelefone(rs.getString("telefone"));
                funcionario.setEmail(rs.getString("email"));
                funcionario.setTipo(rs.getString("tipo"));
                funcionario.setLogin(rs.getString("login"));
                funcionario.setSenha(rs.getString("senha"));
                lista.add(funcionario);
            }
            conn.close();
            st.close();
        }catch(Exception erro){
            throw new RuntimeException("erro 5:"+erro);
        }
        return lista;
    }
    
    public String[] buscarAlterar(String valor){
        String sql="select * from funcionarios join contas on contas.idConta = funcionarios.fkConta where cpf ='"+valor+"'";
        String dados[] = new String[11];
        try{
            conn = new Conexao().getConexao();
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
                
                dados[0] = rs.getString("nome");
                dados[1] = rs.getString("cpf");
                dados[2] = rs.getString("Cargo");
                dados[3] = rs.getString("DataContrato");
                dados[4] = rs.getString("DataFim");
                dados[5] = rs.getString("telefone");
                dados[6] = rs.getString("email");
                dados[7] = rs.getString("tipo");
                dados[8] = rs.getString("login");
                dados[9] = rs.getString("senha");
                dados[10] = rs.getString("idConta");
            }
            conn.close();
            st.close();
        }catch(Exception erro){
            throw new RuntimeException("erro 6:"+erro);
        }
        return dados;
    }
    
    public ArrayList<FuncionarioConta> pesquisar(String valor){
        String sql="select * from funcionarios join contas on contas.idConta = funcionarios.fkConta where nome like '%"+valor+"%'";
        try{
            conn = new Conexao().getConexao();
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            lista.clear();
            while(rs.next()){
                FuncionarioConta funcionario = new FuncionarioConta();
                
                funcionario.setNome(rs.getString("nome"));
                funcionario.setCpf(rs.getString("cpf"));
                funcionario.setCargo(rs.getString("Cargo"));
                funcionario.setDataContrato(rs.getString("DataContrato"));
                funcionario.setDataFim(rs.getString("DataFim"));
                funcionario.setTelefone(rs.getString("telefone"));
                funcionario.setEmail(rs.getString("email"));
                funcionario.setTipo(rs.getString("tipo"));
                funcionario.setLogin(rs.getString("login"));
                funcionario.setSenha(rs.getString("senha"));                
                lista.add(funcionario);
            }
            conn.close();
            st.close();
        }catch(Exception erro){
            throw new RuntimeException("erro 7:"+erro);
        }
        return lista;
    }
    
}
