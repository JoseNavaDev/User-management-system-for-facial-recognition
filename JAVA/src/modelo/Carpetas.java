package modelo;

import java.io.File;

public class Carpetas {
    
    String RutaCarpetas = "K:\\BaseDeDatosProyecto\\";
    String Usuario = "";
    
    public void pedirDatos(String Nombre){
        Usuario =RutaCarpetas+Nombre;
        File c = new File(Usuario);
        if (!c.exists()) {
            c.mkdir();
        } else {
            System.out.println("Usuario ya registrado");
        }
        
        }
   
    
    
}
