package SQLexample;

public class Database {
    /* Singleton pattern:
    Singleton is a creational design pattern, which ensures that only one object of its kind exists and provides
    a single point of access to it for any other code.
    This pattern involves a single class which is responsible to create an object while making sure that only single object gets created.
    This class provides a way to access its only object, which can be accessed directly without need to instantiate the object of the class.
    The most popular approach is to implement a Singleton by creating a regular class and making sure it has:
        * A private constructor
        * A static field containing its only instance
        * A static factory method for obtaining the instance
     */
    private static Database db = new Database(); // create a private static Database instance called db

    public static Database instance() {  // static method that returns an object of the Database class
        return db;
    }

    private Database() { // private constructor, we can create an instance of this class only invoking the method instance() of this class

    }
}
