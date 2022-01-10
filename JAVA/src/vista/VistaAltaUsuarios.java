package vista;

import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class VistaAltaUsuarios extends JFrame {
    
    ImageIcon imagenRegreso = new ImageIcon(getClass().getResource("/imagenes/return.png"));
    
    public JTextField TxfNombre;
    public JTextField TxfApeMaterno;
    public JTextField TxfApePaterno;
    public JTextField TxfCodigo;
    
    private JLabel LblNombre;
    private JLabel LblApeMaterno;
    private JLabel LblApePaterno;
    private JLabel LblCodigo;
    public JLabel iconoRegreso;
    
    public JButton botonAceptar;   
    
    public VistaAltaUsuarios(){
        this.setUndecorated(true);
        diseno();
        etiquetas();
        textfields();
        metodobotonAceptar();
        metodobotonRegresar();
    }
    
    private void diseno(){
        this.setLayout(null);
        this.setUndecorated(true);
        this.setSize(300,250);
        this.setLocationRelativeTo(null);        
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);        
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
        
        this.add(LblCodigo);
        this.add(LblNombre);
        this.add(LblApePaterno);
        this.add(LblApeMaterno);
    }
    
    private void textfields(){
        TxfCodigo = new JTextField();
        TxfNombre = new JTextField();
        TxfApePaterno = new JTextField();
        TxfApeMaterno = new JTextField();
        
        TxfCodigo.setBounds(150,50,100,20);
        TxfNombre.setBounds(150,80,100,20);
        TxfApePaterno.setBounds(150,110,100,20);
        TxfApeMaterno.setBounds(150,140,100,20);
        
        this.add(TxfCodigo);
        this.add(TxfNombre);
        this.add(TxfApePaterno);
        this.add(TxfApeMaterno);
    }
    
    private void metodobotonAceptar(){        
        botonAceptar = new JButton("Aceptar");
        botonAceptar.setBounds(90,200,120,25);
        botonAceptar.setVisible(true);
        this.add(botonAceptar);
    }
    
    public void metodobotonRegresar(){        
        iconoRegreso = new JLabel();
        iconoRegreso.setBounds(270,10,20,20);
        iconoRegreso.setIcon(new ImageIcon(imagenRegreso.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH)));
        this.add(iconoRegreso);
    }    
    
}
