package vista;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class VistaLoginConsulta extends JFrame {
    
    ImageIcon imagenRegreso = new ImageIcon(getClass().getResource("/imagenes/return.png"));
    
    public JLabel LblCodigo;
    public JLabel LblDescripcion;
    public JTextField TxtCodigo;
    public JButton BtnAceptar;
    
    public JLabel iconoRegreso;
    
    public VistaLoginConsulta(){
        diseno();
        componentes();
    }

    private void diseno() {
        this.setUndecorated(true);
        this.setLayout(null);
        this.setSize(300,200);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    private void componentes(){
        LblDescripcion = new JLabel();                
        LblDescripcion.setBounds(30,40,250,20);
        LblDescripcion.setVisible(true);
        this.add(LblDescripcion);
        
        LblCodigo = new JLabel("Codigo");
        LblCodigo.setBounds(50,100,100,20);
        LblCodigo.setVisible(true);
        this.add(LblCodigo);
        
        TxtCodigo = new JTextField();
        TxtCodigo.setBounds(150,100,100,20);
        TxtCodigo.setVisible(true);
        this.add(TxtCodigo);
        
        BtnAceptar = new JButton("Aceptar");
        BtnAceptar.setBounds(100,160,100,20);
        BtnAceptar.setVisible(true);
        this.add(BtnAceptar);
        
        iconoRegreso = new JLabel();
        iconoRegreso.setBounds(270,10,20,20);
        iconoRegreso.setIcon(new ImageIcon(imagenRegreso.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH)));
        this.add(iconoRegreso);
        
    }
    
    
    
}
