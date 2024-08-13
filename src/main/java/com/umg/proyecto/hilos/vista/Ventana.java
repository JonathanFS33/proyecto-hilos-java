package com.umg.proyecto.hilos.vista;

/**
 *
 * @author Jonathan
 */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

public class Ventana extends javax.swing.JFrame implements ActionListener {
    
    Graphics g;
    
    private int img1x = 100;
    private int img2y = 300;
    private int img2x = 100;
    private int img3x = 700;
    private int img3y = 200;
    private boolean avanzar = true;
    private boolean avanzar2 = true;
    private boolean avanzar3 = true;
    private int burguers = 5;
    
    ProductorConsumidor pc = new ProductorConsumidor();
    Thread consumidor1;
    Thread consumidor2;
//    Thread producto;
    Thread productor;
    
    public Ventana() {
        initComponents();
        //obtener gráficos del panel
        g = panelAlgoritmo.getGraphics();
        //setear el objeto gráfico
        img1.setLocation(100, 100);
        img2.setLocation(100, 300);
        imgProducer.setLocation(700, 200);
        panelAlgoritmo.paintComponents(g);
        btnStart.addActionListener(this);
        btnStop.addActionListener(this);
    }
    
    class ProductorConsumidor {
        private int bandera = 0;
        private boolean first = true;
        
        private int burguerx = 220;
        private int burguery = 200;
        private int counter = 0;
        private int countBurguerPosition = 280;
        Random random = new Random();
        
        int randomIntInRange;

        
        public synchronized void run() throws InterruptedException {
            while(true){
                
                
                while(randomIntInRange == 1 || burguers == 0){
                        wait();
                    }
                
                //dibujar circulo
                panelAlgoritmo.repaint();
                img1.setLocation(img1x, img1x);
                
                if (img1x == 100) {
                    avanzar = true;
                                  
                    randomIntInRange = random.nextInt(2);   

                    System.out.println(burguers);
                    
                }
                
                else if(img1x == 200){
                    avanzar = false;
                    if(burguers == 5){
                        burguer1.setVisible(false);
                        burguers--;
                    }
                    else if(burguers == 4){
                        burguer2.setVisible(false);
                        burguers--;
                    }
                    else if(burguers == 3){
                        burguer3.setVisible(false);
                        burguers--;
                    }
                    else if(burguers == 2){
                        burguer4.setVisible(false);
                        burguers--;
                    }
                    else if(burguers == 1){
                        burguer5.setVisible(false);
                        burguers--;
                    }
                    
                } 
                
                

                if(avanzar){
                    img1x += 1;
                } else{
                    img1x -= 1;
                }
               
                notify();

                Thread.sleep(10);
            }
        }
        
        public synchronized void run2() throws InterruptedException {
            while(true){
                
                
                
                while(randomIntInRange == 0 || burguers == 0){
                        wait();
                    }

                //dibujar circulo
                panelAlgoritmo.repaint();
                img2.setLocation(img2x, img2y);
                
                if (img2x == 100) {
                    avanzar2 = true;
                    
                    randomIntInRange = random.nextInt(2);                
                       
                    
                    System.out.println(burguers);
                }
                
                
                
                else if(img2x == 200){
                    avanzar2 = false;
                    if(burguers == 5){
                        burguer1.setVisible(false);
                        burguers--;
                    }
                    else if(burguers == 4){
                        burguer2.setVisible(false);
                        burguers--;
                    }
                    else if(burguers == 3){
                        burguer3.setVisible(false);
                        burguers--;
                    }
                    else if(burguers == 2){
                        burguer4.setVisible(false);
                        burguers--;
                    }
                    else if(burguers == 1){
                        burguer5.setVisible(false);
                        burguers--;
                    }
                }
                
                
                
                
                
                if(avanzar2){
                    img2x += 1;
                    img2y -= 1;
                } else{
                    img2x -= 1;
                    img2y += 1;
                }
               
                

                notify();

                Thread.sleep(10);


            }
        }
        
