package com.sbmicrocredito.view;

import com.sbmicrocredito.controler.FinancasDAO;
import com.sbmicrocredito.controler.FuncionarioDAO;
import com.sbmicrocredito.model.Funcionarios;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import javax.swing.BorderFactory;
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
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class TelaFuncionarios extends JFrame implements ActionListener{
    Font font = new Font("Arial", Font.BOLD, 17);
    Font font1 = new Font("Arial", Font.PLAIN, 16);
    Font font2 = new Font("Arial", Font.BOLD, 30);
    
    ImageIcon iconVoltar = new ImageIcon(getClass().getResource("voltar.png"));
    ImageIcon iconConfirmar = new ImageIcon(getClass().getResource("Emprestimo.png"));
    ImageIcon iconPesquisar = new ImageIcon(getClass().getResource("pesquisa.png"));
    ImageIcon iconDemitir = new ImageIcon(getClass().getResource("lixeira.png"));
    
    JButton btVoltar;
    JButton btRegistar;
    JButton btDemitir;
    JButton btPesquisar;
    
    JLabel lbBonus;
    JLabel lbMt;
    JLabel lbID;
    JLabel lbNome;
    JLabel lbNumeroBI;
    JLabel lbDataNAscimento;
    JLabel lbSexo;
    JLabel lbProfissao;
    JLabel lbLocalResidencia;
    JLabel lbNumeroCasa;
    JLabel lbContacto;
    JLabel lbContactoAlternativo;
    JLabel lbSalario;
    JLabel lbEmail;
    JLabel lbSenha;
    JLabel lbListarFuncionarios;
    JLabel lbCliente;
    
    JTextField txtBonus;
    JTextField txtPesquisa;
    
    JPanel painel;
    JPanel painel1 = new JPanel();
    
    JList lista;
    DefaultListModel modelo ;
    JScrollPane mySc; 
    
    Toolkit tk = Toolkit.getDefaultToolkit();
    Dimension d = tk.getScreenSize();
    
    ArrayList listarJlist = new ArrayList();
    
    public TelaFuncionarios(){
        this.imagemFundo();
        this.textField();
        this.label();
        this.tbLista();
        this.listar();
        this.configuracaoTela();
        this.butao();
        this.painel1();
        this.configuracaoPainel();
}
    private final void configuracaoTela(){
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setUndecorated(true);
        setLayout(null);
        setVisible(true);
    }
    private final void configuracaoPainel(){
        painel = new JPanel();
        painel.setBounds((d.width-1080)/2, (d.height-720)/2, 1080, 720);
        painel.setBackground(Color.WHITE);
        painel.setBorder(BorderFactory.createMatteBorder(75, 2, 2, 2, new Color(0, 153, 153)));
        painel.setBackground(new Color(23, 54, 93));
        painel.setLayout(null);
        add(painel);
        painel.add(btRegistar);
        painel.add(this.btVoltar);
        painel.add(btDemitir);
        painel.add(this.btPesquisar);
        painel.add(mySc);
        painel.add(painel1);
        painel. add(lbBonus);
        painel.add(lbMt);
        painel.add(txtBonus);
        painel.add(txtPesquisa);
        painel.add(this.lbListarFuncionarios);
        
        painel1.add(this.lbCliente);
        painel1.add(this.lbNome);
        painel1.add(this.lbNumeroBI);
        painel1.add(this.lbDataNAscimento);
        painel1.add(this.lbProfissao);
        painel1.add(this.lbLocalResidencia);
        painel1.add(this.lbNumeroCasa);
        painel1.add(this.lbContacto);
        painel1.add(this.lbSexo);
        painel1.add(this.lbContactoAlternativo);
        painel1.add(this.lbSalario);
        painel1.add(this.lbEmail);
        painel1.add(this.lbID);
        painel1.add(this.lbSenha);
    }
    public final void painel1(){
        painel1.setBounds(470, 115, 600, 565);
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
        
        btRegistar = new JButton("Pagar salario", iconConfirmar);
        btRegistar.setBounds(630, 685, 170, 26);
        btRegistar.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
        btRegistar.setFont(font);
        btRegistar.setBackground(Color.WHITE);
        btRegistar.setFocusable(false);
        btRegistar.addActionListener(this);
        
        btDemitir = new JButton("Demitir", iconDemitir);
        btDemitir.setBounds(810, 685, 120, 26);
        btDemitir.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
        btDemitir.setFont(font);
        btDemitir.setBackground(Color.WHITE);
        btDemitir.setFocusable(false);
        btDemitir.addActionListener(this);
        
        btPesquisar = new JButton(iconPesquisar);
        btPesquisar.setBounds(1040, 80, 26, 26);
        btPesquisar.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0,Color.BLACK));
        btPesquisar.setBackground(new Color(23, 54, 93));
        btPesquisar.setFocusable(false);
        btPesquisar.addActionListener(this);
        
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                // Não é necessário implementar keyTyped
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_F12) {
                    // Fecha a janela quando a tecla F12 é pressionada
                   dispose();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                // Não é necessário implementar keyReleased
            }
        });
    }
    public void tbLista(){
        modelo = new DefaultListModel();
        lista = new JList( );
//        lista.setBounds(15, 10, 250, 250);
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
        lbBonus = new JLabel("Bonus");
        lbBonus.setBounds(470, 80, 60, 25);
        lbBonus.setForeground(Color.WHITE);
        lbBonus.setFont(font);
        
        lbMt = new JLabel("Mt");
        lbMt.setBounds(625, 80, 50, 25);
        lbMt.setForeground(Color.WHITE);
        lbMt.setFont(font);
        
        lbNome = new JLabel();
        lbNome.setBounds(10, 80, 360, 25);
        lbNome.setFont(font1);
        
        lbCliente = new JLabel();
        lbCliente.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
        lbCliente.setBounds(415, 5, 180, 200);
        
        lbNumeroBI = new JLabel();
        lbNumeroBI.setBounds(10, 115, 300, 25);
        lbNumeroBI.setFont(font1);
        
        lbDataNAscimento = new JLabel();
        lbDataNAscimento.setBounds(10, 150, 300, 25);
        lbDataNAscimento.setFont(font1);
        
        lbSexo = new JLabel();
        lbSexo.setBounds(10, 185, 185, 25);
        lbSexo.setFont(font1);
        
        lbProfissao = new JLabel();
        lbProfissao.setBounds(10, 220, 300, 25);
        lbProfissao.setFont(font1);
        
        lbLocalResidencia = new JLabel();
        lbLocalResidencia.setBounds(10, 255, 400, 25);
        lbLocalResidencia.setFont(font1);
        
        lbNumeroCasa = new JLabel();
        lbNumeroCasa.setBounds(10, 290, 300, 25);
        lbNumeroCasa.setFont(font1);
        
        lbContacto = new JLabel();
        lbContacto.setBounds(10, 325, 300, 25);
        lbContacto.setFont(font1);
        
        lbContactoAlternativo = new JLabel();
        lbContactoAlternativo.setBounds(10, 360, 300, 25);
        lbContactoAlternativo.setFont(font1);
        
        lbSalario = new JLabel();
        lbSalario.setBounds(10, 395, 300, 25);
        lbSalario.setFont(font1);
        
        lbEmail = new JLabel();
        lbEmail.setBounds(10, 430, 300, 25);
        lbEmail.setFont(font1);
        
        lbID = new JLabel();
        lbID.setBounds(10, 10, 300, 25);
        lbID.setForeground(Color.RED);
        lbID.setFont(font1);
        
        lbSenha = new JLabel();
        lbSenha.setBounds(10, 45, 300, 25);
        lbSenha.setForeground(Color.RED);
        lbSenha.setFont(font1);
        
        lbListarFuncionarios = new JLabel("Listar funcionario");
        lbListarFuncionarios.setBounds(390, 20, 300, 35);
        lbListarFuncionarios.setForeground(Color.WHITE);
        lbListarFuncionarios.setFont(font2);
        
    }
    private final void textField(){
        txtBonus = new JTextField("0.0");
        txtBonus.setBounds(525, 80, 100, 25);
        txtBonus.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
        txtBonus.setFont(font1);
        
        txtBonus.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if(txtBonus.getText().equals("0.0")){
                    txtBonus.setText("");
                }
                
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(txtBonus.getText().isEmpty()){
                    txtBonus.setText("0.0");
                }
            }
        });
        
        txtPesquisa = new JTextField("Nome completo");
        txtPesquisa.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
        txtPesquisa.setFont(font1);
        txtPesquisa.setBounds(660, 80, 375, 25);
        
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
    private final void listar(){
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
        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "Erro na leitura do arquivo!!" +e);
        }
        for (int f = 0; f< fun.size(); f++){
            if(fun.get(f).getStatus()==true){
                listarJlist.add(fun.get(f).getNome());
            }
        }
        for (int i=0; i<listarJlist.size(); i++){
            modelo.addElement(listarJlist.get(i));
        }
        lista.addListSelectionListener(new ListSelectionListener(){
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int index = lista.getSelectedIndex();
                
                for(int j=0; j<fun.size(); j++){
                    if(fun.get(j).getNome().equals(String.valueOf(modelo.get(index)))){
                        lbID.setText("ID: "+fun.get(j).getID());
                        lbNome.setText("Nome: "+fun.get(j).getNome());
                        lbNumeroBI.setText("Numero de BI: "+fun.get(j).getNumeroBI());
                        lbDataNAscimento.setText("Data de nascimento: "+fun.get(j).getDataNascimento());
                        lbSexo.setText("Sexo: "+fun.get(j).getSexo());
                        lbProfissao.setText("Alocacao: "+fun.get(j).getAlocacao());
                        lbLocalResidencia.setText("Local de residencia: "+fun.get(j).getLocalResidencia()+" _ " +fun.get(j).getProvincia());
                        lbNumeroCasa.setText("Numero da casa: "+fun.get(j).getNumeroCasa()+ "     Quarteirao: "+fun.get(j).getQuarterao());
                        lbContacto.setText("Contacto: (+258)"+fun.get(j).getContacto());
                        lbContactoAlternativo.setText("Contacto Alt: (+258)"+fun.get(j).getContactoAlt());
                        lbSalario.setText("Salario: "+fun.get(j).getSalario());
                        lbEmail.setText("Email: "+fun.get(j).getEmail());
                        lbSenha.setText("Senha: "+fun.get(j).getSenha());
                        lbCliente.setIcon( new ImageIcon(fun.get(j).getImagem()));
                    }
                }
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==btVoltar){
            dispose();
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
        if(e.getSource()==btDemitir){
            for (int i=0; i<modelo.size(); i++){
                if(i==lista.getSelectedIndex()){
                    FuncionarioDAO funcDAO = new FuncionarioDAO();
                    funcDAO.demitir(String.valueOf(modelo.get(lista.getSelectedIndex())));
                    lbID.setText("");
                    lbNome.setText("");
                    lbNumeroBI.setText("");
                    lbDataNAscimento.setText("");
                    lbSexo.setText("");
                    lbProfissao.setText("");
                    lbLocalResidencia.setText("");
                    lbNumeroCasa.setText("");
                    lbContacto.setText("");
                    lbContactoAlternativo.setText("");
                    lbSalario.setText("");
                    lbEmail.setText("");
                    lbSenha.setText("");
                    lbCliente.setIcon( null);
                    
                }
            } 
        }
        if (e.getSource()==btRegistar){
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
            } catch (Exception ex) {}
            for(int i=0; i<fun.size(); i++){
                try {
                    if(fun.get(i).getNome().equals(String.valueOf(modelo.get(lista.getSelectedIndex())))){
                        if(Double.parseDouble(txtBonus.getText())>=0){
                            new FinancasDAO().retirarLucro(fun.get(i).getSalario()+ Double.parseDouble(txtBonus.getText()));
                            btRegistar.setVisible(false);
                            break;
                        }else{
                            JOptionPane.showMessageDialog(null, "erro ao pagar salario!! O bonus deve ser maior que 0 Mt", "Mensagem", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "erro!! "+ ex.getMessage(), "Mensagem", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }
}

