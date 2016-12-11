
package Persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoFactory {
    
    private String url = "jdbc:postgresql://localhost:5432/fabricaweb";
    private String user = "postgres";
    private String password = "123";
    
    public ConexaoFactory(){};
    
    public Connection getConnection(){
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    
}
