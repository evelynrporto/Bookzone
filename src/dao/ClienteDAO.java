/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import apoio.ConexaoBD;
import apoio.IDAOT;
import entidade.Cliente;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author evely
 */
public class ClienteDAO implements IDAOT <Cliente> {
        ResultSet resultadoQ;

    @Override
    public String salvar(Cliente o) {
        try {
//            Statement stm = ferrados.Ferrados.conexao.createStatement();
            Statement stm = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "Insert into cliente values "
                    + "(default,"
                    + " '" + o.getNome() + "',"
                    + " '" + o.getEmail() + "',"
                    + " '" + o.getCpf() + "',"
                    + " '" + o.getCidade() + "',"
                    + " '" + o.getDatanasc() + "',"
                    + " '" + o.getCelular() + "',"
                    + " '" + o.getSituacao() + "')";

            System.out.println("SQL: " + sql);

            int resultado = stm.executeUpdate(sql);          
            return null;
            
        } catch (Exception e) {
            System.out.println("Erro ao salvar cliente: " + e);
            return e.toString();
        }
    }

    @Override
    public String atualizar(Cliente o) {
        try {
            Statement stm = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "UPDATE cliente "
                    + "SET nome = '" + o.getNome() + "', "
                    + "email = '" + o.getEmail() + "' ,"
                    + "cpf = '" + o.getCpf() + "' ,"
                    + "cidade = '" + o.getCidade() + "' ,"
                    + "celular = '" + o.getCelular() + "' ,"
                    + "datanasc = '" + o.getDatanasc() + "' ,"
                    + "situacao = '" + o.getSituacao() + "' "
                    + "WHERE id = " + o.getId();

            System.out.println("SQL: " + sql);

            int resultado = stm.executeUpdate(sql);

            return null;
        } catch (Exception e) {
            System.out.println("Erro ao atualizar cliente: " + e);
            return e.toString();
        }
    }

    @Override
    public String excluir(int id) {
        try {
            Statement stm = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "DELETE FROM cliente "
                        +"WHERE id = " + id;
            System.out.println("SQL: " + sql);

            int resultado = stm.executeUpdate(sql);

            return null;
        } catch (Exception e) {
            System.out.println("Erro ao excluir cliente: " + e);
            return e.toString();
        }  
    }

    @Override
    public String inativar(int id) {
        try {
            Statement stm = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "UPDATE cliente "
                    + "SET situacao = 'i' "
                   + "WHERE id = " + id;

           System.out.println("SQL: " + sql);

            int resultado = stm.executeUpdate(sql);

            return null;
            
       } catch (Exception e) {
            System.out.println("Erro ao inativar cliente: " + e);
           return e.toString();
        }
    }

    @Override
    public ArrayList<Cliente> consultarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Cliente> consultar(String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Cliente consultarId(int id) {
        Cliente cliente = null;
        DateTimeFormatter format = DateTimeFormatter.ofPattern("d MMMM yyyy");
        
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "SELECT * "
                    + "FROM cliente "
                    + "WHERE "
                    + "id = " + id;

            System.out.println("SQL: " + sql);

            ResultSet retorno = st.executeQuery(sql);

            if (retorno.next()) {
                cliente = new Cliente();

                cliente.setId(retorno.getInt("id"));
                cliente.setNome(retorno.getString("nome"));
                cliente.setEmail(retorno.getString("email"));
                cliente.setCpf(retorno.getString("cpf"));
                cliente.setCidade(retorno.getString("cidade"));
                cliente.setCelular(retorno.getString("celular"));
                cliente.setDatanasc(retorno.getDate("datanasc"));
                cliente.setSituacao(retorno.getString("situacao").charAt(0));                
            }

        } catch (Exception e) {
            System.out.println("Erro ao consultar cliente: " + e);
        }

        return cliente;
    }
    
    public void popularTabela(JTable tabela, String criterio) {
        // dados da tabela
        Object[][] dadosTabela = null;

        // cabecalho da tabela
        Object[] cabecalho = new Object[5];
        cabecalho[0] = "Id";
        cabecalho[1] = "Nome";
        cabecalho[2] = "Email";
        cabecalho[3] = "CPF";
        cabecalho[4] = "Celular";


        // cria matriz de acordo com nº de registros da tabela
        try {
            resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(""
                    + "SELECT count(*) FROM cliente "
                    + "WHERE nome ILIKE '%" + criterio + "%'");

            resultadoQ.next();

            // instancia da matrzi de acordo com o nº de linhas do ResultSet
            dadosTabela = new Object[resultadoQ.getInt(1)][5];

        } catch (Exception e) {
            System.out.println("Erro ao consultar cliente: " + e);
        }

        int lin = 0;

        // efetua consulta na tabela
        try {
            resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(""
                    
                   + "SELECT id, nome, email, cpf, celular "
                    + "FROM cliente "
                    + "WHERE nome ILIKE '%" + criterio + "%' "
                    + "ORDER BY nome");

            while (resultadoQ.next()) {

                dadosTabela[lin][0] = resultadoQ.getInt("id");
                dadosTabela[lin][1] = resultadoQ.getString("nome");
                dadosTabela[lin][2] = resultadoQ.getString("email");
                dadosTabela[lin][3] = resultadoQ.getString("cpf");
                dadosTabela[lin][4] = resultadoQ.getString("celular");
                                 
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
    

