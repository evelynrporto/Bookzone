/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tela;

import dao.ClienteDAO;
import dao.FuncionarioDAO;
import dao.LivroDAO;
import entidade.Cliente;
import entidade.Funcionario;
import entidade.Livro;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author evely
 */
public class MenuGUI extends javax.swing.JFrame {

    public MenuGUI(Funcionario funcionario) {
        initComponents();  
        
        setIcon();
        configurarBotoes();
        configurarTblLivros();
        // configs dos paineis
        pnlhome.setVisible(true);
        pnlcadastro.setVisible(false);
        lblfuncionario.setText(funcionario.getNome());
        new LivroDAO().popularTabela(tblgeral,"");
                      
    }
    
    public void configurarTblLivros(){
        tblgeral.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 15));
        tblgeral.getTableHeader().setOpaque(false);
        tblgeral.getTableHeader().setBackground(new Color (31,118,138));
    }
    
    public void configurarBotoes() {
        btnhome.setBackground(new Color(0,102,102));
        btnhome.setFocusPainted(false);
        btncadastro.setFocusPainted(false);
        btnprodutos.setFocusPainted(false);
        btnvendas.setFocusPainted(false);      
        btnupdate.setFocusPainted(false);
        btncadastro.setBackground(new Color(32,32,32));
        btnvendas.setBackground(new Color(32,32,32));
        btnprodutos.setBackground(new Color(32,32,32));
        lblmensagem.setVisible(false);
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

        pnlfundo = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        pnlmenu = new javax.swing.JPanel();
        btnhome = new javax.swing.JButton();
        btncadastro = new javax.swing.JButton();
        btnvendas = new javax.swing.JButton();
        btnprodutos = new javax.swing.JButton();
        logo = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        iconuser = new javax.swing.JLabel();
        lblfuncionario = new javax.swing.JLabel();
        pnlhome = new javax.swing.JPanel();
        pnlcadastro = new javax.swing.JPanel();
        pnlcomtabelas = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblgeral = new javax.swing.JTable();
        tfdbusca = new javax.swing.JTextField();
        btnpesquisa = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnAdicionar = new javax.swing.JButton();
        btnupdate = new javax.swing.JButton();
        lblmensagem = new javax.swing.JLabel();
        cmbescolher = new javax.swing.JComboBox<>();
        pnlvendas = new javax.swing.JPanel();
        pnlprodutos = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlfundo.setBackground(new java.awt.Color(230, 228, 228));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlmenu.setBackground(new java.awt.Color(32, 32, 32));
        pnlmenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnhome.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        btnhome.setForeground(new java.awt.Color(255, 255, 255));
        btnhome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/livraria/imagens/botaohome.png"))); // NOI18N
        btnhome.setToolTipText("Home");
        btnhome.setBorder(null);
        btnhome.setHideActionText(true);
        btnhome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhomeActionPerformed(evt);
            }
        });
        pnlmenu.add(btnhome, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 232, 120, 60));

        btncadastro.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        btncadastro.setForeground(new java.awt.Color(255, 255, 255));
        btncadastro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/livraria/imagens/botaocadastro.png"))); // NOI18N
        btncadastro.setToolTipText("Cadastro");
        btncadastro.setBorder(null);
        btncadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncadastroActionPerformed(evt);
            }
        });
        pnlmenu.add(btncadastro, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 120, 60));

        btnvendas.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        btnvendas.setForeground(new java.awt.Color(255, 255, 255));
        btnvendas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/livraria/imagens/botaovendas.png"))); // NOI18N
        btnvendas.setToolTipText("Vendas");
        btnvendas.setBorder(null);
        btnvendas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnvendasActionPerformed(evt);
            }
        });
        pnlmenu.add(btnvendas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 388, 120, 60));

        btnprodutos.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        btnprodutos.setForeground(new java.awt.Color(255, 255, 255));
        btnprodutos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/livraria/imagens/botaoprod.png"))); // NOI18N
        btnprodutos.setToolTipText("Produtos");
        btnprodutos.setBorder(null);
        btnprodutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnprodutosActionPerformed(evt);
            }
        });
        pnlmenu.add(btnprodutos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 466, 120, 60));

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/livraria/imagens/logobz.png"))); // NOI18N
        logo.setToolTipText("");
        pnlmenu.add(logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 28, 100, -1));

        jPanel1.add(pnlmenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 770));

        jPanel4.setBackground(new java.awt.Color(23, 169, 168));

        iconuser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/livraria/imagens/userlog.png"))); // NOI18N

        lblfuncionario.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        lblfuncionario.setForeground(new java.awt.Color(255, 255, 255));
        lblfuncionario.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblfuncionario.setText("UserName   ");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(972, Short.MAX_VALUE)
                .addComponent(lblfuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(iconuser)
                .addGap(19, 19, 19))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(iconuser)
                    .addComponent(lblfuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 0, 1250, 70));

        pnlhome.setBackground(new java.awt.Color(255, 255, 255));
        pnlhome.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(pnlhome, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 1250, 700));

        pnlcadastro.setBackground(new java.awt.Color(204, 204, 204));

        pnlcomtabelas.setBackground(new java.awt.Color(255, 255, 255));

        tblgeral.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tblgeral.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Código", "Descrição", "Situação"
            }
        ));
        tblgeral.setGridColor(new java.awt.Color(204, 204, 204));
        tblgeral.setRowHeight(35);
        tblgeral.setSelectionBackground(new java.awt.Color(204, 204, 204));
        tblgeral.setShowVerticalLines(false);
        tblgeral.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblgeral);

        tfdbusca.setBackground(new java.awt.Color(242, 243, 245));
        tfdbusca.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        tfdbusca.setForeground(new java.awt.Color(151, 156, 164));
        tfdbusca.setText("Pesquisar...");
        tfdbusca.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tfdbusca.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tfdbuscaMouseClicked(evt);
            }
        });

        btnpesquisa.setBackground(new java.awt.Color(18, 151, 160));
        btnpesquisa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/livraria/imagens/pesquisa.png"))); // NOI18N
        btnpesquisa.setToolTipText("Pesquisar");
        btnpesquisa.setFocusPainted(false);
        btnpesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpesquisaActionPerformed(evt);
            }
        });

        btnExcluir.setBackground(new java.awt.Color(18, 151, 160));
        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/livraria/imagens/lixeira.png"))); // NOI18N
        btnExcluir.setToolTipText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnEditar.setBackground(new java.awt.Color(18, 151, 160));
        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/livraria/imagens/edit.png"))); // NOI18N
        btnEditar.setToolTipText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnAdicionar.setBackground(new java.awt.Color(18, 151, 160));
        btnAdicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/livraria/imagens/add.png"))); // NOI18N
        btnAdicionar.setToolTipText("Adicionar");
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });

        btnupdate.setBackground(new java.awt.Color(18, 151, 160));
        btnupdate.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btnupdate.setForeground(new java.awt.Color(255, 255, 255));
        btnupdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/livraria/imagens/refresh.png"))); // NOI18N
        btnupdate.setText("Atualizar lista");
        btnupdate.setToolTipText("");
        btnupdate.setBorder(null);
        btnupdate.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        btnupdate.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        btnupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnupdateActionPerformed(evt);
            }
        });

        lblmensagem.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lblmensagem.setForeground(new java.awt.Color(204, 0, 0));
        lblmensagem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblmensagem.setText("Selecione um registro para editá-lo!");

        cmbescolher.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cmbescolher.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "  Livros", "Funcionário", "Cliente" }));
        cmbescolher.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        cmbescolher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbescolherActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlcomtabelasLayout = new javax.swing.GroupLayout(pnlcomtabelas);
        pnlcomtabelas.setLayout(pnlcomtabelasLayout);
        pnlcomtabelasLayout.setHorizontalGroup(
            pnlcomtabelasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlcomtabelasLayout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addGroup(pnlcomtabelasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1057, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlcomtabelasLayout.createSequentialGroup()
                        .addComponent(tfdbusca)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnpesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlcomtabelasLayout.createSequentialGroup()
                        .addComponent(btnupdate, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(172, 172, 172)
                        .addComponent(lblmensagem, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cmbescolher, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(104, Short.MAX_VALUE))
        );
        pnlcomtabelasLayout.setVerticalGroup(
            pnlcomtabelasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlcomtabelasLayout.createSequentialGroup()
                .addContainerGap(108, Short.MAX_VALUE)
                .addComponent(cmbescolher, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnlcomtabelasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfdbusca, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnpesquisa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addGroup(pnlcomtabelasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlcomtabelasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnupdate, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblmensagem))
                    .addComponent(btnEditar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdicionar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExcluir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43))
        );

        javax.swing.GroupLayout pnlcadastroLayout = new javax.swing.GroupLayout(pnlcadastro);
        pnlcadastro.setLayout(pnlcadastroLayout);
        pnlcadastroLayout.setHorizontalGroup(
            pnlcadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlcadastroLayout.createSequentialGroup()
                .addGap(0, 2, Short.MAX_VALUE)
                .addComponent(pnlcomtabelas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 3, Short.MAX_VALUE))
        );
        pnlcadastroLayout.setVerticalGroup(
            pnlcadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlcomtabelas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel1.add(pnlcadastro, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 1250, 700));

        pnlvendas.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout pnlvendasLayout = new javax.swing.GroupLayout(pnlvendas);
        pnlvendas.setLayout(pnlvendasLayout);
        pnlvendasLayout.setHorizontalGroup(
            pnlvendasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1250, Short.MAX_VALUE)
        );
        pnlvendasLayout.setVerticalGroup(
            pnlvendasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
        );

        jPanel1.add(pnlvendas, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 1250, 700));

        pnlprodutos.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout pnlprodutosLayout = new javax.swing.GroupLayout(pnlprodutos);
        pnlprodutos.setLayout(pnlprodutosLayout);
        pnlprodutosLayout.setHorizontalGroup(
            pnlprodutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1250, Short.MAX_VALUE)
        );
        pnlprodutosLayout.setVerticalGroup(
            pnlprodutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
        );

        jPanel1.add(pnlprodutos, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 1250, 700));

        javax.swing.GroupLayout pnlfundoLayout = new javax.swing.GroupLayout(pnlfundo);
        pnlfundo.setLayout(pnlfundoLayout);
        pnlfundoLayout.setHorizontalGroup(
            pnlfundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlfundoLayout.setVerticalGroup(
            pnlfundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlfundo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlfundo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnhomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhomeActionPerformed
        pnlhome.setVisible(true);
        btnhome.setBackground(new Color (0,102,102));
        btncadastro.setBackground(new Color (32,32,32));
        btnvendas.setBackground(new Color (32,32,32));
        btnprodutos.setBackground(new Color (32,32,32));
    }//GEN-LAST:event_btnhomeActionPerformed

    private void btncadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncadastroActionPerformed
        pnlcadastro.setVisible(true);
        pnlhome.setVisible(false);
        btnhome.setBackground(new Color (32,32,32));
        btncadastro.setBackground(new Color (0,102,102));
        btnvendas.setBackground(new Color (32,32,32));
        btnprodutos.setBackground(new Color (32,32,32));
    }//GEN-LAST:event_btncadastroActionPerformed

    private void btnvendasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnvendasActionPerformed
        pnlvendas.setVisible(true);
        pnlhome.setVisible(false);
        pnlcadastro.setVisible(false);
        btnhome.setBackground(new Color (32,32,32));
        btncadastro.setBackground(new Color (32,32,32));
        btnvendas.setBackground(new Color (0,102,102));
        btnprodutos.setBackground(new Color (32,32,32));
    }//GEN-LAST:event_btnvendasActionPerformed

    private void btnprodutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnprodutosActionPerformed
        pnlprodutos.setVisible(true);
        pnlhome.setVisible(false);
        pnlcadastro.setVisible(false);
        pnlvendas.setVisible(false);
        btnhome.setBackground(new Color (32,32,32));
        btncadastro.setBackground(new Color (32,32,32));
        btnvendas.setBackground(new Color (32,32,32));
        btnprodutos.setBackground(new Color (0,102,102));
    }//GEN-LAST:event_btnprodutosActionPerformed

    private void btnupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupdateActionPerformed
       if (cmbescolher.getSelectedIndex() == 0){
            new LivroDAO().popularTabela(tblgeral,"");
            
        } else if (cmbescolher.getSelectedIndex() == 1){
            new FuncionarioDAO().popularTabela(tblgeral,"");
            
        } else if (cmbescolher.getSelectedIndex() == 2){
            new ClienteDAO().popularTabela(tblgeral,"");
        }    
    }//GEN-LAST:event_btnupdateActionPerformed

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        if (cmbescolher.getSelectedIndex() == 0) {
        DlgLivros tela = new DlgLivros(null, true);
        tela.setVisible(true);
        } else if (cmbescolher.getSelectedIndex() == 1) {
        DlgFuncionario tela2 = new DlgFuncionario (null, true);
        tela2.setVisible(true);
        } else if (cmbescolher.getSelectedIndex() == 2) {
            DlgCliente tela3 = new DlgCliente (null, true);
            tela3.setVisible(true);
        }
    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        if (cmbescolher.getSelectedIndex() == 0) {
                  
        if (tblgeral.getSelectedRow() < 0){ 
            lblmensagem.setVisible(true);
        } else {
        String idString = String.valueOf(tblgeral.getValueAt(tblgeral.getSelectedRow(), 0));
        int id = Integer.parseInt(idString);
        Livro livro = new LivroDAO().consultarId(id);
        lblmensagem.setVisible(false);

        DlgLivros tela = new DlgLivros(null, true, livro);
        tela.setVisible(true);
        }
        } else if (cmbescolher.getSelectedIndex() == 1) {
            
            if (tblgeral.getSelectedRow() < 0){ 
            lblmensagem.setVisible(true);
            
        } else {
        String idString = String.valueOf(tblgeral.getValueAt(tblgeral.getSelectedRow(), 0));
        int id = Integer.parseInt(idString);
        Funcionario funcionario = new FuncionarioDAO().consultarId(id);
        lblmensagem.setVisible(false);

        DlgFuncionario tela = new DlgFuncionario(null, true, funcionario);
        tela.setVisible(true);
        }
        } else if (cmbescolher.getSelectedIndex() == 2) {
            
            if (tblgeral.getSelectedRow() < 0){ 
            lblmensagem.setVisible(true);
            
        } else {
        String idString = String.valueOf(tblgeral.getValueAt(tblgeral.getSelectedRow(), 0));
        int id = Integer.parseInt(idString);
        Cliente cliente = new ClienteDAO().consultarId(id);
        lblmensagem.setVisible(false);

        DlgCliente tela = new DlgCliente(null, true, cliente);
        tela.setVisible(true);
        }
        }
    
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        if (tblgeral.getSelectedRow() < 0){ 
            lblmensagem.setVisible(true);
        } else {
                   
        Object[] options = { "Inativar", "Excluir" };
        int opcao = JOptionPane.showOptionDialog(null, "Escolha a opção desejada", "Excluir", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);

        System.out.println("Opção = " + opcao);
        
        if (cmbescolher.getSelectedIndex() == 0) {
        String idString = String.valueOf(tblgeral.getValueAt(tblgeral.getSelectedRow(), 0));
        int id = Integer.parseInt(idString);

        if (opcao == 0){

            String retorno = new LivroDAO().inativar(id);
            if (retorno == null) {
                JOptionPane.showMessageDialog(null, "Registro inativado com sucesso!");
                new LivroDAO().popularTabela(tblgeral, "");
            } else {
                JOptionPane.showMessageDialog(null, "Ops, problemas ao inativar registro.");
            }
        }

        if (opcao == 1) {
            String retorno = new LivroDAO().excluir(id);
            if (retorno == null) {
                JOptionPane.showMessageDialog(null, "Registro excluído com sucesso!");
                new LivroDAO().popularTabela(tblgeral, "");
            } else {
                JOptionPane.showMessageDialog(null, "Ops, problemas ao excluir registro.");
            }
        }
        } else if (cmbescolher.getSelectedIndex() == 1) {
            
        String idString = String.valueOf(tblgeral.getValueAt(tblgeral.getSelectedRow(), 0));
        int id = Integer.parseInt(idString);

        if (opcao == 0){

            String retorno = new FuncionarioDAO().inativar(id);
            if (retorno == null) {
                JOptionPane.showMessageDialog(null, "Registro inativado com sucesso!");
                new FuncionarioDAO().popularTabela(tblgeral, "");
            } else {
                JOptionPane.showMessageDialog(null, "Ops, problemas ao inativar registro.");
            }
        }

        if (opcao == 1) {
            String retorno = new FuncionarioDAO().excluir(id);
            if (retorno == null) {
                JOptionPane.showMessageDialog(null, "Registro excluído com sucesso!");
                new FuncionarioDAO().popularTabela(tblgeral, "");
            } else {
                JOptionPane.showMessageDialog(null, "Ops, problemas ao excluir registro.");
            }   
        }
        } else if (cmbescolher.getSelectedIndex() == 2) {
            
        String idString = String.valueOf(tblgeral.getValueAt(tblgeral.getSelectedRow(), 0));
        int id = Integer.parseInt(idString);

        if (opcao == 0){

            String retorno = new ClienteDAO().inativar(id);
            if (retorno == null) {
                JOptionPane.showMessageDialog(null, "Registro inativado com sucesso!");
                new ClienteDAO().popularTabela(tblgeral, "");
            } else {
                JOptionPane.showMessageDialog(null, "Ops, problemas ao inativar registro.");
            }
        }

        if (opcao == 1) {
            String retorno = new ClienteDAO().excluir(id);
            if (retorno == null) {
                JOptionPane.showMessageDialog(null, "Registro excluído com sucesso!");
                new ClienteDAO().popularTabela(tblgeral, "");
            } else {
                JOptionPane.showMessageDialog(null, "Ops, problemas ao excluir registro.");
            }   
        }
        }
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnpesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpesquisaActionPerformed
        if (cmbescolher.getSelectedIndex() == 0){
        new LivroDAO().popularTabela(tblgeral, tfdbusca.getText());
        } else if (cmbescolher.getSelectedIndex() == 1) {
        new FuncionarioDAO().popularTabela(tblgeral, tfdbusca.getText());
        } else if (cmbescolher.getSelectedIndex() == 2){
        new ClienteDAO().popularTabela(tblgeral, tfdbusca.getText());
        }
    }//GEN-LAST:event_btnpesquisaActionPerformed

    private void tfdbuscaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tfdbuscaMouseClicked
        tfdbusca.setText("");
        tfdbusca.setForeground(Color.BLACK);
    }//GEN-LAST:event_tfdbuscaMouseClicked

    private void cmbescolherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbescolherActionPerformed
        
        if (cmbescolher.getSelectedIndex() == 0){
            new LivroDAO().popularTabela(tblgeral,"");
            
        } else if (cmbescolher.getSelectedIndex() == 1){
            new FuncionarioDAO().popularTabela(tblgeral,"");
            
        } else if (cmbescolher.getSelectedIndex() == 2){
            new ClienteDAO().popularTabela(tblgeral,"");
        }
    }//GEN-LAST:event_cmbescolherActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btncadastro;
    private javax.swing.JButton btnhome;
    private javax.swing.JButton btnpesquisa;
    private javax.swing.JButton btnprodutos;
    private javax.swing.JButton btnupdate;
    private javax.swing.JButton btnvendas;
    private javax.swing.JComboBox<String> cmbescolher;
    private javax.swing.JLabel iconuser;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblfuncionario;
    private javax.swing.JLabel lblmensagem;
    private javax.swing.JLabel logo;
    private javax.swing.JPanel pnlcadastro;
    private javax.swing.JPanel pnlcomtabelas;
    private javax.swing.JPanel pnlfundo;
    private javax.swing.JPanel pnlhome;
    private javax.swing.JPanel pnlmenu;
    private javax.swing.JPanel pnlprodutos;
    private javax.swing.JPanel pnlvendas;
    private javax.swing.JTable tblgeral;
    private javax.swing.JTextField tfdbusca;
    // End of variables declaration//GEN-END:variables

   

  

}
