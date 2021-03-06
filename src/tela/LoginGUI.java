/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tela;

import apoio.Criptografar;
import dao.FuncionarioDAO;
import entidade.Funcionario;
import java.awt.Toolkit;

/**
 *
 * @author evely
 */
public class LoginGUI extends javax.swing.JFrame {

    /**
     * Creates new form LoguinGUI
     */
    public LoginGUI() {
        initComponents();
        lblerro.setVisible(false);
        tfdusername.setText("Nome de usuário");
        tfdsenha.setEchoChar((char)0);
        tfdsenha.setText("Senha");
        setIcon();
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

        lblfechar = new javax.swing.JLabel();
        lblerro = new javax.swing.JLabel();
        cbmostrar = new javax.swing.JCheckBox();
        btnentrar = new javax.swing.JLabel();
        tfdsenha = new javax.swing.JPasswordField();
        tfdusername = new javax.swing.JTextField();
        fundo = new javax.swing.JLabel();
        lbluser1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("LOGIN BOOKZONE");
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblfechar.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblfechar.setForeground(new java.awt.Color(255, 255, 255));
        lblfechar.setText("X");
        lblfechar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblfecharMouseClicked(evt);
            }
        });
        getContentPane().add(lblfechar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 10, 20, 30));

        lblerro.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblerro.setForeground(new java.awt.Color(255, 0, 0));
        lblerro.setText("Usuário ou senha incorretos.");
        getContentPane().add(lblerro, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 480, 160, 20));

        cbmostrar.setBackground(new java.awt.Color(22, 22, 22));
        cbmostrar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cbmostrar.setForeground(new java.awt.Color(153, 153, 153));
        cbmostrar.setText("  Mostrar senha");
        cbmostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbmostrarActionPerformed(evt);
            }
        });
        getContentPane().add(cbmostrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 480, -1, -1));

        btnentrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnentrarMouseClicked(evt);
            }
        });
        getContentPane().add(btnentrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 530, 200, 40));

        tfdsenha.setBackground(new java.awt.Color(0, 0, 0));
        tfdsenha.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        tfdsenha.setForeground(new java.awt.Color(255, 255, 255));
        tfdsenha.setBorder(null);
        tfdsenha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tfdsenhaMouseClicked(evt);
            }
        });
        getContentPane().add(tfdsenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 420, 330, 40));

        tfdusername.setBackground(new java.awt.Color(0, 0, 0));
        tfdusername.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        tfdusername.setForeground(new java.awt.Color(255, 255, 255));
        tfdusername.setBorder(null);
        tfdusername.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tfdusernameMouseClicked(evt);
            }
        });
        getContentPane().add(tfdusername, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 340, 330, 30));

        fundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/livraria/imagens/login.png"))); // NOI18N
        getContentPane().add(fundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        lbluser1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lbluser1.setForeground(new java.awt.Color(153, 153, 153));
        lbluser1.setText("Nome de usuário");
        getContentPane().add(lbluser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 310, -1, 10));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cbmostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbmostrarActionPerformed
        if (cbmostrar.isSelected())
        {
            tfdsenha.setEchoChar((char)0);
        } 
        else
        {
            tfdsenha.setEchoChar('•');
        }
    }//GEN-LAST:event_cbmostrarActionPerformed

    private void btnentrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnentrarMouseClicked
        FuncionarioDAO dao = new FuncionarioDAO();
        Funcionario funcionario = new Funcionario();

        String username = tfdusername.getText();
        String senha = Criptografar.encriptografar(tfdsenha.getText());

        funcionario = dao.consultarFuncionario(username, senha);
        
        if (funcionario != null)
        {
            this.dispose();
            new MenuGUI(funcionario).setVisible(true);

        } else
        {
            lblerro.setVisible(true);
        }
    }//GEN-LAST:event_btnentrarMouseClicked

    private void tfdusernameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tfdusernameMouseClicked
        tfdusername.setText("");
    }//GEN-LAST:event_tfdusernameMouseClicked

    private void tfdsenhaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tfdsenhaMouseClicked
        tfdsenha.setText("");
        tfdsenha.setEchoChar('•');
    }//GEN-LAST:event_tfdsenhaMouseClicked

    private void lblfecharMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblfecharMouseClicked
        this.dispose();
    }//GEN-LAST:event_lblfecharMouseClicked

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
            java.util.logging.Logger.getLogger(LoginGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnentrar;
    private javax.swing.JCheckBox cbmostrar;
    private javax.swing.JLabel fundo;
    private javax.swing.JLabel lblerro;
    private javax.swing.JLabel lblfechar;
    private javax.swing.JLabel lbluser1;
    private javax.swing.JPasswordField tfdsenha;
    private javax.swing.JTextField tfdusername;
    // End of variables declaration//GEN-END:variables
}
