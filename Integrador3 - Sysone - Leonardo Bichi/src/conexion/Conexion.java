package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    Connection con = null;
    String host = "jdbc:mariadb://localhost:3306/afa?serverTimeZone=UTC";
    String user = "root";
    String pass = "";
    
    public Conexion() {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            con = DriverManager.getConnection(host, user, pass);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public Connection getCon() {
        return con;
    }
}
