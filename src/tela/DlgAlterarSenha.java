/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tela;

import apoio.Criptografar;
import dao.FuncionarioDAO;
import entidade.Funcionario;
import javax.swing.JOptionPane;

/**
 *
 * @author evely
 */
public class DlgAlterarSenha extends javax.swing.JDialog {

    String user;
    public DlgAlterarSenha(java.awt.Frame parent, boolean modal, String username) {
        super(parent, modal);
        initComponents();
        this.user = username;
        System.out.println(user);
        lblerrosenha.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnfechar = new javax.swing.JLabel();
        tfdnovasenha = new javax.swing.JPasswordField();
        tfdsenhaatual = new javax.swing.JPasswordField();
        lblerrosenha = new javax.swing.JLabel();
        btnsalvar = new javax.swing.JButton();
        btncancelar = new javax.swing.JButton();
        fndsenha = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnfechar.setFont(new java.awt.Font("Verdana", 0, 22)); // NOI18N
        btnfechar.setForeground(new java.awt.Color(255, 255, 255));
        btnfechar.setText("X");
        btnfechar.setToolTipText("");
        btnfechar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnfecharMouseClicked(evt);
            }
        });
        getContentPane().add(btnfechar, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 10, 20, -1));

        tfdnovasenha.setBackground(new java.awt.Color(0, 0, 0));
        tfdnovasenha.setForeground(new java.awt.Color(255, 255, 255));
        tfdnovasenha.setBorder(null);
        getContentPane().add(tfdnovasenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 238, 370, 30));

        tfdsenhaatual.setBackground(new java.awt.Color(0, 0, 0));
        tfdsenhaatual.setForeground(new java.awt.Color(255, 255, 255));
        tfdsenhaatual.setBorder(null);
        getContentPane().add(tfdsenhaatual, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 370, 30));

        lblerrosenha.setForeground(new java.awt.Color(255, 0, 0));
        lblerrosenha.setText("- A senha n??o coincide");
        lblerrosenha.setToolTipText("");
        getContentPane().add(lblerrosenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 147, -1, -1));

        btnsalvar.setBackground(new java.awt.Color(23, 169, 168));
        btnsalvar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnsalvar.setForeground(new java.awt.Color(255, 255, 255));
        btnsalvar.setText("Pronto");
        btnsalvar.setToolTipText("");
        btnsalvar.setBorder(null);
        btnsalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalvarActionPerformed(evt);
            }
        });
        getContentPane().add(btnsalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 300, 100, 30));

        btncancelar.setBackground(new java.awt.Color(27, 27, 27));
        btncancelar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btncancelar.setForeground(new java.awt.Color(255, 255, 255));
        btncancelar.setText("Cancelar");
        btncancelar.setBorder(null);
        btncancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelarActionPerformed(evt);
            }
        });
        getContentPane().add(btncancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 300, 80, 30));

        fndsenha.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        fndsenha.setForeground(new java.awt.Color(255, 255, 255));
        fndsenha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/livraria/imagens/altera????odesenha.png"))); // NOI18N
        fndsenha.setText("X");
        fndsenha.setToolTipText("");
        getContentPane().add(fndsenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnfecharMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnfecharMouseClicked
        this.dispose();
    }//GEN-LAST:event_btnfecharMouseClicked

    private void btncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btncancelarActionPerformed

    private void btnsalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalvarActionPerformed
        
        FuncionarioDAO dao = new FuncionarioDAO();
        Funcionario funcionario = new Funcionario();
        String senha = Criptografar.encriptografar(tfdsenhaatual.getText());
        funcionario = dao.consultarFuncionario(user, senha);
        
        if (funcionario != null) {
            funcionario.setSenha(Criptografar.encriptografar(tfdnovasenha.getText()));
            dao.atualizar(funcionario);
            JOptionPane.showMessageDialog(null, "Senha alterada com sucesso!");
            this.dispose();
        } else {
            lblerrosenha.setVisible(true);
        }
        
      
    }//GEN-LAST:event_btnsalvarActionPerformed
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncancelar;
    private javax.swing.JLabel btnfechar;
    private javax.swing.JButton btnsalvar;
    private javax.swing.JLabel fndsenha;
    private javax.swing.JLabel lblerrosenha;
    private javax.swing.JPasswordField tfdnovasenha;
    private javax.swing.JPasswordField tfdsenhaatual;
    // End of variables declaration//GEN-END:variables
}
