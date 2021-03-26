package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.EmpresaConta;

public class EmpresaDao {
    
    private Connection conn;
    private PreparedStatement sttm;
    private Statement st;
    private ResultSet rs;
    private ArrayList<EmpresaConta> lista = new ArrayList<EmpresaConta>(); 
    
    
    public void inserir(EmpresaConta empresa){
        String sql = "insert into contas(idConta, email, tipo, login, senha) values(null, ?, ?, ?, ?)";
        String sql1 = "INSERT INTO empresas_terceiras(idEmpresa, nome, nomeResponsavel, tipoServico, telefone, fkConta) VALUES (null,?,?,?,?,LAST_INSERT_ID())";
        try{
            conn = new Conexao().getConexao();
            sttm = conn.prepareStatement(sql);
            sttm.setString(1, empresa.getEmail());
            sttm.setString(2, empresa.getTipo());
            sttm.setString(3, empresa.getLogin());
            sttm.setString(4, empresa.getSenha());
            if(sttm.execute()==false)
               {
                    sttm.close();
                    sttm = conn.prepareStatement(sql1);
                    sttm.setString(1, empresa.getNome());
                    sttm.setString(2, empresa.getNomeResponsavel());
                    sttm.setString(3, empresa.getTipoServico());
                    sttm.setString(4, empresa.getTelefone());
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
    
    public void alterar(EmpresaConta empresa){
        int id = empresa.getIdEmpresa();
        String sql="update contas join empresas_terceiras on contas.idConta = empresas_terceiras.fkConta set email = ?, login = ?, senha = ?, nome = ?, nomeResponsavel= ?, tipoServico= ?, telefone= ? where idEmpresa ="+id+"";
        try{
            conn = new Conexao().getConexao();
            sttm = conn.prepareStatement(sql);
            sttm.setString(1, empresa.getEmail());
            sttm.setString(2, empresa.getLogin());
            sttm.setString(3, empresa.getSenha());
            sttm.setString(4, empresa.getNome());
            sttm.setString(5, empresa.getNomeResponsavel());
            sttm.setString(6, empresa.getTipoServico());
            sttm.setString(7, empresa.getEmail());

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
    
    public void excluir(int valor){
        String sql="select * from empresas_terceiras join contas on contas.idConta = empresas_terceiras.fkConta where idEmpresa ="+valor+"";
        int idConta = 0 ;
        try{
            conn = new Conexao().getConexao();
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){idConta = Integer.parseInt(rs.getString("idConta"));}
            st.close();
            st = conn.createStatement();
            String sql1="delete from empresas_terceiras where fkConta = "+idConta;
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
    
    public ArrayList<EmpresaConta> listarTodos(){
        String sql="select * from empresas_terceiras join contas on empresas_terceiras.fkConta = contas.idConta";
        try{
            conn = new Conexao().getConexao();
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            lista.clear();
            while(rs.next()){
                EmpresaConta empresa = new EmpresaConta();
                
                empresa.setIdEmpresa(rs.getInt("idEmpresa"));
                empresa.setEmail(rs.getString("email"));
                empresa.setTipo(rs.getString("tipo"));
                empresa.setLogin(rs.getString("login"));
                empresa.setSenha(rs.getString("senha"));
                empresa.setNome(rs.getString("nome"));
                empresa.setNomeResponsavel(rs.getString("nomeResponsavel"));
                empresa.setTipoServico(rs.getString("tipoServico"));
                empresa.setTelefone(rs.getString("telefone"));
                lista.add(empresa);
            }
            conn.close();
            st.close();
        }catch(Exception erro){
            throw new RuntimeException("erro 5:"+erro);
        }
        return lista;
    }
    
    public String[] buscarAlterar(String valor){
        String sql="select * from empresas_terceiras join contas on contas.idConta = empresas_terceiras.fkConta where idEmpresa ="+valor+"";
        String dados[] = new String[8];
        try{
            conn = new Conexao().getConexao();
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
                dados[0] = rs.getString("idEmpresa");
                dados[1] = rs.getString("email");
                dados[2] = rs.getString("login");
                dados[3] = rs.getString("senha");
                dados[4] = rs.getString("nome");
                dados[5] = rs.getString("nomeResponsavel");
                dados[6] = rs.getString("tipoServico");
                dados[7] = rs.getString("telefone");
            }
            conn.close();
            st.close();
        }catch(Exception erro){
            throw new RuntimeException("erro 6:"+erro);
        }
        return dados;
    }
    
    public ArrayList<EmpresaConta> pesquisar(String valor){
        String sql="select * from empresas_terceiras join contas on contas.idConta = empresas_terceiras.fkConta where nome like '%"+valor+"%'";
        try{
            conn = new Conexao().getConexao();
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            lista.clear();
            while(rs.next()){
                EmpresaConta empresa = new EmpresaConta();
                
                empresa.setIdEmpresa(rs.getInt("idEmpresa"));
                empresa.setEmail(rs.getString("email"));
                empresa.setTipo(rs.getString("tipo"));
                empresa.setLogin(rs.getString("login"));
                empresa.setSenha(rs.getString("senha"));
                empresa.setNome(rs.getString("nome"));
                empresa.setNomeResponsavel(rs.getString("nomeResponsavel"));
                empresa.setTipoServico(rs.getString("tipoServico"));
                empresa.setTelefone(rs.getString("telefone"));
                lista.add(empresa);
            }
            conn.close();
            st.close();
        }catch(Exception erro){
            throw new RuntimeException("erro 7:"+erro);
        }
        return lista;
    }
}
