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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import javax.swing.JOptionPane;

/**
 *
 * @author yuri
 */
public class Ping {
    String ip = "192.168.15.45";
    public static void execute(String ip) throws UnknownHostException, IOException {
        String status = "";
        Connection con;



        System.out.println("Enviando ping para " + ip);
        if(InetAddress.getByName(ip).isReachable(2000)){
            System.out.println("Host encontrado!");
            status = "Host encontrado!";
            /*Insere dados BD*/
        }
        else{
            System.out.println("Não foi possível chegar no host");
            status = "Não foi possível chegar no host!";
            
        }
        
        
    }
    
    public Connection connectBD() throws SQLException{
    
    
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
    
    
   public void insertData() throws SQLException{
        Date dataHoraAtual = new Date();
        String data = new SimpleDateFormat("dd/MM/yyyy").format(dataHoraAtual);
        String hora = new SimpleDateFormat("HH:mm:ss").format(dataHoraAtual);      
        Ping p1 = new Ping();

        String sql = "INSERT INTO Pinger(Dia,Hora, IP_ping) VALUES(?,?,?)";

        try {
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, data);
            stmt.setString(2, hora);
            stmt.setString(2, p1.ip);


            stmt.execute(); 
            stmt.close();

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
   
   }
    
 

