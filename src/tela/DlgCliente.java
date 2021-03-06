/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tela;

import dao.ClienteDAO;
import entidade.Cliente;
import java.awt.Toolkit;
import javax.swing.JOptionPane;

/**
 *
 * @author evely
 */
public class DlgCliente extends javax.swing.JDialog {

         int id = 0;
        Cliente cliente = new Cliente();
        
    public DlgCliente(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        lblerror.setVisible(false);
        setIcon();
    }
    
    public DlgCliente(java.awt.Frame parent, boolean modal, Cliente cliente) {
        super(parent, modal);
        initComponents();   
        
        lblerror.setVisible(false);
        setIcon();
        
        tfdnome.setText(cliente.getNome());
        tfdemail.setText(cliente.getEmail());
        tfdcpf.setText(cliente.getCpf());
        tfdcelular.setText(cliente.getCelular());
        tfdcidade.setText(cliente.getCidade());
        tfddata.setDate(cliente.getDatanasc());
               
        if (cliente.getSituacao() == 'a') {
            cmbsituacao.setSelectedIndex(0);
        } else {
            cmbsituacao.setSelectedIndex(1);
        }
        this.cliente = cliente;
    }
    
    public void setIcon(){
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("icon.png")));   
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlfnd = new javax.swing.JPanel();
        lblerror = new javax.swing.JLabel();
        btnregistrar = new javax.swing.JLabel();
        tfddata = new com.toedter.calendar.JDateChooser();
        cmbsituacao = new javax.swing.JComboBox<>();
        tfdcidade = new javax.swing.JTextField();
        tfdcelular = new apoio.JPhoneField();
        tfdcpf = new apoio.JCpfField();
        tfdemail = new javax.swing.JTextField();
        tfdnome = new javax.swing.JTextField();
        lblfundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro Clientes");

        pnlfnd.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblerror.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblerror.setForeground(new java.awt.Color(255, 0, 0));
        lblerror.setText("Algum campo obrigat??rio n??o foi preenchido corretamente!");
        pnlfnd.add(lblerror, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 660, -1, -1));

        btnregistrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnregistrarMouseClicked(evt);
            }
        });
        pnlfnd.add(btnregistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 580, 210, 60));
        pnlfnd.add(tfddata, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 502, 220, 30));

        cmbsituacao.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cmbsituacao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ativo", "Inativo" }));
        pnlfnd.add(cmbsituacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 412, 220, 30));

        tfdcidade.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tfdcidade.setBorder(null);
        pnlfnd.add(tfdcidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 415, 210, 30));

        tfdcelular.setBorder(null);
        pnlfnd.add(tfdcelular, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 325, 200, 30));

        tfdcpf.setBorder(null);
        pnlfnd.add(tfdcpf, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 325, 210, 30));

        tfdemail.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tfdemail.setBorder(null);
        pnlfnd.add(tfdemail, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 245, 430, 30));

        tfdnome.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tfdnome.setBorder(null);
        pnlfnd.add(tfdnome, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 163, 440, 30));

        lblfundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/livraria/imagens/cadastrocliente.png"))); // NOI18N
        pnlfnd.add(lblfundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlfnd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlfnd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnregistrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnregistrarMouseClicked
        
        ClienteDAO cliDAO = new ClienteDAO();
        String cpf = removerMascara (tfdcpf.getText());
        
        if (tfdnome.getText().trim().isEmpty() || cpf.trim().isEmpty()
            || tfdcidade.getText().trim().isEmpty()) {
            lblerror.setVisible(true);
        } else {


        id = cliente.getId();
        cliente.setNome(tfdnome.getText());
        cliente.setEmail(tfdemail.getText());
        cliente.setCpf(tfdcpf.getText());
        cliente.setCelular(tfdcelular.getText());
        cliente.setCidade(tfdcidade.getText());
        cliente.setDatanasc(tfddata.getDate());
        
        int idcsit = cmbsituacao.getSelectedIndex();
        if (idcsit == 0) {
            cliente.setSituacao('a');
        } else {
            cliente.setSituacao('i');
        }

        String retorno = null;

        if (id == 0) {
            retorno = cliDAO.salvar(cliente);
            this.dispose();
        } else {
            retorno = cliDAO.atualizar(cliente);
            this.dispose();
        }

        if (retorno == null) {
            JOptionPane.showMessageDialog(null, "Registro salvo com sucesso!");
            id = 0;

        } else {
            JOptionPane.showMessageDialog(null, "Problemas ao salvar registro!\n\n"
                + "Mensagem t??cnica:\n"
                + "Erro: " + retorno);
        }
        }
    }//GEN-LAST:event_btnregistrarMouseClicked
     
    public String removerMascara (String str) {
        return str.replaceAll("\\D", ""); 
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DlgCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DlgCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DlgCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DlgCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DlgCliente dialog = new DlgCliente(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnregistrar;
    private javax.swing.JComboBox<String> cmbsituacao;
    private javax.swing.JLabel lblerror;
    private javax.swing.JLabel lblfundo;
    private javax.swing.JPanel pnlfnd;
    private apoio.JPhoneField tfdcelular;
    private javax.swing.JTextField tfdcidade;
    private apoio.JCpfField tfdcpf;
    private com.toedter.calendar.JDateChooser tfddata;
    private javax.swing.JTextField tfdemail;
    private javax.swing.JTextField tfdnome;
    // End of variables declaration//GEN-END:variables
}
