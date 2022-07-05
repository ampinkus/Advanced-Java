package application;

import java.sql.DriverManager;
import java.sql.SQLException;

public class App {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("org.sqlite.JDBC");
		
		String dbUrl = "jdbc:sqlite:people.db";
		
		var conn = DriverManager.getConnection(dbUrl);
		
		var stmt = conn.createStatement();
		
		var sql = "create table if not exists user (id integer primary key, name text not null)";
		stmt.execute(sql);
		
		sql = "insert into user (id, name) values (0, 'Bob')"; // we insert with key 0 the name Bob
		stmt.execute(sql);
		
		sql = "insert into user (id, name) values (1, 'Mary')"; // we insert with key 1 the name Mary
		stmt.execute(sql);
		
		sql = "select id, name from user"; // select the columns of the table
		var rs = stmt.executeQuery(sql); // to get data we can't use execute(), we need to use executeQuery()

		// we have to call next on a result set before we get data, the loop will step over all the rows that match our query
		// in this case all the rows that exists in the table
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
