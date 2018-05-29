package Interface;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class lienzo extends javax.swing.JPanel implements Runnable {

    int[][] matrizGeneral;

    /**
     * Creates new form lienzo
     */
    int f = 0;
    int radioBotones = 0;

    public lienzo() {
        initComponents();
        reinicio();
    }

    Thread hilo, hilo2;
    static int filas = 10, columnas = 10, s = 4, e = 3, t = 2;
    int fil_entrada = 3, col_entrada = 0, filasalida = 8, columnaSalida = 9;
    int x = 0, y = 0, termino = 0;

    BufferedImage personaje, puerta_salida, muro, itemImage;
    URL pers = getClass().getResource("/imagenes/Running1.png");
    URL mu = getClass().getResource("/imagenes/muro.png");
    URL door = getClass().getResource("/imagenes/puerta.png");
    URL item = getClass().getResource("/imagenes/item2.png");

    public void reinicio() {
        int[][] copia = {{0, 1, 0, 0, 1, 0, 0, 0, 0, 0},
        {0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
        {1, 1, 0, 1, 1, 0, 1, 0, 0, 0},
        {e, 0, 0, 0, 1, 0, 1, 0, 0, 0},
        {1, 0, 0, 0, t, 0, 0, 0, 0, 0},
        {1, 0, 1, 0, 1, 0, 1, 0, 0, 0},
        {1, 0, 1, 1, 0, 0, 1, 0, 1, 0},
        {1, 0, 0, 0, 0, 1, 1, 0, 1, 1},
        {1, 0, 1, 0, 0, 1, 0, 0, 0, s},
        {1, t, 1, 1, 1, 1, 0, 1, 1, 1}};
        try {
            personaje = ImageIO.read(pers);
            puerta_salida = ImageIO.read(door);
            muro = ImageIO.read(mu);
            itemImage = ImageIO.read(item);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "No se pudo cargar la imagen " + e.getMessage());

        }
        matrizGeneral = copia;
        hilo = new Thread(this);
        hilo2 = new Thread(this);
        fil_entrada = 3;
        col_entrada = 0;
        filasalida = 8;
        columnaSalida = 9;
        f = 1;
        termino = 0;
        repaint();
    }

    public void aleatorio() {
        for (int i = 0; i < matrizGeneral.length; i++) {
            for (int j = 0; j < matrizGeneral.length; j++) {
                int dato = (int) (Math.random() * 1.99);
                if (i == fil_entrada && j == col_entrada) {
                    matrizGeneral[i][j] = e;

                } else if (i == filasalida && j == columnaSalida) {
                    matrizGeneral[i][j] = s;
                } else {
                    matrizGeneral[i][j] = dato;
                }
            }

        }
        int k = fil_entrada, l = col_entrada;
        while (k < filasalida || l < columnaSalida) {
            int camino = (int) (Math.random() * 1.99);
            if (camino == 0 && columnaSalida > 1) {
                matrizGeneral[k][++l] = 0;

            } else if (filasalida > k) {
                matrizGeneral[++k][l] = 0;

            } else {
                matrizGeneral[k][++l] = 0;
            }
        }
        matrizGeneral[filasalida][columnaSalida] = s;
        repaint();

    }

    public void paint(Graphics g) {

        if (f >= 1) {
            g.setColor(getBackground());
            g.fillRect(0, 0, getWidth(), getHeight());
            for (int i = 0; i < matrizGeneral.length; i++) {
                for (int j = 0; j < matrizGeneral.length; j++) {
                    g.setColor(Color.DARK_GRAY);
                    if (matrizGeneral[i][j] == 0 || matrizGeneral[i][j] == 8) {
                        g.drawRect(j * 40, i * 40, 40, 40); //pensamos que es tama;o del rectangulo, modificar

                    } else if (matrizGeneral[i][j] == 1) {
                        g.drawImage(muro, j * 40, i * 40, 40, 40, this);
                    } else if (matrizGeneral[i][j] == e) {
                        g.drawImage(personaje, j * 40, i * 40, 40, 40, this);
                    } else if (matrizGeneral[i][j] == s) {
                        g.drawImage(puerta_salida, j * 40, i * 40, 40, 40, this);
                    } else if (matrizGeneral[i][j] == t) {
                        g.drawImage(itemImage, j * 40, i * 40, 40, 40, this);
                    } else if (matrizGeneral[i][j] == 5) {
                        g.setColor(Color.yellow);
                        g.fillRect(j * 40, i * 40, 40, 40);
                        g.setColor(Color.BLUE);
                        g.drawRect(j * 40, i * 40, 40, 40);
                    }
                }
            }
        }
    }

    public boolean existeCamino(int fila, int columna) {
        if (fila < 0 || fila >= filas || columna < 0 || columna >= columnas) {
            return false;

        }
        if (matrizGeneral[fila][columna] == 5 || matrizGeneral[fila][columna] == 1) {
            return false;

        }
        return true;
    }

    public boolean resolver(int fil, int col) {
        boolean salida = false;

        try {
            Thread.sleep(600);
        } catch (Exception e) {

        }
        matrizGeneral[fil][col] = 5;
        if (fil == filasalida && col == columnaSalida) {
            return true;
        }
        //abajo
        if (!salida && existeCamino(fil + 1, col)) {
            matrizGeneral[fil + 1][col] = e;
            repaint();
            salida = resolver(fil + 1, col);
        }
        //derecha
        if (!salida && existeCamino(fil, col + 1)) {
            matrizGeneral[fil][col + 1] = e;
            repaint();
            salida = resolver(fil, col + 1);
        }
        //izquierda
        if (!salida && existeCamino(fil, col - 1)) {
            matrizGeneral[fil][col - 1] = e;
            repaint();
            salida = resolver(fil, col - 1);
        }
        //arriba
        if (!salida && existeCamino(fil - 1, col)) {
            matrizGeneral[fil - 1][col] = e;
            repaint();
            salida = resolver(fil - 1, col);
        }
        return salida;
    }

    public boolean moveritem(int fila, int columna) {
        Thread threadItem = new Thread();
        if (matrizGeneral[fila][columna] == 1) {
            threadItem.start();
            return false;
        }
        threadItem.start();
        return true;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1178, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 715, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        x = evt.getX() / 40;
        y = evt.getY() / 40;

        if (matrizGeneral[y][x] != e && matrizGeneral[y][x] != s && f == 1) {
            if (evt.getButton() == evt.BUTTON1 && radioBotones == 3) {
                matrizGeneral[y][x] = 1;

            } else if (evt.getButton() == evt.BUTTON3 && radioBotones == 3) {
                matrizGeneral[y][x] = 0;

            } else if (evt.getButton() == evt.BUTTON1 && radioBotones == 1) {
                matrizGeneral[fil_entrada][col_entrada] = 0;
                matrizGeneral[y][x] = e;
                fil_entrada = y;
                col_entrada = x;

            } else if (evt.getButton() == evt.BUTTON1 && radioBotones == 2) {
                matrizGeneral[filasalida][columnaSalida] = 0;
                matrizGeneral[y][x] = s;
                filasalida = y;
                columnaSalida = x;
            }
            repaint();
        }
    }//GEN-LAST:event_formMouseClicked

    @Override
    public void run() {

        if (resolver(fil_entrada, col_entrada)) {
            termino = 1;
            JOptionPane.showMessageDialog(null, "Felicidades, lo lograste");
        } else {
            termino = 1;
            JOptionPane.showMessageDialog(null, "No hay salida");
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
