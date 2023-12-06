package com.sbmicrocredito.view;

import com.sbmicrocredito.controler.ClienteDAO;
import com.sbmicrocredito.controler.FinancasDAO;
import com.sbmicrocredito.controler.GarantiaDAO;
import com.sbmicrocredito.model.Cliente;
import com.sbmicrocredito.model.Garantia;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListCellRenderer;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Djudju
 */
public class TelaEmprestimo extends JFrame implements ActionListener{
    Font font = new Font("Arial", Font.BOLD, 17);
    Font font1 = new Font("Arial", Font.PLAIN, 16);
    Font font2 = new Font("Arial", Font.BOLD, 30);
    
    JLabel lbNome;
    JLabel lbDataNAscimento;
    JLabel lbSexo;
    JLabel lbProfissao;
    JLabel lbLocalResidencia;
    JLabel lbQuarteirao;
    JLabel lbContacto;
    JLabel lbContactoAlternativo;
    JLabel lbTipoEmprstimo;
    JLabel lbQuantia;
    JLabel lbDataEm;
    JLabel lbiD;
    JLabel lbCliente;
    JLabel lbListarClientes;
    
    JTextField txtPesquisa;
    
    ImageIcon iconVoltar = new ImageIcon(getClass().getResource("voltar.png"));
    ImageIcon iconPesquisar = new ImageIcon(getClass().getResource("pesquisa.png"));
    ImageIcon iconConfirmar = new ImageIcon(getClass().getResource("Emprestimo.png"));
    ImageIcon iconRenovar = new ImageIcon(getClass().getResource("renovar.png"));
    
    JButton btVoltar;
    JButton btRegistar;
    JButton btPagarTaxa;
    JButton btPesquisar;
    
    
    JPanel painel;
    JPanel painel1 = new JPanel();
    
    JList lista;
    DefaultListModel modelo ;
    JScrollPane mySc; 
    
    Toolkit tk = Toolkit.getDefaultToolkit();
    Dimension d = tk.getScreenSize();
    
    ArrayList listarJlist = new ArrayList();
    
