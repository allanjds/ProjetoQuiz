/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.DriverManager;
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
    private String result;

    public Resultado(String user, String result) {
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
            list.add(new Resultado(rs.getString("user"), rs.getString("result")));
        }

        rs.close();
        stmt.close();
        con.close();

        return list;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
    
    
}
