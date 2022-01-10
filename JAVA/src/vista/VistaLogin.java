package vista;
import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class VistaLogin extends JFrame{    
    ImageIcon imagenRegreso = new ImageIcon(getClass().getResource("/imagenes/return.png")); 
    
    private VistaPrincipal Vista;
    
    public JTextField Txf_Usuario;
    public JPasswordField Txp_Contrasena;
    private JLabel Lbl_Usuario;
    private JLabel Lbl_Contraseña;
    public JButton botonAceptar;
    public JButton botonRegresar;
       
    public JLabel iconoRegreso = new JLabel();
   
    public VistaLogin(){
        configuracion();        
        campos();       
    }    
    
    private void configuracion(){
        this.setUndecorated(true);
        this.setSize(250,200);
        this.setLocationRelativeTo(null);
        this.setResizable(false);        
    }
    
    private void campos(){
        this.setLayout(null);
        JLabel Lbl_Bienvenida = new JLabel("Ingrese sus datos");
        Lbl_Bienvenida.setBounds(75, 50, 150,30);
        Lbl_Usuario = new JLabel("Usuario");
        Lbl_Usuario.setBounds(20, 88, 100, 20);
        Lbl_Contraseña = new JLabel("Contraseña");
        Lbl_Contraseña.setBounds(20, 120, 100, 20);
        Txf_Usuario = new JTextField();
        Txf_Usuario.setBounds(120,88,100,20);       
        Txp_Contrasena = new JPasswordField();
        Txp_Contrasena.setBounds(120,120,100,20);        
        botonAceptar = new JButton("Aceptar");
        botonAceptar.setBounds(90,160,80,20);
        botonAceptar.setVisible(true);
                       
        this.add(Lbl_Bienvenida);
        this.add(Lbl_Usuario);
        this.add(Lbl_Contraseña);
        this.add(Txf_Usuario);
        this.add(Txp_Contrasena);
        this.add(botonAceptar);
        
        iconoRegreso.setBounds(220,10,20,20);
        iconoRegreso.setIcon(new ImageIcon(imagenRegreso.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH)));
        this.add(iconoRegreso);
        
    }

    
    
}
