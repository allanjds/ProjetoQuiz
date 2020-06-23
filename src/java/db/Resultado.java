/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import web.DbConfig;

/**
 *
 * @author Gabriel
 */
public class Resultado {
    private String user;
    private int result;

    public Resultado(String user, int result) {
        this.user = user;
        this.result = result;
    }
    
    public static ArrayList<Resultado> listaResultados() throws Exception {
        ArrayList<Resultado> list = new ArrayList<>();

        Class.forName(DbConfig.CLASS_NAME);

        Connection con = DriverManager.getConnection(DbConfig.URL);
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * from results");

        while (rs.next()) {
            list.add(new Resultado(rs.getString("user"), rs.getInt("result")));
        }

        rs.close();
        stmt.close();
        con.close();

        return list;
    }
    
    public static void addResultado(String user, int result) throws Exception {
        Class.forName(DbConfig.CLASS_NAME);

        Connection con = DriverManager.getConnection(DbConfig.URL);
        String SQL = "INSERT INTO results(user, result) VALUES(?,?)";

        PreparedStatement stmt = con.prepareStatement(SQL);

        stmt.setString(1, user);
        stmt.setInt(2, result);

        stmt.execute();

        stmt.close();
        con.close();

    }
    
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }
    
    
}
