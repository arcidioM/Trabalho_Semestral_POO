/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sbmicrocredito.view;

import com.sbmicrocredito.model.Funcionarios;
import com.sbmicrocredito.model.Relatorio;
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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class TelaRelatorio extends JFrame implements ActionListener{
    ImageIcon iconVoltar = new ImageIcon(getClass().getResource("voltar.png"));
    
    Font font = new Font("Arial", Font.BOLD, 17);
    Font font1 = new Font("Arial", Font.PLAIN, 16);
    Font font2 = new Font("Arial", Font.BOLD, 30);
    
    JButton btVoltar;
    
    JPanel painel;
    
    JLabel lbImprimirRelatorio;
    
    Toolkit tk = Toolkit.getDefaultToolkit();
    Dimension d = tk.getScreenSize();
    
    DefaultTableModel model;
    JTable table;
    JScrollPane roda;
    public TelaRelatorio(){
        this.imagemFundo();
        this.label();
        this.butao();
        this.tabelaRelatorio();
        this.ListarTabela();
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
        painel.setBackground(new Color(23, 54, 93));
        painel.setLayout(null);
        add(painel);
        painel.add(this.btVoltar);
        painel.add(this.roda);
        painel.add(this.lbImprimirRelatorio);
    }
    private final void butao(){
        btVoltar = new JButton("Voltar", iconVoltar);
        btVoltar.setBounds(940, 685, 130, 26);
        btVoltar.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
        btVoltar.setFont(font);
        btVoltar.setBackground(Color.WHITE);
        btVoltar.setFocusable(false);
        btVoltar.addActionListener(this);
    } 
    private final void label(){
        lbImprimirRelatorio = new JLabel("Imprimir relatorio");
        lbImprimirRelatorio.setBounds(415, 20, 250, 35);
        lbImprimirRelatorio.setForeground(Color.WHITE);
        lbImprimirRelatorio.setFont(font2);
        
    }
    private final void tabelaRelatorio(){
        Object[][] dados ={};
        Object [] colunas = {"ID","Nome","Valor emprestimo", "Data emprestimo", "validadade", "Data do pagamento", "classificacao"};
        model = new DefaultTableModel(dados, colunas);
        table = new JTable(model);
        table.setFont(font1);
        roda = new JScrollPane(table);
        
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        
        roda.setBounds(2, 75, 1075,605 );
        table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        table.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        table.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        table.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
        table.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
        table.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
        table.getColumnModel().getColumn(6).setCellRenderer(centerRenderer);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btVoltar)
            dispose();
    }
    private final void ListarTabela(){
        ArrayList<Relatorio> relat = new ArrayList();
        try {
            FileInputStream fileInput = new FileInputStream("Relatorio.txt");
            ObjectInputStream objInput = new ObjectInputStream(fileInput);
            
            Relatorio vic = null;
            while ((vic = (Relatorio)objInput.readObject())!= null){
               relat.add(vic);
            }
            objInput.close();
            fileInput.close();
        } catch (Exception e) {}
        
        model.setRowCount(0);
        for (int f = 0; f< relat.size(); f++){
            Object[] dados= {relat.get(f).getiD(),
                relat.get(f).getNome(),
                relat.get(f).getValorEmprestimo(),
                relat.get(f).getDataEmprestimo(),
                relat.get(f).getValidade(),
                relat.get(f).getDataPagamento(),
                relat.get(f).getClassificao()};
            model.addRow(dados);
        }
    }
    
}

