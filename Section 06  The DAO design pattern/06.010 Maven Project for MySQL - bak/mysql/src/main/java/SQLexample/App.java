package SQLexample;

import java.sql.SQLException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        System.out.println( "Trying to connect to the database...." );
        var db = Database.instance(); // create a Database instance called db

        try{
            db.connect();
        } catch (SQLException e) {
            System.out.println("Can't connect to the database");
        };

        System.out.println("Connected to the database");

        UserDao userDao = new UserDaoImpl();
        // userDao.save(new User("Mars")); We comment out because they are just added to the database
        // userDao.save(new User("Mercury"));
        // userDao.save(new User("Neptune"));


        try{
            db.close();
        } catch (SQLException e) {
            System.out.println("Can't close the connection");
        }

    }
}
