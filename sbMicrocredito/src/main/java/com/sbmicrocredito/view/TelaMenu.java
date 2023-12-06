package com.sbmicrocredito.view;

import com.sbmicrocredito.controler.FinancasDAO;
import com.sbmicrocredito.controler.FuncionarioDAO;
import com.sbmicrocredito.model.Financas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.geom.RoundRectangle2D;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 *
 * @author Djudju
 */
public class TelaMenu extends JFrame implements ActionListener{
    Font font = new Font("Arial", Font.BOLD, 17);
    Font font2 = new Font("Times New Roman", Font.ITALIC, 30);
    Font font1 = new Font("Arial", Font.PLAIN, 16);
    
    ImageIcon iconLogo = new ImageIcon(getClass().getResource("logoIcon.png"));
    ImageIcon iconAdministrados = new ImageIcon(getClass().getResource("venancio.jpg"));
    ImageIcon iconEmprestimo = new ImageIcon(getClass().getResource("emprestimo_1.png"));
    ImageIcon iconCriarFun = new ImageIcon(getClass().getResource("cadastrar1.png"));
    ImageIcon iconEstatica = new ImageIcon(getClass().getResource("estatistica_1.png"));
    ImageIcon iconRelatorio = new ImageIcon(getClass().getResource("relatorio.png"));
    ImageIcon iconListarCli = new ImageIcon(getClass().getResource("listar1.png"));
    ImageIcon iconListarFun = new ImageIcon(getClass().getResource("listar2.png"));
    ImageIcon iconGarantia = new ImageIcon(getClass().getResource("garantia.png"));
    ImageIcon iconExit = new ImageIcon(getClass().getResource("exit.png"));
    ImageIcon iconSair = new ImageIcon(getClass().getResource("sair.png"));
    ImageIcon iconOpcoes = new ImageIcon(getClass().getResource("opcoes.png"));
    ImageIcon iconTrocar = new ImageIcon(getClass().getResource("trocar.png"));
    ImageIcon iconConsultar = new ImageIcon(getClass().getResource("consultar.png"));
    ImageIcon iconactivar = new ImageIcon(getClass().getResource("activar.png"));
    ImageIcon iconCpnsultaSal = new ImageIcon(getClass().getResource("consultarSal.png"));
    ImageIcon iconConsultarBonus = new ImageIcon(getClass().getResource("bonusConsulta.png"));
    ImageIcon iconRecarregar = new ImageIcon(getClass().getResource("recarregar.png"));
    
    
    JLabel lbImagemLogo;
    JLabel lbDataHora;
    JLabel lbAdministrador;
    JLabel lbDadosAdmin;
    
    JButton jbEmprestimo;
    JButton jbCriarFuncionario;
    JButton jbListarEmprestimo;
    JButton jbListarFuncionario;
    JButton jbListarGaratia;
    JButton jbRelatorio;
    JButton jbEstatistica;
    
    JMenuBar barra;
    JMenu opcoes;
    JMenuItem opcoesRecarregar;
    
    JMenu consulta;
    JMenuItem consultaSaldo;
    JMenuItem consultaLucro;
    
    JMenu sair;
    JMenuItem sairExit;
    JMenuItem sairTrocar;
    
    JMenu activarFuncionario;
    JMenuItem activarRenovarContrato;
    
    Toolkit tk = Toolkit.getDefaultToolkit();
    Dimension d = tk.getScreenSize();
    
    JPanel  PainelMenu = new JPanel();
    public TelaMenu(){
        this.menu();
        this.label();
        this.butao();
        this.configuracoesTela();
        this.tempo();
        
    }
    
