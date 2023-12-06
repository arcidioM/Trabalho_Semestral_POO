package com.sbmicrocredito.view;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamResolution;
import com.sbmicrocredito.controler.ClienteDAO;
import com.sbmicrocredito.controler.FinancasDAO;
import com.sbmicrocredito.controler.FuncionarioDAO;
import com.sbmicrocredito.controler.GarantiaDAO;
import com.sbmicrocredito.model.Cliente;
import com.sbmicrocredito.model.Garantia;
import com.toedter.calendar.JDateChooser;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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

public class TelaCadastroCliente extends JFrame implements ActionListener{
    ImageIcon iconVoltar = new ImageIcon(getClass().getResource("voltar.png"));
    ImageIcon iconConfirmar = new ImageIcon(getClass().getResource("certo.png"));
    ImageIcon iconUsuario = new ImageIcon(getClass().getResource("TelaCliente.png"));
    ImageIcon iconCapturar = new ImageIcon(getClass().getResource("capturar.png"));
    ImageIcon iconPlay = new ImageIcon(getClass().getResource("play.png"));
    ImageIcon iconAdicionar = new ImageIcon(getClass().getResource("adicionar.png"));
    ImageIcon iconActualizar = new ImageIcon(getClass().getResource("actualizar.png"));
    
    JTextField txtNome;
    JTextField txtNumeroBI;
    JDateChooser txtDataNAscimento;
    JTextField txtProfissao;
    JTextField txtLocalResidencia;
    JTextField txtQuarteirao;
    JTextField txtNumeroCasa;
    JTextField txtContacto;
    JTextField txtContactoAlternativo;
    JTextField txtQuantia;
    JTextField txtGarantia;
    
    JComboBox<String> comboProvincia;
    JCheckBox checkFotocopiaBI;
    JCheckBox checkAcordo;
    
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
    JLabel lbTipoEmprstimo;
    JLabel lbQuantia;
    JLabel lbGarantia;
    JLabel lbUsuario;
    JLabel lbValor;
    JLabel lbRegistarCliente;
    JLabel lbValorAjustado;
    JLabel lbValorTotal;
    JLabel lbEditar;
    
    JRadioButton masculino = new JRadioButton("Masculino");
    JRadioButton femenino = new JRadioButton("Femenino");
    JRadioButton outro = new JRadioButton("Outros");
    JRadioButton particular = new JRadioButton("Particular");
    JRadioButton comercial = new JRadioButton("Comercial");
    
    Font font = new Font("Arial", Font.BOLD, 17);
    Font font1 = new Font("Arial", Font.PLAIN, 16);
    Font font2 = new Font("Arial", Font.BOLD, 30);
    Font font3 = new Font("Arial", Font.BOLD, 17);
    Font font4 = new Font("Arial", Font.PLAIN, 14);
    
    JButton btVoltar;
    JButton btRegistar;
    JButton btActualizar;
    JButton btCapturar = new JButton(iconCapturar);
    JButton btLigar = new JButton(iconPlay);
    JButton btAdicionar = new JButton(iconAdicionar);
    
    Toolkit tk = Toolkit.getDefaultToolkit();
    Dimension d = tk.getScreenSize();
    
    JPanel painel1 = new JPanel();
    
    Cliente cli = new Cliente();
    private Webcam WEBCAM;
    
    double contValor = 0;
    byte[] imagemRedim = null;
    private Dimension dimensao_default;
    
    String sexo = null, tipoEm = null;
    boolean editar = false;
    
    DefaultTableModel model;
    JTable table;
    JScrollPane roda;
    
    DefaultTableModel modelCliente;
    JTable tableCliente;
    JScrollPane rodaCliente;
    
    ArrayList<Double> valorArraylist = new ArrayList();
    ArrayList<String> garantiaArrayList = new ArrayList();
    
