package database;

import model.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import model.Questao;

public class DbConfig implements ServletContextListener {

    public static final String URL = "jdbc:sqlite:C:\\ProjetoQuiz\\quiz.db";
    public static final String CLASS_NAME = "org.sqlite.JDBC";

    public static String exceptionMessage = null;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        String step = "Iniciando criação das tabelas";
        try {
            Class.forName(CLASS_NAME);
            Connection con = DriverManager.getConnection(URL);
            Statement stmt = con.createStatement();

            String SQL;

            step = "Criando tabela de usuário";
            SQL = "CREATE TABLE IF NOT EXISTS users("
                    +"idusuario INTEGER PRIMARY KEY NOT NULL,"
                    + "name VARCHAR(200) NOT NULL,"
                    + "login VARCHAR(50) UNIQUE NOT NULL,"
                    + "password_hash LONG"
                    + ")";
            stmt.executeUpdate(SQL);
            
            step = "Criando tabela de questao";
            SQL = "CREATE TABLE IF NOT EXISTS questions ("
                    + "idenunciated INTEGER PRIMARY KEY NOT NULL"
                    + "enunciated VARCHAR(500) NOT NULL,"
                    + ")";
            stmt.executeUpdate(SQL);
            
            step = "Criando tabela de resposta";
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS answer("
                    + "idanswer INTEGER PRIMARY KEY NOT NULL,"
                    + "answer VARCHAR(500) NOT NULL,"
                    + "idenunciated INTEGER NOT NULL,"
                    + "answercorreta BOOLEAN NOT NULL,"
                    + "FOREIGN KEY (idenunciated) REFERENCES questions (idenunciated)"
                    + ")");
            
            step = "Criando tabela de quiz";
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS quiz("
                    + "idquiz INTEGER PRIMARY KEY,"
                    + "idresultado INTEGER NOT NULL,"
                    + "idusuario INTEGER NOT NULL,"
                    + "FOREIGN KEY (idusuario) REFERENCES usuario(idusuario)"
                    + ")");

            if (Usuario.listaUsuarios().isEmpty()) {
                step = "Inserindo usuário administrador";
                SQL = "INSERT INTO users VALUES('Administrador', 'admin', '" + ("admin".hashCode()) + "');";
                stmt.executeUpdate(SQL);
            }

            stmt.close();
            con.close();
        } catch (Exception ex) {
            exceptionMessage = step + ": " + ex;
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }

}
