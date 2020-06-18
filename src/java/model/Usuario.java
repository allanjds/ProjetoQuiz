package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import database.DbConfig;

public class Usuario {

    private String name;
    private String login;

    public Usuario(String name, String login) {
        this.name = name;
        this.login = login;
    }

    public static ArrayList<Usuario> listaUsuarios() throws Exception {
        ArrayList<Usuario> list = new ArrayList<>();

        Class.forName(DbConfig.CLASS_NAME);

        Connection con = DriverManager.getConnection(DbConfig.URL);
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM users");

        while (rs.next()) {
            list.add(new Usuario(rs.getString("name"), rs.getString("login")));
        }

        rs.close();
        stmt.close();
        con.close();

        return list;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
