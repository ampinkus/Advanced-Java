package application;

import java.sql.DriverManager;
import java.sql.SQLException;

public class App {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		 // int[] ids = {1, 2, 3};
		 int[] ids = {5, 6, 7};
		String[] names = {"Sue", "Bob", "Charley"};
		
		Class.forName("org.sqlite.JDBC");
		
		String dbUrl = "jdbc:sqlite:people.db";
		
		var conn = DriverManager.getConnection(dbUrl);
		
		var stmt = conn.createStatement();
		// by default each time a statement is executed the database is updated.  This may not be the most efficient way to work.
		// autocommit is on by default, the next instruction turns this off in order to process the statements as a batch file
		conn.setAutoCommit(false);
		
		var sql = "create table if not exists user (id integer primary key, name text not null)";
		stmt.execute(sql);
		
		sql = "insert into user (id, name) values (?, ?)";
		var insertStmt = conn.prepareStatement(sql);
		
		for(int i = 0; i < ids.length; i++) {
			insertStmt.setInt(1, ids[i]);
			insertStmt.setString(2, names[i]);
			
			insertStmt.executeUpdate(); // update the table
		}
		// You must commit to confirm any changes you make, or rollback to discard them.
		// This is especially useful when you have multiple INSERT, UPDATE, DROP and DELETE statements within the same connection.
		conn.commit(); // save the changes at the database
		
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
		conn.commit(); // we need to commit the deletion of the table!

		stmt.close();
		conn.close();

	}

}
