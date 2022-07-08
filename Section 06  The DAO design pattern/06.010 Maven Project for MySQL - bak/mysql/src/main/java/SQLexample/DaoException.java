package SQLexample;
/*
Create a class that handles the runtime exceptions.  Is this logic??
 */

import java.sql.SQLException;

public class DaoException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public DaoException(SQLException e) {
        super(e);
    }

}