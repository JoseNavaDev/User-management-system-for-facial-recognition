package modelo;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Externos implements Runnable {
    
    @Override
    public void run(){        
        String[] parametros = new String[2];        
        parametros[0] = "python.exe";
        parametros[1] = "K:\\BaseDeDatosProyecto\\muestreo.py";        
        try {          
            Process proceso = Runtime.getRuntime().exec(parametros, null);
            proceso.waitFor();             
        } catch (IOException e) {
            System.out.println("Error...");
            e.printStackTrace();
        } catch (InterruptedException ex) {
            Logger.getLogger(Externos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
