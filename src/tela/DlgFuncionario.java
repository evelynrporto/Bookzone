/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tela;

import apoio.Criptografar;
import dao.FuncionarioDAO;
import entidade.Funcionario;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JOptionPane;

/**
 *
 * @author evely
 */
public class DlgFuncionario extends javax.swing.JDialog {
    
        int id = 0;
        Funcionario funcionario = new Funcionario();
        
    public DlgFuncionario(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        lblerror.setVisible(false);
        tfdsenha.setVisible(true);
        lblsenha.setVisible(true);
        lblsenha2.setVisible(true);
        setIcon();
        
    }
    
    public DlgFuncionario(java.awt.Frame parent, boolean modal, Funcionario funcionario) {
        super(parent, modal);
        initComponents();   
        
        lblerror.setVisible(false);
        setIcon();
        
        tfdnome.setText(funcionario.getNome());
        tfdemail.setText(funcionario.getEmail());
        tfdcpf.setText(funcionario.getCpf());
        tfdfone.setText(funcionario.getTelefone());
        tfdcidade.setText(funcionario.getCidade());
        tfdusuario.setText(funcionario.getUsername());
        tfdsenha.setText("");
        tfdsenha.setVisible(false);
        lblsenha.setVisible(false);
        lblsenha2.setVisible(false);
        
        if (funcionario.getSituacao() == 'a') {
            cmbsituacao.setSelectedIndex(0);
        } else {
            cmbsituacao.setSelectedIndex(1);
        }
        this.funcionario = funcionario;
    }
    
    public void setIcon(){
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("icon.png")));   
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlfuncionario = new javax.swing.JPanel();
        lblsenha2 = new javax.swing.JLabel();
        lblsenha = new javax.swing.JLabel();
        lblaviso = new javax.swing.JLabel();
        lblerror = new javax.swing.JLabel();
        tfdnome = new javax.swing.JTextField();
        tfdemail = new javax.swing.JTextField();
        tfdcidade = new javax.swing.JTextField();
        btnregistrar = new javax.swing.JLabel();
        cmbsituacao = new javax.swing.JComboBox<>();
        tfdsenha = new javax.swing.JPasswordField();
        tfdusuario = new javax.swing.JTextField();
        tfdfone = new apoio.JPhoneField();
        tfdcpf = new apoio.JCpfField();
        lblfundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro Funcionario");

        pnlfuncionario.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblsenha2.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
        lblsenha2.setForeground(new java.awt.Color(255, 0, 0));
        lblsenha2.setText("*");
        pnlfuncionario.add(lblsenha2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 480, -1, -1));

        lblsenha.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
        lblsenha.setForeground(new java.awt.Color(255, 255, 255));
        lblsenha.setText("Senha");
        pnlfuncionario.add(lblsenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 481, -1, -1));

        lblaviso.setForeground(new java.awt.Color(255, 255, 255));
        pnlfuncionario.add(lblaviso, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 540, -1, -1));

        lblerror.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblerror.setForeground(new java.awt.Color(255, 0, 0));
        lblerror.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblerror.setText("Algum campo obrigat??rio n??o foi preenchido corretamente!");
        pnlfuncionario.add(lblerror, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 660, -1, -1));

        tfdnome.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tfdnome.setBorder(null);
        pnlfuncionario.add(tfdnome, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 162, 430, 30));

        tfdemail.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tfdemail.setBorder(null);
        pnlfuncionario.add(tfdemail, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 243, 440, 30));

        tfdcidade.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tfdcidade.setBorder(null);
        pnlfuncionario.add(tfdcidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 413, 210, 30));

        btnregistrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnregistrarMouseClicked(evt);
            }
        });
        pnlfuncionario.add(btnregistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 580, 200, 60));

        cmbsituacao.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cmbsituacao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ativo", "Inativo" }));
        pnlfuncionario.add(cmbsituacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 414, 220, 30));

        tfdsenha.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tfdsenha.setBorder(null);
        tfdsenha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfdsenhaKeyTyped(evt);
            }
        });
        pnlfuncionario.add(tfdsenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 503, 210, 30));

        tfdusuario.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tfdusuario.setBorder(null);
        pnlfuncionario.add(tfdusuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 502, 210, 30));

        tfdfone.setBorder(null);
        pnlfuncionario.add(tfdfone, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 325, 200, 30));

        tfdcpf.setBorder(null);
        pnlfuncionario.add(tfdcpf, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 325, 210, 30));

        lblfundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/livraria/imagens/cadastrofuncionario.png"))); // NOI18N
        pnlfuncionario.add(lblfundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 530, 700));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlfuncionario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlfuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnregistrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnregistrarMouseClicked
        FuncionarioDAO funcDAO = new FuncionarioDAO();
        String fone = removerMascara(tfdfone.getText());
        String cpf = removerMascara (tfdcpf.getText());
        
        if (tfdnome.getText().trim().isEmpty() || cpf.trim().isEmpty()
            || fone.trim().isEmpty() || tfdcidade.getText().trim().isEmpty() || tfdusuario.getText().trim().isEmpty()){
            lblerror.setVisible(true);
        } else {


        id = funcionario.getId();
        funcionario.setNome(tfdnome.getText());
        funcionario.setEmail(tfdemail.getText());
        funcionario.setCpf(tfdcpf.getText());
        funcionario.setTelefone(tfdfone.getText());
        funcionario.setCidade(tfdcidade.getText());
        funcionario.setUsername(tfdusuario.getText());
        funcionario.setSenha(Criptografar.encriptografar(tfdsenha.getText()));
        
        int idcsit = cmbsituacao.getSelectedIndex();
        if (idcsit == 0) {
            funcionario.setSituacao('a');
        } else {
            funcionario.setSituacao('i');
        }

        String retorno = null;

        if (id == 0) {
            if (tfdsenha.getText().trim().length() > 4) {
            retorno = funcDAO.salvar(funcionario);
            this.dispose(); 
            } else {
                lblerror.setVisible(true);
            }
        } else {
            retorno = funcDAO.atualizar(funcionario);
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

    private void tfdsenhaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfdsenhaKeyTyped
        if (tfdsenha.getText().trim().length() <= 3) {
            lblaviso.setForeground(Color.red);
            lblaviso.setText("Senha fraca");
        } else if (tfdsenha.getText().trim().length() > 3 && tfdsenha.getText().trim().length() <= 5) {
            lblaviso.setForeground(Color.ORANGE);
            lblaviso.setText("Senha mediana");
        } else if (tfdsenha.getText().trim().length() > 5) {
            lblaviso.setText("Senha forte");
            lblaviso.setForeground(Color.green);
        }
    }//GEN-LAST:event_tfdsenhaKeyTyped
    
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
            java.util.logging.Logger.getLogger(DlgFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DlgFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DlgFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DlgFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DlgFuncionario dialog = new DlgFuncionario(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel lblaviso;
    private javax.swing.JLabel lblerror;
    private javax.swing.JLabel lblfundo;
    private javax.swing.JLabel lblsenha;
    private javax.swing.JLabel lblsenha2;
    private javax.swing.JPanel pnlfuncionario;
    private javax.swing.JTextField tfdcidade;
    private apoio.JCpfField tfdcpf;
    private javax.swing.JTextField tfdemail;
    private apoio.JPhoneField tfdfone;
    private javax.swing.JTextField tfdnome;
    private javax.swing.JPasswordField tfdsenha;
    private javax.swing.JTextField tfdusuario;
    // End of variables declaration//GEN-END:variables
}
