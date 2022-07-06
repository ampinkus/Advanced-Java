package application;

import java.sql.DriverManager;
import java.sql.SQLException;

public class App {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		// the information we want to load in the table are in two arrays:
		int[] ids = {0, 1, 2};
		String[] names = {"Sue", "Bob", "Charley"};
		
		
		Class.forName("org.sqlite.JDBC");
		
		String dbUrl = "jdbc:sqlite:people.db";
		
		var conn = DriverManager.getConnection(dbUrl);
		
		var stmt = conn.createStatement();
		
		var sql = "create table if not exists user (id integer primary key, name text not null)";
		stmt.execute(sql);

		// we will use a better way to insert values in a table without repeating a lot of commands.
		sql = "insert into user (id, name) values (?, ?)"; // the question marks are placeholders
		var insertStmt = conn.prepareStatement(sql);
		/*
		The Java JDBC PreparedStatement() primary features are:
			* Easy to insert parameters into the SQL statement.
			* Easy to reuse the PreparedStatement with new parameter values.
			* May increase performance of executed statements.
			* Enables easier batch updates.
		 */
		
		for(int i = 0; i < ids.length; i++) { // loop through the arrays:
			insertStmt.setInt(1, ids[i]); // setInt(1, ids[i]); first argument is the index of (id, name) and the second what to insert, id in this case.  FIRST INDEX IS 1!
			insertStmt.setString(2, names[i]); // setInt(1, ids[i]); first argument is the index of (id, name) and the second what to insert, name in this case
			
			insertStmt.executeUpdate(); // run the update command to add the values
		}
		
		insertStmt.close();
		
		sql = "select id, name from user";
		var rs = stmt.executeQuery(sql);
		
		while(rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("name");
			
			System.out.println(id + ": " + name);
		}
		
		sql = "drop table user";
		stmt.execute(sql);
		
		stmt.close();
		
		conn.close();

	}

}
