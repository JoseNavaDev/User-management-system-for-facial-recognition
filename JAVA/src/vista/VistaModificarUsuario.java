package vista;

import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class VistaModificarUsuario extends JFrame {
    
    ImageIcon imagenRegreso = new ImageIcon(getClass().getResource("/imagenes/return.png")); 
    public JLabel iconoRegreso = new JLabel();

    public JTextField TxtNombre;
    public JTextField TxtApeMaterno;
    public JTextField TxtApePaterno;
    public JLabel TxtCodigo;
    
    private JLabel LblNombre;
    private JLabel LblApeMaterno;
    private JLabel LblApePaterno;
    private JLabel LblCodigo;
    
    public JButton botonModificar;
    public JButton botonBorrar;
        
    public VistaModificarUsuario(){
        diseno();
        etiquetas();
        textfields();
        metodobotonModificar();
        metodoBotonBorrar();
        
    }

    private void diseno() {
        this.setLayout(null);
        this.setUndecorated(true);
        this.setSize(300,250);
        this.setLocationRelativeTo(null);        
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    
    private void etiquetas(){
        LblCodigo = new JLabel("Código");
        LblNombre = new JLabel("Nombre(s)");
        LblApePaterno = new JLabel("Apellido Paterno");
        LblApeMaterno = new JLabel("Apellido Materno");
        
        LblCodigo.setBounds(20,50,100,20);
        LblNombre.setBounds(20,80,100,20);
        LblApePaterno.setBounds(20,110,100,20);
        LblApeMaterno.setBounds(20,140,100,20);
        
        iconoRegreso.setBounds(260,10,20,20);
        iconoRegreso.setIcon(new ImageIcon(imagenRegreso.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH)));
        this.add(iconoRegreso);
        
        this.add(LblCodigo);
        this.add(LblNombre);
        this.add(LblApePaterno);
        this.add(LblApeMaterno);
    }
    
    private void textfields(){
        TxtCodigo = new JLabel();
        TxtNombre = new JTextField();
        TxtApePaterno = new JTextField();
        TxtApeMaterno = new JTextField();        
                
        TxtCodigo.setBounds(150,50,100,20);
        TxtNombre.setBounds(150,80,100,20);
        TxtApePaterno.setBounds(150,110,100,20);
        TxtApeMaterno.setBounds(150,140,100,20);
        
        this.add(TxtCodigo);
        this.add(TxtNombre);
        this.add(TxtApePaterno);
        this.add(TxtApeMaterno);
    }
    
    private void metodobotonModificar(){        
        botonModificar = new JButton("Modificar");
        botonModificar.setBounds(30,200,100,25);
        botonModificar.setVisible(true);
        this.add(botonModificar);
    }
    
    private void metodoBotonBorrar(){
        botonBorrar = new JButton("Borrar");
        botonBorrar.setBounds(170, 200, 100, 25);
        botonBorrar.setVisible(true);
        this.add(botonBorrar);
    }
    
    
    
}
