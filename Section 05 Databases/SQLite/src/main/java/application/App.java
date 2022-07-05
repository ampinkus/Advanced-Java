package application;

import java.sql.DriverManager;
import java.sql.SQLException;

public class App {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // The forName() method of java.lang.Class class is used to get the instance of this Class with the specified class name.
        // This class name is specified as the string parameter.
        Class.forName("org.sqlite.JDBC"); // program works even if we comment out this line
        String dbUrl = "jdbc:sqlite:people.db"; // where to locate the database, the name is people.db.  It will be seen at the project directory


        // The getConnection(String url) method of Java DriverManager class attempts to establish a connection to the database
        // by using the given database URL.
        var conn = DriverManager.getConnection(dbUrl); // the database is created here
        System.out.println(conn);

        conn.close();
    }
}
