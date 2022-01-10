package controlador;

import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import javax.swing.JLabel;
import modelo.ModeloUsuario;
import vista.VistaConsultarUsuario;
import vista.VistaPrincipal;
import vista.VistaLogin;
import vista.VistaLoginConsulta;

public class ControladorVistaPrincipal implements MouseListener, MouseMotionListener {
    private ModeloUsuario ModeloUsuario;
    private VistaPrincipal VistaPrincipal;
    private VistaLogin VistaLogin;
    private ControladorVistaLogin ControladorVistaLogin;    
    int x,y;
    
    JLabel etiquetaMov = new JLabel();

    public ControladorVistaPrincipal(VistaPrincipal VistaPrincipal) {
        this.VistaPrincipal = VistaPrincipal;        
        oyentes();
        movimientoLabel();
        this.VistaPrincipal.setVisible(true);        
    }    

    @Override
    public void mouseClicked(MouseEvent me) {
        if (me.getSource()==VistaPrincipal.BotonSalida) {
            System.exit(0);
        }
        if (me.getSource()==VistaPrincipal.BotonAgregarUsuario) {
            ModeloUsuario = new ModeloUsuario();
            ModeloUsuario.setBandera(true);
            VistaLogin = new VistaLogin();
            ControladorVistaLogin = new ControladorVistaLogin(ModeloUsuario,VistaLogin);
            VistaPrincipal.setVisible(false);
        }
        
        if (me.getSource()==VistaPrincipal.BotonModificarUsuario) {
            ModeloUsuario = new ModeloUsuario();
            ModeloUsuario.setBandera(false);
            VistaLogin = new VistaLogin();
            ControladorVistaLogin = new ControladorVistaLogin(ModeloUsuario,VistaLogin);
            VistaPrincipal.setVisible(false);            
        }
        
        if (me.getSource()==VistaPrincipal.BotonConsultarUsuario) {
            ModeloUsuario = new ModeloUsuario();
            ModeloUsuario.setBandera(true);
            VistaLoginConsulta VistaLoginConsulta = new VistaLoginConsulta();
            VistaLoginConsulta.LblDescripcion.setText("Ingrese el codigo del profesor a consultar");
            ControladorVistaLoginConsulta ControladorVistaLoginConsulta = new ControladorVistaLoginConsulta(ModeloUsuario,VistaLoginConsulta);
            VistaPrincipal.setVisible(false);
        }        
    }

    @Override
    public void mousePressed(MouseEvent me) {
        if (me.getSource()==etiquetaMov) {
            x=me.getX(); // Obtiene las coordenadas en X y Y
            y=me.getY();
        }
    }

    @Override
    public void mouseReleased(MouseEvent me) {
      
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        if (me.getSource()== etiquetaMov) {
            etiquetaMov.setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
        } 
    }

    @Override
    public void mouseExited(MouseEvent me) {
      
    }

    @Override
    public void mouseDragged(MouseEvent me) {
        if (me.getSource()==etiquetaMov) {
            VistaPrincipal.setLocation(VistaPrincipal.getLocation().x+me.getX()-x,
                                    VistaPrincipal.getLocation().y+me.getY()-y);            
        }
    }

    @Override
    public void mouseMoved(MouseEvent me) {
       
    }

    public void mouseWheelMoved(MouseWheelEvent mwe) {
    }

    private void oyentes() {
        //Oyentes del mouse
        etiquetaMov.addMouseListener(this);        
        //Oyente para el MouseMotionListener
        etiquetaMov.addMouseMotionListener(this);
        //Oyente de los botones
        VistaPrincipal.BotonSalida.addMouseListener(this);
        //Oyente de boton agregar
        VistaPrincipal.BotonAgregarUsuario.addMouseListener(this);
        
        VistaPrincipal.BotonConsultarUsuario.addMouseListener(this);
        
        VistaPrincipal.BotonModificarUsuario.addMouseListener(this);
        
    }

    private void movimientoLabel() {
        etiquetaMov.setSize(140,190);
        etiquetaMov.setLocation(310,125);
        VistaPrincipal.foto.add(etiquetaMov);
    }   
    
    
}
