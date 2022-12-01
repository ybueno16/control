/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.control;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Properties;

/**
 *
 * @author yuri
 */
public class Ping {
    public static void execute(String ip) throws UnknownHostException, IOException, SQLException {
        String status = "";
        System.out.println("Enviando ping para " + ip);
        if(InetAddress.getByName(ip).isReachable(2000)){
            System.out.println("Host encontrado!");
            status = "Host encontrado!";
        }
        else{
            System.out.println("Não foi possível chegar no host");
            status = "Não foi possível chegar no host!";
        }

        String url = "jdbc:postgresql://localhost/test";
        Properties props = new Properties();
        props.setProperty("user", "fred");
        props.setProperty("password", "secret");
        props.setProperty("ssl", "true");
        Connection conn = DriverManager.getConnection(url, props);

        PreparedStatement st = conn.prepareStatement("INSERT INTO pinger (ip, status) VALUES (?, ?)");
        st.setString(1, ip);
        st.setString(2, status);
        st.executeUpdate();
        st.close();

    }
}
