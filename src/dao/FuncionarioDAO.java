/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import apoio.ConexaoBD;
import apoio.IDAOT;
import entidade.Funcionario;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author evely
 */
public class FuncionarioDAO implements IDAOT<Funcionario> {

        ResultSet resultadoQ;


    @Override
    public String salvar(Funcionario o) {
         try {
//            Statement stm = ferrados.Ferrados.conexao.createStatement();
            Statement stm = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "Insert into funcionario values "
                    + "(default,"
                    + " '" + o.getNome() + "',"
                    + " '" + o.getUsername() + "',"
                    + " '" + o.getSenha() + "',"
                    + " '" + o.getCpf() + "',"
                    + " '" + o.getTelefone() + "',"
                    + " '" + o.getCidade() + "',"
                    + " '" + o.getEmail() + "',"
                    + " '" + o.getSituacao() + "')";

            System.out.println("SQL: " + sql);

            int resultado = stm.executeUpdate(sql);
            return null;
        } catch (Exception e) {
            System.out.println("Erro ao salvar funcionario: " + e);
            return e.toString();
        }
    }

    @Override
    public String atualizar(Funcionario o) {
         try {
            Statement stm = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "UPDATE funcionario "
                    + "SET nome = '" + o.getNome() + "', "
                    + "email = '" + o.getEmail() + "', "
                    + "cpf = '" + o.getCpf() + "', "
                    + "telefone = '" + o.getTelefone() + "', "
                    + "cidade = '" + o.getCidade() + "' ,"
                    + "situacao = '" + o.getSituacao() + "' ,"
                    + "username = '" + o.getUsername() + "' ,"
                    + "senha = '" + o.getSenha() + "' "
                    + "WHERE id = " + o.getId();

            System.out.println("SQL: " + sql);

            int resultado = stm.executeUpdate(sql);

            return null;
        } catch (Exception e) {
            System.out.println("Erro ao atualizar funcionario: " + e);
            return e.toString();
        }
    }

    @Override
    public String excluir(int id) {
        try {
            Statement stm = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "DELETE FROM funcionario "
                        +"WHERE id = " + id;
            System.out.println("SQL: " + sql);

            int resultado = stm.executeUpdate(sql);

            return null;
        } catch (Exception e) {
            System.out.println("Erro ao excluir: " + e);
            return e.toString();
        }  
    }

    @Override
    public String inativar(int id) {
        try {
            Statement stm = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "UPDATE funcionario "
                    + "SET situacao = 'i' "
                   + "WHERE id = " + id;

           System.out.println("SQL: " + sql);

            int resultado = stm.executeUpdate(sql);

            return null;
            
       } catch (Exception e) {
            System.out.println("Erro ao inativar: " + e);
           return e.toString();
        }
    }

    @Override
    public ArrayList<Funcionario> consultarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Funcionario> consultar(String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Funcionario consultarId(int id) {
        Funcionario funcionario = null;

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "SELECT * "
                    + "FROM funcionario "
                    + "WHERE "
                    + "id = " + id;

            System.out.println("SQL: " + sql);

            ResultSet retorno = st.executeQuery(sql);

            if (retorno.next()) {
                funcionario = new Funcionario();

                funcionario.setId(retorno.getInt("id"));
                funcionario.setNome(retorno.getString("nome"));
                funcionario.setEmail(retorno.getString("email"));
                funcionario.setCpf(retorno.getString("cpf"));
                funcionario.setTelefone(retorno.getString("telefone"));
                funcionario.setCidade(retorno.getString("cidade"));
                funcionario.setSituacao(retorno.getString("situacao").charAt(0));                
                funcionario.setUsername(retorno.getString("username"));
                funcionario.setSenha(retorno.getString("senha"));
            }

        } catch (Exception e) {
            System.out.println("Erro ao consultar funcionario: " + e);
        }

        return funcionario;
    }
    
    public Funcionario consultarFuncionario (String username, String senha) 
    {
        Funcionario funcionario = null;

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "SELECT * "
                    + "FROM funcionario "
                    + "WHERE "
                    + "username = '" + username + "'"
                    + "AND senha = '" + senha + "'"
                    + "AND situacao = 'a'";

            System.out.println("SQL: " + sql);

            ResultSet retorno = st.executeQuery(sql);

            if (retorno.next()) {
                funcionario = new Funcionario();

                funcionario.setId(retorno.getInt("id"));
                funcionario.setNome(retorno.getString("nome"));
                funcionario.setSituacao(retorno.getString("situacao").charAt(0));
                funcionario.setSenha(retorno.getString("senha"));
            }
         } catch (Exception e) {
            System.out.println("Erro ao consultar funcionario: " + e);
        }

        return funcionario;
        
    }
    
  
    public void popularTabela(JTable tabela, String criterio) {
        // dados da tabela
        Object[][] dadosTabela = null;

        // cabecalho da tabela
        Object[] cabecalho = new Object[6];
        cabecalho[0] = "Id";
        cabecalho[1] = "Nome";
        cabecalho[2] = "Email";
        cabecalho[3] = "CPF";
        cabecalho[4] = "Cidade";
        cabecalho[5] = "Telefone";


        // cria matriz de acordo com nº de registros da tabela
        try {
            resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(""
                    + "SELECT count(*) FROM funcionario "
                    + "WHERE nome ILIKE '%" + criterio + "%'");

            resultadoQ.next();

            // instancia da matrzi de acordo com o nº de linhas do ResultSet
            dadosTabela = new Object[resultadoQ.getInt(1)][6];

        } catch (Exception e) {
            System.out.println("Erro ao consultar cliente: " + e);
        }

        int lin = 0;

        // efetua consulta na tabela
        try {
            resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(""
                    
                   + "SELECT id, nome, email, cpf, cidade, telefone "
                    + "FROM funcionario "
                    + "WHERE nome ILIKE '%" + criterio + "%' "
                    + "ORDER BY nome");

            while (resultadoQ.next()) {

                dadosTabela[lin][0] = resultadoQ.getString("id");
                dadosTabela[lin][1] = resultadoQ.getString("nome");
                dadosTabela[lin][2] = resultadoQ.getString("email");
                dadosTabela[lin][3] = resultadoQ.getString("cpf");
                dadosTabela[lin][4] = resultadoQ.getString("cidade");
                dadosTabela[lin][5] = resultadoQ.getString("telefone");
                                 
                lin++;                
            }
        } catch (Exception e) {
            System.out.println("problemas para popular tabela...");
            System.out.println(e);
         }

        // configuracoes adicionais no componente tabela
        tabela.setModel(new DefaultTableModel(dadosTabela, cabecalho) {
            @Override
            // quando retorno for FALSE, a tabela nao é editavel
            public boolean isCellEditable(int row, int column) {
                return false;  
            }
        });

        // permite seleção de apenas uma linha da tabela
        tabela.setSelectionMode(0);

        // redimensiona as colunas de uma tabela     
            TableColumn column = null;
            for (int i = 0; i < tabela.getColumnCount(); i++) {
            column = tabela.getColumnModel().getColumn(i);
            switch (i) {
                case 0: 
                    column.setPreferredWidth(80);
                    column.setMaxWidth(80);
                    column.setMinWidth(25);
                    break;
            }   
}
}
}
