package SQLexample;
 /* Singleton pattern:
    Singleton is a creational design pattern, which ensures that only one object of its kind exists and provides
    a single point of access to it for any other code.  It is nothing but a way of defining a class.
    Class is defined in such a way that only one instance of the class is created in the complete execution of a program or project.
    It is used where only a single instance of a class is required to control the action throughout the execution. A singleton class shouldn’t have
    multiple instances in any case and at any cost. Singleton classes are used for logging, driver objects, caching and thread pool, database connections.
    This pattern involves a single class which is responsible to create an object while making sure that only single object gets created.
    This class provides a way to access its only object, which can be accessed directly without need to instantiate the object of the class.
    The most popular approach is to implement a Singleton by creating a regular class and making sure it has:
        * A private constructor
        * A static field containing its only instance
        * A static factory method for obtaining the instance
     */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

// singleton class should have public visibility so that complete application can use it
public class Database {
    // Attributes
    // static instance of type Database called db, is private because db is only accessible inside this class
    private static Database db = new Database();

    // URL is the link to the database
    private static final String URL = "jdbc:mysql://localhost:3306/people?serverTimezone=UTC";
    private Connection conn;

    // constructor
    private Database() { // private constructor, the only way we can create an instance of this class is invoking the method instance() of this class
    }

    //getter
    // return the connection class
    public Connection getConnection() {
        return conn;
    }

    //methods
    // static method that returns an object of the Database class
    public static Database instance() {
        return db;
    }

    // method to connect to a database
    // we use the db.prod.properties file to get the information of the database
    public void connect(Properties props) throws SQLException {
        String server = props.getProperty("server");
        String port = props.getProperty("port");
        String database = props.getProperty("database");
        String user = props.getProperty("user");
        String password = props.getProperty("password");
        String url = String.format("jdbc:mysql://%s:%s/%s?serverTimezone=UTC", server,port, database);
        conn = DriverManager.getConnection(URL, user, password);
    }

    // method to close the connection
    public void close() throws SQLException {
        conn.close();
    }

}
