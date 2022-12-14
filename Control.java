/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license.
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.control;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author yuri
 */
public class Control {
    
    public static void main(String[] args) throws UnknownHostException, IOException, SQLException {
        
        int delay = 0;   // tempo de espera antes da 1ª execução da tarefa.
        int interval = 10000;  // intervalo no qual a tarefa será executada.
        Timer timer = new Timer();
        Ping p = new Ping();
        p.ip = "192.168.15.45";
        timer.scheduleAtFixedRate(new TimerTask() {
            
          public void run() { 
              try {
                Ping.execute(p.ip);
                p.connectBD();
                p.selectData();
              } catch (Exception ex) {
                  System.out.println("Erro interno");
              }
          }
        }, delay, interval);
        
      
        /*Enumeration<NetworkInterface> nets = null;
        try {
            nets = NetworkInterface.getNetworkInterfaces();
        } catch (SocketException ex) {
            System.err.println(ex);
        }
        do {
            NetworkInterface r = nets.nextElement();
            System.out.println("Nome completo: " + r.getDisplayName());
            System.out.println("Nome curto: " + r.getName());
        } while(nets.hasMoreElements());
        
        
        System.out.println("Available processors (cores): " + 
        Runtime.getRuntime().availableProcessors());
        System.out.println("Free memory (bytes): " + 
        Runtime.getRuntime().freeMemory());
        long maxMemory = Runtime.getRuntime().maxMemory();
        System.out.println("Maximum memory (bytes): " + 
        (maxMemory == Long.MAX_VALUE ? "no limit" : maxMemory));
        System.out.println("Total memory available to JVM (bytes): " + 
        Runtime.getRuntime().totalMemory());
        File[] roots = File.listRoots();
        for (File root : roots) {
            System.out.println("File system root: " + root.getAbsolutePath());
            System.out.println("Total space (bytes): " + root.getTotalSpace());
            System.out.println("Free space (bytes): " + root.getFreeSpace());
            System.out.println("Usable space (bytes): " + root.getUsableSpace());
            
            
            
            
        }   */
    }
}
