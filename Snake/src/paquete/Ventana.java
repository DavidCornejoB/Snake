/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
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
    private int puntaje;
    private JLabel lblpuntaje;
    private Random numero;
    private Timer t;
    private JFrame vPuntaje;
    boolean bandera = true, bandera2 = true, bandera3 = true, bandera4 = true;
    int a = 0, c = 0, x = 0;
    int cont1 = 0, cont2 = 0, cont3 = 0, cont4 = 0;

    public void iniciaComponentes() {

        ventana = new JFrame("Snake");
        ventana.setSize(400, 400);
        ventana.setBackground(Color.CYAN);
        ventana.setLocationRelativeTo(this);
        ventana.addKeyListener(this);
        ventana.setResizable(false);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



        paneles = new ArrayList<JPanel>();
        panelInicial = new JPanel(new GridLayout(25, 25));
        numero = new Random();
        x = numero.nextInt(624);
        System.out.println(x);
        vPuntaje = new JFrame(":v");
        vPuntaje.setBounds(280, 185, 180, 60);
        vPuntaje.setDefaultCloseOperation(0);
        
        this.lblpuntaje = new JLabel("Puntaje: 0");
        vPuntaje.add(lblpuntaje);
        vPuntaje.setVisible(true);
        
        
        for (int i = 0; i < 625; i++) {
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
        t = new Timer(250, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    if (c == 1 && bandera2 == true) {
                        for (int i = 24; i < 625; i += 25) {
                            if (a == i) {
                                paneles.get(a).setBackground(Color.black);
                                a = a - 25;
                                break;
                            }
                        }
                        a = a + 1;
                        paneles.get(a).setBackground(Color.yellow);
                        paneles.get(a - 1).setBackground(Color.black);
                    }

                    if (c == 2 && bandera == true) {
                        for (int i = 0; i < 601; i += 25) {
                            if (a == i) {
                                paneles.get(a).setBackground(Color.black);
                                a = a + 25;
                                break;
                            }
                        }
                        a = a - 1;
                        paneles.get(a).setBackground(Color.yellow);
                        paneles.get(a + 1).setBackground(Color.black);
                    }

                    if (c == 3) {
                        a = a + 25;
                        paneles.get(a).setBackground(Color.yellow);
                        paneles.get(a - 25).setBackground(Color.black);
                    }

                    if (c == 4) {
                        a = a - 25;
                        paneles.get(a).setBackground(Color.yellow);
                        paneles.get(a + 25).setBackground(Color.black);
                    }
                } catch (IndexOutOfBoundsException err) {
                    System.out.println("error");
                    if (c == 3) {
                        t.stop();
                        paneles.get(a - 25).setBackground(Color.black);
                        a = a - 625;
                        paneles.get(a).setBackground(Color.yellow);
                        t.start();
                    } else if (c == 4) {
                        t.stop();
                        paneles.get(a + 25).setBackground(Color.black);
                        a = a + 625;
                        paneles.get(a).setBackground(Color.yellow);
                        t.start();
                    }
                }

                if (a == x) {
                    paneles.get(a - 1).setBackground(Color.yellow);
                    x = numero.nextInt(399);
                    paneles.get(x).setBackground(Color.CYAN);
                    puntaje = puntaje + 10;
                    lblpuntaje.setText("Puntaje: " + puntaje);
                }
            }
        });
    }

    @Override

    public void keyTyped(KeyEvent ke) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == 39 && bandera2 == true) {
            t.start();
            c = 1;
            System.out.println("derecha");
            bandera = false;
            bandera3 = true;
            bandera4 = true;
        }
        if (e.getKeyCode() == 37 && bandera == true) {
            t.start();
            c = 2;
            System.out.println("izquierda");
            bandera2 = false;
            bandera3 = true;
            bandera4 = true;
        }
        if (e.getKeyCode() == 40 && bandera4 == true) {
            t.start();
            c = 3;
            System.out.println("abajo");
            bandera3 = false;
            bandera = true;
            bandera2 = true;

        }
        if (e.getKeyCode() == 38 && bandera3 == true) {
            t.start();
            c = 4;
            System.out.println("arriba");
            bandera4 = false;
            bandera = true;
            bandera2 = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent ke) {
    }

    
}
