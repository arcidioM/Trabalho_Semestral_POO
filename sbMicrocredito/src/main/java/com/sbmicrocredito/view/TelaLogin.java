package com.sbmicrocredito.view;

import com.sbmicrocredito.controler.FuncionarioDAO;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.RoundRectangle2D;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class TelaLogin extends JFrame implements ActionListener {
    /** Labels para exibição de imagens e textos */
    JLabel lbUsuario;
    JLabel lbImagem;
    JLabel lbNome;
    JLabel lbSenha;

    /** Campos de entrada de texto */
    JTextField txtNome;
    JPasswordField txtSenha;

    /** Botões de ação */
    JButton jbLogin = new JButton("Login");
    JButton jbCancel = new JButton("Cancel");
    JButton jbNovaConta;

    /** Toolkit para informações sobre a tela */
    Toolkit tk = Toolkit.getDefaultToolkit();
    Dimension d = tk.getScreenSize();

    /** Ícones para imagens */
    ImageIcon icon1 = new ImageIcon(getClass().getResource("Arcidio.png"));
    ImageIcon icon2 = new ImageIcon(getClass().getResource("logo.jpg"));

    /** Fontes para textos */
    Font font1 = new Font("Arial", Font.PLAIN, 15);
    Font font = new Font("Arial", Font.BOLD, 17);

    public TelaLogin() {
        // Inicializa a tela de login
        this.imagemFundo();
        this.label();
        this.butao();
        this.textField();
        this.configuracoesTela();
    }

    public void configuracoesTela() {
        setSize(720, 480);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setUndecorated(true);
        setLayout(null);
        setVisible(true);

        // Cria um painel para adicionar componentes
        JPanel java = new JPanel();
        java.setBounds((d.width - 720) / 2, (d.height - 480) / 2, 720, 480);
        java.setBackground(Color.WHITE);
        java.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.white));
        java.setBackground(new Color(23, 54, 93));
        java.setLayout(null);
        add(java);

        // Adiciona componentes ao painel
        java.add(lbUsuario);
        java.add(lbImagem);
        java.add(lbNome);
        java.add(lbSenha);
        java.add(txtNome);
        java.add(txtSenha);
        java.add(jbLogin);
        java.add(jbCancel);
        java.add(jbNovaConta);
    }

    public void label() {
        // Configura as labels
        lbUsuario = new JLabel(icon1);
        lbImagem = new JLabel(icon2);

        lbNome = new JLabel("Usuario");
        lbSenha = new JLabel("Senha");

        lbNome.setBounds(385, 180, 150, 25);
        lbNome.setForeground(Color.WHITE);
        lbSenha.setBounds(385, 240, 150, 25);
        lbSenha.setForeground(Color.WHITE);

        lbNome.setFont(font);
        lbSenha.setFont(font);

        lbUsuario.setBounds(470, 20, 150, 150);
        lbImagem.setBounds(2, 2, 360, 476);
        lbImagem.setForeground(Color.WHITE);
        lbImagem.setBackground(Color.cyan);
    }

    public void textField() {
        // Configura os campos de texto
        txtNome = new JTextField();
        txtSenha = new JPasswordField();

        txtNome.setBounds(385, 210, 310, 25);
        txtNome.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
        txtNome.setFont(font1);
        txtSenha.setFont(font1);

        txtSenha.setBounds(385, 270, 310, 25);
        txtSenha.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
        addNumericFilter(txtSenha);
        this.eventoEnter();
    }

    public void butao() {
        // Configura os botões

        // Botão de Login
        jbLogin = new JButton("Login") {
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
        jbLogin.setBounds(385, 320, 100, 25); /* Defina a posição e o tamanho do botão */
        jbLogin.setBorder(BorderFactory.createEmptyBorder());
        jbLogin.setContentAreaFilled(false);
        jbLogin.setBackground(Color.WHITE);
        jbLogin.setForeground(Color.BLACK);
        jbLogin.setFont(font);
        jbLogin.setFocusable(false);
        jbLogin.addActionListener(this);

        // Botão de Cancelar
        jbCancel = new JButton("Cancelar") {
            @Override
            protected void paintComponent(Graphics g) {
                if (getModel().isArmed()) {
                    g.setColor(getBackground().darker());
                } else {
                    g.setColor(getBackground());
                }

                int width = getWidth();
                int height = getHeight();
                int arc = 30; /* Ajuste o valor para controlar o raio dos cantos arredondados */

                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                g2.fill(new RoundRectangle2D.Double(0, 0, width, height, arc, arc));
                g2.setColor(getForeground());
                super.paintComponent(g);
            }
        };
        jbCancel.setBounds(595, 320, 100, 25); /* Defina a posição e o tamanho do botão */
        jbCancel.setBorder(BorderFactory.createEmptyBorder());
        jbCancel.setContentAreaFilled(false);
        jbCancel.setBackground(Color.WHITE);
        jbCancel.setForeground(Color.BLACK);
        jbCancel.setFont(font);
        jbCancel.setFocusable(false);
        jbCancel.addActionListener(this);

        // Botão "Criar Nova Conta"
        jbNovaConta = new JButton("Criar nova conta") {
            @Override
            protected void paintComponent(Graphics g) {
                if (getModel().isArmed()) {
                    g.setColor(getBackground().darker());
                } else {
                    g.setColor(getBackground());
                }

                int width = getWidth();
                int height = getHeight();
                int arc = 30; /* Ajuste o valor para controlar o raio dos cantos arredondados */

                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                g2.fill(new RoundRectangle2D.Double(0, 0, width, height, arc, arc));
                g2.setColor(getForeground());
                super.paintComponent(g);
            }
        };
        jbNovaConta.setBounds(470, 370, 135, 25); /* Defina a posição e o tamanho do botão */
        jbNovaConta.setBorder(BorderFactory.createEmptyBorder());
        jbNovaConta.setContentAreaFilled(false);
        jbNovaConta.setBackground(new Color(23, 54, 93));
        jbNovaConta.setForeground(Color.WHITE);
        jbNovaConta.setFont(font);
        jbNovaConta.setFocusable(false);
        jbNovaConta.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jbNovaConta) {
            JOptionPane.showMessageDialog(null, "Impossivel Criar uma nova Conta!!\n O acesso é feito Somente por\nUtilizadores Autorizados.", "Mensagem", JOptionPane.ERROR_MESSAGE);
            this.limparTxt();
        }
        if (e.getSource() == jbCancel) {
            System.exit(0);
        }
        if (e.getSource() == jbLogin) {
            try {
                if ((txtNome.getText().equals("Admin")) && (txtSenha.getText().equals("1234"))) {
                    new TelaMenu();
                } else {
                    if (new FuncionarioDAO().confirmacaoLogin(txtNome.getText(), Long.parseLong(txtSenha.getText()))) {
                        byte[] imagem = new FuncionarioDAO().retornarImagem(txtNome.getText(), txtSenha.getText());
                        new TelaMenuFuncionario(txtNome.getText(), imagem, new FuncionarioDAO().retornarCaixa(txtNome.getText(), txtSenha.getText()));
                    } else {
                        JOptionPane.showMessageDialog(null, "Credenciais invalidas.", "Mensagem", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Credenciais invalidas. "+ ex.getMessage(), "Mensagem", JOptionPane.ERROR_MESSAGE);
            }

            this.limparTxt();
        }
    }

    private final void imagemFundo() {
        JPanel painelFundo = new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon fundo = new ImageIcon(getClass().getResource("fundo3.jpg"));
                g.drawImage(fundo.getImage(), 0, 0, d.width, d.height, null);
            }
        };
        setContentPane(painelFundo);
    }

    private final void limparTxt() {
        txtNome.setText("");
        txtSenha.setText("");
    }

    private final void eventoEnter() {
        txtNome.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    txtSenha.requestFocus();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        txtSenha.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    // Quando Enter é pressionado, chame o actionPerformed do botão
                    jbLogin.doClick();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
    }
    public void addNumericFilter(JTextField textField) {
        textField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c)) {
                    e.consume(); // Remove caracteres não numéricos
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
    }
}