    public TelaEmprestimo(){
        this.imagemFundo();
        this.label();
        this.textField();
        this.tbLista();
        this.listar();
        this.configuracaoTela();
        this.butao();
        this.painel1();
        this.configuracaoPainel();
}
    private final void configuracaoTela(){
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        setLayout(null);
        setVisible(true);
    }
    private final void configuracaoPainel(){
        painel = new JPanel();
        painel.setBounds((d.width-1080)/2, (d.height-720)/2, 1080, 720);
        painel.setBackground(Color.WHITE);
        painel.setBorder(BorderFactory.createMatteBorder(75, 2, 2, 2,new Color(0, 153, 153)));
        painel.setBackground(new Color(23, 54, 93));
        painel.setLayout(null);
        add(painel);
        painel.add(txtPesquisa);
        painel1.add(this.lbCliente);
        painel1.add(this.lbNome);
        painel1.add(this.lbDataNAscimento);
        painel1.add(this.lbSexo);
        painel1.add(this.lbProfissao);
        painel1.add(this.lbLocalResidencia);
        painel1.add(this.lbQuarteirao);
        painel1.add(this.lbContactoAlternativo);
        painel1.add(this.lbContacto);
        painel1.add(this.lbTipoEmprstimo);
        painel1.add(this.lbQuantia);
        painel1.add(this.lbDataEm);
        painel1.add(this.lbiD);
        
        painel.add(this.lbListarClientes);
        painel.add(btRegistar);
        painel.add(btPagarTaxa);
        painel.add(this.btVoltar);
        painel.add(this.btPesquisar);
        painel.add(mySc);
        painel.add(painel1);
        
    }
    public final void painel1(){
        painel1.setBounds(470, 110, 600, 570);
        painel1.setBackground(Color.WHITE);
        painel1.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
        painel1.setLayout(null);
    }
    private final void butao(){
        btVoltar = new JButton("Voltar", iconVoltar);
        btVoltar.setBounds(940, 685, 130, 26);
        btVoltar.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
        btVoltar.setFont(font);
        btVoltar.setBackground(Color.WHITE);
        btVoltar.setFocusable(false);
        btVoltar.addActionListener(this);
        
        btRegistar = new JButton("Pagar", iconConfirmar);
        btRegistar.setBounds(580, 685, 120, 26);
        btRegistar.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
        btRegistar.setFont(font);
        btRegistar.setBackground(Color.WHITE);
        btRegistar.setFocusable(false);
        btRegistar.addActionListener(this);
        
        btPagarTaxa = new JButton("Renovar emprestimo", iconRenovar);
        btPagarTaxa.setBounds(710, 685, 220, 26);
        btPagarTaxa.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
        btPagarTaxa.setFont(font);
        btPagarTaxa.setBackground(Color.WHITE);
        btPagarTaxa.setFocusable(false);
        btPagarTaxa.addActionListener(this);
        
        btPesquisar = new JButton(iconPesquisar);
        btPesquisar.setBounds(1040, 80, 26, 26);
        btPesquisar.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0,Color.BLACK));
        btPesquisar.setBackground(new Color(23, 54, 93));
        btPesquisar.setFocusable(false);
        btPesquisar.addActionListener(this);
    }
    public void tbLista(){
        modelo = new DefaultListModel();
        lista = new JList( );
        lista.setForeground(Color.BLACK);
        lista.setFont(font);
        mySc = new JScrollPane(lista, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        mySc.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
        mySc.setBounds(10, 80, 450, 630);
        
        lista.setModel(modelo);
    }
    private final void imagemFundo(){
        JPanel painelFundo = new JPanel(){
            protected void paintComponent(Graphics g){
                super.paintComponent(g);
                ImageIcon fundo = new ImageIcon(getClass().getResource("fundo3.jpg"));
                g.drawImage(fundo.getImage(), 0, 0,d.width, d.height, null);
                
            }
        };
        setContentPane(painelFundo);
    }
    private final void label(){
        lbNome = new JLabel();
        lbNome.setBounds(10, 10, 360, 25);
        lbNome.setFont(font1);
        
        lbCliente = new JLabel();
        lbCliente.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
        lbCliente.setBounds(415, 5, 180, 200);
        
        lbDataNAscimento = new JLabel();
        lbDataNAscimento.setBounds(10, 45, 300, 25);
        lbDataNAscimento.setFont(font1);
        
        lbSexo = new JLabel();
        lbSexo.setBounds(10, 80, 300, 25);
        lbSexo.setFont(font1);
        
        lbProfissao = new JLabel();
        lbProfissao.setBounds(10, 115, 300, 25);
        lbProfissao.setFont(font1);
        
        lbLocalResidencia = new JLabel();
        lbLocalResidencia.setBounds(10, 150, 350, 25);
        lbLocalResidencia.setFont(font1);
        
        lbQuarteirao = new JLabel();
        lbQuarteirao.setBounds(10, 185, 300, 25);
        lbQuarteirao.setFont(font1);
        
        lbContacto = new JLabel();
        lbContacto.setBounds(10, 220, 300, 25);
        lbContacto.setFont(font1);
        
        lbContactoAlternativo = new JLabel();
        lbContactoAlternativo.setBounds(10, 255, 300, 25);
        lbContactoAlternativo.setFont(font1);
        
        lbTipoEmprstimo = new JLabel();
        lbTipoEmprstimo.setBounds(10, 290, 300, 25);
        lbTipoEmprstimo.setFont(font1);
        
        lbQuantia = new JLabel();
        lbQuantia.setBounds(10, 325, 250, 25);
        lbQuantia.setFont(font1);
        
        lbDataEm = new JLabel();
        lbDataEm.setBounds(10, 360, 500, 25);
        lbDataEm.setFont(font1);
        
        lbiD = new JLabel();
        lbiD.setBounds(10, 395, 500, 25);
        lbiD.setFont(font1);
        
        lbListarClientes = new JLabel("Listar cliente");
        lbListarClientes.setBounds(440, 20, 200, 35);
        lbListarClientes.setForeground(Color.WHITE);
        lbListarClientes.setFont(font2);
    }
    private final void textField(){
        txtPesquisa = new JTextField("Nome completo");
        txtPesquisa.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
        txtPesquisa.setFont(font1);
        txtPesquisa.setBounds(470, 80, 565, 25);
        txtPesquisa.setToolTipText("Pesquisasr um Cliente");
        
        txtPesquisa.addFocusListener(new FocusListener() {
            
            @Override
            public void focusGained(FocusEvent e) {
                if(txtPesquisa.getText().equals("Nome completo")){
                    txtPesquisa.setText("");
                }
                
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(txtPesquisa.getText().isEmpty()){
                    txtPesquisa.setText("Nome completo");
                }
            }
        });
        
    }
    private final void listar() {
        ArrayList<Cliente> cli = new ArrayList<>();
        try {
            FileInputStream fileInput = new FileInputStream("Cliente.txt");
            ObjectInputStream objInput = new ObjectInputStream(fileInput);

            Cliente vic;
            while ((vic = (Cliente) objInput.readObject()) != null) {
                cli.add(vic);
            }
            objInput.close();
            fileInput.close();
        } catch (Exception e) {}

        modelo = new DefaultListModel<>();
        lista.setModel(modelo);

        for (int f = 0; f < cli.size(); f++) {
            listarJlist.add(cli.get(f).getNome());
        }
        for (int i = 0; i < listarJlist.size(); i++) {
            if (cli.get(i).getStatus()) {
                modelo.addElement((String) listarJlist.get(i));
            }
        }

        lista.setCellRenderer(new ListCellRenderer<String>() {
            @Override
            public Component getListCellRendererComponent(JList<? extends String> list, String value, int index, boolean isSelected, boolean cellHasFocus) {
                Component renderer = new DefaultListCellRenderer().getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

                for (Cliente cliente : cli) {
                    if (cliente.getNome().equals(value) && cliente.getStatus()) {
                        if(new ClienteDAO().verificadorData(cliente.getNome())){
                            renderer.setForeground(Color.RED); 
                            break;
                        }else{
                            break;
                        }
                    }
                }

                return renderer;
            }
        });

        lista.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int index = lista.getSelectedIndex();

                for (int i = 0; i < listarJlist.size(); i++) {
                    if (cli.get(i).getNome().equals(String.valueOf(modelo.get(index)))){
                        // Atualize os campos de exibição com as informações do cliente
                        lbNome.setText("Nome: " + cli.get(i).getNome());
                        lbDataNAscimento.setText("Data de nascimento: " + cli.get(i).getDataNascimento());
                        lbSexo.setText("Sexo: " + cli.get(i).getSexo());
                        lbProfissao.setText("Profissao: " + cli.get(i).getProfissao());
                        lbLocalResidencia.setText("Local de Residencia: " + cli.get(i).getLocalResidencia());
                        lbQuarteirao.setText("Quateirao: " + cli.get(i).getQuarterao() + " Casa num: " + cli.get(i).getNumeroCasa());
                        lbContacto.setText("Contacto: +258" + cli.get(i).getContacto());
                        lbContactoAlternativo.setText("Contacto Alt: +258" + cli.get(i).getContactoAlt());
                        lbTipoEmprstimo.setText("Tipo de emprestimo: " + cli.get(i).getTipoEmprestimo());
                        lbQuantia.setText("Valor a pagar: " + cli.get(i).getQuantia() + " Mt");
                        lbDataEm.setText("Data do empréstimo: " + cli.get(i).getDataEmprestimo() + " Valido ate " + cli.get(i).getValidadeEmprestimo());
                        lbiD.setText("ID: " + cli.get(i).getiD());

                        lbCliente.setIcon(new ImageIcon(cli.get(i).getImagem()));
                    }
                }
            }
        });
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==btVoltar)
            dispose();
        if(e.getSource()==btRegistar){
            for (int i=0; i<listarJlist.size(); i++){
                if(i==lista.getSelectedIndex()){
                    new FinancasDAO().pagarDividida(String.valueOf(modelo.get(lista.getSelectedIndex())));
                    new GarantiaDAO().removerGarantia(String.valueOf(modelo.get(lista.getSelectedIndex())));
                }
            }

        }
        if(e.getSource()==btPesquisar){
            boolean verficador = false;
            for(int i=0; i<modelo.size(); i++){
                if(txtPesquisa.getText().equals(String.valueOf(modelo.get(i)))){
                    lista.setSelectedIndex(i);
                    txtPesquisa.setText("");
                    verficador=true;
                    break;
                }
            }
            if(!verficador){
                JOptionPane.showMessageDialog(null, "Cliente nao encotrado!!\nCertifique os seus dados e tente novamente",
            "Mensagem", JOptionPane.ERROR_MESSAGE);
            }
        }
        if(e.getSource()==btPagarTaxa){
            for (int i=0; i<listarJlist.size(); i++){
                if(i==lista.getSelectedIndex()){
                    new ClienteDAO().renovarEmprestimo(String.valueOf(modelo.get(lista.getSelectedIndex())));
                    new FinancasDAO().pagarRenovarEm(String.valueOf(modelo.get(lista.getSelectedIndex())));
                }
            }
        }
    }
}
