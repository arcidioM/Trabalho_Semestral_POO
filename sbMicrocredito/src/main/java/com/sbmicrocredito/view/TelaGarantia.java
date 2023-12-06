/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sbmicrocredito.view;

import com.sbmicrocredito.controler.FinancasDAO;
import com.sbmicrocredito.controler.GarantiaDAO;
import com.sbmicrocredito.model.Garantia;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Djudju
 */
public class TelaGarantia extends JFrame implements ActionListener{
    ImageIcon iconVoltar = new ImageIcon(getClass().getResource("voltar.png"));
    ImageIcon iconVender = new ImageIcon(getClass().getResource("vender.png"));
    
    Font font = new Font("Arial", Font.BOLD, 17);
    Font font1 = new Font("Arial", Font.PLAIN, 16);
    Font font2 = new Font("Arial", Font.BOLD, 30);
    
    JButton btVoltar;
    JButton btVenderGarantia;
    
    JPanel painel;
    
    JLabel lbListarGarantia;
    JLabel lbClienteGarantia;
    JLabel lbDadosGarantia;
    JLabel lbValorTotalGarantia;
    JLabel lbQuantidadeGarantia;
    JLabel lbCaixaEntrada;
    JLabel lbEstadoGarntia;
    
    Toolkit tk = Toolkit.getDefaultToolkit();
    Dimension d = tk.getScreenSize();
    
    JList lista;
    DefaultListModel modelo ;
    JScrollPane mySc; 
    
    JCheckBox checkAutorizacao;
    
    DefaultTableModel model;
    JTable table;
    JScrollPane roda;
    
    ArrayList listarJlist = new ArrayList();
    String nome = null;
    
