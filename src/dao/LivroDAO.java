/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import apoio.ConexaoBD;
import apoio.IDAOT;
import entidade.Livro;
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
public class LivroDAO implements IDAOT <Livro> {
    
       ResultSet resultadoQ;

    @Override
    public String salvar(Livro o) {
        try {
//            Statement stm = ferrados.Ferrados.conexao.createStatement();
            Statement stm = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "Insert into livro values "
                    + "(default,"
                    + " '" + o.getTitulo() + "',"
                    + " " + o.getQuantidade() + ","
                    + " " + o.getValor_custo() + ","
                    + " " + o.getValor_venda() + ","
                    + " '" + o.getIdioma() + "',"
                    + " '" + o.getSituacao() + "',"
                    + " " + o.getEstante_id() + ","
                    + " " + o.getEditora_id() + ","
                    + " " + o.getCategoria_id() + ","
                    + " " + o.getAutor_id() + ")";

            System.out.println("SQL: " + sql);

            int resultado = stm.executeUpdate(sql);

            return null;
        } catch (Exception e) {
            System.out.println("Erro ao salvar livro: " + e);
            return e.toString();
        }
    }

    @Override
    public String atualizar(Livro o) {
       try {
            Statement stm = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "UPDATE livro "
                    + "SET titulo = '" + o.getTitulo() + "', "
                    + "quantidade = " + o.getQuantidade() + " "
                    + "valor_custo = " + o.getValor_custo() + " "
                    + "valor_venda = " + o.getValor_venda() + " "
                    + "idioma = '" + o.getIdioma() + "' "
                    + "situacao = '" + o.getSituacao() + "' "
                    + "estante_id = " + o.getEstante_id() + " "
                    + "editora_id = " + o.getEditora_id() + " "
                    + "categoria_id = " + o.getCategoria_id() + " "
                    + "autor_id = " + o.getAutor_id() + " "
                    + "WHERE id = " + o.getId();

            System.out.println("SQL: " + sql);

            int resultado = stm.executeUpdate(sql);

            return null;
        } catch (Exception e) {
            System.out.println("Erro ao atualizar livro: " + e);
            return e.toString();
        }
    }

    @Override
    public String excluir(int id) {
         try {
            Statement stm = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "DELETE FROM livro "
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

            String sql = "UPDATE livro "
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
    public ArrayList<Livro> consultarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Livro> consultar(String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Livro consultarId(int id) {
       Livro livro = null;

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "SELECT * "
                    + "FROM livro "
                    + "WHERE "
                    + "id = " + id;

            System.out.println("SQL: " + sql);

            ResultSet retorno = st.executeQuery(sql);

            if (retorno.next()) {
                livro = new Livro();

                livro.setId(retorno.getInt("id"));
                livro.setTitulo(retorno.getString("titulo"));
                livro.setQuantidade(retorno.getInt("quantidade"));
                livro.setValor_custo(retorno.getDouble("valor_custo"));
                livro.setValor_venda(retorno.getDouble("valor_venda"));
                livro.setIdioma(retorno.getString("idioma"));
                livro.setSituacao(retorno.getString("situacao").charAt(0));
                livro.setEstante_id(retorno.getInt("estante_id"));
                livro.setEditora_id(retorno.getInt("editora_id"));
                livro.setCategoria_id(retorno.getInt("categoria_id"));
                livro.setAutor_id(retorno.getInt("autor_id"));
            }

        } catch (Exception e) {
            System.out.println("Erro ao consultar livro: " + e);
        }

        return livro;
    }
    
    public void popularTabela(JTable tabela, String criterio) {
        // dados da tabela
        Object[][] dadosTabela = null;

        // cabecalho da tabela
        Object[] cabecalho = new Object[7];
        cabecalho[0] = "Id";
        cabecalho[1] = "Título";
        cabecalho[2] = "Valor";
        cabecalho[3] = "Autor";
        cabecalho[4] = "Categoria";
        cabecalho[5] = "Estante";
        cabecalho[6] = "Qtd";

        // cria matriz de acordo com nº de registros da tabela
        try {
            resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(""
                    + "SELECT count(*) FROM livro "
                    + "WHERE titulo ILIKE '%" + criterio + "%'");

            resultadoQ.next();

            // instancia da matrzi de acordo com o nº de linhas do ResultSet
            dadosTabela = new Object[resultadoQ.getInt(1)][7];

        } catch (Exception e) {
            System.out.println("Erro ao consultar livro: " + e);
        }

        int lin = 0;

        // efetua consulta na tabela
        try {
            resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(""
                    
                   + "SELECT l.id as id, l.titulo as titulo, l.valor_venda as valor, a.nome as autor, c.descricao as categoria, e.descricao as estante, l.quantidade as qtd "
                    + "FROM livro l, categoria c, autor a, estante e "
                    + "WHERE l.titulo ILIKE '%" + criterio + "%' AND c.id=l.categoria_id AND a.id=l.autor_id AND e.id=l.estante_id "
                    + "ORDER BY l.titulo");

            while (resultadoQ.next()) {

                dadosTabela[lin][0] = resultadoQ.getInt("id");
                dadosTabela[lin][1] = resultadoQ.getString("titulo");
                dadosTabela[lin][2] = resultadoQ.getDouble("valor");
                dadosTabela[lin][3] = resultadoQ.getString("autor");
                dadosTabela[lin][4] = resultadoQ.getString("categoria");
                dadosTabela[lin][5] = resultadoQ.getString("estante");
                dadosTabela[lin][6] = resultadoQ.getInt("qtd");
                                 
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
                case 0: case 6:
                    column.setPreferredWidth(80);
                    column.setMaxWidth(80);
                    column.setMinWidth(25);
                    break;
                case 1:
                    column.setPreferredWidth(140);
                    break;
            }
        }

            }       
    }

    


