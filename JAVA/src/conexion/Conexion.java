package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexion {
    private final String Servidor = "localhost";
    private final String Database = "profesores";
    private final String Usuario = "root";
    private final String Password = "";
    
    private final String Puerto = "3306";
    private final String Url = "jdbc:mysql://"+Servidor+":"+Puerto+"/"+Database;
    
    private static Connection Con;
    
    public Conexion(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Con = (Connection) DriverManager.getConnection(Url,Usuario,Password);
            System.out.println("Conexión establecida con la base de datos:"+Database);
        } catch (SQLException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Error: "+e);
        }
    }
    
    public Connection getConexion(){
        return Con;
    }
}