    public TelaGarantia(){
        this.imagemFundo();
        this.tbLista();
        this.listar();
        this.tabelaGarantia();
        this.label();
        this.butao();
        this.configuracaoPainel();
        this.configuracaoTela();
        
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
        painel.setBackground(new Color(23, 54, 94));
        painel.setLayout(null);
        add(painel);
        painel.add(this.mySc);
        painel.add(roda);
        painel.add(this.btVoltar);
        painel.add(this.btVenderGarantia);
        painel.add(this.checkAutorizacao);
        
        painel.add(this.lbListarGarantia);
        painel.add(this.lbClienteGarantia);
        painel.add(this.lbDadosGarantia);
        painel.add(this.lbValorTotalGarantia);
        painel.add(this.lbQuantidadeGarantia);
        painel.add(this.lbCaixaEntrada);
        painel.add(this.lbEstadoGarntia);
        
    }
    private final void butao(){
        btVoltar = new JButton("Voltar", iconVoltar);
        btVoltar.setBounds(940, 685, 130, 26);
        btVoltar.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
        btVoltar.setFont(font);
        btVoltar.setBackground(Color.WHITE);
        btVoltar.setFocusable(false);
        btVoltar.addActionListener(this);
        
        btVenderGarantia = new JButton("Vender garantia", iconVender);
        btVenderGarantia.setBounds(750, 685, 180, 26);
        btVenderGarantia.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
        btVenderGarantia.setFont(font);
        btVenderGarantia.setBackground(Color.WHITE);
        btVenderGarantia.setFocusable(false);
        btVenderGarantia.addActionListener(this);
        
        checkAutorizacao = new JCheckBox("Autorizar leilao");
        checkAutorizacao.setBounds(470, 685, 180, 25);
        checkAutorizacao.setBackground(new Color(23, 54, 93));
        checkAutorizacao.setForeground(Color.WHITE);
        checkAutorizacao.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.BLACK));
        checkAutorizacao.setFocusable(false);
        checkAutorizacao.setFont(font);
    } 
    private final void label(){
        lbListarGarantia = new JLabel("Listar garantia");
        lbListarGarantia.setBounds(435, 20, 210, 35);
        lbListarGarantia.setForeground(Color.WHITE);
        lbListarGarantia.setFont(font2);
        
        lbClienteGarantia = new JLabel();
        lbClienteGarantia.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.WHITE));
        lbClienteGarantia.setBounds(470, 80, 180, 200);
        
        lbDadosGarantia = new JLabel();
        lbDadosGarantia.setFont(font);
        lbDadosGarantia.setForeground(Color.WHITE);
        lbDadosGarantia.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.WHITE));
        lbDadosGarantia.setBounds(655, 100, 415, 25);
        
        lbValorTotalGarantia = new JLabel();
        lbValorTotalGarantia.setFont(font);
        lbValorTotalGarantia.setForeground(Color.WHITE);
        lbValorTotalGarantia.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.WHITE));
        lbValorTotalGarantia.setBounds(655, 135, 415, 25);
        
        lbQuantidadeGarantia = new JLabel();
        lbQuantidadeGarantia.setFont(font);
        lbQuantidadeGarantia.setForeground(Color.WHITE);
        lbQuantidadeGarantia.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.WHITE));
        lbQuantidadeGarantia.setBounds(655, 170, 415, 25);
        
        lbCaixaEntrada = new JLabel();
        lbCaixaEntrada.setFont(font);
        lbCaixaEntrada.setForeground(Color.WHITE);
        lbCaixaEntrada.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.WHITE));
        lbCaixaEntrada.setBounds(655, 205, 415, 25);
        
        lbEstadoGarntia = new JLabel();
        lbEstadoGarntia.setFont(font);
        lbEstadoGarntia.setForeground(Color.WHITE);
        lbEstadoGarntia.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.WHITE));
        lbEstadoGarntia.setBounds(655, 240, 415, 25);
        
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
    private final void tabelaGarantia(){
        Object[][] dados ={};
        Object [] colunas = {"Garantia","Preco"};
        model = new DefaultTableModel(dados, colunas);
        table = new JTable(model);
        table.setFont(font1);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

        table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        table.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);

        roda = new JScrollPane(table);
        roda.setBounds(470, 290, 600, 390);
    }
    private final void listar(){
        ArrayList<Garantia> gar = new ArrayList();
        try {
            FileInputStream fileInput = new FileInputStream("Garantia.txt");
            ObjectInputStream objInput = new ObjectInputStream(fileInput);
            
            Garantia vic = null;
            while ((vic = (Garantia)objInput.readObject())!= null){
               gar.add(vic);
            }
            objInput.close();
            fileInput.close();
        } catch (Exception e) {}
        for (int f = 0; f< gar.size(); f++){
                listarJlist.add(gar.get(f).getNome());
        }
        for (int i=0; i<listarJlist.size(); i++){
            if(gar.get(i).getEstado()==true){
                modelo.addElement(listarJlist.get(i));
            }
        }
        lista.addListSelectionListener(new ListSelectionListener(){
            @Override
            public void valueChanged(ListSelectionEvent e) {
                double cont = 0;
                model.setRowCount(0);
                int index = lista.getSelectedIndex();
                
                for(int i=0; i<listarJlist.size(); i++){
                    if(gar.get(i).getNome().equals(String.valueOf(modelo.get(index)))){
                        lbClienteGarantia.setIcon( new ImageIcon(gar.get(i).getFoto()));
                        lbDadosGarantia.setText(String.valueOf("ID: "+gar.get(i).getiD()));
                        for(int j = 0; j<gar.get(i).getGarantia().size(); j++){
                            Object[] dados= {gar.get(i).getGarantia().get(j),
                            gar.get(i).getPreco().get(j)};
                            cont += gar.get(i).getPreco().get(j);
                            model.addRow(dados);
                        }
                        lbValorTotalGarantia.setText("Valor total da Garantia: "+ cont+" Mt");
                        lbQuantidadeGarantia.setText("Quantidade da Garantia: "+ gar.get(i).getGarantia().size());
                        lbEstadoGarntia.setText("Estado: Activo");
                        lbCaixaEntrada.setText("Entrada da Garantia: ");
                        nome = String.valueOf(modelo.get(index));
                    }
                }
            }
        });
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btVoltar)
            dispose();
        if(e.getSource()==btVenderGarantia){
            if(checkAutorizacao.isSelected()){
                if(nome!= null){
                    new GarantiaDAO().removerGarantia(nome);
                    new FinancasDAO().pagarDividida(nome);
                    
                }else{
                    JOptionPane.showMessageDialog(null, "Erro!!!! Nenhum cliente encontrado", "Mensagem", JOptionPane.ERROR_MESSAGE);

                }
            }else{
                JOptionPane.showMessageDialog(null, "Leilao nao autorizado!", "Mensagem", JOptionPane.ERROR_MESSAGE);
                
            }
        }
        checkAutorizacao.setSelected(false);
    }
}