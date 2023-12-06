package com.sbmicrocredito.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

public class TelaInicial extends JFrame {

    /* Barra de progresso */
    JProgressBar barra = new JProgressBar();
    /* Toolkit para obter informações da tela */
    Toolkit tk = Toolkit.getDefaultToolkit();
    /* Dimensões da tela */
    Dimension d = tk.getScreenSize();

    /* Fonte personalizada */
    Font font = new Font("Arial", Font.BOLD, 17);

    public TelaInicial() {
        // Configuração da janela
        ImageIcon icon = new ImageIcon(getClass().getResource("iconLogo.png"));
        JLabel iconInicio = new JLabel(icon);
        iconInicio.setBounds((d.width - 300) / 2, (d.height - 300) / 2, 300, 300);
        add(iconInicio);

        /* Configuração da barra de progresso */
        barra.setBounds((d.width - 500) / 2, (d.height + 350) / 2, 500, 25);
        barra.setStringPainted(true);

        // Configuração da barra de progresso
        barra.setForeground(Color.BLACK);
        barra.setBackground(Color.WHITE);
        barra.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.yellow));
        barra.setFont(font);
        add(barra);
        new Temporizador().start(); // Inicia o temporizador

        setExtendedState(JFrame.MAXIMIZED_BOTH); // Define o tamanho da janela para maximizado
        getContentPane().setBackground(new Color(23, 54, 93)); // Define a cor de fundo da janela
        setUndecorated(true); // Remove a decoração da janela (bordas, botões de fechar, etc.)
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Fecha o aplicativo ao fechar a janela
        setResizable(true); // Permite redimensionar a janela
        setLayout(null); // Define o layout como nulo (posicionamento manual dos componentes)
        setVisible(true); // Torna a janela visível
    }

    /* Classe interna que controla o temporizador */
    public class Temporizador extends Thread {
        public void run() {
            while (barra.getValue() < 100) {
                try {
                    sleep(100);
                    barra.setValue(barra.getValue() + 2); // Incrementa o valor da barra de progresso
                } catch (InterruptedException ex) {
                }
            }
            new TelaLogin(); // Inicia a tela de login quando a barra atinge 100%
        }
    }
}
