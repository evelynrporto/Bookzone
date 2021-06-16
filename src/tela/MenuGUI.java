/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tela;

import tela.relatorios.DlgRelatorioEstantes;
import tela.relatorios.DlgRelatorioVendas;
import apoio.ConexaoBD;
import apoio.VendaController;
import dao.ClienteDAO;
import dao.FuncionarioDAO;
import dao.ItemVendaDAO;
import dao.LivroDAO;
import dao.VendaDAO;
import entidade.Cliente;
import entidade.Funcionario;
import entidade.ItemVenda;
import entidade.Livro;
import entidade.Venda;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author evely
 */
public class MenuGUI extends javax.swing.JFrame {

    String preco;
    String username;
    String email;
    String nome;
    int id;

    public MenuGUI(Funcionario funcionario) {
        initComponents();

        setIcon();
        configurarBotoes();
        configurarTblCadastros();
        configurarTblConsulta();
        configurarTblVendas();
        iniciarData();
        funcionarioMes();
        totalVendas();
        // configs dos paineis
        pnlhome.setVisible(true);
        pnlcadastro.setVisible(false);
        pnlvendas.setVisible(false);
        pnlrelatorios.setVisible(false);
        pnlConsulta.setVisible(false);
        tfdPagar.setEditable(false);

        lblfuncionario.setText(funcionario.getNome());
        this.username = funcionario.getUsername();
        this.email = funcionario.getEmail();
        this.nome = funcionario.getNome();
        this.id = funcionario.getId();
        totalVendasFuncionario();
        new LivroDAO().popularTabela(tblgeral, "");

    }

    private Cliente cliente;
    private Funcionario funcionarioP;
    private Livro livro;
    private Funcionario funcionario;
    private DefaultTableModel tableModel;
    double total;
    int codigoLivro;
    String formapagamento = "";

    public void iniciarData() {
        Date data = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        jldata.setText(formato.format(data));

        Timer timer = new Timer(1000, new hora());
        timer.start();
    }

    public void configurarTblCadastros() {
        tblgeral.getTableHeader().setFont(new Font("Poppins", Font.BOLD, 15));
        tblgeral.getTableHeader().setForeground(Color.WHITE);
        tblgeral.getTableHeader().setOpaque(false);
        tblgeral.getTableHeader().setBackground(new Color(2, 166, 166));
    }  
    public void configurarTblConsulta() {
        tblconsulta.getTableHeader().setFont(new Font("Poppins", Font.BOLD, 15));
        tblconsulta.getTableHeader().setForeground(Color.WHITE);
        tblconsulta.getTableHeader().setOpaque(false);
        tblconsulta.getTableHeader().setBackground(new Color(2, 166, 166));   
    }
    public void configurarTblVendas() {
        tabelaVenda.getTableHeader().setFont(new Font("Poppins", Font.BOLD, 15));
        tabelaVenda.getTableHeader().setForeground(Color.WHITE);
        tabelaVenda.getTableHeader().setOpaque(false);
        tabelaVenda.getTableHeader().setBackground(new Color(2, 166, 166));

        tabelaVenda.setSelectionMode(0);

        // redimensiona as colunas de uma tabela     
        TableColumn column = null;
        for (int i = 0; i < tabelaVenda.getColumnCount(); i++) {
            column = tabelaVenda.getColumnModel().getColumn(i);
            switch (i) {
                case 0:
                    column.setPreferredWidth(80);
                    column.setMaxWidth(80);
                    column.setMinWidth(25);
                    break;
            }
        }
    }

    public void configurarBotoes() {
        btnhome.setBackground(new Color(0, 102, 102));
        btnhome.setFocusPainted(false);
        btncadastro.setFocusPainted(false);
        btnrelatorios.setFocusPainted(false);
        btnvendas.setFocusPainted(false);
        btnupdate.setFocusPainted(false);
        btnconsulta.setFocusPainted(false);
        btncadastro.setBackground(new Color(32, 32, 32));
        btnvendas.setBackground(new Color(32, 32, 32));
        btnrelatorios.setBackground(new Color(32, 32, 32));
        btnconsulta.setBackground(new Color(32, 32, 32));
        lblmensagem.setVisible(false);
        btnRelatorioCliente.setVisible(false);
        //-------botão relatórios----------//
        btnLivrosEstantes.setOpaque(false);
        btnLivrosEstantes.setContentAreaFilled(false);
        btnLivrosEstantes.setBorderPainted(false);
        btnVendasData.setOpaque(false);
        btnVendasData.setContentAreaFilled(false);
        btnVendasData.setBorderPainted(false);
        btnLivrosSemEstoque.setOpaque(false);
        btnLivrosSemEstoque.setContentAreaFilled(false);
        btnLivrosSemEstoque.setBorderPainted(false);
    }

