/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import apoio.ConexaoBD;
import apoio.IDAOT;
import entidade.ItemVenda;
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
public class ItemVendaDAO implements IDAOT <ItemVenda> {
    
           ResultSet resultadoQ;

    @Override
    public String salvar(ItemVenda o) {
         try {
//            Statement stm = ferrados.Ferrados.conexao.createStatement();
            Statement stm = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "Insert into item_venda values "
                    + "(default,"
                    + " " + o.getIdVenda() + ","
                    + " " + o.getIdProduto()+ ","
                    + " '" + o.getNomeProduto() + "',"
                    + " " + o.getQuantidade() + ","
                    + " " + o.getValor_item() + ","
                    + " " + o.getSubtotal() + ")";

            System.out.println("SQL: " + sql);
            
            int resultado = stm.executeUpdate(sql);
            return null;
        } catch (Exception e) {
            System.out.println("Erro ao salvar item: " + e);
            return e.toString();
        }
         
    }

    @Override
    public String atualizar(ItemVenda o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String excluir(int idItem) {
         try {
            Statement stm = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "DELETE FROM item_venda "
                        +"WHERE id = " + idItem;
            System.out.println("SQL: " + sql);

            int resultado = stm.executeUpdate(sql);

            return null;
        } catch (Exception e) {
            System.out.println("Erro ao excluir item: " + e);
            return e.toString();
        }  
    }
    

    @Override
    public String inativar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<ItemVenda> consultarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<ItemVenda> consultar(String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ItemVenda consultarId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
           
     public void popularTabela(JTable tabela, int idVenda) {
        // dados da tabela
        Object[][] dadosTabela = null;

        // cabecalho da tabela
        Object[] cabecalho = new Object[5];
        cabecalho[0] = "Código";
        cabecalho[1] = "Título";
        cabecalho[2] = "Preço";
        cabecalho[3] = "Quantidade";
        cabecalho[4] = "Subtotal";
        
         try {
            resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(""
                    + "SELECT count(*) FROM item_venda "
                    + "WHERE idvenda = " + idVenda + " ");

            resultadoQ.next();

            // instancia da matrzi de acordo com o nº de linhas do ResultSet
            dadosTabela = new Object[resultadoQ.getInt(1)][5];

        } catch (Exception e) {
            System.out.println("Erro ao consultar itens: " + e);
        }

        int lin = 0;

        // efetua consulta na tabela
        try {
            resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(""
                    
                   + "SELECT id, nomeProduto, valor_item, quantidade, subtotal "
                    + "FROM item_venda "
                    + "WHERE idVenda = " + idVenda + " ");

            while (resultadoQ.next()) {

                dadosTabela[lin][0] = resultadoQ.getInt("id");
                dadosTabela[lin][1] = resultadoQ.getString("nomeProduto");
                dadosTabela[lin][2] = resultadoQ.getDouble("valor_item");
                dadosTabela[lin][3] = resultadoQ.getInt("quantidade");
                dadosTabela[lin][4] = resultadoQ.getDouble("subtotal");
                                 
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
