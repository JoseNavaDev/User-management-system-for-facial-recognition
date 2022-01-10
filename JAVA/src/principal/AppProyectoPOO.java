package principal;

import controlador.ControladorVistaSplash;
import vista.VistaSplash;

public class AppProyectoPOO {
    public static void main(String[] args) {        
        
        VistaSplash VistaSplash = new VistaSplash();
        ControladorVistaSplash ControladorVistaSplash = new ControladorVistaSplash(VistaSplash); 
        
    }

}