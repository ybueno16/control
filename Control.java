/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.control;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

/**
 *
 * @author yuri
 */
public class Control {

    public static void main(String[] args) throws UnknownHostException, IOException {
        
            String ip = "192.168.15.45";
        
            InetAddress adress = InetAddress.getByName(ip);
            System.out.println("Enviando ping para " + ip);
            if(adress.isReachable(2000)){
            
                System.out.println("Host encontrado");
            
            }
            else{
            
                System.out.println("Não foi possível chegar no host");
            
            }
        
        
        
        Enumeration<NetworkInterface> nets = null;
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
            
            
            
            
        }   
    }
}
