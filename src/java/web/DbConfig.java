package web;

import db.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import db.Questao;
import db.Resultado;

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
                    + "name VARCHAR(200) NOT NULL,"
                    + "login VARCHAR(50) UNIQUE NOT NULL,"
                    + "password_hash LONG"
                    + ")";
            stmt.executeUpdate(SQL);

            if (Usuario.listaUsuarios().isEmpty()) {
                step = "Inserindo usuário administrador";
                SQL = "INSERT INTO users VALUES('Administrador', 'admin', '" + ("admin".hashCode()) + "');";
                stmt.executeUpdate(SQL);
            }

            step = "Criando tabela de questão";
            SQL = "CREATE TABLE IF NOT EXISTS questions ("
                    + "enunciated VARCHAR(500) UNIQUE NOT NULL,"
                    + "answer VARCHAR(100) NOT NULL"
                    + ")";
            stmt.executeUpdate(SQL);

            if (Questao.listaQuestoes().isEmpty()) {
                step = "Inserindo questoes";

                SQL = "INSERT INTO questions VALUES('Descubra a lógica e complete o próximo elemento da sequência: 1, 3, 5, 7, _', '9');";
                stmt.executeUpdate(SQL);

                SQL = "INSERT INTO questions VALUES('Descubra a lógica e complete o próximo elemento da sequência: 2, 4, 8, 16, 32, 64, _', '128');";
                stmt.executeUpdate(SQL);

                SQL = "INSERT INTO questions VALUES('Descubra a lógica e complete o próximo elemento da sequência: 0, 1, 4, 9, 16, 25, 36, _', '49');";
                stmt.executeUpdate(SQL);

                SQL = "INSERT INTO questions VALUES('Descubra a lógica e complete o próximo elemento da sequência: 4, 16, 36, 64, _', '100');";
                stmt.executeUpdate(SQL);

                SQL = "INSERT INTO questions VALUES('Descubra a lógica e complete o próximo elemento da sequência:  1, 1, 2, 3, 5, 8, _', '13');";
                stmt.executeUpdate(SQL);

                SQL = "INSERT INTO questions VALUES('Descubra a lógica e complete o próximo elemento da sequência: 2, 10, 12, 16, 17, 18, 19, _', '200');";
                stmt.executeUpdate(SQL);

                SQL = "INSERT INTO questions VALUES('Descubra a lógica e complete o próximo elemento da sequência: 10, 13, 17, 22, 28, _', '35');";
                stmt.executeUpdate(SQL);

                SQL = "INSERT INTO questions VALUES('Descubra a lógica e complete o próximo elemento da sequência: 0, 5, 10, 15, 20, _', '25');";
                stmt.executeUpdate(SQL);

                SQL = "INSERT INTO questions VALUES('Descubra a lógica e complete o próximo elemento da sequência: 22, 24, 28, 34, _', '42');";
                stmt.executeUpdate(SQL);

                SQL = "INSERT INTO questions VALUES('Descubra a lógica e complete o próximo elemento da sequência: 1, 0, 2, 1, 3, 2, _', '4');";
                stmt.executeUpdate(SQL);
            }

            step = "Criando tabela de resultado";
            SQL = "CREATE TABLE IF NOT EXISTS results ("
                    + "user VARCHAR(50) NOT NULL,"
                    + "result INTEGER NOT NULL,"
                    + "date TEXT not null"
                    + ")";
            stmt.executeUpdate(SQL);

            if (Resultado.listaResultados().isEmpty()) {
                step = "Inserindo resultados admin";
                SQL = "INSERT INTO results VALUES('admin', 10, '2020-06-06');";
                stmt.executeUpdate(SQL);
                SQL = "INSERT INTO results VALUES('admin', 10, '2020-06-03');";
                stmt.executeUpdate(SQL);
                SQL = "INSERT INTO results VALUES('admin', 9, '2020-06-05');";
                stmt.executeUpdate(SQL);
                SQL = "INSERT INTO results VALUES('admin', 8, '2020-06-04');";
                stmt.executeUpdate(SQL);
                SQL = "INSERT INTO results VALUES('admin', 10, '2020-06-04');";
                stmt.executeUpdate(SQL);
                SQL = "INSERT INTO results VALUES('admin', 10, '2020-06-07');";
                stmt.executeUpdate(SQL);
                SQL = "INSERT INTO results VALUES('admin', 7, '2020-06-10');";
                stmt.executeUpdate(SQL);
                SQL = "INSERT INTO results VALUES('admin', 9, '2020-06-09');";
                stmt.executeUpdate(SQL);
                SQL = "INSERT INTO results VALUES('admin', 6, '2020-06-08');";
                stmt.executeUpdate(SQL);
                SQL = "INSERT INTO results VALUES('admin', 10, '2020-06-08');";
                stmt.executeUpdate(SQL);
                SQL = "INSERT INTO results VALUES('admin', 8, '2020-06-02');";
                stmt.executeUpdate(SQL);
                SQL = "INSERT INTO results VALUES('admin', 10, '2020-06-01');";
                stmt.executeUpdate(SQL);

                step = "Inserindo resultados exemplo";
                SQL = "INSERT INTO results VALUES('esteves', 1, '2020-06-07');";
                stmt.executeUpdate(SQL);

                SQL = "INSERT INTO results VALUES('santana', 5, '2020-06-04');";
                stmt.executeUpdate(SQL);

                SQL = "INSERT INTO results VALUES('walter', 9, '2020-06-03');";
                stmt.executeUpdate(SQL);

                SQL = "INSERT INTO results VALUES('nelson', 7, '2020-06-11');";
                stmt.executeUpdate(SQL);

                SQL = "INSERT INTO results VALUES('rodriguez', 4, '2020-06-23');";
                stmt.executeUpdate(SQL);

                SQL = "INSERT INTO results VALUES('thomas', 6, '2020-06-27');";
                stmt.executeUpdate(SQL);

                SQL = "INSERT INTO results VALUES('ramirez', 3, '2020-06-14');";
                stmt.executeUpdate(SQL);

                SQL = "INSERT INTO results VALUES('lucas', 2, '2020-06-11');";
                stmt.executeUpdate(SQL);

                SQL = "INSERT INTO results VALUES('marcos', 0, '2020-06-01');";
                stmt.executeUpdate(SQL);

                SQL = "INSERT INTO results VALUES('paulo', 8, '2020-06-18');";
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