        public synchronized void productor() throws InterruptedException {
            while(true){
                
                while (burguers != 0){
                    wait();
                }
                
                panelAlgoritmo.repaint();
                imgProducer.setLocation(img3x, img3y);
                
                if(img3x == 700){
                  avanzar = false;
                  if(counter == 1){
                     burguers = 5;
                     counter = 0;
                  }
                }
                else if(img3x == 500) {
                    avanzar = true;
                    burguer5.setVisible(true);
                    burguer4.setVisible(true);
                    Thread.sleep(100);
                    burguer3.setVisible(true);
                    Thread.sleep(100);
                    burguer2.setVisible(true);
                    Thread.sleep(100);
                    burguer1.setVisible(true);
                    burguer1.setLocation(burguerx, burguery);
                    burguer2.setLocation(burguerx+70, burguery);
                    burguer3.setLocation(burguerx+140, burguery);
                    burguer4.setLocation(burguerx+210, burguery);
                    burguer5.setLocation(burguerx+280, burguery);
                    counter = 1;

                }
                
                if(avanzar == false){
                    img3x--;
                } else{
                    img3x++;
                }
                
                System.out.println(burguers);
                
                
                notify();
                Thread.sleep(10);
            }
        }
        
//        public synchronized void producto() throws InterruptedException {
//            while(true){
//                panelAlgoritmo.repaint();
//                burguer1.setLocation(burguerx, burguery);
//                burguer2.setLocation(burguerx+70, burguery);
//                burguer3.setLocation(burguerx+140, burguery);
//                burguer4.setLocation(burguerx+210, burguery);
//                burguer5.setLocation(burguerx+280, burguery);
//                
//                if(burguer1.isVisible() == false ){
//                    if(countBurguerPosition != 0){
//                        burguerx--;
//                        countBurguerPosition --;
//                        while(countBurguerPosition == 210){
//                            wait();
//                        }
//                    }
//                }
//                if(burguer2.isVisible() == false ){
//                    if(countBurguerPosition != 0){
//                        burguerx--;
//                        countBurguerPosition --;
//                        while(countBurguerPosition == 140){
//                            wait();
//                        }
//                    }
//                }
//                if(burguer3.isVisible() == false ){
//                    if(countBurguerPosition != 0){
//                        burguerx--;
//                        countBurguerPosition --;
//                        while(countBurguerPosition == 70){
//                            wait();
//                        }
//                    }
//                }
//                if(burguer4.isVisible() == false ){
//                    if(countBurguerPosition != 0){
//                        burguerx--;
//                        countBurguerPosition --;
//                        while(countBurguerPosition == 0){
//                            wait();
//                        }
//                    }
//                }
//                if(burguer5.isVisible() == false ){
//                    if(countBurguerPosition != 0){
//                        burguerx--;
//                        countBurguerPosition --;
//                        while(countBurguerPosition == -70){
//                            wait();
//                        }
//                    }
//                }
//                
//                notify();
//                Thread.sleep(10);
//            }
//        }
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
        btnStart = new javax.swing.JButton();
        btnStop = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelAlgoritmo.setBackground(new java.awt.Color(204, 255, 255));
        panelAlgoritmo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        panelAlgoritmo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        img1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/user.png"))); // NOI18N
        panelAlgoritmo.add(img1, new org.netbeans.lib.awtextra.AbsoluteConstraints(107, 105, -1, -1));

        img2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/user.png"))); // NOI18N
        panelAlgoritmo.add(img2, new org.netbeans.lib.awtextra.AbsoluteConstraints(107, 280, -1, -1));

        burguer1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/burguer.png"))); // NOI18N
        panelAlgoritmo.add(burguer1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 200, -1, -1));

        burguer2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/burguer.png"))); // NOI18N
        panelAlgoritmo.add(burguer2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 200, -1, -1));

        burguer3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/burguer.png"))); // NOI18N
        panelAlgoritmo.add(burguer3, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 200, -1, -1));

        burguer4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/burguer.png"))); // NOI18N
        panelAlgoritmo.add(burguer4, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 200, -1, -1));

        burguer5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/burguer.png"))); // NOI18N
        panelAlgoritmo.add(burguer5, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 200, -1, -1));

        imgProducer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/chef.png"))); // NOI18N
        panelAlgoritmo.add(imgProducer, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 200, -1, -1));

        jPanel1.add(panelAlgoritmo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, 900, 400));

        btnStart.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnStart.setText("INICIAR");
        jPanel1.add(btnStart, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 20, 140, 40));

        btnStop.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnStop.setText("DETENER");
        jPanel1.add(btnStop, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 20, 130, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 994, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 502, Short.MAX_VALUE)
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel panelAlgoritmo;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnStart) {
            
            this.consumidor2 = new Thread( () -> {
            try {
                pc.run2();
            } catch (InterruptedException ex) {
                Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
            }
            });
            
            this.consumidor1 = new Thread( () -> {
                try {
                    pc.run();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
            
        //        this.producto = new Thread( () -> {
        //            try {
        //                pc.producto();
        //            } catch (InterruptedException ex) {
        //                Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
        //            }
        //        });
        
            this.productor = new Thread( () -> {
                try {
                    pc.productor();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
            
            //iniciar el hilo
            consumidor1.start();
            consumidor2.start();
            //producto.start();
            productor.start();
        }
        if (e.getSource() == btnStop) {
            //detener hilo de animacion y limpiar el panel
            consumidor1.interrupt();
            consumidor2.interrupt();
            //producto.interrupt();
            productor.interrupt();
            panelAlgoritmo.repaint();
            img1.setLocation(100, 100);
            img2.setLocation(100, 300);
            burguer1.setLocation(220, 200);
            burguer2.setLocation(290, 200);
            burguer3.setLocation(360, 200);
            burguer4.setLocation(430, 200);
            burguer5.setLocation(700, 200);
            burguer1.setVisible(true);
            burguer2.setVisible(true);
            burguer3.setVisible(true);
            burguer4.setVisible(true);
            burguer5.setVisible(true);
            burguers = 5;
        }
    }
}
