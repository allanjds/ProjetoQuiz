/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import web.DbConfig;
import db.Resultado;
import static java.lang.String.valueOf;
import java.sql.PreparedStatement;

/**
 *
 * @author Anna
 */
public class Ranking {
      public static ArrayList<Ranking> getResult() throws SQLException{
        ArrayList<Ranking> listaRanking = new ArrayList<>();
       
       String query = "SELECT TOP 10 FROM result order by desc";
      
       Connection con = DriverManager.getConnection(DbConfig.URL);
       PreparedStatement stmt = con.prepareStatement(query);
       
       ResultSet rs = stmt.executeQuery();
       
         while (rs.next()) {
            Ranking ranking = new Ranking();
            ranking.setResult(rs.getInt("result"));
            
            listaRanking.add(ranking);
        }
        
        rs.close();
        stmt.close();
        con.close();
        
        return listaRanking;
    }
     public static ArrayList<Ranking> getUltimosTestesRealizados() throws ClassNotFoundException, SQLException{
       ArrayList<Ranking> listaRanking = new ArrayList<>();
       
       String query = "SELECT * from results "
                    + " order by results desc LIMIT 10;";
      
      
       Connection con = DriverManager.getConnection(DbConfig.URL);
       PreparedStatement stmt = con.prepareStatement(query);
       
       ResultSet rs = stmt.executeQuery();
       
        while(rs.next()){
            Ranking ranking = new Ranking();
            
            ranking.setResult(rs.getInt("result"));
            
            listaRanking.add(ranking);
        }
        
        rs.close();
        stmt.close();
        con.close();
        
        return listaRanking;
    }
     
    public static ArrayList<Ranking> getUltimosTestesRealizadosUsuario(String login) throws ClassNotFoundException, SQLException{
       ArrayList<Ranking> listaRanking = new ArrayList<>();
       
       String query = "SELECT * FROM results where login = ? order by result desc LIMIT 10";
      
       Connection con = DriverManager.getConnection(DbConfig.URL);
       PreparedStatement stmt = con.prepareStatement(query);
       
       ResultSet rs = stmt.executeQuery(login);
       
        while(rs.next()){
            Ranking ranking = new Ranking();
            ranking.setUser(valueOf(rs.getInt("user")));
            ranking.setResultado(valueOf(rs.getInt("result")));
            
            listaRanking.add(ranking);
        }
        
        rs.close();
        stmt.close();
        con.close();
        
        return listaRanking;
    }
    