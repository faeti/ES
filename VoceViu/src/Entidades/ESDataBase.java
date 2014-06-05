/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