    public TelaCadastroCliente(){
        this.play();
        this.imagemFundo();
        this.tabelaGarantia();
        this.tabelaCliente();
        this.ListarTabela();
        this.label();
        this.radioButton();
        this.textField();
        this.butao();
        this.configuracaoPainel();
        this.configuracaoTela();
        
    }
    private void configuracaoTela(){
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setUndecorated(true);
        setLayout(null);
        setVisible(true);
        btRegistar.addActionListener(this);
        btVoltar.addActionListener(this);
    }
    private void configuracaoPainel(){
        JPanel painel = new JPanel();
        painel.setBounds((d.width-1080)/2, (d.height-720)/2, 1080, 720);
        painel.setBackground(Color.WHITE);
        painel.setBorder(BorderFactory.createMatteBorder(75, 2, 2, 2, new Color(0, 153, 153)));
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
        painel.add(this.lbTipoEmprstimo);
        painel.add(this.lbQuantia);
        painel.add(this.lbGarantia);
        painel.add(this.checkFotocopiaBI);
        painel.add(this.checkAcordo);
        painel.add(this.lbEditar);
        
        painel.add(this.btVoltar);
        painel.add(this.btRegistar);
        painel.add(this.btActualizar);
        painel.add(this.btLigar);
        painel.add(this.btCapturar);
        painel.add(this.btAdicionar);
        painel.add(lbUsuario);
        painel.add(this.lbValor);
        painel.add(this.lbValorAjustado);
        painel.add(this.lbValorTotal);
        painel.add(this.lbRegistarCliente);
        
        painel.add(this.txtNome);
        painel.add(this.txtNumeroBI);
        painel.add(this.txtDataNAscimento);
        painel.add(this.txtProfissao);
        painel.add(this.txtLocalResidencia);
        painel.add(this.txtNumeroCasa);
        painel.add(this.comboProvincia);
        painel.add(this.txtQuarteirao);
        painel.add(this.txtContacto);
        painel.add(this.txtContactoAlternativo);
        painel.add(this.txtQuantia);
        painel.add(this.txtGarantia);
        painel.add(this.masculino);
        painel.add(this.femenino);
        painel.add(this.outro);
        painel.add(this.particular);
        painel.add(this.comercial);
        painel.add(this.roda);
        painel.add(this.rodaCliente);
        
    }
    private final void tabelaCliente(){
        Object[][] dados ={};
        Object [] colunas = {"ID","Nome","valor a pagar", "Validade"};
        modelCliente = new DefaultTableModel(dados, colunas);
        tableCliente = new JTable(modelCliente);
        tableCliente.setFont(font4);
        rodaCliente = new JScrollPane(tableCliente);
        rodaCliente.setBounds(10, 525, 680,150 );
        
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        
        tableCliente.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        tableCliente.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        tableCliente.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        tableCliente.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
        
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
        txtDataNAscimento.setFont(font1);
        txtDataNAscimento.setForeground(Color.WHITE);
        
        Calendar dataMin = Calendar.getInstance();
        dataMin.set(Calendar.YEAR, 1900);
        dataMin.set(Calendar.MONTH, Calendar.JANUARY);
        dataMin.set(Calendar.DAY_OF_MONTH, 01);
        txtDataNAscimento.setMinSelectableDate(dataMin.getTime());
        
        Calendar dataMax = Calendar.getInstance();
        dataMax.set(Calendar.YEAR, 2006);
        dataMax.set(Calendar.MONTH, Calendar.JUNE);
        dataMax.set(Calendar.DAY_OF_MONTH, 01);
        txtDataNAscimento.setMaxSelectableDate(dataMax.getTime());
        
        txtProfissao = new JTextField();
        txtProfissao.setBounds(200, 240, 490, 25);
        txtProfissao.setFont(font1);
        txtProfissao.setToolTipText("Introduza a profissao do cliente");
        
        txtLocalResidencia = new JTextField();
        txtLocalResidencia.setBounds(200, 275, 490, 25);
        txtLocalResidencia.setFont(font1);
        txtLocalResidencia.setToolTipText("Introduza o local da residencia");
        
        txtQuarteirao = new JTextField();
        txtQuarteirao.setBounds(200, 310, 80, 25);
        txtQuarteirao.setFont(font1);
        txtQuarteirao.setToolTipText("Introduza o quarteirao da casa");
        
        
        txtNumeroCasa = new JTextField();
        txtNumeroCasa.setBounds(605, 310, 80, 25);
        txtNumeroCasa.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
        txtNumeroCasa.setFont(font1);
        txtNumeroCasa.setToolTipText("Introduza o numero da casa");
        
        comboProvincia = new JComboBox();
        comboProvincia.setBounds(700, 310, 190, 25);
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
        
        txtQuantia = new JTextField();
        txtQuantia.setBounds(200, 490, 80, 25);
        txtQuantia.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
        txtQuantia.setFont(font1);
        txtQuantia.setToolTipText("Introduza o valor do emprestimo a efectuar");
        
        checkFotocopiaBI = new JCheckBox("FotoCopia do BI");
        checkFotocopiaBI.setBounds(340, 490, 150, 25);
        checkFotocopiaBI.setBackground(new Color(23, 54, 93));
        checkFotocopiaBI.setForeground(Color.WHITE);
        checkFotocopiaBI.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.BLACK));
        checkFotocopiaBI.setFocusable(false);
        checkFotocopiaBI.setFont(font);
        
        checkAcordo = new JCheckBox("Autorizar");
        checkAcordo.setBounds(530, 490, 150, 25);
        checkAcordo.setBackground(new Color(23, 54, 93));
        checkAcordo.setForeground(Color.WHITE);
        checkAcordo.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.BLACK));
        checkAcordo.setFocusable(false);
        checkAcordo.setFont(font);
        
        txtGarantia = new JTextField();
        txtGarantia.setBounds(200, 455, 460, 25);
        txtGarantia.setFont(font1);
        txtGarantia.setToolTipText("O que tem como garantia");
        
        comboProvincia.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
        txtNome.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
        txtContacto.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
        txtContactoAlternativo.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
        txtNome.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
        txtDataNAscimento.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
        txtQuarteirao.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
        txtNumeroCasa.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
        txtLocalResidencia.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
        txtNumeroBI.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
        txtProfissao.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
        txtGarantia.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
        this.eventosCor();
        this.eventoEnter();
    }
    private final void label(){
        lbUsuario = new JLabel(iconUsuario);
        lbUsuario.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.WHITE));
        lbUsuario.setBounds(890, 100, 180, 200);
        
        lbNome = new JLabel("Nome");
        lbNome.setBounds(10, 100, 160, 25);
        lbNome.setFont(font);
        lbNome.setForeground(Color.WHITE);
        
        lbNumeroBI = new JLabel("Numero do BI");
        lbNumeroBI.setBounds(10, 135, 170, 25);
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
        
        lbProfissao = new JLabel("Profissao");
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
        
        lbTipoEmprstimo = new JLabel("Tipo de Emprestimo");
        lbTipoEmprstimo.setBounds(10, 420, 170, 25);
        lbTipoEmprstimo.setFont(font);
        lbTipoEmprstimo.setForeground(Color.WHITE);
        
        lbGarantia = new JLabel("Garantia");
        lbGarantia.setBounds(10, 455, 160, 25);
        lbGarantia.setFont(font);
        lbGarantia.setForeground(Color.WHITE);
        
        lbQuantia = new JLabel("Valor Requisitado");
        lbQuantia.setBounds(10, 490, 180, 25);
        lbQuantia.setFont(font);
        lbQuantia.setForeground(Color.WHITE);
        
        lbValor = new JLabel("Mt");
        lbValor.setBounds(280, 490, 50, 25);
        lbValor.setForeground(Color.BLACK);
        lbValor.setFont(font);
        lbValor.setForeground(Color.WHITE);
        
        lbValorAjustado = new JLabel("Valor: "+0.0);
        lbValorAjustado.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.WHITE));
        lbValorAjustado.setBounds(715, 170, 150, 25);
        lbValorAjustado.setForeground(Color.BLACK);
        lbValorAjustado.setFont(font3);
        lbValorAjustado.setForeground(Color.WHITE);
        
        lbValorTotal = new JLabel("Total: "+ contValor);
        lbValorTotal.setBounds(715, 205, 150, 25);
        lbValorTotal.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.WHITE));
        lbValorTotal.setForeground(Color.WHITE);
        lbValorTotal.setFont(font3);
        lbValorTotal.setForeground(Color.WHITE);
        
        lbRegistarCliente = new JLabel("Efectuar emprestimo");
        lbRegistarCliente.setBounds(390, 20, 300, 35);
        lbRegistarCliente.setForeground(Color.WHITE);
        lbRegistarCliente.setFont(font2);
        
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
        
        btActualizar = new JButton("Actualizar", iconActualizar);
        btActualizar.setBounds(800, 685, 130, 26);
        btActualizar.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
        btActualizar.setFont(font);
        btActualizar.setBackground(Color.WHITE);
        btActualizar.setFocusable(false);
        btActualizar.addActionListener(this);
        
        btRegistar = new JButton("Confirmar", iconConfirmar);
        btRegistar.setBounds(630, 685, 160, 26);
        btRegistar.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
        btRegistar.setFont(font);
        btRegistar.setBackground(Color.WHITE);
        btRegistar.setFocusable(false);
        
        btLigar.setBounds(935, 302, 38, 38);
        btLigar.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.BLACK));
        btLigar.setFont(font);
        btLigar.setBackground(new Color(23, 54, 93));
        btLigar.setFocusable(false);
        btLigar.addActionListener(this);
        
        btCapturar.setBounds(985, 301, 40, 40);
        btCapturar.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.BLACK));
        btCapturar.setFont(font);
        btCapturar.setBackground(new Color(23, 54, 93));
        btCapturar.setFocusable(false);
        btCapturar.addActionListener(this);
        
        btAdicionar.setBounds(660, 455, 25, 25);
        btAdicionar.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.BLACK));
        btAdicionar.setFont(font);
        btAdicionar.setBackground(new Color(23, 54, 93));
        btAdicionar.setFocusable(false);
        btAdicionar.addActionListener(this);
    }
    private final void radioButton(){
        ButtonGroup grupo = new ButtonGroup();
        grupo.add(outro);
        grupo.add(masculino);
        grupo.add(femenino);
        
        ButtonGroup grupo1 = new ButtonGroup();
        grupo1.add(particular);
        grupo1.add(comercial);
        
        masculino.setBounds(200, 205, 110, 25);
        masculino.setBackground(Color.WHITE);
        masculino.setFont(font1);
        masculino.setFocusable(false);
        
        femenino.setBounds(400, 205, 110, 25);
        femenino.setBackground(Color.WHITE);
        femenino.setFont(font1);
        femenino.setFocusable(false);
        
        outro.setBounds(580, 205, 110, 25);
        outro.setFont(font1);
        outro.setBackground(Color.WHITE);
        outro.setFocusable(false);
        
        particular.setBounds(200, 420, 110, 25);
        particular.setBackground(Color.WHITE);
        particular.setFont(font1);
        particular.setFocusable(false);
        
        comercial.setBounds(400, 420, 110, 25);
        comercial.setBackground(Color.WHITE);
        comercial.setFont(font1);
        comercial.setFocusable(false);
        
        if(masculino.isSelected()==true)
        sexo = "Masculino";
        if(femenino.isSelected()==true)
            sexo = "Femenino";
        if(outro.isSelected()==true)
            sexo = "Outros";
        if(particular.isSelected()==true)
            tipoEm = "Particular";
        if(comercial.isSelected()==true)
            tipoEm = "Comercial";
        
    }
    long iD;
    ClienteDAO dAO = new ClienteDAO();
    public void registo(){
        
        try {
            String nome = txtNome.getText();
            double quantia = Double.parseDouble( txtQuantia.getText());
            String dataEmp = cli.dataActual();
            String validadeEmp = cli.dataValidade();
            String bI = txtNumeroBI.getText();
            String nascimento = ((JTextField)txtDataNAscimento.getDateEditor().getUiComponent()).getText();
            String profissao = txtProfissao.getText();
            String localResidencia = txtLocalResidencia.getText();
            String quarteirao = txtQuarteirao.getText();
            String numeroCasa = txtNumeroCasa.getText();
            long contacto = Long.parseLong(txtContacto.getText()) ;
            long contactoAlt = Long.parseLong(txtContactoAlternativo.getText());
            String garantia = txtGarantia.getText();
            iD = dAO.numeroID();
            
            this.radioButton();
            
            Cliente cli = new Cliente();
            double tot = cli.precoFinal(quantia);

            Cliente cliente = new Cliente(tot, dataEmp, validadeEmp,
            tipoEm, profissao, true, nome, nascimento, sexo, bI, localResidencia, numeroCasa, quarteirao, contacto, contactoAlt, iD, imagemRedim, (String)comboProvincia.getSelectedItem());
            ClienteDAO clien = new ClienteDAO();
            Garantia garantiaObs = new Garantia(iD, nome, valorArraylist, garantiaArrayList, imagemRedim, true);
            
            if ((quantia<1000)&&(tipoEm.equals("Particular"))){
                    JOptionPane.showMessageDialog(null, "Impossivel fazer o emprestimo!!\nO seu tipo de emprestimo nao permite\n um valor abaixo de 1.000 Mt.",
                    "Mensagem", JOptionPane.ERROR_MESSAGE);
            }
            if ((quantia<15000)&&(tipoEm.equals("Comercial"))){
                JOptionPane.showMessageDialog(null, "Impossivel fazer o emprestimo!!\nO seu tipo de emprestimo nao permite\n um valor abaixo de 15.000 Mt.","Mensagem", JOptionPane.ERROR_MESSAGE);
            }else{    
            
                if(new FinancasDAO().retirarSal(quantia)){
                    if ((quantia>=1000)&&(tipoEm.equals("Particular"))){
                        this.mensagem(nome, quantia, iD, validadeEmp);
                        new GarantiaDAO().cadastroGarantia(garantiaObs);
                        this.ListarTabela();
                        lbValorAjustado.setText("Valor: "+ quantia+" Mt");
                        lbValorTotal.setText("Total: "+ tot +" Mt");
                        
                        clien.cadastroCliente(cliente);
                        quantia = 0;
                    }
                    if ((quantia>=15000)&&(tipoEm.equals("Comercial"))){
                        this.mensagem(nome, quantia, iD, validadeEmp);
                        this.ListarTabela();
                        clien.cadastroCliente(cliente);
                        lbValorAjustado.setText("Valor"+ quantia*(1+0.3));
                        lbValorTotal.setText("Total: "+ tot );
                        new GarantiaDAO().cadastroGarantia(garantiaObs);
                        quantia = 0;
                    }
                }
            }
            this.linpar();
            model.setRowCount(0);
            contValor=0;
            lbUsuario.setIcon(iconUsuario);
            imagemRedim = null;
            checkAcordo.setSelected(false);
            checkFotocopiaBI.setSelected(false);
            this.ListarTabela();
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Impossivel fazer o emprestimo!!\nCertique se todos os campos estao devidamente preenchidos."+ e.getMessage(),"Mensagem", JOptionPane.ERROR_MESSAGE);
        }
        

    }
    private  final void imagemFundo(){
        JPanel painelFundo = new JPanel(){
            protected void paintComponent(Graphics g){
                super.paintComponent(g);
                ImageIcon fundo = new ImageIcon(getClass().getResource("fundo3.jpg"));
                g.drawImage(fundo.getImage(), 0, 0,d.width, d.height, null);
                
            }
        };
        setContentPane(painelFundo);
    }
    private final void linpar(){
        txtNome.setText("");
        txtNumeroBI.setText("");
        ((JTextField)txtDataNAscimento.getDateEditor()).setText("");
        txtProfissao.setText("");
        txtLocalResidencia.setText("");
        txtQuarteirao.setText("");
        txtNumeroCasa.setText("");
        txtContacto.setText("");
        txtContactoAlternativo.setText("");
        txtQuantia.setText("");
        txtGarantia.setText("");
        valorArraylist.clear();
        garantiaArrayList.clear();
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btVoltar)
            dispose();
        if(e.getSource()==btRegistar){
            this.radioButton();
            if((txtContacto.getText().length()==9)&&(txtContactoAlternativo.getText().length()==9)&&(txtNumeroBI.getText().length()==13)&&(txtNome.getText().length()>5)&&
                    ((txtQuarteirao.getText().length()>0)&&(txtNumeroCasa.getText().length()>0))&&(txtProfissao.getText().length()>4)&&(sexo.length()>0)&&
                    (imagemRedim!=null)&&(tipoEm.length()>0)){
                if((Double.parseDouble(txtQuantia.getText())*1.3)<= contValor){
                    if(new ClienteDAO().consultar(txtNome.getText())){
                        if(checkAcordo.isSelected()&&(checkFotocopiaBI.isSelected())){
                            this.registo();
                        }else{
                            JOptionPane.showMessageDialog(null, "Impossivel fazer o emprestimo!!\nO seu pedido nao santisfaz todos os requisitos.","Mensagem", JOptionPane.ERROR_MESSAGE);
                            
                        }
                    }else{
                        JOptionPane.showMessageDialog(null, "Impossivel fazer o emprestimo!!\nO Clente ja encontra_se registado","Mensagem", JOptionPane.ERROR_MESSAGE);    
                        this.linpar();
                        model.setRowCount(0);
                        contValor=0;
                        lbUsuario.setIcon(iconUsuario);
                        imagemRedim = null;   
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Erro!!! O valor da garantia nao compativel para efetuar\no emprestimo", "Messagem", JOptionPane.ERROR_MESSAGE);
                }
            }else{
            JOptionPane.showMessageDialog(null, "Erro!!! Verifica se todos os campos estao devidamente preenchidos.", "Messagem", JOptionPane.ERROR_MESSAGE);
            }
        }
        if (e.getSource()==btLigar){
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
        if(e.getSource()==btAdicionar){
            if(txtGarantia.getText().length()>2){
                try {
                    String valorGarantia = JOptionPane.showInputDialog("Digite o preco da garantia");
                    contValor += Double.parseDouble(valorGarantia);
                    Object[] dados= {txtGarantia.getText(),
                    valorGarantia};
                    model.addRow(dados);
                    valorArraylist.add(Double.parseDouble(valorGarantia));
                    garantiaArrayList.add(txtGarantia.getText());
                    txtGarantia.setText("");
                } catch (Exception ex) {
                    txtGarantia.setText("");
                    JOptionPane.showMessageDialog(null, "Erro!!! "+ex.getMessage(), "Messagem", JOptionPane.ERROR_MESSAGE);
                }
            }else{
                JOptionPane.showMessageDialog(null, "Erro!!! Garantia invalida", "Messagem", JOptionPane.ERROR_MESSAGE);
            }
        }
        if(e.getSource()==btActualizar){
            if(editar){
                if((txtContacto.getText().length()==9)&&(txtContactoAlternativo.getText().length()==9)&&(txtNumeroBI.getText().length()==13)&&
                    ((txtQuarteirao.getText().length()>0)&&(txtNumeroCasa.getText().length()>0))&&(txtLocalResidencia.getText().length()>4)&&
                    (txtProfissao.getText().length()>2)){
                    this.actualizarTabela();
                    this.ListarTabela();
                }else{
                    JOptionPane.showMessageDialog(null, "Impossivel fazer o cadastro!!\nCertique se todos os campos estao devidamente preenchidos.","Mensagem", JOptionPane.ERROR_MESSAGE);
                }

            }else{
                JOptionPane.showMessageDialog(null, "Erro!! Para actualizar clique no [Editar campos] e\nSegue as instrucoes."
                    , "Mensagem", JOptionPane.ERROR_MESSAGE);
            }
            
            txtNome.enable(true);
            txtDataNAscimento.setEnabled(true);
            txtGarantia.setEditable(true);
            txtQuantia.setEditable(true);
            masculino.setEnabled(true);
            femenino.setEnabled(true);
            outro.setEnabled(true);
            particular.setEnabled(true);
            comercial.setEnabled(true);
            checkAcordo.setEnabled(true);
            checkFotocopiaBI.setEnabled(true);

            txtContacto.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
            txtContactoAlternativo.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
            txtProfissao.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
            txtQuarteirao.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
            txtNumeroCasa.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
            txtLocalResidencia.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
            txtNumeroBI.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
        }
    }
    private void play(){
        try {
            dimensao_default =  WebcamResolution.VGA.getSize();
            WEBCAM = Webcam.getDefault();
            WEBCAM.setViewSize(dimensao_default);
            
        } catch (Exception e) {
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
                } catch (Exception e) {
                }
            }
            
        }.start();
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
                    txtProfissao.requestFocus();
                }
            }
            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        
        
        txtProfissao.addKeyListener(new KeyListener() {
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
                    txtGarantia.requestFocus();
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
        
        txtGarantia.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    txtQuantia.requestFocus();
                }
            }
            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        txtQuantia.addKeyListener(new KeyListener() {
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
    
    private final void tabelaGarantia(){
        Object[][] dados ={};
        Object [] colunas = {"Garantia","Preco"};
        model = new DefaultTableModel(dados, colunas);
        table = new JTable(model);
        table.setFont(font4);
        table.setFont(font1);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

        table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        table.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);

        roda = new JScrollPane(table);
        roda.setBounds(700, 350, 370,325 );
    }
    private final void ListarTabela(){
        ArrayList<Cliente> cli = new ArrayList();
        try {
            FileInputStream fileInput = new FileInputStream("Cliente.txt");
            ObjectInputStream objInput = new ObjectInputStream(fileInput);
            
            Cliente vic = null;
            while ((vic = (Cliente)objInput.readObject())!= null){
               cli.add(vic);
            }
            objInput.close();
            fileInput.close();
        } catch (Exception e) {}
        
        modelCliente.setRowCount(0);
        for (int f = 0; f< cli.size(); f++){
            if(cli.get(f).getStatus()==true){
                Object[] dados= {cli.get(f).getiD(),
                cli.get(f).getNome(),
                cli.get(f).getQuantia(),
                cli.get(f).getValidadeEmprestimo()};
                modelCliente.addRow(dados);
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
            imagemRedim = buff2.toByteArray();
            new Thread(){
            public void run(){
                WEBCAM.close();
            }
        }.start();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    public  void mensagem(String nome, double valor, long codigo, String validade) {
        try {
            Date date = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

            String dateStr = dateFormat.format(date);
            Twilio.init("ACb89ad02a4c2af7eba77c09daa758c58d", "6861d45a116ddabeb01ded4ccb17c991");
            Message message = Message.creator(
            new com.twilio.type.PhoneNumber("+258874352370"),
            new com.twilio.type.PhoneNumber("+16186740522"),
            "Confirmado Ajkk"+ codigo+ "Q. Efectou um emprestimo de "+ valor+" Mt na SB_Microcredito Aos "+ dateStr+ " valido ate "+ validade+".")
            .create();

            System.out.println(message.getBody());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
    }
    private final void mouseListener(){
        lbEditar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                txtNome.enable(false);
                txtDataNAscimento.setEnabled(false);
                txtGarantia.setEditable(false);
                txtQuantia.setEditable(false);
                masculino.setEnabled(false);
                femenino.setEnabled(false);
                outro.setEnabled(false);
                particular.setEnabled(false);
                comercial.setEnabled(false);
                checkAcordo.setEnabled(false);
                checkFotocopiaBI.setEnabled(false);
                
                txtContacto.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
                txtContactoAlternativo.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
                txtProfissao.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
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
            DefaultTableModel modeloTabela = (DefaultTableModel) tableCliente.getModel();
            int LinhaSelecionada = tableCliente.getSelectedRow();
            
            new ClienteDAO().actualizar((long) tableCliente.getModel().getValueAt(LinhaSelecionada, 0), txtNumeroBI.getText()
                    , txtProfissao.getText(), txtLocalResidencia.getText(), txtQuarteirao.getText()
                    , txtNumeroCasa.getText(), (String) comboProvincia.getSelectedItem(), Long.parseLong(txtContacto.getText())
                    , Long.parseLong(txtContacto.getText()));
            
            editar = false;
            this.linpar();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro!!! Seleciona na tabela a linha que deseja Actualizar"+e.getMessage(), "Mensagem", JOptionPane.ERROR_MESSAGE);
        }
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
