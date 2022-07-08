package SQLexample;
/*
    implementation of the UserDao
    We could have created a UserDao class to implements Dao for Users.
    The advantage of this approach is we are using here MySQL but we could have another implementation for SQL lite and so on.
    This gives a great flexibility

 */

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDaoImpl implements UserDao {
    @Override
    public void save(User u) {
        var conn = Database.instance().getConnection(); // get a database connection

        try {
            var stmt = conn.prepareStatement("insert into user (name) values (?)");
            stmt.setString(1, u.getName()); // we replace the (?) with the name of the user
            stmt.executeUpdate(); // execute the statement
            stmt.close();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public Optional<User> findById(int id) {
        return Optional.empty();
    }

    @Override
    public void update(User user) {

    }

    @Override
    public void delete(User user) {

    }

    @Override
    public List<User> getAll() {
        List<User> users = new ArrayList<>();

        var conn = Database.instance().getConnection();

        try {
            var stmt = conn.createStatement();
            var rs = stmt.executeQuery("select id, name from user");
            while(rs.next()) {
                var id = rs.getInt("id");
                var name = rs.getString("name");
                users.add(new User(id, name));
            }

            stmt.close();
        } catch (SQLException e) {
            throw new DaoException(e);
        }

        return users;
    }
}
