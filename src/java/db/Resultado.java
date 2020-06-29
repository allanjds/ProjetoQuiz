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
    private String date;

    public Resultado(String user, int result, String date) {
        this.user = user;
        this.result = result;
        this.date = date;
    }

    public static ArrayList<Resultado> listaResultados() throws Exception {
        ArrayList<Resultado> list = new ArrayList<>();

        Class.forName(DbConfig.CLASS_NAME);

        Connection con = DriverManager.getConnection(DbConfig.URL);
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * from results order by date ASC");

        while (rs.next()) {
            list.add(new Resultado(
                    rs.getString("user"),
                    rs.getInt("result"),
                    rs.getString("date")
            ));
        }

        rs.close();
        stmt.close();
        con.close();

        return list;
    }

    public static ArrayList<Resultado> listaTop10() throws Exception {
        ArrayList<Resultado> list = new ArrayList<>();

        Class.forName(DbConfig.CLASS_NAME);

        Connection con = DriverManager.getConnection(DbConfig.URL);
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM results ORDER BY result DESC LIMIT 10");

        while (rs.next()) {
            list.add(new Resultado(
                    rs.getString("user"),
                    rs.getInt("result"),
                    rs.getString("date")
            ));
        }

        rs.close();
        stmt.close();
        con.close();

        return list;
    }

    public static ArrayList<Resultado> listaResultadosUsuario(String usuario) throws Exception {
        ArrayList<Resultado> list = new ArrayList<>();

        Class.forName(DbConfig.CLASS_NAME);

        Connection con = DriverManager.getConnection(DbConfig.URL);
        String sql = "SELECT * FROM results where user = ? ORDER BY date DESC LIMIT 10";

        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, usuario);

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            list.add(new Resultado(
                    rs.getString("user"),
                    rs.getInt("result"),
                    rs.getString("date")
            ));
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

}
