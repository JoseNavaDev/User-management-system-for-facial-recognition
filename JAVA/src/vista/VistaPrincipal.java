package vista;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class VistaPrincipal extends JFrame {
    //IMAGEN
    ImageIcon fotografia = new ImageIcon(getClass().getResource("/imagenes/FONFO.jpg"));//Imagen de fondo principal
    public JLabel foto = new JLabel(fotografia);
    
    //BOTONES
    public JButton BotonAgregarUsuario = new JButton();
    public JButton BotonConsultarUsuario = new JButton();
    public JButton BotonModificarUsuario = new JButton();
    public JButton BotonSalida = new JButton();
    
    public VistaPrincipal(){
        configuracion();       
        botones();
    }

    private void configuracion() {        
        this.setUndecorated(true);        
        this.setSize(fotografia.getIconWidth(),fotografia.getIconHeight());                      
        this.setResizable(false);
        this.setEnabled(true);        
        this.setLocationRelativeTo(null);
        this.add(foto);                        
    }

    private void botones() {       
        //Boton agregar usuario        
        BotonConsultarUsuario.setSize(150,25);
        BotonConsultarUsuario.setLocation(50,370);        
        BotonConsultarUsuario.setText("Consultar profesor");
        BotonConsultarUsuario.setBackground(Color.CYAN);
        BotonConsultarUsuario.setBorderPainted(false);
        BotonConsultarUsuario.setVisible(true);
        foto.add(BotonConsultarUsuario);
        
        //Boton checar entrada                
        BotonAgregarUsuario.setSize(160,25);
        BotonAgregarUsuario.setLocation(300,370);
        BotonAgregarUsuario.setText("Agregar profesor");
        BotonAgregarUsuario.setBackground(Color.CYAN);
        BotonAgregarUsuario.setBorderPainted(false);
        BotonAgregarUsuario.setVisible(true);
        foto.add(BotonAgregarUsuario);
        
        //Boton solicitar aula               
        BotonModificarUsuario.setSize(160,25);
        BotonModificarUsuario.setLocation(570,370);        
        BotonModificarUsuario.setText("Modificar / Borrar" );
        BotonModificarUsuario.setBackground(Color.CYAN);
        BotonModificarUsuario.setBorderPainted(false);
        BotonModificarUsuario.setVisible(true);
        foto.add(BotonModificarUsuario);
        
        //Boton salir                
        BotonSalida.setSize(70,25);
        BotonSalida.setLocation(710,25);
        BotonSalida.setText("Salir");
        BotonSalida.setBackground(Color.red);
        BotonSalida.setBorderPainted(false);
        BotonSalida.setVisible(true);        
        foto.add(BotonSalida);        
    }

   
    
}
