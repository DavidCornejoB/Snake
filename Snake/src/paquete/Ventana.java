/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Estudiante
 */
public class Ventana extends JFrame implements KeyListener {

    private JFrame ventana;
    private JPanel panelInicial;
    private ArrayList<JPanel> paneles;
    private JLabel puntaje;
    private Random numero;
    private Timer t;
    int a = 0, c = 0;
    int cont1 = 0, cont2 = 0, cont3 = 0, cont4 = 0;

    public void iniciaComponentes() {

        ventana = new JFrame("Snake");
        ventana.setSize(400, 400);
        ventana.setLocationRelativeTo(this);
        ventana.addKeyListener(this);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        paneles = new ArrayList<JPanel>();
        panelInicial = new JPanel(new GridLayout(20, 20, 1, 1));
        numero = new Random();
        int x = numero.nextInt(399);
        System.out.println(x);
        for (int i = 0; i < 400; i++) {
            paneles.add(new JPanel());
            if (i == x) {
                paneles.get(i).setBackground(Color.CYAN);
                panelInicial.add(paneles.get(i));

            } else {
                paneles.get(i).setBackground(Color.black);
                panelInicial.add(paneles.get(i));
            }
        }

        ventana.add(panelInicial);

        ventana.setVisible(true);
    }

    public void Tiempo() {
        t = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (c == 1) {                        
                        a = a + 1;
                        paneles.get(a).setBackground(Color.yellow);
                        paneles.get(a - 1).setBackground(Color.black);
                    }

                    if (c == 2) {
                        a = a - 1;
                        paneles.get(a).setBackground(Color.yellow);
                        paneles.get(a + 1).setBackground(Color.black);
                    }

                    if (c == 3) {
                        a = a + 20;
                        paneles.get(a).setBackground(Color.yellow);
                        paneles.get(a - 20).setBackground(Color.black);
                    }

                    if (c == 4) {
                        a = a - 20;
                        paneles.get(a).setBackground(Color.yellow);
                        paneles.get(a + 20).setBackground(Color.black);
                    }
                } catch (IndexOutOfBoundsException err) {
                    System.out.println("error");
                    if (c == 3) {
                        t.stop();
                        paneles.get(a - 20).setBackground(Color.black);
                        a = a - 400;
                        paneles.get(a).setBackground(Color.yellow);
                        t.start();
                    } else if (c == 4) {
                        t.stop();
                        paneles.get(a + 20).setBackground(Color.black);
                        a = a + 400;
                        paneles.get(a).setBackground(Color.yellow);
                        t.start();
                    }
                }
            }
        });
    }

    @Override

    public void keyTyped(KeyEvent ke) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == 39) {
            t.start();
            c = 1;
            System.out.println("derecha");
        }
        if (e.getKeyCode() == 37) {
            t.start();
            c = 2;
            System.out.println("izquierda");
        }
        if (e.getKeyCode() == 40) {
            t.start();
            c = 3;
            System.out.println("abajo");

        }
        if (e.getKeyCode() == 38) {
            t.start();
            c = 4;
            System.out.println("arriba");
        }
    }

    @Override
    public void keyReleased(KeyEvent ke) {
    }

}
