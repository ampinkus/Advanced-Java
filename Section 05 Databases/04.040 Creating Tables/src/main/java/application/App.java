package application;

import java.sql.DriverManager;
import java.sql.SQLException;

public class App {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("org.sqlite.JDBC");
		
		String dbUrl = "jdbc:sqlite:people.db"; // specify which is the database we want to connect
		
		var conn = DriverManager.getConnection(dbUrl); // connect to the database specified by dbUrl
		
		var stmt = conn.createStatement(); //Creates a Statement object that is used to execute an SQL statement.
		// we create a variable with a string that is the sql command that we want to execute
		// we create a table called user with two columns: id (is an integer as the primary key), name( non null text field).
		// if user exists we don't create it again
		var sql = "create table if not exists user (id integer primary key, name text not null)";

		stmt.execute(sql); // execute the sql command
		
		sql = "drop table user"; // we delete the table (drop) from the database
		stmt.execute(sql); // execute the drop command
		
		stmt.close(); // we need to close the statement
		
		conn.close(); // close the connection to the database

	}

}
