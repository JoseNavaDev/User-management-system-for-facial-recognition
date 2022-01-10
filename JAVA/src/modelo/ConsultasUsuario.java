package modelo;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConsultasUsuario extends Conexion{
        Connection Con = getConexion();
        
        public boolean buscarLogin(ModeloUsuario Modelo){
            try {
                PreparedStatement Ps;
                String SQL = "select * from login where UsuarioNombre = ? and Password = ?";
                Ps = Con.prepareCall(SQL);
                Ps.setString(1,Modelo.getUsuario());
                Ps.setString(2,Modelo.getContrasena());
                ResultSet Rs = Ps.executeQuery();
                if (Rs.next()) {
                    Modelo.setUsuario(Rs.getString("UsuarioNombre"));
                    Modelo.setContrasena(Rs.getString("Password"));
                    return true;                    
                }
                return false;
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null,"Error: " +e);
                return false;
            }
        }
        
        public boolean insertar(ModeloUsuario Modelo){
            try {
                PreparedStatement Ps;
                String SQL = "insert into profesores values (?,?,?,?)";
                Ps = Con.prepareCall(SQL);
                Ps.setString(1,Modelo.getCodigo());
                Ps.setString(2,Modelo.getNombres());
                Ps.setString(3,Modelo.getApellidoPaterno());
                Ps.setString(4,Modelo.getApellidoMaterno());               
                Ps.executeUpdate(); //Se aplica para modificar, eliminar e insertar.
                //Ps.executeQuery();//Solo para consultas
                return true;                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Usuario no encontrado");
                return false;
            }
            
        }
        
        public boolean consultar(ModeloUsuario Modelo){
            try {
                PreparedStatement Ps;
                String SQL = "select * from profesores where Codigo = ?";
                Ps = Con.prepareCall(SQL);
                Ps.setString(1,Modelo.getCodigo());
                //Ps.setString(1,Modelo.getNombres());
                ResultSet Rs = Ps.executeQuery();
                if (Rs.next()) {
                    Modelo.setCodigo(Rs.getString("Codigo"));
                    Modelo.setNombres(Rs.getString("Nombres"));
                    Modelo.setApellidoPaterno(Rs.getString("ApellidoP"));
                    Modelo.setApellidoMaterno(Rs.getString("ApellidoM"));                    
                    return true;                    
                }
                return false;
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null,"Error: " +e);
                return false;
            }
        }
        
        public boolean modificar(ModeloUsuario Modelo){
            try {
                PreparedStatement Ps;
                String SQL = "update profesores set Nombres = ?, ApellidoP = ?, ApellidoM = ? where Codigo = "+Modelo.getCodigo();
                Ps = Con.prepareCall(SQL);
                //Ps.setString(1,Modelo.getCodigo());
                Ps.setString(1,Modelo.getNombres());
                Ps.setString(2,Modelo.getApellidoPaterno());
                Ps.setString(3,Modelo.getApellidoMaterno());               
                Ps.executeUpdate();
                
                return true;
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "No se pudo modificar el usuario");
                return false;
            }
        }
        
        public boolean eliminar(ModeloUsuario Modelo){
            try {
                PreparedStatement Ps;                
                String SQL = "DELETE FROM profesores where Codigo = ?";
                Ps = Con.prepareCall(SQL);
                Ps.setString(1,Modelo.getCodigo());               
                Ps.executeUpdate(); //Se aplica para modificar, eliminar e insertar.
                //Ps.executeQuery();//Solo para consultas
                JOptionPane.showMessageDialog(null, "Usuario eliminado correctamente");
                return true;                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Usuario no encontrado");
                return false;
            }
        }

        
       
}
