/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sbmicrocredito.view;

import com.sbmicrocredito.controler.ClienteDAO;
import com.sbmicrocredito.controler.FuncionarioDAO;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Djudju
 */
public class TelaEstatistica extends JFrame implements ActionListener {
    ImageIcon iconVoltar = new ImageIcon(getClass().getResource("voltar.png"));
    
    Font font = new Font("Arial", Font.BOLD, 17);
    Font font2 = new Font("Arial", Font.BOLD, 30);
    
    Toolkit tk = Toolkit.getDefaultToolkit();
    Dimension d = tk.getScreenSize();
    
    JPanel painel;
    ChartPanel painelGrafico;
    
    JLabel lbEstatistia;
    
    JButton btVoltar;
    public TelaEstatistica(){
        this.imagemFundo();
        this.label();
        this.criarGrafico();
        this.butao();
        configuracaoPainel();
        this.configuracaoTela();
        
    }
    private void configuracaoTela(){
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setUndecorated(true);
        setLayout(null);
        setVisible(true);
    }
    private void configuracaoPainel(){
        painel = new JPanel();
        painel.setBounds((d.width-1080)/2, (d.height-720)/2, 1080, 720);
        painel.setBackground(Color.WHITE);
        painel.setBorder(BorderFactory.createMatteBorder(75, 2, 2, 2, new Color(0, 153, 153)));
        painel.setLayout(null);
        painel.setBackground(new Color(23, 54, 93));
        add(painel);
        
        painel.add(btVoltar);
        painel.add(lbEstatistia);
        painel.add(painelGrafico);
        
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
        lbEstatistia = new JLabel("Estatistica");
        lbEstatistia.setBounds(465, 20, 200, 25);
        lbEstatistia.setForeground(Color.WHITE);
        lbEstatistia.setFont(font2);
    }
    private final void criarGrafico(){
        DefaultCategoryDataset barra = new DefaultCategoryDataset();
        barra.setValue(new ClienteDAO().contEmprestimos(), "Emprestimo", "");
        barra.setValue(new ClienteDAO().contEmprestimosActivos(), "Emprestimo activo", "");
        barra.setValue(new ClienteDAO().contEmprestimosNaoActivos(), "Emprestimo nao activo", "");
        barra.setValue(new FuncionarioDAO().contFuncionario(), "Funcionario", "");
        barra.setValue(new FuncionarioDAO().contFuncionarioHomem(), "F Homem", "");
        barra.setValue(new FuncionarioDAO().contFuncionarioMulher(), "F Mulher", "");
        
        JFreeChart grafico = ChartFactory.createBarChart("A", "B", "C", barra, PlotOrientation.VERTICAL, true, true, false);
        painelGrafico = new ChartPanel(grafico);
        painelGrafico.setBounds(40, 90, 1000, 590);
        
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btVoltar)
            dispose();
    }
    
}