    public void configuracoesTela(){
        this.imagemFundo();
        setSize(720, 480);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setUndecorated(true);
        setLayout(null);
        setVisible(true);
        
        PainelMenu.setBounds((d.width-400)/2, (d.height-745)/2, 400, 725);
        PainelMenu.setBackground(Color.WHITE);
        PainelMenu.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK));
        PainelMenu.setBackground(new Color(23, 54, 93));
        PainelMenu.setLayout(null);
        
        add(PainelMenu);
        add(lbDataHora);
        add(lbAdministrador);
        add(lbDadosAdmin);
        
        PainelMenu.add(lbImagemLogo);
        PainelMenu.add(jbEmprestimo);
        PainelMenu.add(jbCriarFuncionario);
        PainelMenu.add(jbListarEmprestimo);
        PainelMenu.add(jbListarFuncionario);
        PainelMenu.add(jbListarGaratia);
        PainelMenu.add(jbRelatorio);
        PainelMenu.add(jbEstatistica);
    }
    private  final void imagemFundo(){
        JPanel painelFundo = new JPanel(){
            protected void paintComponent(Graphics g){
                super.paintComponent(g);
                ImageIcon fundo = new ImageIcon(getClass().getResource("fundo3.jpg"));
                g.drawImage(fundo.getImage(), 0, 0, d.width, d.height, null);
            }
        };
        setContentPane(painelFundo);
    }
    private final void label(){
        lbImagemLogo = new JLabel(iconLogo);
        lbImagemLogo.setBounds(89, 10, 222, 222);
        
        lbDataHora = new JLabel();
        lbDataHora.setBounds(10, 10, 400, 50);
        lbDataHora.setFont(font2);
        lbDataHora.setForeground(Color.white);
        
        lbAdministrador = new JLabel(iconAdministrados);
        lbAdministrador.setBounds(50, 70, 180, 200);
        lbAdministrador.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.white));
        
        lbDadosAdmin = new JLabel("Administrador");
        lbDadosAdmin.setBounds(90, 280, 180, 25);
        lbDadosAdmin.setForeground(Color.WHITE);
        lbDadosAdmin.setFont(font);
    }
    private final void butao(){
        jbEmprestimo = new JButton("Registar emprestimo", iconEmprestimo) {
            @Override
            protected void paintComponent(Graphics g) {
                if (getModel().isArmed()) {
                    g.setColor(getBackground().darker());
                } else {
                    g.setColor(getBackground());
                }

                int width = getWidth();
                int height = getHeight();
                int arc = 30; // Ajuste o valor para controlar o raio dos cantos arredondados

                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                g2.fill(new RoundRectangle2D.Double(0, 0, width, height, arc, arc));
                g2.setColor(getForeground());
                super.paintComponent(g);
            }
        };
        jbEmprestimo.setBounds(50, 212, 300, 60);
        jbEmprestimo.setBorder(BorderFactory.createEmptyBorder());
        jbEmprestimo.setContentAreaFilled(false);
        jbEmprestimo.setBackground(Color.WHITE);
        jbEmprestimo.setForeground(Color.BLACK);
        jbEmprestimo.setFont(font);
        jbEmprestimo.setFocusable(false);
        jbEmprestimo.addActionListener(this);
        
        jbCriarFuncionario = new JButton("Criar funcionario", iconCriarFun) {
            @Override
            protected void paintComponent(Graphics g) {
                if (getModel().isArmed()) {
                    g.setColor(getBackground().darker());
                } else {
                    g.setColor(getBackground());
                }

                int width = getWidth();
                int height = getHeight();
                int arc = 30; // Ajuste o valor para controlar o raio dos cantos arredondados

                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                g2.fill(new RoundRectangle2D.Double(0, 0, width, height, arc, arc));
                g2.setColor(getForeground());
                super.paintComponent(g);
            }
        };
        jbCriarFuncionario.setBounds(50, 282, 300, 60);
        jbCriarFuncionario.setBorder(BorderFactory.createEmptyBorder());
        jbCriarFuncionario.setContentAreaFilled(false);
        jbCriarFuncionario.setBackground(Color.WHITE);
        jbCriarFuncionario.setForeground(Color.BLACK);
        jbCriarFuncionario.setFont(font);
        jbCriarFuncionario.setFocusable(false);
        jbCriarFuncionario.addActionListener(this);
        
        jbListarEmprestimo = new JButton("Listar cliente", iconListarCli) {
            @Override
            protected void paintComponent(Graphics g) {
                if (getModel().isArmed()) {
                    g.setColor(getBackground().darker());
                } else {
                    g.setColor(getBackground());
                }

                int width = getWidth();
                int height = getHeight();
                int arc = 30; // Ajuste o valor para controlar o raio dos cantos arredondados

                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                g2.fill(new RoundRectangle2D.Double(0, 0, width, height, arc, arc));
                g2.setColor(getForeground());
                super.paintComponent(g);
            }
        };
        jbListarEmprestimo.setBounds(50, 352, 300, 60);
        jbListarEmprestimo.setBorder(BorderFactory.createEmptyBorder());
        jbListarEmprestimo.setContentAreaFilled(false);
        jbListarEmprestimo.setBackground(Color.WHITE);
        jbListarEmprestimo.setForeground(Color.BLACK);
        jbListarEmprestimo.setFont(font);
        jbListarEmprestimo.setFocusable(false);
        jbListarEmprestimo.addActionListener(this);
        
        jbListarFuncionario = new JButton("Listar Funcionario", iconListarFun) {
            @Override
            protected void paintComponent(Graphics g) {
                if (getModel().isArmed()) {
                    g.setColor(getBackground().darker());
                } else {
                    g.setColor(getBackground());
                }

                int width = getWidth();
                int height = getHeight();
                int arc = 30; // Ajuste o valor para controlar o raio dos cantos arredondados

                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                g2.fill(new RoundRectangle2D.Double(0, 0, width, height, arc, arc));
                g2.setColor(getForeground());
                super.paintComponent(g);
            }
        };
        jbListarFuncionario.setBounds(50, 422, 300, 60);
        jbListarFuncionario.setBorder(BorderFactory.createEmptyBorder());
        jbListarFuncionario.setContentAreaFilled(false);
        jbListarFuncionario.setBackground(Color.WHITE);
        jbListarFuncionario.setForeground(Color.BLACK);
        jbListarFuncionario.setFont(font);
        jbListarFuncionario.setFocusable(false);
        jbListarFuncionario.addActionListener(this);
        
        jbListarGaratia = new JButton("Listar garantia", iconGarantia) {
            @Override
            protected void paintComponent(Graphics g) {
                if (getModel().isArmed()) {
                    g.setColor(getBackground().darker());
                } else {
                    g.setColor(getBackground());
                }

                int width = getWidth();
                int height = getHeight();
                int arc = 30; // Ajuste o valor para controlar o raio dos cantos arredondados

                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                g2.fill(new RoundRectangle2D.Double(0, 0, width, height, arc, arc));
                g2.setColor(getForeground());
                super.paintComponent(g);
            }
        };
        jbListarGaratia.setBounds(50, 492, 300, 60);
        jbListarGaratia.setBorder(BorderFactory.createEmptyBorder());
        jbListarGaratia.setContentAreaFilled(false);
        jbListarGaratia.setBackground(Color.WHITE);
        jbListarGaratia.setForeground(Color.BLACK);
        jbListarGaratia.setFont(font);
        jbListarGaratia.setFocusable(false);
        jbListarGaratia.addActionListener(this);
        
        jbRelatorio = new JButton("Relatorio", iconRelatorio) {
            @Override
            protected void paintComponent(Graphics g) {
                if (getModel().isArmed()) {
                    g.setColor(getBackground().darker());
                } else {
                    g.setColor(getBackground());
                }

                int width = getWidth();
                int height = getHeight();
                int arc = 30; // Ajuste o valor para controlar o raio dos cantos arredondados

                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                g2.fill(new RoundRectangle2D.Double(0, 0, width, height, arc, arc));
                g2.setColor(getForeground());
                super.paintComponent(g);
            }
        };
        jbRelatorio.setBounds(50, 562, 300, 60);
        jbRelatorio.setBorder(BorderFactory.createEmptyBorder());
        jbRelatorio.setContentAreaFilled(false);
        jbRelatorio.setBackground(Color.WHITE);
        jbRelatorio.setForeground(Color.BLACK);
        jbRelatorio.setFont(font);
        jbRelatorio.setFocusable(false);
        jbRelatorio.addActionListener(this);
        
        jbEstatistica = new JButton("Estatistica", iconEstatica) {
            @Override
            protected void paintComponent(Graphics g) {
                if (getModel().isArmed()) {
                    g.setColor(getBackground().darker());
                } else {
                    g.setColor(getBackground());
                }

                int width = getWidth();
                int height = getHeight();
                int arc = 30; // Ajuste o valor para controlar o raio dos cantos arredondados

                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                g2.fill(new RoundRectangle2D.Double(0, 0, width, height, arc, arc));
                g2.setColor(getForeground());
                super.paintComponent(g);
            }
        };
        jbEstatistica.setBounds(50, 632, 300, 60);
        jbEstatistica.setBorder(BorderFactory.createEmptyBorder());
        jbEstatistica.setContentAreaFilled(false);
        jbEstatistica.setBackground(Color.WHITE);
        jbEstatistica.setForeground(Color.BLACK);
        jbEstatistica.setFont(font);
        jbEstatistica.setFocusable(false);
        jbEstatistica.addActionListener(this);
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==jbEmprestimo)
            new TelaCadastroCliente();
        if(e.getSource()==jbCriarFuncionario)
            new TelaCadastroFuncionario();
        if(e.getSource()==jbListarEmprestimo)
            new TelaEmprestimo();
        if(e.getSource()==jbListarFuncionario)
            new TelaFuncionarios();
        if(e.getSource()==jbListarGaratia)
            new TelaGarantia();
        if(e.getSource()==jbRelatorio)
            new TelaRelatorio();
        if(e.getSource()==jbEstatistica)
            new TelaEstatistica();
        if(e.getSource()==sairExit)
            System.exit(0);
        if(e.getSource()==sairTrocar)
            new TelaLogin();
        if(e.getSource()==consultaSaldo)
            JOptionPane.showMessageDialog(null, "A SB_Microcredito tem um total de "+ new FinancasDAO().consultarSaldo() +" Mt.");
        if(e.getSource()==consultaLucro)
            JOptionPane.showMessageDialog(null, "A SB_Microcredito tem um total de "+ new FinancasDAO().consultarLucro()+" Mt.");
        if(e.getSource()==opcoesRecarregar){
            String saldoDep = JOptionPane.showInputDialog(null, "Introduza o valor", "Confirmacao", JOptionPane.QUESTION_MESSAGE);
            FinancasDAO c = new FinancasDAO();
            try {
                if(c.sizee()==0){
                    c.fundoFinasceiro(new Financas(Double.parseDouble(saldoDep), 0));
                    }else{
                    c.arecadarFundos(Double.parseDouble(saldoDep));
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro!! "+ ex.getMessage()+"\nTente novamente");
            }
            
        }
        if(e.getSource()==activarRenovarContrato){
            String nomeFuncionario = JOptionPane.showInputDialog(null, "Introduza o nome do Funcionario.", "Mensagem", JOptionPane.QUESTION_MESSAGE);
            new FuncionarioDAO().activarFuncionario(nomeFuncionario);
        }
    }
    private final void menu(){
        barra = new JMenuBar();
        barra.add(Box.createHorizontalGlue());

        barra.setBackground(Color.WHITE);
        setJMenuBar(barra);
        
        opcoes = new JMenu("Opcoes");
        opcoes.setIcon(iconOpcoes);
        opcoes.setFont(font1);
        opcoesRecarregar = new JMenuItem("Recarregar", iconRecarregar);
        opcoesRecarregar.setFont(font1);
        opcoesRecarregar.addActionListener(this);
        opcoes.add(opcoesRecarregar);
        
        sair = new JMenu("Sair");
        sair.setIcon(iconSair);
        sair.setFont(font1);
        sairTrocar = new JMenuItem("Trocar usuario", iconTrocar);
        sairTrocar.setFont(font1);
        sairTrocar.addActionListener(this);
        sairExit = new JMenuItem("Exit f10", iconExit);
        sairExit.setFont(font1);
        sairExit.addActionListener(this);
        
        sair.add(sairTrocar);
        sair.add(sairExit);
        
        consulta = new JMenu("Consutas");
        consulta.setIcon(iconConsultar);
        consulta.setFont(font1);
        consultaSaldo = new JMenuItem("consultar saldo", iconCpnsultaSal);
        consultaSaldo.setFont(font1);
        consultaSaldo.addActionListener(this);
        consulta.add(consultaSaldo);
        consultaLucro = new JMenuItem("Consultar lucro", iconConsultarBonus);
        consultaLucro.setFont(font1);
        consultaLucro.addActionListener(this);
        consulta.add(consultaLucro);
        
        activarFuncionario = new JMenu("Activar Funcionario");
        activarFuncionario.setIcon(iconactivar);
        activarFuncionario.setFont(font1);
        activarRenovarContrato = new JMenuItem("Renovar", iconRecarregar);
        activarRenovarContrato.setFont(font1);
        activarRenovarContrato.addActionListener(this);
        activarFuncionario.add(activarRenovarContrato);
        
        
        
        barra.add(activarFuncionario);
        barra.add(consulta);
        barra.add(opcoes);
        barra.add(sair);
        this.FecharComF10();
    }
    private final void tempo(){
        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss    dd/MM/yyyy");
        Runnable task = () -> {
            String currentTime = dateFormat.format(new Date());
            lbDataHora.setText(currentTime);
        };

        executor.scheduleAtFixedRate(task, 0, 1, TimeUnit.SECONDS);
        
    }
    public void FecharComF10() {
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_F10) {
                    System.exit(0);
                }
            }
        });
    }
        
}

