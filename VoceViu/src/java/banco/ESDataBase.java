package banco;

/**
 *
 * @author rafaelfae
 */
import java.sql.*;

public class ESDataBase {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/EMP";

    static final String USER = "username";
    static final String PASS = "password";

    public ESDataBase() {
        //Class.forName(JDBC_DRIVER);

    }
}
