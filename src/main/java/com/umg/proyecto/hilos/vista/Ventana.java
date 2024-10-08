package com.umg.proyecto.hilos.vista;

/**
 *
 * @author Jonathan
 */
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.*;

public class Ventana extends javax.swing.JFrame implements ActionListener {

    Graphics g;

    private boolean avanzar = true;
    private boolean avanzar2 = true;

    private int burguers = 5;
    private int counter = 0;

    ProductorConsumidor pc = new ProductorConsumidor();
    Thread consumidor1;
    Thread consumidor2;
    Thread productor;

    public Ventana() {
        initComponents();
        //obtener gráficos del panel
        g = panelAlgoritmo.getGraphics();
        verde1.setVisible(false);
        verde2.setVisible(false);
        rojo1.setVisible(true);
        rojo2.setVisible(true);
        btnStart.addActionListener(this);
        btnStop.addActionListener(this);
    }

    class ProductorConsumidor {

        public void audio() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
            File file = new File("src/main/resources/cash (1).wav");
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);

            clip.start();
        }

        private int burguerx = 220;
        private int burguery = 200;
        private int img1x = 0;
        private int img1y = 200;
        private int localImg1x;
        private int localImg2x;
        private int localImg2y;

        Random random = new Random();

        int randomIntInRange;

        int randomTime;

        private int img2y = 300;
        private int img2x = 100;
        private int img3x = 700;
        private int img3y = 200;

        private boolean last = false;

        public synchronized void run() throws InterruptedException {
            while (true) {

                while (randomIntInRange == 1 || burguers == 0) { 
                    wait();
                }

                if (localImg1x != 200) {
                    img1.setLocation(img1x, img1y);
                }

                if (img1x == 0) {
                    avanzar = true;

                    randomIntInRange = random.nextInt(2);

                    System.out.println(burguers);

                    if (last == true) {
                        last = false;
                        burguers--;
                    }

                } else if (img1x == 200) {

                    randomTime = random.nextInt(900) + 100;

                    try {
                        audio();
                    } catch (UnsupportedAudioFileException ex) {
                        Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (LineUnavailableException ex) {
                        Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    Thread.sleep(randomTime);
                    avanzar = false;

                    if (burguers == 5) {
                        burguer1.setVisible(false);
                        burguers--;

                        for (int i = 0; i <= 70; i++) {
                            Thread.sleep(10);
                            burguer2.setLocation(290 - i, 200);
                            burguer3.setLocation(360 - i, 200);
                            burguer4.setLocation(430 - i, 200);
                            burguer5.setLocation(500 - i, 200);

                            img1.setLocation(localImg1x, img1y);
                        }

                    } else if (burguers == 4) {
                        burguer2.setVisible(false);

                        burguers--;

                        for (int i = 0; i <= 70; i++) {
                            Thread.sleep(10);
                            burguer3.setLocation(290 - i, 200);
                            burguer4.setLocation(360 - i, 200);
                            burguer5.setLocation(430 - i, 200);

                            img1.setLocation(localImg1x, img1y);
                        }

                    } else if (burguers == 3) {
                        burguer3.setVisible(false);

                        burguers--;

                        for (int i = 0; i <= 70; i++) {
                            Thread.sleep(10);
                            burguer4.setLocation(290 - i, 200);
                            burguer5.setLocation(360 - i, 200);

                            img1.setLocation(localImg1x, img1y);
                        }

                    } else if (burguers == 2) {
                        burguer4.setVisible(false);

                        burguers--;

                        for (int i = 0; i <= 70; i++) {
                            Thread.sleep(10);
                            burguer5.setLocation(290 - i, 200);

                            img1.setLocation(localImg1x, img1y);
                        }

                    } else if (burguers == 1) {
                        last = true;
                        burguer5.setVisible(false);

                    }

                }

                if (avanzar) {
                    img1x += 2;
                    localImg1x = img1x;
                } else {
                    img1x -= 2;
                    localImg1x = img1x;
                }

                notify();

                Thread.sleep(10);
            }
        }

        public synchronized void run2() throws InterruptedException {
            while (true) {

                while (randomIntInRange == 0 || burguers == 0) {
                    wait();
                }

                img2.setLocation(img2x, img2y);

                if (img2x == 100) {
                    avanzar2 = true;

                    randomIntInRange = random.nextInt(2);

                    System.out.println(burguers);

                    if (last == true) {
                        last = false;
                        burguers--;
                    }

                } else if (img2x == 200) {
                    randomTime = random.nextInt(900) + 100;

                    try {
                        audio();
                    } catch (UnsupportedAudioFileException ex) {
                        Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (LineUnavailableException ex) {
                        Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    Thread.sleep(randomTime);
                    avanzar2 = false;

                    if (burguers == 5) {
                        burguer1.setVisible(false);

                        burguers--;

                        for (int i = 0; i <= 70; i++) {
                            Thread.sleep(10);
                            burguer2.setLocation(290 - i, 200);
                            burguer3.setLocation(360 - i, 200);
                            burguer4.setLocation(430 - i, 200);
                            burguer5.setLocation(500 - i, 200);

                            img2.setLocation(localImg2x, localImg2y);
                        }

                    } else if (burguers == 4) {
                        burguer2.setVisible(false);

                        burguers--;

                        for (int i = 0; i <= 70; i++) {
                            Thread.sleep(10);
                            burguer3.setLocation(290 - i, 200);
                            burguer4.setLocation(360 - i, 200);
                            burguer5.setLocation(430 - i, 200);

                            img2.setLocation(localImg2x, localImg2y);
                        }

                    } else if (burguers == 3) {
                        burguer3.setVisible(false);

                        burguers--;

                        for (int i = 0; i <= 70; i++) {
                            Thread.sleep(10);
                            burguer4.setLocation(290 - i, 200);
                            burguer5.setLocation(360 - i, 200);

                            img2.setLocation(localImg2x, localImg2y);
                        }

                    } else if (burguers == 2) {
                        burguer4.setVisible(false);

                        burguers--;

                        for (int i = 0; i <= 70; i++) {
                            Thread.sleep(10);
                            burguer5.setLocation(290 - i, 200);

                            img2.setLocation(localImg2x, localImg2y);
                        }

                    } else if (burguers == 1) {
                        last = true;
                        burguer5.setVisible(false);

                    }
                }

                if (avanzar2) {
                    img2x += 1;
                    img2y -= 1;

                    localImg2x = img2x;
                    localImg2y = img2y;
                } else {
                    img2x -= 1;
                    img2y += 1;

                    localImg2x = img2x;
                    localImg2y = img2y;
                }

                notify();

                Thread.sleep(10);
            }
        }

        public synchronized void productor() throws InterruptedException {
            while (true) {

                while (burguers != 0) {
                    verde1.setVisible(false);
                    rojo1.setVisible(true);
                    verde2.setVisible(true);
                    rojo2.setVisible(false);
                    wait();
                }

                //imgProducer.setLocation(localImg3x, img3y);
                imgProducer.setLocation(img3x, img3y);

                verde1.setVisible(true);
                rojo1.setVisible(false);
                verde2.setVisible(false);
                rojo2.setVisible(true);

                if (img3x == 700) {
                    avanzar = false;
                    if (counter == 1) {
                        burguers = 5;
                        counter = 0;
                    }
                } else if (img3x == 500) {
                    avanzar = true;

                    randomTime = random.nextInt(400) + 100;

                    Thread.sleep(randomTime);
                    burguer5.setVisible(true);

                    burguer5.setLocation(burguerx + 280, burguery);

                    Thread.sleep(randomTime);
                    burguer4.setVisible(true);

                    for (int i = 0; i <= 70; i++) {
                        burguer4.setLocation(burguerx + 280 - (i), burguery);
                        Thread.sleep(10);
                    }

                    Thread.sleep(randomTime);

                    burguer3.setVisible(true);

                    for (int i = 0; i <= 70; i++) {
                        burguer3.setLocation(burguerx + 280 - (i * 2), burguery);
                        Thread.sleep(10);
                    }

                    Thread.sleep(randomTime);
                    burguer2.setVisible(true);

                    for (int i = 0; i <= 70; i++) {
                        burguer2.setLocation(burguerx + 280 - (i * 3), burguery);
                        Thread.sleep(10);
                    }

                    Thread.sleep(randomTime);
                    burguer1.setVisible(true);

                    for (int i = 0; i <= 70; i++) {
                        burguer1.setLocation(burguerx + 280 - (i * 4), burguery);
                        Thread.sleep(10);
                    }

                    counter = 1;

                }

                if (avanzar == false) {
                    img3x--;
                } else {
                    img3x++;
                }

                notify();
                Thread.sleep(10);
            }
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        panelAlgoritmo = new javax.swing.JPanel();
        img1 = new javax.swing.JLabel();
        img2 = new javax.swing.JLabel();
        burguer1 = new javax.swing.JLabel();
        burguer2 = new javax.swing.JLabel();
        burguer3 = new javax.swing.JLabel();
        burguer4 = new javax.swing.JLabel();
        burguer5 = new javax.swing.JLabel();
        imgProducer = new javax.swing.JLabel();
        verde1 = new javax.swing.JPanel();
        rojo1 = new javax.swing.JPanel();
        rojo2 = new javax.swing.JPanel();
        verde2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnStart = new javax.swing.JButton();
        btnStop = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        panelAlgoritmo.setBackground(new java.awt.Color(102, 204, 255));
        panelAlgoritmo.setLayout(null);

        img1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/user (1).png"))); // NOI18N
        panelAlgoritmo.add(img1);
        img1.setBounds(0, 200, 64, 64);

        img2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/user (2).png"))); // NOI18N
        panelAlgoritmo.add(img2);
        img2.setBounds(100, 300, 64, 64);

        burguer1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/burguer.png"))); // NOI18N
        burguer1.setMinimumSize(new java.awt.Dimension(0, 0));
        burguer1.setPreferredSize(null);
        panelAlgoritmo.add(burguer1);
        burguer1.setBounds(220, 200, 32, 32);

        burguer2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/burguer.png"))); // NOI18N
        burguer2.setPreferredSize(null);
        panelAlgoritmo.add(burguer2);
        burguer2.setBounds(290, 200, 32, 32);

        burguer3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/burguer.png"))); // NOI18N
        burguer3.setPreferredSize(null);
        panelAlgoritmo.add(burguer3);
        burguer3.setBounds(360, 200, 32, 32);

        burguer4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/burguer.png"))); // NOI18N
        burguer4.setPreferredSize(null);
        panelAlgoritmo.add(burguer4);
        burguer4.setBounds(430, 200, 32, 32);

        burguer5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/burguer.png"))); // NOI18N
        burguer5.setPreferredSize(null);
        panelAlgoritmo.add(burguer5);
        burguer5.setBounds(500, 200, 32, 32);

        imgProducer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/chef (1).png"))); // NOI18N
        imgProducer.setPreferredSize(null);
        panelAlgoritmo.add(imgProducer);
        imgProducer.setBounds(700, 200, 64, 64);

        verde1.setBackground(new java.awt.Color(0, 255, 0));
        verde1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        verde1.setLayout(null);
        panelAlgoritmo.add(verde1);
        verde1.setBounds(590, 130, 32, 32);

        rojo1.setBackground(new java.awt.Color(255, 0, 0));
        rojo1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        rojo1.setLayout(null);
        panelAlgoritmo.add(rojo1);
        rojo1.setBounds(630, 130, 32, 32);

        rojo2.setBackground(new java.awt.Color(255, 0, 0));
        rojo2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        rojo2.setLayout(null);
        panelAlgoritmo.add(rojo2);
        rojo2.setBounds(210, 130, 32, 32);

        verde2.setBackground(new java.awt.Color(0, 255, 0));
        verde2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        verde2.setLayout(null);
        panelAlgoritmo.add(verde2);
        verde2.setBounds(250, 130, 32, 32);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/plate.png"))); // NOI18N
        panelAlgoritmo.add(jLabel1);
        jLabel1.setBounds(485, 230, 70, 20);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/plate.png"))); // NOI18N
        panelAlgoritmo.add(jLabel2);
        jLabel2.setBounds(205, 230, 70, 20);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/plate.png"))); // NOI18N
        panelAlgoritmo.add(jLabel3);
        jLabel3.setBounds(275, 230, 70, 20);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/plate.png"))); // NOI18N
        panelAlgoritmo.add(jLabel4);
        jLabel4.setBounds(345, 230, 70, 20);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/plate.png"))); // NOI18N
        panelAlgoritmo.add(jLabel5);
        jLabel5.setBounds(415, 230, 70, 20);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/table.png"))); // NOI18N
        panelAlgoritmo.add(jLabel6);
        jLabel6.setBounds(200, 250, 350, 150);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/puesto.png"))); // NOI18N
        panelAlgoritmo.add(jLabel7);
        jLabel7.setBounds(490, -80, 410, 500);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/street (1).jpg"))); // NOI18N
        panelAlgoritmo.add(jLabel8);
        jLabel8.setBounds(0, 0, 900, 400);

        jPanel1.add(panelAlgoritmo);
        panelAlgoritmo.setBounds(50, 80, 900, 400);

        btnStart.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnStart.setText("INICIAR");
        jPanel1.add(btnStart);
        btnStart.setBounds(230, 20, 140, 40);

        btnStop.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnStop.setText("DETENER");
        jPanel1.add(btnStop);
        btnStop.setBounds(610, 20, 130, 40);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 994, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 502, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnStart;
    private javax.swing.JButton btnStop;
    private javax.swing.JLabel burguer1;
    private javax.swing.JLabel burguer2;
    private javax.swing.JLabel burguer3;
    private javax.swing.JLabel burguer4;
    private javax.swing.JLabel burguer5;
    private javax.swing.JLabel img1;
    private javax.swing.JLabel img2;
    private javax.swing.JLabel imgProducer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel panelAlgoritmo;
    private javax.swing.JPanel rojo1;
    private javax.swing.JPanel rojo2;
    private javax.swing.JPanel verde1;
    private javax.swing.JPanel verde2;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnStart) {

            this.consumidor2 = new Thread(() -> {
                try {
                    pc.run2();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
                }
            });

            this.consumidor1 = new Thread(() -> {
                try {
                    pc.run();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
                }
            });

            this.productor = new Thread(() -> {
                try {
                    pc.productor();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
                }
            });

            verde2.setVisible(true);
            rojo2.setVisible(false);

            //iniciar el hilo
            consumidor1.start();
            consumidor2.start();
            productor.start();
        }
        if (e.getSource() == btnStop) {
            //detener hilo de animacion y limpiar el panel
            consumidor1.interrupt();
            consumidor2.interrupt();
            productor.interrupt();

        }
    }
}