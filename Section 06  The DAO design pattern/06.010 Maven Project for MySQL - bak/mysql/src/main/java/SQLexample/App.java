package SQLexample;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )  {
        // include the properties dp.properties file
        Properties props = new Properties();
        String propertiesFile = "/config/db.prod.properties";
        try {
            props.load(App.class.getResourceAsStream(propertiesFile));
        } catch (NullPointerException | IOException e) {
            System.out.println("Can't load properties file: " + propertiesFile);
            throw new RuntimeException(e);
        }

        System.out.println( "Trying to connect to the database...." );
        var db = Database.instance(); // create a Database instance called db

        try{
            db.connect(props);
        } catch (SQLException e) {
            System.out.println("Can't connect to the database");
        }

        System.out.println("Connected to the database");

        UserDao userDao = new UserDaoImpl();
        // userDao.save(new User("Mars")); We comment out because they are just added to the database
        // userDao.save(new User("Mercury"));
        // userDao.save(new User("Neptune"));

        var users = userDao.getAll();
        users.forEach(System.out::println);

        var userOpt = userDao.findById(6);
        if (userOpt.isPresent()) {
            System.out.println("Retrieved: " + userOpt.get());
        } else {
            System.out.println("No user retrieved");
        }

        userOpt = userDao.findById(4);

        if (userOpt.isPresent()) {

            User user = userOpt.get();
            System.out.println("Retrieved: " + user);
            user.setName("Snoopy");
            userDao.update(user);

        } else {
            System.out.println("No user retrieved");
        }

        //userDao.delete(new User(5, null));


        try{
            db.close();
        } catch (SQLException e) {
            System.out.println("Can't close the connection");
        }

    }
}
