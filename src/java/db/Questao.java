/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import web.DbConfig;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Gabriel
 */
public class Questao {

    private String enunciated;
    private String answer;

    public Questao(String enunciated, String answer) {
        this.enunciated = enunciated;
        this.answer = answer;
    }

    public static ArrayList<Questao> listaQuestoes() throws Exception {
        ArrayList<Questao> list = new ArrayList<>();

        Class.forName(DbConfig.CLASS_NAME);

        Connection con = DriverManager.getConnection(DbConfig.URL);
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * from questions");

        while (rs.next()) {
            list.add(new Questao(rs.getString("enunciated"), rs.getString("answer")));
        }

        rs.close();
        stmt.close();
        con.close();

        return list;
    }

    public static int geraNumeroRandom() {
        return (int) (Math.random() * ((150 - 0) + 1)) + 0;
    }

    public String getEnunciated() {
        return enunciated;
    }

    public void setEnunciated(String enunciated) {
        this.enunciated = enunciated;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

}
