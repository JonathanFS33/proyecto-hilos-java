package com.umg.proyecto.hilos.java;

import java.util.LinkedList;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.umg.proyecto.hilos.vista.Ventana;

/**
 *
 * @author Jonathan
 */

class ProductorConsumidor {
    private Queue<Integer> espacios = new LinkedList();
    private final int capacidad = 5;
    
    public synchronized void producir() throws InterruptedException {
        int elemento = 0;
        while(true){
            while(espacios.size() == capacidad){
                wait();
            }
            System.out.println("Productor produce: "+elemento);
            espacios.add(elemento);
            elemento++;
            notify();
            Thread.sleep(1000);
        }
    }
    
    public synchronized void consumir() throws InterruptedException {
        while(true){
            while(espacios.isEmpty()){
                wait();
            }
            int elemento = espacios.poll();
            System.out.println("Consumidor consumen: "+elemento);
            notify();
            Thread.sleep(1000);
        }
    }
}

public class Main {

    public static void main(String[] args) {
        
        try {
            Ventana v = new Ventana();
            //posicion y dimensiones de la ventana
            //v.setBounds(400, 100, 800, 600);
            v.setVisible(true);
        } catch (Exception e) {
            System.out.println(e);
        }
        
//        ProductorConsumidor pc = new ProductorConsumidor();
//        Thread productor = new Thread( () -> {
//            try {
//                pc.producir();
//            } catch (InterruptedException ex) {
//                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        });
//        
//        Thread consumidor = new Thread(() -> {
//            try {
//                pc.consumir();
//            } catch (InterruptedException ex) {
//                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        });
//        
//        productor.start();
//        consumidor.start();
        
    }
    
}
