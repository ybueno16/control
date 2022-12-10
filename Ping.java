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
import java.sql.ResultSet;
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
        Connection con;
        
        
        System.out.println("Enviando ping para " + ip);
        if(InetAddress.getByName(ip).isReachable(2000)){
            System.out.println("Host encontrado!");
            
             
        }
        else{
            System.out.println("Não foi possível chegar no host");
            
            
        }     
    }
    
    public long connectBD() throws SQLException{
        Date dataHoraAtual = new Date();
        String data = new SimpleDateFormat("yyyy-MM-dd").format(dataHoraAtual);
        String hora = new SimpleDateFormat("HH:mm:ss").format(dataHoraAtual);      
        Ping p1 = new Ping();
        long id = 0;
        String url = "jdbc:mysql://localhost:3306/control";
        String username = "root";
        String password = "Isacreeper1";
        System.out.println("Conectando no Banco de Dados");
        Connection con = DriverManager.getConnection(url, username, password);
        String sql = "INSERT INTO pinger(Dia, Hora, IP_ping) VALUES(?, ?, ?)";
        
        try(con) {            
          System.out.println("Conexão estabelecida");
          PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
          stmt.setString(1, data);  
          stmt.setString(2, hora); 
          stmt.setString(3, p1.ip);  
          int affectedRows = stmt.executeUpdate();
          if (affectedRows > 0) {
              try (ResultSet rs = stmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        id = rs.getLong(1);
                    }
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return id;
    }
    
    
    
    
    
    
    public long selectData() throws SQLException{         
        String url = "jdbc:mysql://localhost:3306/control";
        String username = "root";
        String password = "Isacreeper1";
        long id =0;
        Connection con = DriverManager.getConnection(url, username, password);
        String select = "SELECT hora FROM pinger WHERE id=(SELECT max(id)FROM pinger)";
        String select1 = "select hora from pinger where id=(select max(id)-1 from pinger)";
            try (Statement stmt = con.createStatement()){
                ResultSet rs = stmt.executeQuery(select);
                while (rs.next()) {
                    String lastHour = rs.getString("Hora");
                    System.out.println(lastHour);
                }
            }catch (SQLException e) {
            System.out.println(e.getMessage());
            }
            
            
            try (Statement stmt = con.createStatement()){
                ResultSet rs = stmt.executeQuery(select1);
                while (rs.next()) {
                    String horaBD = rs.getString("Hora");
                    System.out.println(horaBD);
                }
            }catch (SQLException e) {
            System.out.println(e.getMessage());
            }
        return id;
    }
        
    
            
            
}