    public void setIcon() {
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
        logo = new javax.swing.JLabel();
        btnLogout = new javax.swing.JButton();
        btnconsulta = new javax.swing.JButton();
        btnrelatorios = new javax.swing.JButton();
        pnlusername = new javax.swing.JPanel();
        lblfuncionario = new javax.swing.JLabel();
        btneditarperfil = new javax.swing.JButton();
        jldata = new javax.swing.JLabel();
        jlhora = new javax.swing.JLabel();
        pnlhome = new javax.swing.JPanel();
        lblMinhasVendas = new javax.swing.JLabel();
        lblTotalVendas = new javax.swing.JLabel();
        tfdnomeFuncMes = new javax.swing.JLabel();
        fundohome = new javax.swing.JLabel();
        pnlcadastro = new javax.swing.JPanel();
        cmbescolher = new javax.swing.JComboBox<>();
        tfdbusca = new javax.swing.JTextField();
        btnpesquisa = new javax.swing.JButton();
        btnAdicionar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        lblmensagem = new javax.swing.JLabel();
        btnRelatorioCliente = new javax.swing.JButton();
        btnupdate = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblgeral = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        pnlConsulta = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblconsulta = new javax.swing.JTable();
        lblDataIni = new javax.swing.JLabel();
        lblDataIni1 = new javax.swing.JLabel();
        lblCliente = new javax.swing.JLabel();
        tfdCpfCliente = new apoio.JCpfField();
        lblFuncionario = new javax.swing.JLabel();
        tfdCpfFuncionario = new apoio.JCpfField();
        tfdDataIni = new javax.swing.JFormattedTextField();
        tfdDataFim = new javax.swing.JFormattedTextField();
        btnBuscaCliente = new javax.swing.JButton();
        btnBuscaFuncionario = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnpesquisarconsulta = new javax.swing.JButton();
        btnPesquisarItens = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        pnlvendas = new javax.swing.JPanel();
        chkCartao = new javax.swing.JCheckBox();
        chkDinheiro = new javax.swing.JCheckBox();
        tfdPagar = new apoio.JCurrencyField();
        lblPagar = new javax.swing.JLabel();
        lblcpf = new javax.swing.JLabel();
        tfdCpf = new apoio.JCpfField();
        btnfinalizar = new javax.swing.JButton();
        tfdnome = new javax.swing.JTextField();
        btnBuscarCliente = new javax.swing.JButton();
        tfdTotal = new javax.swing.JLabel();
        lblIdVenda = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabelaVenda = new javax.swing.JTable();
        btnadicionar = new javax.swing.JButton();
        btndescartar = new javax.swing.JButton();
        btndesconto = new javax.swing.JButton();
        tfdCodigo = new apoio.JNumberField();
        btnbuscacodigo = new javax.swing.JButton();
        tfdProduto = new javax.swing.JTextField();
        tfdValorUnitario = new apoio.JCurrencyField();
        spnQuantidade = new javax.swing.JSpinner();
        tfdValorTotal = new apoio.JCurrencyField();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        fundo = new javax.swing.JLabel();
        pnlrelatorios = new javax.swing.JPanel();
        btnVendasData = new javax.swing.JButton();
        btnLivrosEstantes = new javax.swing.JButton();
        btnLivrosSemEstoque = new javax.swing.JButton();
        lblfundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Livraria BookZone");

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
        btnvendas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/livraria/imagens/botaocompras.png"))); // NOI18N
        btnvendas.setToolTipText("Vendas");
        btnvendas.setBorder(null);
        btnvendas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnvendasActionPerformed(evt);
            }
        });
        pnlmenu.add(btnvendas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 388, 120, 60));

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/livraria/imagens/logobz.png"))); // NOI18N
        logo.setToolTipText("");
        pnlmenu.add(logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 28, 100, -1));

        btnLogout.setBackground(new java.awt.Color(32, 32, 32));
        btnLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/livraria/imagens/logout.png"))); // NOI18N
        btnLogout.setBorder(null);
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });
        pnlmenu.add(btnLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 710, 40, 40));

        btnconsulta.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        btnconsulta.setForeground(new java.awt.Color(255, 255, 255));
        btnconsulta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/livraria/imagens/botaoconsulta.png"))); // NOI18N
        btnconsulta.setToolTipText("Consultas");
        btnconsulta.setBorder(null);
        btnconsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnconsultaActionPerformed(evt);
            }
        });
        pnlmenu.add(btnconsulta, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 550, 120, 60));

        btnrelatorios.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        btnrelatorios.setForeground(new java.awt.Color(255, 255, 255));
        btnrelatorios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/livraria/imagens/botaorelatorios.png"))); // NOI18N
        btnrelatorios.setToolTipText("Relatórios");
        btnrelatorios.setBorder(null);
        btnrelatorios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnrelatoriosActionPerformed(evt);
            }
        });
        pnlmenu.add(btnrelatorios, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 470, 120, 60));

        jPanel1.add(pnlmenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 770));

        pnlusername.setBackground(new java.awt.Color(23, 169, 168));

        lblfuncionario.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        lblfuncionario.setForeground(new java.awt.Color(255, 255, 255));
        lblfuncionario.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblfuncionario.setText("UserName   ");

        btneditarperfil.setBackground(new java.awt.Color(23, 169, 168));
        btneditarperfil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/livraria/imagens/userlog.png"))); // NOI18N
        btneditarperfil.setBorder(null);
        btneditarperfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditarperfilActionPerformed(evt);
            }
        });

        jldata.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jldata.setForeground(new java.awt.Color(255, 255, 255));
        jldata.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jlhora.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jlhora.setForeground(new java.awt.Color(255, 255, 255));
        jlhora.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout pnlusernameLayout = new javax.swing.GroupLayout(pnlusername);
        pnlusername.setLayout(pnlusernameLayout);
        pnlusernameLayout.setHorizontalGroup(
            pnlusernameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlusernameLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(pnlusernameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jldata, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlhora, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 870, Short.MAX_VALUE)
                .addComponent(lblfuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btneditarperfil, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );
        pnlusernameLayout.setVerticalGroup(
            pnlusernameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlusernameLayout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(lblfuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlusernameLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlusernameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlusernameLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jlhora, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jldata, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btneditarperfil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel1.add(pnlusername, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 0, 1250, 70));

        pnlhome.setBackground(new java.awt.Color(255, 255, 255));
        pnlhome.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblMinhasVendas.setFont(new java.awt.Font("Poppins", 1, 48)); // NOI18N
        lblMinhasVendas.setForeground(new java.awt.Color(255, 255, 255));
        lblMinhasVendas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMinhasVendas.setText("18");
        lblMinhasVendas.setToolTipText("");
        pnlhome.add(lblMinhasVendas, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 430, 140, 130));

        lblTotalVendas.setFont(new java.awt.Font("Poppins", 1, 36)); // NOI18N
        lblTotalVendas.setForeground(new java.awt.Color(255, 255, 255));
        lblTotalVendas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTotalVendas.setText("18");
        pnlhome.add(lblTotalVendas, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 410, 130, 70));

        tfdnomeFuncMes.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        tfdnomeFuncMes.setForeground(new java.awt.Color(255, 255, 255));
        tfdnomeFuncMes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pnlhome.add(tfdnomeFuncMes, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 570, 280, 40));

        fundohome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/livraria/imagens/imageminicial.png"))); // NOI18N
        pnlhome.add(fundohome, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel1.add(pnlhome, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 1250, 700));

        pnlcadastro.setBackground(new java.awt.Color(204, 204, 204));
        pnlcadastro.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cmbescolher.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        cmbescolher.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Livros", "Funcionário", "Cliente" }));
        cmbescolher.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        cmbescolher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbescolherActionPerformed(evt);
            }
        });
        pnlcadastro.add(cmbescolher, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 120, 217, 31));

        tfdbusca.setBackground(new java.awt.Color(229, 233, 233));
        tfdbusca.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        tfdbusca.setForeground(new java.awt.Color(151, 156, 164));
        tfdbusca.setText("Pesquisar...");
        tfdbusca.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tfdbusca.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tfdbuscaMouseClicked(evt);
            }
        });
        pnlcadastro.add(tfdbusca, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 180, 990, 40));

        btnpesquisa.setBackground(new java.awt.Color(18, 151, 160));
        btnpesquisa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/livraria/imagens/pesquisa.png"))); // NOI18N
        btnpesquisa.setToolTipText("Pesquisar");
        btnpesquisa.setFocusPainted(false);
        btnpesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpesquisaActionPerformed(evt);
            }
        });
        pnlcadastro.add(btnpesquisa, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 180, 46, 40));

        btnAdicionar.setBackground(new java.awt.Color(18, 151, 160));
        btnAdicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/livraria/imagens/add.png"))); // NOI18N
        btnAdicionar.setToolTipText("Adicionar");
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });
        pnlcadastro.add(btnAdicionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 620, 45, 40));

        btnEditar.setBackground(new java.awt.Color(18, 151, 160));
        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/livraria/imagens/edit.png"))); // NOI18N
        btnEditar.setToolTipText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        pnlcadastro.add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 620, 46, 40));

        btnExcluir.setBackground(new java.awt.Color(18, 151, 160));
        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/livraria/imagens/lixeira.png"))); // NOI18N
        btnExcluir.setToolTipText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });
        pnlcadastro.add(btnExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 620, 46, 40));

        lblmensagem.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        lblmensagem.setForeground(new java.awt.Color(204, 0, 0));
        lblmensagem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblmensagem.setText("Selecione um registro para editá-lo!");
        pnlcadastro.add(lblmensagem, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 630, 277, 30));

        btnRelatorioCliente.setBackground(new java.awt.Color(18, 151, 160));
        btnRelatorioCliente.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        btnRelatorioCliente.setForeground(new java.awt.Color(255, 255, 255));
        btnRelatorioCliente.setText("Gerar relatório");
        btnRelatorioCliente.setBorder(null);
        btnRelatorioCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRelatorioClienteActionPerformed(evt);
            }
        });
        pnlcadastro.add(btnRelatorioCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 630, 116, 31));

        btnupdate.setBackground(new java.awt.Color(18, 151, 160));
        btnupdate.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
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
        pnlcadastro.add(btnupdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 630, 126, 31));

        tblgeral.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
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

        pnlcadastro.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 250, 1050, 350));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/livraria/imagens/gerarcadastros.png"))); // NOI18N
        pnlcadastro.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel1.add(pnlcadastro, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 1250, 700));

        pnlConsulta.setBackground(new java.awt.Color(255, 255, 255));
        pnlConsulta.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblconsulta.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        tblconsulta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "idVenda", "Valor pago", "Forma de pagamento", "Funcionário", "Cliente"
            }
        ));
        tblconsulta.setRowHeight(35);
        tblconsulta.setSelectionBackground(new java.awt.Color(204, 204, 204));
        tblconsulta.setShowVerticalLines(false);
        jScrollPane2.setViewportView(tblconsulta);

        pnlConsulta.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 270, 1150, 370));

        lblDataIni.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        lblDataIni.setForeground(new java.awt.Color(255, 255, 255));
        lblDataIni.setText("Data Final:");
        pnlConsulta.add(lblDataIni, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 204, -1, -1));

        lblDataIni1.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        lblDataIni1.setForeground(new java.awt.Color(255, 255, 255));
        lblDataIni1.setText("Data Inicial:");
        pnlConsulta.add(lblDataIni1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 153, -1, -1));

        lblCliente.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        lblCliente.setForeground(new java.awt.Color(255, 255, 255));
        lblCliente.setText("Cliente:");
        pnlConsulta.add(lblCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 153, -1, -1));
        pnlConsulta.add(tfdCpfCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 150, 170, 30));

        lblFuncionario.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        lblFuncionario.setForeground(new java.awt.Color(255, 255, 255));
        lblFuncionario.setText("Funcionário:");
        lblFuncionario.setToolTipText("");
        pnlConsulta.add(lblFuncionario, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 200, -1, -1));
        pnlConsulta.add(tfdCpfFuncionario, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 200, 170, 30));

        try {
            tfdDataIni.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tfdDataIni.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        pnlConsulta.add(tfdDataIni, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 150, 160, 30));

        try {
            tfdDataFim.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tfdDataFim.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        pnlConsulta.add(tfdDataFim, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 200, 160, 30));

        btnBuscaCliente.setBackground(new java.awt.Color(23, 169, 168));
        btnBuscaCliente.setForeground(new java.awt.Color(23, 169, 168));
        btnBuscaCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/livraria/imagens/botaoverificar.png"))); // NOI18N
        btnBuscaCliente.setBorder(null);
        btnBuscaCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscaClienteActionPerformed(evt);
            }
        });
        pnlConsulta.add(btnBuscaCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 150, 30, 30));

        btnBuscaFuncionario.setBackground(new java.awt.Color(23, 169, 168));
        btnBuscaFuncionario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/livraria/imagens/botaoverificar.png"))); // NOI18N
        btnBuscaFuncionario.setBorder(null);
        btnBuscaFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscaFuncionarioActionPerformed(evt);
            }
        });
        pnlConsulta.add(btnBuscaFuncionario, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 200, 30, 30));

        jLabel3.setForeground(new java.awt.Color(255, 0, 0));
        jLabel3.setText("*");
        pnlConsulta.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 210, 10, 10));

        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setText("*");
        pnlConsulta.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 150, 10, 10));

        btnpesquisarconsulta.setBackground(new java.awt.Color(23, 169, 168));
        btnpesquisarconsulta.setFont(new java.awt.Font("Poppins", 1, 13)); // NOI18N
        btnpesquisarconsulta.setForeground(new java.awt.Color(255, 255, 255));
        btnpesquisarconsulta.setText("Consultar");
        btnpesquisarconsulta.setToolTipText("");
        btnpesquisarconsulta.setBorder(null);
        btnpesquisarconsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpesquisarconsultaActionPerformed(evt);
            }
        });
        pnlConsulta.add(btnpesquisarconsulta, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 650, 130, 30));

        btnPesquisarItens.setBackground(new java.awt.Color(23, 169, 168));
        btnPesquisarItens.setFont(new java.awt.Font("Poppins", 1, 13)); // NOI18N
        btnPesquisarItens.setForeground(new java.awt.Color(255, 255, 255));
        btnPesquisarItens.setText("Ver itens");
        btnPesquisarItens.setToolTipText("");
        btnPesquisarItens.setBorder(null);
        btnPesquisarItens.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarItensActionPerformed(evt);
            }
        });
        pnlConsulta.add(btnPesquisarItens, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 650, 130, 30));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/livraria/imagens/gerarconsulta.png"))); // NOI18N
        pnlConsulta.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel1.add(pnlConsulta, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 1250, 700));

        pnlvendas.setBackground(new java.awt.Color(15, 112, 112));
        pnlvendas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        chkCartao.setBackground(new java.awt.Color(32, 32, 32));
        chkCartao.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        chkCartao.setText("    Cartão");
        chkCartao.setToolTipText("");
        chkCartao.setFocusPainted(false);
        chkCartao.setOpaque(false);
        chkCartao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkCartaoActionPerformed(evt);
            }
        });
        pnlvendas.add(chkCartao, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 150, -1, -1));

        chkDinheiro.setBackground(new java.awt.Color(255, 255, 255));
        chkDinheiro.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        chkDinheiro.setText("    Dinheiro");
        chkDinheiro.setToolTipText("");
        chkDinheiro.setFocusPainted(false);
        chkDinheiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkDinheiroActionPerformed(evt);
            }
        });
        pnlvendas.add(chkDinheiro, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 150, -1, -1));

        tfdPagar.setBackground(new java.awt.Color(204, 204, 204));
        tfdPagar.setBorder(null);
        tfdPagar.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tfdPagar.setToolTipText("");
        tfdPagar.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        pnlvendas.add(tfdPagar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 260, 140, 40));

        lblPagar.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        lblPagar.setText("Pagar:");
        pnlvendas.add(lblPagar, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 260, -1, -1));

        lblcpf.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        lblcpf.setText("CPF:");
        pnlvendas.add(lblcpf, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 340, -1, -1));

        tfdCpf.setBackground(new java.awt.Color(204, 204, 204));
        tfdCpf.setBorder(null);
        tfdCpf.setToolTipText("");
        tfdCpf.setFont(new java.awt.Font("Poppins", 0, 16)); // NOI18N
        pnlvendas.add(tfdCpf, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 330, 140, 40));

        btnfinalizar.setBackground(new java.awt.Color(2, 166, 166));
        btnfinalizar.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        btnfinalizar.setForeground(new java.awt.Color(255, 255, 255));
        btnfinalizar.setText("Finalizar venda");
        btnfinalizar.setBorder(null);
        btnfinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnfinalizarActionPerformed(evt);
            }
        });
        pnlvendas.add(btnfinalizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 630, 310, 40));

        tfdnome.setEditable(false);
        tfdnome.setBackground(new java.awt.Color(230, 227, 227));
        tfdnome.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        tfdnome.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfdnome.setBorder(null);
        pnlvendas.add(tfdnome, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 420, 250, 30));

        btnBuscarCliente.setBackground(new java.awt.Color(2, 166, 166));
        btnBuscarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/livraria/imagens/pesquisa.png"))); // NOI18N
        btnBuscarCliente.setBorder(null);
        btnBuscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarClienteActionPerformed(evt);
            }
        });
        pnlvendas.add(btnBuscarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 340, 30, 30));

        tfdTotal.setFont(new java.awt.Font("Poppins", 0, 20)); // NOI18N
        tfdTotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        pnlvendas.add(tfdTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 580, 120, 30));

        lblIdVenda.setFont(new java.awt.Font("Poppins", 1, 24)); // NOI18N
        lblIdVenda.setForeground(new java.awt.Color(2, 166, 166));
        lblIdVenda.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        pnlvendas.add(lblIdVenda, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 60, 90, 30));

        tabelaVenda.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        tabelaVenda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Título", "Preço", "Quantidade", "Subtotal"
            }
        ));
        tabelaVenda.setGridColor(new java.awt.Color(204, 204, 204));
        tabelaVenda.setRowHeight(35);
        tabelaVenda.setSelectionBackground(new java.awt.Color(204, 204, 204));
        tabelaVenda.setShowHorizontalLines(false);
        tabelaVenda.setShowVerticalLines(false);
        jScrollPane3.setViewportView(tabelaVenda);

        pnlvendas.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, 810, 450));

        btnadicionar.setBackground(new java.awt.Color(255, 255, 255));
        btnadicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/livraria/imagens/adicionar.png"))); // NOI18N
        btnadicionar.setBorder(null);
        btnadicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnadicionarActionPerformed(evt);
            }
        });
        pnlvendas.add(btnadicionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 140, 80, 40));

        btndescartar.setBackground(new java.awt.Color(255, 255, 255));
        btndescartar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/livraria/imagens/descartar.png"))); // NOI18N
        btndescartar.setBorder(null);
        btndescartar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndescartarActionPerformed(evt);
            }
        });
        pnlvendas.add(btndescartar, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 140, 80, 40));

        btndesconto.setBackground(new java.awt.Color(255, 255, 255));
        btndesconto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/livraria/imagens/codigo desconto.png"))); // NOI18N
        btndesconto.setBorder(null);
        pnlvendas.add(btndesconto, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 140, 80, 40));

        tfdCodigo.setBorder(null);
        tfdCodigo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfdCodigo.setToolTipText("");
        tfdCodigo.setFont(new java.awt.Font("Poppins", 0, 16)); // NOI18N
        pnlvendas.add(tfdCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, 70, 30));

        btnbuscacodigo.setBackground(new java.awt.Color(2, 166, 166));
        btnbuscacodigo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/livraria/imagens/buscarcodigo.png"))); // NOI18N
        btnbuscacodigo.setBorder(null);
        btnbuscacodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscacodigoActionPerformed(evt);
            }
        });
        pnlvendas.add(btnbuscacodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(175, 79, 30, 30));

        tfdProduto.setEditable(false);
        tfdProduto.setBackground(new java.awt.Color(229, 233, 233));
        tfdProduto.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        tfdProduto.setBorder(null);
        pnlvendas.add(tfdProduto, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 80, 380, 30));

        tfdValorUnitario.setEditable(false);
        tfdValorUnitario.setBackground(new java.awt.Color(229, 233, 233));
        tfdValorUnitario.setBorder(null);
        tfdValorUnitario.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tfdValorUnitario.setToolTipText("");
        tfdValorUnitario.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        pnlvendas.add(tfdValorUnitario, new org.netbeans.lib.awtextra.AbsoluteConstraints(138, 156, 100, 20));

        spnQuantidade.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        spnQuantidade.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        spnQuantidade.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        spnQuantidade.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spnQuantidadeStateChanged(evt);
            }
        });
        pnlvendas.add(spnQuantidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 80, 110, 30));

        tfdValorTotal.setEditable(false);
        tfdValorTotal.setBackground(new java.awt.Color(229, 233, 233));
        tfdValorTotal.setBorder(null);
        tfdValorTotal.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tfdValorTotal.setText("jCurrencyField1");
        tfdValorTotal.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        pnlvendas.add(tfdValorTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(315, 155, 110, -1));

        jLabel2.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        jLabel2.setText("R$");
        pnlvendas.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 155, -1, -1));

        jLabel1.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        jLabel1.setText("R$");
        pnlvendas.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 155, -1, -1));

        fundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/livraria/imagens/menucompras.png"))); // NOI18N
        pnlvendas.add(fundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel1.add(pnlvendas, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 1250, 700));

        pnlrelatorios.setBackground(new java.awt.Color(255, 255, 255));
        pnlrelatorios.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnVendasData.setBorder(null);
        btnVendasData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVendasDataActionPerformed(evt);
            }
        });
        pnlrelatorios.add(btnVendasData, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 240, 170, 170));

        btnLivrosEstantes.setBorder(null);
        btnLivrosEstantes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLivrosEstantesActionPerformed(evt);
            }
        });
        pnlrelatorios.add(btnLivrosEstantes, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 250, 150, 150));

        btnLivrosSemEstoque.setBorder(null);
        btnLivrosSemEstoque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLivrosSemEstoqueActionPerformed(evt);
            }
        });
        pnlrelatorios.add(btnLivrosSemEstoque, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 240, 170, 170));

        lblfundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/livraria/imagens/painelrelatorios.png"))); // NOI18N
        pnlrelatorios.add(lblfundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel1.add(pnlrelatorios, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 1250, 700));

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
        pnlvendas.setVisible(false);
        pnlrelatorios.setVisible(false);
        pnlcadastro.setVisible(false);
        pnlConsulta.setVisible(false);
        btnhome.setBackground(new Color(0, 102, 102));
        btncadastro.setBackground(new Color(32, 32, 32));
        btnvendas.setBackground(new Color(32, 32, 32));
        btnrelatorios.setBackground(new Color(32, 32, 32));
        btnconsulta.setBackground(new Color(32, 32, 32));
    }//GEN-LAST:event_btnhomeActionPerformed

    private void btncadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncadastroActionPerformed
        pnlcadastro.setVisible(true);
        pnlhome.setVisible(false);
        pnlvendas.setVisible(false);
        pnlConsulta.setVisible(false);
        btnhome.setBackground(new Color(32, 32, 32));
        btncadastro.setBackground(new Color(0, 102, 102));
        btnvendas.setBackground(new Color(32, 32, 32));
        btnrelatorios.setBackground(new Color(32, 32, 32));
        btnconsulta.setBackground(new Color(32, 32, 32));
    }//GEN-LAST:event_btncadastroActionPerformed
   
    private void btnvendasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnvendasActionPerformed
        pnlvendas.setVisible(true);
        pnlhome.setVisible(false);
        pnlcadastro.setVisible(false);
        pnlrelatorios.setVisible(false);
        pnlConsulta.setVisible(false);
        btnhome.setBackground(new Color(32, 32, 32));
        btncadastro.setBackground(new Color(32, 32, 32));
        btnvendas.setBackground(new Color(0, 102, 102));
        btnrelatorios.setBackground(new Color(32, 32, 32));
        btnconsulta.setBackground(new Color(32, 32, 32));
        atualizaIndiceVenda();
    }//GEN-LAST:event_btnvendasActionPerformed

    private void btnrelatoriosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnrelatoriosActionPerformed
        pnlrelatorios.setVisible(true);
        pnlhome.setVisible(false);
        pnlcadastro.setVisible(false);
        pnlvendas.setVisible(false);
        pnlConsulta.setVisible(false);
        btnhome.setBackground(new Color(32, 32, 32));
        btncadastro.setBackground(new Color(32, 32, 32));
        btnvendas.setBackground(new Color(32, 32, 32));
        btnconsulta.setBackground(new Color(32, 32, 32));
        btnrelatorios.setBackground(new Color(0, 102, 102));
    }//GEN-LAST:event_btnrelatoriosActionPerformed

    private void funcionarioMes() {
    VendaDAO dao = new VendaDAO();
    int idFM;
    idFM = dao.obterFuncionarioMes();
    FuncionarioDAO daoF = new FuncionarioDAO();
    Funcionario funcionariom = daoF.consultarId(idFM);
    tfdnomeFuncMes.setText(funcionariom.getNome());   
}
    
    private void totalVendas () {
      int total;
      VendaDAO dao = new VendaDAO();
      total = dao.obterUltima();
      lblTotalVendas.setText(String.valueOf(total));
    }
    
    private void totalVendasFuncionario() {
     int total;
     VendaDAO dao = new VendaDAO();
     total = dao.obterNumeroVendas(id);
     lblMinhasVendas.setText(String.valueOf(total));
    }
    
    private void btnupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupdateActionPerformed
        switch (cmbescolher.getSelectedIndex()) {
            case 0:
                new LivroDAO().popularTabela(tblgeral, "");
                break;
            case 1:
                new FuncionarioDAO().popularTabela(tblgeral, "");
                break;
            case 2:
                new ClienteDAO().popularTabela(tblgeral, "");
                break;
            default:
                break;
        }
    }//GEN-LAST:event_btnupdateActionPerformed

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        switch (cmbescolher.getSelectedIndex()) {
            case 0:
                DlgLivros tela = new DlgLivros(null, true);
                tela.setVisible(true);
                break;
            case 1:
                DlgFuncionario tela2 = new DlgFuncionario(null, true);
                tela2.setVisible(true);
                break;
            case 2:
                DlgCliente tela3 = new DlgCliente(null, true);
                tela3.setVisible(true);
                break;
            default:
                break;
        }
    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        if (tblgeral.getSelectedRow() < 0) {
            lblmensagem.setVisible(true);
        } else {
            System.out.println(cmbescolher.getSelectedIndex());
            switch (cmbescolher.getSelectedIndex()) {
                case 0: {
                    String idString = String.valueOf(tblgeral.getValueAt(tblgeral.getSelectedRow(), 0));
                    int id = Integer.parseInt(idString);
                    Livro livro = new LivroDAO().consultarId(id);
                    lblmensagem.setVisible(false);
                    DlgLivros tela = new DlgLivros(null, true, livro);
                    tela.setVisible(true);
                    break;
                }
                case 1: {
                    String idString = String.valueOf(tblgeral.getValueAt(tblgeral.getSelectedRow(), 0));
                    int id = Integer.parseInt(idString);
                    Funcionario funcionario = new FuncionarioDAO().consultarId(id);
                    lblmensagem.setVisible(false);
                    DlgFuncionario tela = new DlgFuncionario(null, true, funcionario);
                    tela.setVisible(true);
                    break;
                }
                case 2: {
                    String idString = String.valueOf(tblgeral.getValueAt(tblgeral.getSelectedRow(), 0));
                    int id = Integer.parseInt(idString);
                    Cliente cliente = new ClienteDAO().consultarId(id);
                    lblmensagem.setVisible(false);
                    DlgCliente tela = new DlgCliente(null, true, cliente);
                    tela.setVisible(true);
                    break;
                }
                default:
                    break;
            }
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        if (tblgeral.getSelectedRow() < 0) {
            lblmensagem.setVisible(true);
        } else {

            Object[] options = {"Inativar", "Excluir"};
            int opcao = JOptionPane.showOptionDialog(null, "Escolha a opção desejada", "Excluir", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);

            System.out.println("Opção = " + opcao);

            switch (cmbescolher.getSelectedIndex()) {
                case 0: {
                    String idString = String.valueOf(tblgeral.getValueAt(tblgeral.getSelectedRow(), 0));
                    int id = Integer.parseInt(idString);
                    if (opcao == 0) {

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
                    break;
                }
                case 1: {
                    String idString = String.valueOf(tblgeral.getValueAt(tblgeral.getSelectedRow(), 0));
                    int id = Integer.parseInt(idString);
                    if (opcao == 0) {

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
                    break;
                }
                case 2: {
                    String idString = String.valueOf(tblgeral.getValueAt(tblgeral.getSelectedRow(), 0));
                    int id = Integer.parseInt(idString);
                    if (opcao == 0) {

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
                    break;
                }
                default:
                    break;
            }
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnpesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpesquisaActionPerformed
        switch (cmbescolher.getSelectedIndex()) {
            case 0:
                new LivroDAO().popularTabela(tblgeral, tfdbusca.getText());
                break;
            case 1:
                new FuncionarioDAO().popularTabela(tblgeral, tfdbusca.getText());
                break;
            case 2:
                new ClienteDAO().popularTabela(tblgeral, tfdbusca.getText());
                break;
            default:
                break;
        }
    }//GEN-LAST:event_btnpesquisaActionPerformed

    private void tfdbuscaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tfdbuscaMouseClicked
        tfdbusca.setText("");
        tfdbusca.setForeground(Color.BLACK);
    }//GEN-LAST:event_tfdbuscaMouseClicked

    private void cmbescolherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbescolherActionPerformed

        switch (cmbescolher.getSelectedIndex()) {
            case 0:
                new LivroDAO().popularTabela(tblgeral, "");
                btnRelatorioCliente.setVisible(false);
                break;
            case 1:
                new FuncionarioDAO().popularTabela(tblgeral, "");
                btnRelatorioCliente.setVisible(false);
                break;
            case 2:
                new ClienteDAO().popularTabela(tblgeral, "");
                btnRelatorioCliente.setVisible(true);
                break;
            default:
                break;
        }
    }//GEN-LAST:event_cmbescolherActionPerformed

    private void btneditarperfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditarperfilActionPerformed
        DlgEditarPerfil telaperfil = new DlgEditarPerfil(null, true, id, username, nome, email);
        telaperfil.setVisible(true);
    }//GEN-LAST:event_btneditarperfilActionPerformed

//------------------------------------parte de vendas-------------------------------------//

    private void spnQuantidadeStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spnQuantidadeStateChanged

        int qtd = (Integer) spnQuantidade.getValue();
        double venda = Double.parseDouble(preco.replaceAll(",", "."));
        double total = (qtd * venda);
        String total2 = priceToString(total);
        tfdValorTotal.setText(total2);
        
    }//GEN-LAST:event_spnQuantidadeStateChanged

    private void btnbuscacodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscacodigoActionPerformed
        int id = Integer.parseInt(tfdCodigo.getText());
        livro = new LivroDAO().consultarId(id);
        String venda = priceToString(livro.getValor_venda());
        tfdValorUnitario.setText(venda);
        tfdValorTotal.setText(venda);
        preco = venda;
        spnQuantidade.setValue(1);
        tfdProduto.setText(livro.getTitulo());
    }//GEN-LAST:event_btnbuscacodigoActionPerformed

    private void btnadicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnadicionarActionPerformed
       
        int quantidade = (Integer) spnQuantidade.getValue();
        
        if (tfdCodigo.getText().isEmpty() || tfdCodigo.getText().equals("0")) {
            JOptionPane.showMessageDialog(rootPane,
                "Você deve inserir o código do produto!",
                "Atencão",
                JOptionPane.ERROR_MESSAGE);
            
        } else if (quantidade == 0) {
            JOptionPane.showMessageDialog(rootPane,
                "A quantidade de itens não pode ser zero!",
                "Atencão",
                JOptionPane.ERROR_MESSAGE);
            
        } else {
                   
            //-----------------------------------------------------------------------------------//
            int qtd;
            int retirado;
            int total;
            int verificar;
            LivroDAO daoL = new LivroDAO();
            Livro livro = new Livro();
            livro = daoL.consultarId(Integer.parseInt(tfdCodigo.getText()));
            verificar = livro.getQuantidade();
            
            if (verificar < quantidade) {
              JOptionPane.showMessageDialog(rootPane,
                "A quantidade não está disponível em estoque!",
                "Atencão",
                JOptionPane.ERROR_MESSAGE);  
              
            } else {
            
            
            ItemVendaDAO dao = new ItemVendaDAO();
            ItemVenda item = new ItemVenda();
            item.setIdProduto(Integer.parseInt(tfdCodigo.getText()));
            item.setIdVenda(Integer.parseInt(lblIdVenda.getText()));
            item.setNomeProduto(tfdProduto.getText());
            item.setQuantidade(quantidade);
            item.setSubtotal(Double.parseDouble(tfdValorTotal.getText().replaceAll(",", ".")));
            item.setValor_item(Double.parseDouble(tfdValorUnitario.getText().replaceAll(",", ".")));
            dao.salvar(item);
            
            int ultimaVenda = atualizaIndiceVenda();
            dao.popularTabela(tabelaVenda, ultimaVenda);
            
            retirado = quantidade;
            qtd = livro.getQuantidade();
            total = qtd - retirado;
            livro.setQuantidade(total);
            daoL.atualizar(livro);
            codigoLivro = Integer.parseInt(tfdCodigo.getText());
            
            atualizaSubtotal();

        }
        }
        tfdProduto.setText("");
        tfdValorUnitario.setText("0");
        tfdValorTotal.setText("0");
        spnQuantidade.setValue(0);
        tfdCodigo.setText("0");
    }//GEN-LAST:event_btnadicionarActionPerformed

    private void btndescartarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndescartarActionPerformed
        if (tabelaVenda.getSelectedRow() != -1) {
            
            LivroDAO daoL = new LivroDAO();
            Livro livro = new Livro();
            
            int row = tabelaVenda.getSelectedRow();
            int column = 0;
            String value = tabelaVenda.getModel().getValueAt(row, column).toString();
            String qtdString = tabelaVenda.getModel().getValueAt(row, 3).toString();
            int retirado = Integer.parseInt(qtdString);
            int codigo = Integer.parseInt(value);
            
            DefaultTableModel dtmProdutos = (DefaultTableModel) tabelaVenda.getModel();
            dtmProdutos.removeRow(tabelaVenda.getSelectedRow());
            ItemVendaDAO dao = new ItemVendaDAO();
            dao.excluir(codigo);
            
            int total;
            int quantidade;
            livro = daoL.consultarId(codigoLivro);
            quantidade = livro.getQuantidade();
            total = quantidade + retirado;
            livro.setQuantidade(total);
            daoL.atualizar(livro);
                       
            atualizaSubtotal();
            // double valor = Double.parseDouble(preco);
            //total -= valor;
        }
    }//GEN-LAST:event_btndescartarActionPerformed
    public void atualizaSubtotal() {

        double subtotal = 0f;

        //faz cálculo de subtotal da compra
        DefaultTableModel tabela = (DefaultTableModel) tabelaVenda.getModel();
        for (int i = 1; i <= tabela.getRowCount(); i++) {
            subtotal += (Double) tabelaVenda.getValueAt(i - 1, 4);
        }

        //insere valor subtotal da compra na label
        tfdTotal.setText(String.valueOf(subtotal));
    }

    public int atualizaIndiceVenda() {
       
        int idvenda;
        VendaDAO venda = new VendaDAO();
        int ultimaVenda = venda.obterUltima();
        
        System.out.println(ultimaVenda);
        

        if (ultimaVenda == 0) {
            lblIdVenda.setText("1");
            ultimaVenda = 1;           
        } else {
            ultimaVenda += 1;
            lblIdVenda.setText("" + ultimaVenda);
            return ultimaVenda;
        }
        return ultimaVenda;
    }

    private void chkDinheiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkDinheiroActionPerformed
        if (chkDinheiro.isSelected()) {
            chkCartao.setSelected(false);
            tfdPagar.setEditable(true);
            formapagamento = "Dinheiro";
        }
    }//GEN-LAST:event_chkDinheiroActionPerformed

    private void chkCartaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkCartaoActionPerformed
        chkDinheiro.setSelected(false);
        tfdPagar.setEditable(true);
        formapagamento = "Cartão";
    }//GEN-LAST:event_chkCartaoActionPerformed

    private void btnBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarClienteActionPerformed
        ClienteDAO dao = new ClienteDAO();
        Cliente cliente = new Cliente();
        cliente = dao.consultarCpf(tfdCpf.getText());
        if (cliente != null) {
            tfdnome.setVisible(true);
            tfdnome.setText(cliente.getNome());
        } else {
            tfdnome.setText("Cliente não encontrado");
        }
    }//GEN-LAST:event_btnBuscarClienteActionPerformed

    private void btnfinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnfinalizarActionPerformed
        int cont = tabelaVenda.getRowCount();
        System.out.println("contagem: "+ cont);
        
        if (cont <= 0) {
         JOptionPane.showMessageDialog(rootPane,
                "Você deve adicionar itens para venda!",
                "Atencão",
                JOptionPane.ERROR_MESSAGE);   
        } else if (!chkDinheiro.isSelected() && !chkCartao.isSelected()) { 
            JOptionPane.showMessageDialog(rootPane,
                "Você precisa selecionar uma forma de pagamento!",
                "Atencão",
                JOptionPane.ERROR_MESSAGE);
        } else if (tfdPagar.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane,
                "Você precisa informar o valor a ser pago!",
                "Atencão",
                JOptionPane.ERROR_MESSAGE);
        } else if (tfdnome.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane,
                "O cpf do cliente deve ser informado!",
                "Atencão",
                JOptionPane.ERROR_MESSAGE);
        } else {
            ClienteDAO clidao = new ClienteDAO();
            Cliente cliente = new Cliente();
            cliente = clidao.consultarCpf(tfdCpf.getText());
            Double valorPagar = Double.parseDouble(tfdPagar.getText().replaceAll(",", "."));
            Double totalc = Double.parseDouble(tfdTotal.getText().replaceAll(",", "."));
            if (valorPagar < totalc) {
                JOptionPane.showMessageDialog(rootPane,
               "O valor a ser pago está incorreto!",
                "Atencão",
                JOptionPane.ERROR_MESSAGE);
            } else {
            tfdnome.setVisible(true);
            tfdnome.setText(cliente.getNome());
            
            Venda venda = new Venda();           
            VendaDAO dao = new VendaDAO();
            Double total = Double.valueOf(tfdTotal.getText().replaceAll(",", ".")).doubleValue();            
            java.util.Date dataUtil = new java.util.Date();
            java.sql.Date dataSql = new java.sql.Date(dataUtil.getTime());  
            
            int idVenda = Integer.parseInt(lblIdVenda.getText());
            
            venda.setId(idVenda);
            venda.setCliente_id(cliente.getId());
            venda.setData_venda(dataSql);
            venda.setFuncionario_id(id);
            venda.setForma_pagamento(formapagamento);
            venda.setValor_pagamento(total);
            dao.salvar(venda);
            
            if (valorPagar > total) {
                Double troco = valorPagar - total;
                JOptionPane.showMessageDialog(rootPane,
                "Venda concluída com sucesso!\n"
                + "Troco: R$"+troco,
                "Venda finalizada", JOptionPane.INFORMATION_MESSAGE);                                
            } else {
            JOptionPane.showMessageDialog(rootPane,
                "Venda concluída com sucesso!",
                "Venda finalizada", JOptionPane.INFORMATION_MESSAGE);                      
        }
        DefaultTableModel tabela = (DefaultTableModel) tabelaVenda.getModel();
        tabela.setRowCount(0);
        tfdTotal.setText("");
        tfdnome.setText("");
        tfdPagar.setText("0");
        tfdCpf.setText("");
        chkDinheiro.setSelected(false);
        chkCartao.setSelected(false);
        atualizaIndiceVenda();
        }
        }
        
    }//GEN-LAST:event_btnfinalizarActionPerformed

    private void btnLivrosEstantesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLivrosEstantesActionPerformed
        DlgRelatorioEstantes tela = new DlgRelatorioEstantes(null, true);
        tela.setVisible(true);
    }//GEN-LAST:event_btnLivrosEstantesActionPerformed

    private void btnVendasDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVendasDataActionPerformed
      DlgRelatorioVendas tela2 = new DlgRelatorioVendas(null, true);
      tela2.setVisible(true);
    }//GEN-LAST:event_btnVendasDataActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        LoginGUI login = new LoginGUI();
        login.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void btnLivrosSemEstoqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLivrosSemEstoqueActionPerformed
        try {
            // Compila o relatorio
            JasperReport relatorio = JasperCompileManager.compileReport(getClass().getResourceAsStream("/relatorio/relatorioLivrosSemEstoque.jrxml"));

            // Mapeia campos de parametros para o relatorio, mesmo que nao existam
            Map parametros = new HashMap();

            // Executa relatoio
            JasperPrint impressao = JasperFillManager.fillReport(relatorio, parametros, ConexaoBD.getInstance().getConnection());

            // Exibe resultado em video
            JasperViewer.viewReport(impressao, false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao gerar relatório: " + e);
        }
    }//GEN-LAST:event_btnLivrosSemEstoqueActionPerformed

    private void btnconsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnconsultaActionPerformed
        pnlConsulta.setVisible(true);
        pnlcadastro.setVisible(false);
        pnlhome.setVisible(false);
        pnlrelatorios.setVisible(false);
        pnlvendas.setVisible(false);
        btnconsulta.setBackground(new Color(0, 102, 102));
        btnhome.setBackground(new Color(32, 32, 32));
        btncadastro.setBackground(new Color(32, 32, 32));
        btnvendas.setBackground(new Color(32, 32, 32));
        btnrelatorios.setBackground(new Color(32, 32, 32));
    }//GEN-LAST:event_btnconsultaActionPerformed

    private void btnBuscaClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscaClienteActionPerformed
        String cpf = tfdCpfCliente.getText();
        
        if (cpf.replaceAll("\\D", "").isEmpty()){
            JOptionPane.showMessageDialog(rootPane,
                "Você deve informar um cpf para continuar!",
                "Atencão",
                JOptionPane.ERROR_MESSAGE);
        } else {        
        ClienteDAO dao = new ClienteDAO();
        cliente = dao.consultarCpf(cpf);
        
        if (cliente == null){
            JOptionPane.showMessageDialog(rootPane,
                "Cliente não encontrado!",
                "Atencão",
                JOptionPane.ERROR_MESSAGE);
            
        } else {           
        Object[] options = { "Confirmar", "Cancelar" };
        int resposta = JOptionPane.showOptionDialog(null, "O cliente que você procura é: "+cliente.getNome()+" ?", "Informação", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        if (resposta == 0){
            System.out.println("ok");          
        } else {
            tfdCpfCliente.setText("");
        }
        }
        }
    }//GEN-LAST:event_btnBuscaClienteActionPerformed

    private void btnBuscaFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscaFuncionarioActionPerformed
        String cpf = tfdCpfFuncionario.getText();
        
        if (cpf.replaceAll("\\D", "").isEmpty()){
            JOptionPane.showMessageDialog(rootPane,
                "Você deve informar um cpf para continuar!",
                "Atencão",
                JOptionPane.ERROR_MESSAGE);
        } else {        
        FuncionarioDAO dao = new FuncionarioDAO();
        funcionarioP = dao.consultarCpf(cpf);
        
        if (funcionarioP == null){
            JOptionPane.showMessageDialog(rootPane,
                "Funcionário não encontrado!",
                "Atencão",
                JOptionPane.ERROR_MESSAGE);
            
        } else {           
        Object[] options = { "Confirmar", "Cancelar" };
        int resposta = JOptionPane.showOptionDialog(null, "O funcionário que você procura é: "+funcionarioP.getNome()+" ?", "Informação", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        if (resposta == 0){
        } else {
            tfdCpfFuncionario.setText("");
        }
        }
        }
    }//GEN-LAST:event_btnBuscaFuncionarioActionPerformed

    private void btnpesquisarconsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpesquisarconsultaActionPerformed
        String dataIni = tfdDataIni.getText();
        String dataFim = tfdDataFim.getText();
        String cliente;
        String funcionario;
        if (tfdDataIni.getText().replaceAll("\\D", "").isEmpty() || tfdDataFim.getText().replaceAll("\\D", "").isEmpty()) {
            JOptionPane.showMessageDialog(rootPane,
                "As datas são obrigatórias!",
                "Atencão",
                JOptionPane.ERROR_MESSAGE);
        } else {
        if (!tfdCpfCliente.getText().replaceAll("\\D", "").isEmpty()) {
            cliente = tfdCpfCliente.getText();
        } else {
            cliente = "";
        }
        if (!tfdCpfFuncionario.getText().replaceAll("\\D", "").isEmpty()) {
            funcionario = tfdCpfFuncionario.getText();
        } else {
            funcionario = "";
        }
        new VendaDAO().popularTabela(tblconsulta, dataIni, dataFim, cliente, funcionario);                 
        }
    }//GEN-LAST:event_btnpesquisarconsultaActionPerformed

    private void btnPesquisarItensActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarItensActionPerformed
         if (tblconsulta.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(rootPane,
                "Você deve selecionar uma venda!",
                "Atencão",
                JOptionPane.ERROR_MESSAGE);
        } else {       
        String idString = String.valueOf(tblconsulta.getValueAt(tblconsulta.getSelectedRow(), 0));
        int id = Integer.parseInt(idString);
        DlgItensConsulta consultar = new DlgItensConsulta(null, true, id);
        consultar.setVisible(true);
    }
    }//GEN-LAST:event_btnPesquisarItensActionPerformed

    private void btnRelatorioClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRelatorioClienteActionPerformed
        if (tblgeral.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(rootPane,
                "Você deve selecionar um cliente!",
                "Atencão",
                JOptionPane.ERROR_MESSAGE);
        } else {
         String clienteId = String.valueOf(tblgeral.getValueAt(tblgeral.getSelectedRow(), 0));
         int idC = Integer.parseInt(clienteId);
         ClienteDAO dao = new ClienteDAO();
         cliente = dao.consultarId(idC);
         String nomeCli = cliente.getNome();
         int codCli = cliente.getId();     
            
            try {
            // Compila o relatorio
            JasperReport relatorio = JasperCompileManager.compileReport(getClass().getResourceAsStream("/relatorio/RelatorioVendasCliente.jrxml"));

            // Mapeia campos de parametros para o relatorio, mesmo que nao existam
            Map parametros = new HashMap();

            // adiciona parametros           
            parametros.put("idCliente",codCli);
            parametros.put("nomeCliente",nomeCli);
            

            // Executa relatoio
            JasperPrint impressao = JasperFillManager.fillReport(relatorio, parametros, ConexaoBD.getInstance().getConnection());

            // Exibe resultado em video
            JasperViewer.viewReport(impressao, false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao gerar relatório: " + e);
        }
        }    
    }//GEN-LAST:event_btnRelatorioClienteActionPerformed
   
    public static String priceWithDecimal(Double price) {
        DecimalFormat formatter = new DecimalFormat("###,###,###.00");
        return formatter.format(price);
    }

    public static String priceWithoutDecimal(Double price) {
        DecimalFormat formatter = new DecimalFormat("###,###,###.##");
        return formatter.format(price);
    }

    public static String priceToString(Double price) {
        String toShow = priceWithoutDecimal(price);
        if (toShow.indexOf(".") > 0) {
            return priceWithDecimal(price);
        } else {
            return priceWithoutDecimal(price);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnBuscaCliente;
    private javax.swing.JButton btnBuscaFuncionario;
    private javax.swing.JButton btnBuscarCliente;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnLivrosEstantes;
    private javax.swing.JButton btnLivrosSemEstoque;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnPesquisarItens;
    private javax.swing.JButton btnRelatorioCliente;
    private javax.swing.JButton btnVendasData;
    private javax.swing.JButton btnadicionar;
    private javax.swing.JButton btnbuscacodigo;
    private javax.swing.JButton btncadastro;
    private javax.swing.JButton btnconsulta;
    private javax.swing.JButton btndescartar;
    private javax.swing.JButton btndesconto;
    private javax.swing.JButton btneditarperfil;
    private javax.swing.JButton btnfinalizar;
    private javax.swing.JButton btnhome;
    private javax.swing.JButton btnpesquisa;
    private javax.swing.JButton btnpesquisarconsulta;
    private javax.swing.JButton btnrelatorios;
    private javax.swing.JButton btnupdate;
    private javax.swing.JButton btnvendas;
    private javax.swing.JCheckBox chkCartao;
    private javax.swing.JCheckBox chkDinheiro;
    private javax.swing.JComboBox<String> cmbescolher;
    private javax.swing.JLabel fundo;
    private javax.swing.JLabel fundohome;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel jldata;
    private javax.swing.JLabel jlhora;
    private javax.swing.JLabel lblCliente;
    private javax.swing.JLabel lblDataIni;
    private javax.swing.JLabel lblDataIni1;
    private javax.swing.JLabel lblFuncionario;
    private javax.swing.JLabel lblIdVenda;
    private javax.swing.JLabel lblMinhasVendas;
    private javax.swing.JLabel lblPagar;
    private javax.swing.JLabel lblTotalVendas;
    private javax.swing.JLabel lblcpf;
    private javax.swing.JLabel lblfuncionario;
    private javax.swing.JLabel lblfundo;
    private javax.swing.JLabel lblmensagem;
    private javax.swing.JLabel logo;
    private javax.swing.JPanel pnlConsulta;
    private javax.swing.JPanel pnlcadastro;
    private javax.swing.JPanel pnlfundo;
    private javax.swing.JPanel pnlhome;
    private javax.swing.JPanel pnlmenu;
    private javax.swing.JPanel pnlrelatorios;
    private javax.swing.JPanel pnlusername;
    private javax.swing.JPanel pnlvendas;
    private javax.swing.JSpinner spnQuantidade;
    private javax.swing.JTable tabelaVenda;
    private javax.swing.JTable tblconsulta;
    private javax.swing.JTable tblgeral;
    private apoio.JNumberField tfdCodigo;
    private apoio.JCpfField tfdCpf;
    private apoio.JCpfField tfdCpfCliente;
    private apoio.JCpfField tfdCpfFuncionario;
    private javax.swing.JFormattedTextField tfdDataFim;
    private javax.swing.JFormattedTextField tfdDataIni;
    private apoio.JCurrencyField tfdPagar;
    private javax.swing.JTextField tfdProduto;
    private javax.swing.JLabel tfdTotal;
    private apoio.JCurrencyField tfdValorTotal;
    private apoio.JCurrencyField tfdValorUnitario;
    private javax.swing.JTextField tfdbusca;
    private javax.swing.JTextField tfdnome;
    private javax.swing.JLabel tfdnomeFuncMes;
    // End of variables declaration//GEN-END:variables
class hora implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Calendar now = Calendar.getInstance();
            jlhora.setText(String.format("%1$tH:%1$tM", now));
        }
    }
}
