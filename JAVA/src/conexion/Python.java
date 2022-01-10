package conexion;

public class Python {
    
    String[] parametros = new String[2];
    
    public void ejecutarPython(){        
        parametros[0] = "notepad.exe";
        parametros[1] = "C:\\Users\\josem\\Desktop";
        
        //Process proceso = Runtime.getRuntime().exec(parametros, null);
       
    }
    
    
}
