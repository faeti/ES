package banco;

/**
 *
 * @author rafaelfae
 */
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ESDataBase {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/voceviu";

    static final String USER = "root";
    static final String PASS = "1234";

    public Connection conn;
    public Statement stmt;
    
    public ESDataBase() {
        try {
            Class.forName(JDBC_DRIVER);
            
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            conn.setAutoCommit(false);
            
            stmt = conn.createStatement(
                           ResultSet.TYPE_SCROLL_INSENSITIVE,
                           ResultSet.CONCUR_UPDATABLE);
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ESDataBase.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ESDataBase.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
