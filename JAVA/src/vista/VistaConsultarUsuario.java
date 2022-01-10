package vista;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import modelo.ModeloUsuario;

public class VistaConsultarUsuario extends JFrame{
    
    ImageIcon imagenRegreso = new ImageIcon(getClass().getResource("/imagenes/return.png"));
    
    public JLabel iconoRegreso = new JLabel();    
    public JLabel LblInformacion;    
    public JLabel BdNombre;
    public JLabel BdApeMaterno;
    public JLabel BdApePaterno;
    public JLabel BdCodigo;    
    private JLabel LblNombre;
    private JLabel LblApeMaterno;
    private JLabel LblApePaterno;
    private JLabel LblCodigo;
    
    public JButton botonConsultarAgain;
    public JButton botonRegresar;
    
    public VistaConsultarUsuario(){        
        diseno();
        componentes();        
    }

    private void diseno() {
        this.setLayout(null);
        this.setUndecorated(true);
        this.setSize(300,280);
        this.setLocationRelativeTo(null);        
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void componentes() {
        LblInformacion = new JLabel("Informacion del profesor consultado");
        LblInformacion.setBounds(40,40,220,20);
        this.add(LblInformacion);
                
        LblCodigo = new JLabel("Código");
        LblNombre = new JLabel("Nombre(s)");
        LblApePaterno = new JLabel("Apellido Paterno");
        LblApeMaterno = new JLabel("Apellido Materno");
        
        LblCodigo.setBounds(20,90,100,20);
        LblNombre.setBounds(20,120,100,20);
        LblApePaterno.setBounds(20,150,100,20);
        LblApeMaterno.setBounds(20,180,100,20);
        
        this.add(LblCodigo);
        this.add(LblNombre);
        this.add(LblApePaterno);
        this.add(LblApeMaterno);
        
        BdCodigo = new JLabel();
        BdNombre = new JLabel();
        BdApePaterno = new JLabel();
        BdApeMaterno = new JLabel();
        
        BdCodigo.setBounds(150,90,100,20);
        BdNombre.setBounds(150,120,100,20);
        BdApePaterno.setBounds(150,150,100,20);
        BdApeMaterno.setBounds(150,180,100,20);
        
        this.add(BdCodigo);
        this.add(BdNombre);
        this.add(BdApePaterno);
        this.add(BdApeMaterno);
        
        botonConsultarAgain = new JButton("Consultar otro");
        botonConsultarAgain.setBounds(75,230,150,30);
        botonConsultarAgain.setVisible(true);
        this.add(botonConsultarAgain);
        
        iconoRegreso.setBounds(270,10,20,20);
        iconoRegreso.setIcon(new ImageIcon(imagenRegreso.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH)));
        this.add(iconoRegreso);
        
    }
    
}
