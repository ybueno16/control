/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.control;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalDate;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import javax.swing.JOptionPane;

/**
 *
 * @author yuri
 */
public class Ping {
    public static void execute(String ip) throws UnknownHostException, IOException {
        String status = "";
        Connection con;
        System.out.println("Enviando ping para " + ip);
        if(InetAddress.getByName(ip).isReachable(2000)){
            System.out.println("Host encontrado!");
            status = "Host encontrado!";
        }
        else{
            System.out.println("Não foi possível chegar no host");
            status = "Não foi possível chegar no host!";
        }
        
        
    }
    
    public Connection insertData() throws SQLException{
    
    
        Connection con = null;
        
        try {
        
          String url = "jdbc:mysql://localhost:3306/control?user=root&password=Isacreeper1";  
          con = DriverManager.getConnection(url);
          
        } 
        
        catch(SQLException e){
        
            JOptionPane.showMessageDialog(null,e.getMessage());
        
        }
        return con;
        
        
        


    }
        
    
 
}
