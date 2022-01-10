package modelo;

public class ModeloUsuario {
    private String Codigo;
    private String Nombres;
    private String ApellidoPaterno;
    private String ApellidoMaterno;
    
    private String Usuario;
    private String Contrasena;
    private boolean bandera;

    public ModeloUsuario() {
        
    }

    public String getCodigo() {
        return Codigo;
    }

    public String getNombres() {
        return Nombres;
    }

    public String getApellidoPaterno() {
        return ApellidoPaterno;
    }

    public String getApellidoMaterno() {
        return ApellidoMaterno;
    }

    public void setCodigo(String Codigo) {
        this.Codigo = Codigo;
    }

    public void setNombres(String Nombres) {
        this.Nombres = Nombres;
    }

    public void setApellidoPaterno(String ApellidoPaterno) {
        this.ApellidoPaterno = ApellidoPaterno;
    }

    public void setApellidoMaterno(String ApellidoMaterno) {
        this.ApellidoMaterno = ApellidoMaterno;
    }

    public String getUsuario() {
        return Usuario;
    }

    public String getContrasena() {
        return Contrasena;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public void setContrasena(String Contrasena) {
        this.Contrasena = Contrasena;
    }
    
    
    public boolean isBandera() {
        return bandera;
    }

    public void setBandera(boolean bandera) {
        this.bandera = bandera;
    }
    
    
    
    
    
}
