package com.sbmicrocredito.view;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamResolution;
import com.sbmicrocredito.controler.FuncionarioDAO;
import com.sbmicrocredito.model.Funcionarios;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Calendar;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class TelaCadastroFuncionario extends JFrame implements ActionListener{
    
    JTextField txtNome;
    JTextField txtNumeroBI;
    JDateChooser txtDataNAscimento;
    JComboBox<String> comboAlocao;
    JTextField txtLocalResidencia;
    JTextField txtQuarteirao;
    JTextField txtNumeroCasa;
    JTextField txtContacto;
    JTextField txtContactoAlternativo;
    JTextField txtSalario;
    JTextField txtEmail;
    
    JComboBox<String> comboProvincia;
    JCheckBox checkAutorizacao;
    JCheckBox checkAutorizar;
    
    JLabel lbNome;
    JLabel lbNumeroBI;
    JLabel lbDataNAscimento;
    JLabel lbSexo;
    JLabel lbProfissao;
    JLabel lbLocalResidencia;
    JLabel lbQuarteirao;
    JLabel lbNumeroCasa;
    JLabel lbContacto;
    JLabel lbContactoAlternativo;
    JLabel lbSalario;
    JLabel lbEmail;
    JLabel lbUsuario;
    JLabel lbValor;
    JLabel lbCadastrarFuncionario;
    JLabel lbEditar;
    
    JRadioButton masculino = new JRadioButton("Masculino");
    JRadioButton femenino = new JRadioButton("Femenino");
    JRadioButton outro = new JRadioButton("Outros");
    JRadioButton particular = new JRadioButton("Particular");
    JRadioButton comercial = new JRadioButton("Comercial");
    
    ImageIcon iconVoltar = new ImageIcon(getClass().getResource("voltar.png"));
    ImageIcon iconConfirmar = new ImageIcon(getClass().getResource("certo.png"));
    ImageIcon iconUsuario = new ImageIcon(getClass().getResource("Funcionario.png"));
    ImageIcon iconCapturar = new ImageIcon(getClass().getResource("capturar.png"));
    ImageIcon iconPlay = new ImageIcon(getClass().getResource("play.png"));
    ImageIcon iconActualizar = new ImageIcon(getClass().getResource("actualizar.png"));
    
    Font font = new Font("Arial", Font.BOLD, 17);
    Font font1 = new Font("Arial", Font.PLAIN, 16);
    Font font2 = new Font("Arial", Font.BOLD, 30);
    
    JButton btVoltar;
    JButton btRegistar;
    JButton btLigar = new JButton(iconPlay);
    JButton btActualizar;
    JButton btCapturar = new JButton(iconCapturar);
    
    Toolkit tk = Toolkit.getDefaultToolkit();
    Dimension d = tk.getScreenSize();
    JPanel painel1 = new JPanel();
    
    byte [] imagemRed = null;
    
    FuncionarioDAO dAO = new FuncionarioDAO();
    private Webcam WEBCAM;
    private Dimension dimensao_default;
    
    double salario ;
    String sexo = "nulll";
    String nome;
    boolean editar = false;
    long senha;
    long iD;
    
    DefaultTableModel model;
    JTable table;
    JScrollPane roda;
    public TelaCadastroFuncionario(){
        this.play();
        this.imagemFundo();
        this.label();
        this.radioButton();
        this.textField();
        this.butao();
        this.tabelafuncionario();
        this.adicionarTabela();
        this.configuracaoPainel();
        this.configuracaoTela();
        
    }
    private final void configuracaoTela(){
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(true);
        setLayout(null);
        setVisible(true);
    }
    private final void configuracaoPainel(){
        JPanel painel = new JPanel();
        painel.setBounds((d.width-1080)/2, (d.height-720)/2, 1080, 720);
        painel.setBackground(Color.WHITE);
        painel.setBorder(BorderFactory.createMatteBorder(75, 2, 2, 2,new Color(0, 153, 153)));
        painel.setLayout(null);
        painel.setBackground(new Color(23, 54, 93));
        add(painel);
        painel.add(this.lbNome);
        painel.add(this.lbNumeroBI);
        painel.add(this.lbDataNAscimento);
        painel.add(this.lbProfissao);
        painel.add(this.lbLocalResidencia);
        painel.add(this.lbQuarteirao);
        painel.add(this.lbNumeroCasa);
        painel.add(this.lbContacto);
        painel.add(this.lbSexo);
        painel.add(this.lbContactoAlternativo);
        painel.add(this.lbSalario);
        painel.add(this.lbEmail);
        painel.add(lbUsuario);
        painel.add(this.lbValor);
        painel.add(this.lbEditar);
        painel.add(this.lbCadastrarFuncionario);
        
        painel.add(this.btVoltar);
        painel.add(this.btRegistar);
        painel.add(this.btLigar);
        painel.add(this.btCapturar);
        painel.add(this.btActualizar);
        
        painel.add(this.txtNome);
        painel.add(this.txtNumeroBI);
        painel.add(this.txtDataNAscimento);
        painel.add(this.comboAlocao);
        painel.add(this.comboProvincia);
        painel.add(this.txtLocalResidencia);
        painel.add(this.txtNumeroCasa);
        painel.add(this.txtQuarteirao);
        painel.add(this.txtContacto);
        painel.add(this.txtContactoAlternativo);
        painel.add(this.txtSalario);
        painel.add(this.checkAutorizacao);
        painel.add(this.checkAutorizar);
        painel.add(this.txtEmail);
        painel.add(this.masculino);
        painel.add(this.femenino);
        painel.add(this.outro);
        painel.add(roda);
        
    }
    private final void tabelafuncionario(){
        Object[][] dados ={};
        Object [] colunas = {"ID","Nome", "Provincia", "Alocacao", "Salario", "Senha", "Email"};
        model = new DefaultTableModel(dados, colunas);
        table = new JTable(model);
        table.setFont(font1);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

        table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        table.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        table.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        table.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
        table.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
        table.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
        table.getColumnModel().getColumn(6).setCellRenderer(centerRenderer);

        roda = new JScrollPane(table);
        roda.setBounds(10, 490, 1060, 190);
    }
    public final void adicionarTabela(){
        ArrayList<Funcionarios> fun = new ArrayList();
        try {
            FileInputStream fileInput = new FileInputStream("Funcionario.txt");
            ObjectInputStream objInput = new ObjectInputStream(fileInput);
            
            Funcionarios vic = null;
            while ((vic = (Funcionarios)objInput.readObject())!= null){
               fun.add(vic);
            }
            objInput.close();
            fileInput.close();
        } catch (Exception e) {}
        this.ListarTabela();
    }
    private final void textField(){
        txtNome = new JTextField();
        txtNome.setBounds(200, 100, 490, 25);
        txtNome.setFont(font1);
        txtNome.setToolTipText("introduza o nome completo");
        
        txtNumeroBI = new JTextField();
        txtNumeroBI.setBounds(200, 135, 490, 25);
        txtNumeroBI.setFont(font1);
        txtNumeroBI.setToolTipText("introduza o numero do blilhete de Identidade");
        
        txtDataNAscimento = new JDateChooser();
        txtDataNAscimento.setBounds(200, 170, 490, 25);
        txtDataNAscimento.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
        txtDataNAscimento.setFont(font1);
        txtDataNAscimento.setForeground(Color.WHITE);
        
        Calendar dataMin = Calendar.getInstance();
        dataMin.set(Calendar.YEAR, 1900);
        dataMin.set(Calendar.MONTH, Calendar.JANUARY);
        dataMin.set(Calendar.DAY_OF_MONTH, 01);
        txtDataNAscimento.setMinSelectableDate(dataMin.getTime());
        
        Calendar dataMax = Calendar.getInstance();
        dataMax.set(Calendar.YEAR, 2005);
        dataMax.set(Calendar.MONTH, Calendar.JUNE);
        dataMax.set(Calendar.DAY_OF_MONTH, 01);
        txtDataNAscimento.setMaxSelectableDate(dataMax.getTime());
        
        comboAlocao = new JComboBox();
        comboAlocao.setBounds(200, 240, 490, 25);
        comboAlocao.setBackground(Color.WHITE);
        comboAlocao.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
        comboAlocao.setFont(font1);
        comboAlocao.setToolTipText("Introduza a profissao do cliente");
        comboAlocao.addItem("");
        comboAlocao.addItem("caixa 01");
        comboAlocao.addItem("caixa 02");
        comboAlocao.addItem("caixa 03");
        comboAlocao.addItem("caixa 04");
        
        txtLocalResidencia = new JTextField();
        txtLocalResidencia.setBounds(200, 275, 490, 25);
        txtLocalResidencia.setFont(font1);
        txtLocalResidencia.setToolTipText("Introduza o local da residencia");
        
        txtQuarteirao = new JTextField();
        txtQuarteirao.setBounds(200, 310, 80, 25);
        txtQuarteirao.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.darkGray));
        txtQuarteirao.setFont(font1);
        txtQuarteirao.setToolTipText("Introduza o quarteirao da casa");
        
        
        txtNumeroCasa = new JTextField();
        txtNumeroCasa.setBounds(605, 310, 80, 25);
        txtNumeroCasa.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
        txtNumeroCasa.setFont(font1);
        txtNumeroCasa.setToolTipText("Introduza o numero da casa");
        
        
        txtContacto = new JTextField();
        addCharacterLimit(txtContacto, 9);
        txtContacto.setBounds(200, 350, 490, 25);
        txtContacto.setFont(font1);
        txtContacto.setToolTipText("Introduza o contacto do cliente");
        
        txtContactoAlternativo = new JTextField();
        addCharacterLimit(txtContactoAlternativo, 9);
        txtContactoAlternativo.setBounds(200, 385, 490, 25);
        txtContactoAlternativo.setFont(font1);
        txtContactoAlternativo.setToolTipText("Introduza o contacto Alternativo do cliente");
        
        txtSalario = new JTextField();
        txtSalario.setBounds(200, 420, 80, 25);
        txtSalario.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
        txtSalario.setFont(font1);
        txtSalario.setToolTipText("Introduza o salario do funcionario");
        
        checkAutorizacao = new JCheckBox("Assinar contrato");
        checkAutorizacao.setBounds(320, 420, 150, 25);
        checkAutorizacao.setBackground(new Color(23, 54, 93));
        checkAutorizacao.setForeground(Color.WHITE);
        checkAutorizacao.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.BLACK));
        checkAutorizacao.setFocusable(false);
        checkAutorizacao.setFont(font);
        
        checkAutorizar = new JCheckBox("Autorizar contrato");
        checkAutorizar.setBounds(500, 420, 180, 25);
        checkAutorizar.setBackground(new Color(23, 54, 93));
        checkAutorizar.setForeground(Color.WHITE);
        checkAutorizar.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.BLACK));
        checkAutorizar.setFocusable(false);
        checkAutorizar.setFont(font);
        
        txtEmail = new JTextField("arcidio64@gmail.com");
        txtEmail.setBounds(200, 455, 490, 25);
        txtEmail.setFont(font1);
        txtEmail.setToolTipText("Introduza um email valido");
        
        comboProvincia = new JComboBox();
        comboProvincia.setBounds(805, 350, 150, 25);
        comboProvincia.setBackground(Color.WHITE);
        comboProvincia.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
        comboProvincia.setFont(font1);
        comboProvincia.setToolTipText("Introduza a provincia");
        comboProvincia.addItem("Maputo Cidade");
        comboProvincia.addItem("Maputo Provincia");
        comboProvincia.addItem("Gaza");
        comboProvincia.addItem("Inhabane");
        comboProvincia.addItem("Sofala");
        comboProvincia.addItem("Manica");
        comboProvincia.addItem("Tete");
        comboProvincia.addItem("Zambezia");
        comboProvincia.addItem("Nampula");
        comboProvincia.addItem("Cabo Delgado");
        comboProvincia.addItem("Niassa");
        
        comboAlocao.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
        txtNome.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
        txtContacto.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
        txtContactoAlternativo.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
        txtEmail.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
        txtSalario.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
        txtQuarteirao.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
        txtNumeroCasa.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
        txtLocalResidencia.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
        txtNumeroBI.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
        
        txtEmail.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if(txtEmail.getText().equals("arcidio64@gmail.com")){
                    txtEmail.setText("");
                }
                
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(txtEmail.getText().isEmpty()){
                    txtEmail.setText("arcidio64@gmail.com");
                }
            }
        });
        this.eventosCor();
        this.eventoEnter();
    }
    private final void label(){
        lbUsuario = new JLabel(iconUsuario);
        lbUsuario.setBounds(790, 100, 180, 200);
        lbUsuario.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
        lbUsuario.setForeground(Color.BLACK);
        
        lbNome = new JLabel("Nome");
        lbNome.setBounds(10, 100, 160, 25);
        lbNome.setFont(font);
        lbNome.setForeground(Color.WHITE);
        
        lbNumeroBI = new JLabel("Numero do BI");
        lbNumeroBI.setBounds(10, 135, 160, 25);
        lbNumeroBI.setFont(font);
        lbNumeroBI.setForeground(Color.WHITE);
        
        lbDataNAscimento = new JLabel("Data do Nascimento");
        lbDataNAscimento.setBounds(10, 170, 170, 25);
        lbDataNAscimento.setFont(font);
        lbDataNAscimento.setForeground(Color.WHITE);
        
        lbSexo = new JLabel("Sexo");
        lbSexo.setBounds(10, 205, 160, 25);
        lbSexo.setFont(font);
        lbSexo.setForeground(Color.WHITE);
        
        lbProfissao = new JLabel("Alocacao");
        lbProfissao.setBounds(10, 240, 160, 25);
        lbProfissao.setFont(font);
        lbProfissao.setForeground(Color.WHITE);
        
        lbLocalResidencia = new JLabel("Local da Residencia");
        lbLocalResidencia.setBounds(10, 275, 170, 25);
        lbLocalResidencia.setFont(font);
        lbLocalResidencia.setForeground(Color.WHITE);
        
        lbQuarteirao = new JLabel("Numero do Quarterao");
        lbQuarteirao.setBounds(10, 310, 190, 25);
        lbQuarteirao.setFont(font);
        lbQuarteirao.setForeground(Color.WHITE);
        
        lbNumeroCasa = new JLabel("Numero da Casa");
        lbNumeroCasa.setBounds(455, 310, 160, 25);
        lbNumeroCasa.setFont(font);
        lbNumeroCasa.setForeground(Color.WHITE);
        
        lbContacto = new JLabel("Contacto");
        lbContacto.setBounds(10, 350, 160, 25);
        lbContacto.setFont(font);
        lbContacto.setForeground(Color.WHITE);
        
        lbContactoAlternativo = new JLabel("Contacto Alternativo");
        lbContactoAlternativo.setBounds(10, 385, 180, 25);
        lbContactoAlternativo.setFont(font);
        lbContactoAlternativo.setForeground(Color.WHITE);
        
        lbEmail = new JLabel("E-mail");
        lbEmail.setBounds(10, 455, 100, 25);
        lbEmail.setFont(font);
        lbEmail.setForeground(Color.WHITE);
        
        lbSalario = new JLabel("Salario");
        lbSalario.setBounds(10, 420, 100, 25);
        lbSalario.setFont(font);
        lbSalario.setForeground(Color.WHITE);
        
        lbValor = new JLabel("Mt");
        lbValor.setBounds(280, 420, 100, 25);
        lbValor.setForeground(Color.BLACK);
        lbValor.setFont(font);
        lbValor.setForeground(Color.WHITE);
        
        lbCadastrarFuncionario = new JLabel("Registar funcionario");
        lbCadastrarFuncionario.setBounds(390, 20, 300, 35);
        lbCadastrarFuncionario.setForeground(Color.WHITE);
        lbCadastrarFuncionario.setFont(font2);
        
        lbEditar = new JLabel("Editar campos");
        lbEditar.setBounds(10, 685, 150, 35);
        lbEditar.setForeground(Color.WHITE);
        lbEditar.setFont(font);
        this.mouseListener();
        
    }
    private final void butao(){
        btVoltar = new JButton("Voltar", iconVoltar);
        btVoltar.setBounds(940, 685, 130, 26);
        btVoltar.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
        btVoltar.setFont(font);
        btVoltar.setBackground(Color.WHITE);
        btVoltar.setFocusable(false);
        btVoltar.addActionListener(this);
        
        btRegistar = new JButton("Confirmar", iconConfirmar);
        btRegistar.setBounds(630, 685, 160, 26);
        btRegistar.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
        btRegistar.setFont(font);
        btRegistar.setBackground(Color.WHITE);
        btRegistar.setFocusable(false);
        btRegistar.addActionListener(this);
        
        btActualizar = new JButton("Actualizar", iconActualizar);
        btActualizar.setBounds(800, 685, 130, 26);
        btActualizar.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
        btActualizar.setFont(font);
        btActualizar.setBackground(Color.WHITE);
        btActualizar.setFocusable(false);
        btActualizar.addActionListener(this);
        
        btLigar.setBounds(840, 303, 38, 38);
        btLigar.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.BLACK));
        btLigar.setFont(font);
        btLigar.setBackground(new Color(23, 54, 93));
        btLigar.setFocusable(false);
        btLigar.addActionListener(this);
        
        btCapturar.setBounds(885, 301, 40, 40);
        btCapturar.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.BLACK));
        btCapturar.setFont(font);
        btCapturar.setBackground(new Color(23, 54, 93));
        btCapturar.setFocusable(false);
        btCapturar.addActionListener(this);
    }
    private final void radioButton(){
        ButtonGroup grupo = new ButtonGroup();
        grupo.add(outro);
        grupo.add(masculino);
        grupo.add(femenino);
        
        masculino.setBounds(200, 205, 110, 25);
        masculino.setBackground(Color.WHITE);
        masculino.setFont(font1);
        masculino.setFocusable(false);
        
        femenino.setBounds(390, 205, 110, 25);
        femenino.setBackground(Color.WHITE);
        femenino.setFont(font1);
        femenino.setFocusable(false);
        
        outro.setBounds(580, 205, 110, 25);
        outro.setFont(font1);
        outro.setBackground(Color.WHITE);
        outro.setFocusable(false);
        
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
    private final void linpar(){
        txtNome.setText("");
        txtNumeroBI.setText("");
        ((JTextField)txtDataNAscimento.getDateEditor()).setText("");
        txtLocalResidencia.setText("");
        txtQuarteirao.setText("");
        txtNumeroCasa.setText("");
        txtContacto.setText("");
        txtContactoAlternativo.setText("");
        txtEmail.setText("");
        txtSalario.setText("");
        comboAlocao.setSelectedIndex(0);
        checkAutorizacao.setSelected(false);
        checkAutorizar.setSelected(false);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btVoltar)
            dispose();
        if(e.getSource()==btRegistar){
            if((txtNumeroBI.getText().length() ==13)&&(txtContacto.getText().length()==9)&&(txtContactoAlternativo.getText().length()==9)
                &&(txtNumeroCasa.getText().length()>0)&&(txtSalario.getText().length()>2)&&(txtQuarteirao.getText().length()>0)
                &&(txtLocalResidencia.getText().length()>4)&&(txtNome.getText().length()>4)&&(sexo!= null)&&(imagemRed!= null)
                &&(comboAlocao.getSelectedItem()!="")){
                if(new Funcionarios().isValidEmail(txtEmail.getText())){
                    if((checkAutorizacao.isSelected())&&(checkAutorizar.isSelected())){
                        this.cadastroFuncionario();
                    }else{
                        JOptionPane.showMessageDialog(null, "Impossivel registar o funcionario!!\nEste registo nao santisfaz todos os requisitos.","Mensagem", JOptionPane.ERROR_MESSAGE);
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "O e-mail é válido.", "Mensagem", JOptionPane.ERROR_MESSAGE);
                }
            }else{
                JOptionPane.showMessageDialog(null, "Erro!!! Verifica se todos os campos estao devidamente preenchidos.", "Messagem", JOptionPane.ERROR_MESSAGE);
            }
        }
        if(e.getSource()==btLigar){
            new Thread(){
                public void run(){
                    WEBCAM.open();
                    playVideo();
                }
            }.start();
        }
        if(e.getSource()==btCapturar){
            this.imagemredimensionada();
        }
        if(e.getSource()==btActualizar){
            if(editar){
                if((txtNumeroBI.getText().length() == 13)&&(txtContacto.getText().length()==9)&&(txtContactoAlternativo.getText().length()==9)
                        &&(txtNumeroCasa.getText().length()>0)&&(txtSalario.getText().length()>2)&&(txtQuarteirao.getText().length()>0)
                        &&(txtLocalResidencia.getText().length()>4)){
                    this.actualizarTabela();
                    this.ListarTabela();

                    txtNome.enable(true);
                    txtDataNAscimento.setEnabled(true);
                    comboAlocao.enable(true);
                    particular.setEnabled(true);
                    comercial.setEnabled(true);
                    checkAutorizacao.setEnabled(true);
                    checkAutorizar.setEnabled(true);
                    masculino.setEnabled(true);
                    femenino.setEnabled(true);
                    outro.setEnabled(true);
                    
                    comboAlocao.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
                    txtNome.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
                    txtContacto.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
                    txtContactoAlternativo.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
                    txtEmail.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
                    txtSalario.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
                    txtQuarteirao.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
                    txtNumeroCasa.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
                    txtLocalResidencia.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
                    txtNumeroBI.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));

                }else{
                    JOptionPane.showMessageDialog(null, "Erro!! Preencha todos os campos devidamente", "Mensagem", JOptionPane.ERROR_MESSAGE);
            
                }
            }else{
                JOptionPane.showMessageDialog(null, "Erro!! Para actualizar clique no [Editar campos] e\nSegue as instrucoes."
                    , "Mensagem", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    private void imagemredimensionada(){
        try {
            ByteArrayOutputStream buff = new ByteArrayOutputStream();
            ImageIO.write(WEBCAM.getImage(), "JPG", buff);
            byte[] bytes = buff.toByteArray();

            ByteArrayInputStream is = new ByteArrayInputStream(bytes);
            BufferedImage imagem = ImageIO.read(is);

            BufferedImage novaImagem = new BufferedImage(180, 200, BufferedImage.TYPE_INT_RGB);
            Graphics2D g = novaImagem.createGraphics();
            g.drawImage(imagem, 0, 0, 180, 200, null);

            ByteArrayOutputStream buff2 = new ByteArrayOutputStream();
            ImageIO.write(novaImagem, "JPG", buff2);
            imagemRed = buff2.toByteArray();
            new Thread(){
            public void run(){
                WEBCAM.close();
            }
        }.start();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    public final void cadastroFuncionario(){
        try {
            nome = txtNome.getText();
            String bI = txtNumeroBI.getText();
            String nascimento = ((JTextField)txtDataNAscimento.getDateEditor().getUiComponent()).getText();
            String localResidencia = txtLocalResidencia.getText();
            String quarteirao = txtQuarteirao.getText();
            String numeroCasa = txtNumeroCasa.getText();
            long contacto = Long.parseLong(txtContacto.getText()) ;
            long contactoAlt = Long.parseLong(txtContactoAlternativo.getText());
            salario = Double.parseDouble( txtSalario.getText());
            String email = txtEmail.getText();
            senha = dAO.numeroSenha();
            iD = dAO.numeroID();

            this.radioButton();

            if(masculino.isSelected()==true)
                sexo = "Masculino";
            if(femenino.isSelected()==true)
                sexo = "Femenino";
            if(outro.isSelected()==true)
                sexo = "Outros";
            Funcionarios func = new Funcionarios(salario, email, senha, iD, nome, nascimento, sexo, bI, localResidencia, 
                    numeroCasa, quarteirao, contacto, contactoAlt, (String)comboAlocao.getSelectedItem(), true, imagemRed, (String) comboProvincia.getSelectedItem());
            dAO.cadastroFuncionario(func);
            this.linpar();
            model.setRowCount(0);
            this.adicionarTabela();
            lbUsuario.setIcon(iconUsuario);
            imagemRed = null;
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Impossivel fazer o cadastro!!\nCertique se todos os campos estao devidamente preenchidos.","Mensagem", JOptionPane.ERROR_MESSAGE);
        }
    }
    private void playVideo(){
        new Thread(){
            public void run(){
                try {
                    while (true){
                    Image imagem = WEBCAM.getImage();
                    ImageIcon icon = new ImageIcon(imagem);
                    icon.setImage(icon.getImage().getScaledInstance(lbUsuario.getWidth(), lbUsuario.getHeight(), 100));
                    lbUsuario.setIcon(icon);
                    Thread.sleep(50);
                }
                    
                } catch (Exception e) {}
            }
            
        }.start();
    }
    private void play(){
        try {
            dimensao_default =  WebcamResolution.VGA.getSize();
            WEBCAM = Webcam.getDefault();
            WEBCAM.setViewSize(dimensao_default);
            
        } catch (Exception e) {
        }
    }
    private final void eventosCor(){
        txtNumeroBI.getDocument().addDocumentListener(new DocumentListener() {

            public void insertUpdate(DocumentEvent e) {
                updateColor();
            }
            public void removeUpdate(DocumentEvent e) {
                updateColor();
            }
            public void changedUpdate(DocumentEvent e) {
                updateColor();
            }
            private void updateColor() {
                int length = txtNumeroBI.getText().length();
                if (length < 13 || length > 13) {
                    txtNumeroBI.setForeground(Color.RED);
                } else {
                    txtNumeroBI.setForeground(Color.BLACK);
                }
            }
        });
        
        txtContactoAlternativo.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) {
                updateColor();
            }
            public void removeUpdate(DocumentEvent e) {
                updateColor();
            }
            public void changedUpdate(DocumentEvent e) {
                updateColor();
            }
            private void updateColor() {
                int length = txtContactoAlternativo.getText().length();
                if (length < 9 || length > 9) {
                    txtContactoAlternativo.setForeground(Color.RED);
                } else {
                    txtContactoAlternativo.setForeground(Color.BLACK);
                }
            }
        });
        
        txtContacto.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) {
                updateColor();
            }
            public void removeUpdate(DocumentEvent e) {
                updateColor();
            }
            public void changedUpdate(DocumentEvent e) {
                updateColor();
            }
            private void updateColor() {
                int length = txtContacto.getText().length();
                if (length < 9 || length > 9) {
                    txtContacto.setForeground(Color.RED);
                } else {
                    txtContacto.setForeground(Color.BLACK);
                }
            }
        });
    }
    private final void ListarTabela(){
        ArrayList<Funcionarios> fun = new ArrayList();
        try {
            FileInputStream fileInput = new FileInputStream("Funcionario.txt");
            ObjectInputStream objInput = new ObjectInputStream(fileInput);
            
            Funcionarios vic = null;
            while ((vic = (Funcionarios)objInput.readObject())!= null){
               fun.add(vic);
            }
            objInput.close();
            fileInput.close();
        } catch (Exception e) {}
        
        model.setRowCount(0);
        for (int f = 0; f< fun.size(); f++){
            if(fun.get(f).getStatus()==true){
                Object[] dados= {fun.get(f).getID(),
                    fun.get(f).getNome(),
                    fun.get(f).getProvincia(),
                    fun.get(f).getAlocacao(),
                    fun.get(f).getSalario(),
                    fun.get(f).getSenha(),
                    fun.get(f).getEmail()};
                model.addRow(dados);
            }
        }
    }
    private final void mouseListener(){
        lbEditar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                txtNome.enable(false);
                txtDataNAscimento.setEnabled(false);
                comboAlocao.enable(false);
                particular.setEnabled(false);
                comercial.setEnabled(false);
                masculino.setEnabled(false);
                femenino.setEnabled(false);
                outro.setEnabled(false);
                
                checkAutorizacao.setEnabled(false);
                checkAutorizar.setEnabled(false);
                
                
                txtContacto.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
                txtContactoAlternativo.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
                txtEmail.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
                txtSalario.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
                txtQuarteirao.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
                txtNumeroCasa.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
                txtLocalResidencia.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
                txtNumeroBI.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
                editar = true;
            }
        });
        
    }
    private final void actualizarTabela(){
        try {
            DefaultTableModel modeloTabela = (DefaultTableModel) table.getModel();
            int LinhaSelecionada = table.getSelectedRow();
            
            new FuncionarioDAO().actualizar((long) table.getModel().getValueAt(LinhaSelecionada, 0), txtNumeroBI.getText(), txtLocalResidencia.getText(), txtQuarteirao.getText(), txtNumeroCasa.getText(), nome,
                Long.parseLong(txtContacto.getText()), Long.parseLong(txtContactoAlternativo.getText()), Double.parseDouble(txtSalario.getText()), txtEmail.getText());
            this.ListarTabela();
            editar = false;
            
            JOptionPane.showMessageDialog(null, "Actualizacao feita com sucesso.");
        
            this.linpar();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro!!! Seleciona na tabela a linha que deseja Actualizar. "+e.getMessage(), "Mensagem", JOptionPane.ERROR_MESSAGE);
        }
    }
    private final void eventoEnter(){
        txtNome.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    txtNumeroBI.requestFocus();
                }
            }
            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        
        txtNumeroBI.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    txtDataNAscimento.requestFocus();
                }
            }
            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        
        
        txtDataNAscimento.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    comboAlocao.requestFocus();
                }
            }
            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        
        
        comboAlocao.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    txtLocalResidencia.requestFocus();
                }
            }
            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        txtNumeroBI.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    txtDataNAscimento.requestFocus();
                }
            }
            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        
        txtLocalResidencia.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    txtQuarteirao.requestFocus();
                }
            }
            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        
        txtQuarteirao.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    txtNumeroCasa.requestFocus();
                }
            }
            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        txtNumeroCasa.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    txtContacto.requestFocus();
                }
            }
            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        
        txtContacto.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    txtContactoAlternativo.requestFocus();
                }
            }
            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        
        txtContactoAlternativo.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    txtSalario.requestFocus();
                }
            }
            
          public void txtNomeKeyTyped(KeyEvent e){
          char validar = e.getKeyChar();
          if (Character.isLetter(validar)){
              getToolkit().beep();
              e.consume();
              JOptionPane.showMessageDialog(null, "So valida Letras");
          }
      }
            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        
        txtSalario.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    txtEmail.requestFocus();
                }
            }
            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        txtEmail.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    comboProvincia.requestFocus();
                }
            }
            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        
    }
    public static void addCharacterLimit(JTextField textField, int maxLength) {
        textField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (textField.getText().length() >= maxLength) {
                    e.consume(); // Remove caracteres adicionais se exceder o limite
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
