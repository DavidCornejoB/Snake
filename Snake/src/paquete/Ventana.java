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
import javax.swing.JOptionPane;
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
    boolean bandera = true, bandera2 = true, bandera3 = true, bandera4 = true, bandera5 = true, iz = false, de = false, ar = false, ab = false;
    int a = 0, c = 0, x = 0, puntajeExtra = 100, tiempo = 250, contF = 1, contC = 25;
    int cont1 = 0, cont2 = 0, cont3 = 0, cont4 = 0, aux =0, aux2 = 0;
    private int[] serpiente = new int[contF];

    public Ventana() {
        this.generarTiempo();
        t.start();
        this.iniciaComponentes();
    }

    public void generarTiempo() {
        t = new Timer(tiempo, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (bandera5 == true) { //MOVIMIENTO ALEATORIO
                    bandera5 = false;
                    c = numero.nextInt(4);
                    a = numero.nextInt(399);
                }
                //*********************************************************************
                try {

                    if (c == 0) { // INICIO DERECHA
                        de = true;
                        if (ar == true) {
                            aux = serpiente.length;
                            for (int i = 0; i < serpiente.length; i++) {
                                paneles.get(a + (25 * aux)).setBackground(Color.black);
                                aux--;
                            }
                            if (aux == 0) {
                                ar = false;
                            }
                        }
                        if (ab == true) {
                            aux = serpiente.length;
                            for (int i = 0; i < serpiente.length; i++) {
                                paneles.get(a - (25 * aux)).setBackground(Color.black);
                                aux--;
                            }
                            if (aux == 0) {
                                ab = false;
                            }
                        }
                        for (int i = 24; i < 625; i += 25) {
                            if (a == i) {
                                paneles.get(a).setBackground(Color.black);
                                a = a - 25;
                                break;
                            }
                        }
                        a = a + 1;
                        paneles.get(a).setBackground(Color.yellow);
                        if (paneles.get(a + 1).getBackground().getRed() == 255 && paneles.get(a + 1).getBackground().getGreen() == 255 && paneles.get(a + 1).getBackground().getBlue() == 0) {
                            JOptionPane.showMessageDialog(ventana, "Perdiste", "GameOver", JOptionPane.ERROR_MESSAGE);
                            perderJuego();
                        }
                        paneles.get(a - serpiente.length).setBackground(Color.black);
                        System.out.println(a);
                    } // FIN DERECHA
                    //****************************************************************
                    if (c == 1) { // INICIO IZQUIERDA
                        iz = true;
                        if (ar == true) {
                            aux = serpiente.length;
                            for (int i = 0; i < serpiente.length; i++) {
                                paneles.get(a + (25 * aux)).setBackground(Color.black);
                                aux--;
                            }
                            if (aux == 0) {
                                ar = false;
                            }
                        }
                        if (ab == true) {
                            aux = serpiente.length;
                            for (int i = 0; i < serpiente.length; i++) {
                                paneles.get(a - (25 * aux)).setBackground(Color.black);
                                aux--;
                            }
                            if (aux == 0) {
                                ab = false;
                            }
                        }
                        for (int i = 0; i < 601; i += 25) {
                            if (a == i) {
                                paneles.get(a).setBackground(Color.black);
                                a = a + 25;
                                break;
                            }
                        }
                        a = a - 1;
                        paneles.get(a).setBackground(Color.yellow);
                        if (paneles.get(a - 1).getBackground().getRed() == 255 && paneles.get(a - 1).getBackground().getGreen() == 255 && paneles.get(a - 1).getBackground().getBlue() == 0) {
                            JOptionPane.showMessageDialog(ventana, "Perdiste", "GameOver", JOptionPane.ERROR_MESSAGE);
                            perderJuego();
                        }
                        paneles.get(a + serpiente.length).setBackground(Color.black);
                        System.out.println(a);
                    } // FIN IZQUIERDA
                    //****************************************************************
                    if (c == 2) { // INICIO ABAJO
                        ab = true;
                        a = a + 25;
                        paneles.get(a).setBackground(Color.yellow);
                        if (paneles.get(a + 25).getBackground().getRed() == 255 && paneles.get(a + 25).getBackground().getGreen() == 255 && paneles.get(a + 25).getBackground().getBlue() == 0) {
                            JOptionPane.showMessageDialog(ventana, "Perdiste", "GameOver", JOptionPane.ERROR_MESSAGE);
                            perderJuego();
                        }
                        paneles.get(a - (25 * serpiente.length)).setBackground(Color.black);
                        System.out.println(a);
                    } // FIN ABAJO
                    //****************************************************************
                    if (c == 3) { // INICIO ARRIBA
                        ar = true;
                        a = a - 25;
                        paneles.get(a).setBackground(Color.yellow);
                        if (paneles.get(a - 25).getBackground().getRed() == 255 && paneles.get(a - 25).getBackground().getGreen() == 255 && paneles.get(a - 25).getBackground().getBlue() == 0) {
                            JOptionPane.showMessageDialog(ventana, "Perdiste", "GameOver", JOptionPane.ERROR_MESSAGE);
                            perderJuego();
                        }
                        paneles.get(a + (25 * serpiente.length)).setBackground(Color.black);
                        System.out.println(a);
                    } // FIN ARRIBA

                } catch (IndexOutOfBoundsException err) {// INICIO CATCH
                    if (a < 0 || a > 624) {
                        if (c == 2) {
                            paneles.get(a - 25).setBackground(Color.black);
                            a = a - 625;
                            paneles.get(a).setBackground(Color.yellow);

                        } else if (c == 3) {
                            paneles.get(a + 25).setBackground(Color.black);
                            a = a + 625;
                            paneles.get(a).setBackground(Color.yellow);

                        }
                    }
                }//FIN CATCH

                if (a > 624) {
                    a = a - 625;
                    System.out.println("salio");
                }

                if (a < 0) {
                    a = a + 625;
                    System.out.println("salio");
                }

                if (a == x) {// INICIO COMER SERPIENTE
                    do {
                        x = numero.nextInt(624);
                        if (paneles.get(x).getBackground().getRed() == 255 && paneles.get(x).getBackground().getGreen() == 255 && paneles.get(x).getBackground().getBlue() == 0) {
                            x = numero.nextInt(624);
                        }
                    } while (paneles.get(x).getBackground().getRed() == 255 && paneles.get(x).getBackground().getGreen() == 255 && paneles.get(x).getBackground().getBlue() == 0);
                    paneles.get(x).setBackground(Color.CYAN);
                    puntaje = puntaje + 10;
                    lblpuntaje.setText("Puntaje: " + puntaje);
                    contF++;
                    contC = contC + 25;
                    serpiente = new int[contF];

                    if (c == 0) { // INICIO DERECHA
                        for (int i = 0; i < serpiente.length; i++) {
                            serpiente[i] = a - i;
                        }
                    } // FIN DERECHA

                    if (c == 1) {// INICIO IZQUIERDA
                        for (int i = 0; i < serpiente.length; i++) {
                            serpiente[i] = a + i;
                        }
                    } // FIN IZQUIERDA

                    if (c == 2) { // INICIO ABAJO
                        int cont = 25;
                        for (int i = 0; i < serpiente.length; i++) {
                            serpiente[i] = a - cont;
                            cont = cont + 25;
                        }

                    } // FIN ABAJO

                    if (c == 3) { // INICIO ARRIBA
                        int cont = 25;
                        for (int i = 0; i < serpiente.length; i++) {
                            serpiente[i] = a + cont;
                            cont = cont + 25;
                        }
                    } // FIN ARRIBA

                    //repintarMapa();
                }// FIN COMER SERPIENTE

                if (puntaje >= puntajeExtra) {
                    puntajeExtra = puntajeExtra + 100;
                }

            }
        });
    }

    public void perderJuego() {
        a = 0;
        x = numero.nextInt(624);
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
        contF = 1;
        puntaje = 0;
        lblpuntaje.setText("Puntaje: " + puntaje);
        puntajeExtra = 100;
        serpiente = new int[contF];

    }

    public void repintarMapa() {
        for (int i = 0; i < 625; i++) {

            if (i == x) {
                paneles.get(i).setBackground(Color.CYAN);

            } else {
                paneles.get(i).setBackground(Color.black);
            }
        }

        for (int j = 0; j < serpiente.length; j++) {
            System.out.println(": " + serpiente[j]);
            try {
                paneles.get(serpiente[j]).setBackground(Color.yellow);
            } catch (IndexOutOfBoundsException err) {
                if (serpiente[j] < 0) {
                    serpiente[j] = serpiente[j] + 625;
                    paneles.get(serpiente[j]).setBackground(Color.yellow);
                }

                if (serpiente[j] > 624) {
                    serpiente[j] = serpiente[j] - 625;
                    paneles.get(serpiente[j]).setBackground(Color.yellow);
                }

            }

        }

    }

    public void iniciaComponentes() {

        ventana = new JFrame("Snake");
        ventana.setSize(400, 400);
        ventana.setBackground(Color.CYAN);
        ventana.setLocationRelativeTo(this);
        ventana.addKeyListener(this);
        ventana.setResizable(false);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        paneles = new ArrayList<JPanel>();
        panelInicial = new JPanel(new GridLayout(25, 25, 1, 1));
        numero = new Random();
        x = numero.nextInt(624);
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
    //**************************************************************************

    @Override
    public void keyTyped(KeyEvent ke) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == 39 && bandera2 == true) //DERECHA
        {
            t.start();
            c = 0;
            bandera = false;
            bandera3 = true;
            bandera4 = true;
        }
        if (e.getKeyCode() == 37 && bandera == true) //IZQUIERDA
        {
            t.start();
            c = 1;
            bandera2 = false;
            bandera3 = true;
            bandera4 = true;
        }
        if (e.getKeyCode() == 40 && bandera4 == true) //ABAJO
        {
            t.start();
            c = 2;
            bandera3 = false;
            bandera = true;
            bandera2 = true;

        }
        if (e.getKeyCode() == 38 && bandera3 == true) //ARRIBA
        {
            t.start();
            c = 3;
            bandera4 = false;
            bandera = true;
            bandera2 = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent ke) {
    }
}
