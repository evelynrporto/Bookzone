/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import apoio.ConexaoBD;
import apoio.IDAOT;
import entidade.Venda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author evely
 */
public class VendaDAO implements IDAOT <Venda> {
    
    ResultSet resultadoQ;
    
    @Override
    public String salvar(Venda o) {
          try {
//            Statement stm = ferrados.Ferrados.conexao.createStatement();
            Statement stm = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "Insert into vendas values "
                    + "( " + o.getId() + ","
                    + " '" + o.getData_venda() + "',"
                    + " " + o.getValor_pagamento() + ","
                    + " '" + o.getForma_pagamento() + "',"
                    + " " + o.getCliente_id() + ","
                    + " " + o.getFuncionario_id() + ")";


            System.out.println("SQL: " + sql);

            int resultado = stm.executeUpdate(sql);
            return null;
        } catch (Exception e) {
            System.out.println("Erro ao salvar venda: " + e);
            return e.toString();
        }   
    }

    @Override
    public String atualizar(Venda o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String excluir(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String inativar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Venda> consultarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Venda> consultar(String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Venda consultarId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public int obterUltima() {
        
        int ultimaVenda = 0;
        
         try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "SELECT MAX(id) qtdVendas FROM vendas";

            System.out.println("SQL: " + sql);

            ResultSet retorno = st.executeQuery(sql);

            if (retorno.next()) {
                
               ultimaVenda = retorno.getInt("qtdVendas");
            }

        } catch (Exception e) {
            System.out.println("Erro ao consultar livro: " + e);
        }

        return ultimaVenda;
        
    }
    
    public void EfetuarConsulta(JTable tabela, String dataIni, String dataFim, String func, String cliente){
        
       Object[][] dadosTabela = null;
        // cabecalho da tabela
        Object[] cabecalho = new Object[6];
        cabecalho[0] = "Id Venda";
        cabecalho[1] = "Data";
        cabecalho[2] = "Valor Pago";
        cabecalho[3] = "Forma Pagamento";
        cabecalho[4] = "Funcionario";
        cabecalho[5] = "Cliente";
            
        try {
            resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(""
                    + "SELECT count(*) FROM vendas "
                    + "WHERE data_venda BETWEEN '"+dataIni+"' AND '"+dataFim+"'");

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
                    
                    +"SELECT v.id as id, v.data_venda as data, v.valor_pagamento as valor, v.forma_pagamento as FormaPagamento, f.nome as funcionario, c.nome as cliente "
                    + "FROM vendas v, funcionario f, cliente c "
                    + "WHERE v.data_venda BETWEEN '"+dataIni+"' AND '"+dataFim+"' AND f.cpf ILIKE '%"+func+"%' and c.cpf ILIKE '%"+cliente+"%' "
                    + "AND c.id = v.cliente_id AND f.id = v.funcionario_id");

            while (resultadoQ.next()) {

                dadosTabela[lin][0] = resultadoQ.getInt("id");
                dadosTabela[lin][1] = resultadoQ.getString("data");
                dadosTabela[lin][2] = resultadoQ.getDouble("valor");
                dadosTabela[lin][3] = resultadoQ.getString("FormaPagamento");
                dadosTabela[lin][4] = resultadoQ.getString("funcionario");
                dadosTabela[lin][5] = resultadoQ.getString("cliente");
                                 
                lin++;                
            }
        } catch (Exception e) {
            System.out.println("problemas para popular tabela...");
            System.out.println(e);
         }    
    }
    
     public void popularTabela(JTable tabela, String dataIni, String dataFim, String cpfCli, String cpfFunc) {
        // dados da tabela
        Object[][] dadosTabela = null;

        // cabecalho da tabela
        Object[] cabecalho = new Object[6];
        cabecalho[0] = "Id Venda";
        cabecalho[1] = "Data";
        cabecalho[2] = "Valor Pago";
        cabecalho[3] = "Forma Pagamento";
        cabecalho[4] = "Funcionario";
        cabecalho[5] = "Cliente";


        // cria matriz de acordo com nº de registros da tabela
        try {
            resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(""
                    + "SELECT count(*) FROM vendas "
                    + "WHERE data_venda BETWEEN '"+dataIni+"' AND '"+dataFim+"'");

            resultadoQ.next();

            // instancia da matrzi de acordo com o nº de linhas do ResultSet
            dadosTabela = new Object[resultadoQ.getInt(1)][6];

        } catch (Exception e) {
            System.out.println("Erro ao consultar cliente: " + e);
        }

        int lin = 0;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        // efetua consulta na tabela
        try {
            resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(""
                    
                   +"SELECT v.id as id, to_char (v.data_venda, 'DD/MM/YYYY') as data, v.valor_pagamento as valor, v.forma_pagamento as forma, f.nome as funcionario, c.nome as cliente "
                   + "FROM vendas v, funcionario f, cliente c "
                   + "WHERE v.data_venda BETWEEN '"+dataIni+"' AND '"+dataFim+"' AND f.cpf ILIKE '%" +cpfFunc+ "%' and c.cpf ILIKE '%" +cpfCli+ "%' "
                   + "AND c.id = v.cliente_id AND f.id = v.funcionario_id");

            while (resultadoQ.next()) {

                dadosTabela[lin][0] = resultadoQ.getInt("id");
                dadosTabela[lin][1] = resultadoQ.getString("data");
                dadosTabela[lin][2] = resultadoQ.getDouble("valor");
                dadosTabela[lin][3] = resultadoQ.getString("forma");
                dadosTabela[lin][4] = resultadoQ.getString("funcionario");
                dadosTabela[lin][5] = resultadoQ.getString("cliente");
                
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
                case 1:
                    
            }
          }
        }
     
     public int obterFuncionarioMes() {
        
        int id = 0;
                
         try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "SELECT funcionario_id FROM vendas LIMIT 1";

            System.out.println("SQL: " + sql);

            ResultSet retorno = st.executeQuery(sql);

            if (retorno.next()) {
                
               id = retorno.getInt("funcionario_id");
            }

        } catch (Exception e) {
            System.out.println("Erro ao consultar funcionario: " + e);
        }

        return id;
        
    }
     public int obterNumeroVendas(int id) {
        
        int num = 0;
                
         try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "SELECT count (*) FROM vendas WHERE funcionario_id = "+id;

            System.out.println("SQL: " + sql);

            ResultSet retorno = st.executeQuery(sql);

            if (retorno.next()) {
                
               num = retorno.getInt("count");
            }

        } catch (Exception e) {
            System.out.println("Erro ao consultar funcionario: " + e);
        }

        return num;
        
    }
    
}
