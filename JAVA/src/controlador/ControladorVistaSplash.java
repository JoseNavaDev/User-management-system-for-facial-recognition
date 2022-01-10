
package controlador;

import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import javax.swing.JOptionPane;
import vista.VistaPrincipal;
import vista.VistaSplash;

public class ControladorVistaSplash implements MouseListener, MouseMotionListener,MouseWheelListener{    
    private VistaSplash VistaSplash;
    int x,y;  //Para saber las coordenadas del JFrame

    public ControladorVistaSplash(VistaSplash VistaSplash) {
        this.VistaSplash = VistaSplash;
        oyentes();
        VistaSplash.setVisible(true);
        matarSplash(2);  //Tiempo definido
    }

    private void oyentes() {
        //Oyentes del mouse
        VistaSplash.LblSplash.addMouseListener(this);
        
        //Oyente para el MouseMotionListener
        VistaSplash.LblSplash.addMouseMotionListener(this);
        
        //Oyente para el MouseWheelListener
        VistaSplash.LblSplash.addMouseWheelListener(this);
        
    }

    @Override
    public void mouseClicked(MouseEvent me) {
    }

    @Override
    public void mousePressed(MouseEvent me) {
        if (me.getSource()==VistaSplash.LblSplash) {
            x=me.getX(); // Obtiene las coordenadas en X y Y
            y=me.getY();
        }
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        if (me.getSource()== VistaSplash.LblSplash) {
            VistaSplash.LblSplash.setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
        }
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }

    
    //Metodos MouseMotionListener
    @Override
    public void mouseDragged(MouseEvent me) {
        if (me.getSource()==VistaSplash.LblSplash) {
            VistaSplash.setLocation(VistaSplash.getLocation().x+me.getX()-x,
                                    VistaSplash.getLocation().y+me.getY()-y);            
        }
    }
    
    @Override
    public void mouseMoved(MouseEvent me) {
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent mwe) {
        if (mwe.getSource()==VistaSplash.LblSplash) {
            VistaSplash.dispose();  //Liberar espacio del JFrame y continua con instrucciones
            
            
        }
    }

    private void matarSplash(int segundos) {
        try {
            Thread.sleep(segundos*1000);
        } catch (InterruptedException ex) {
            JOptionPane.showMessageDialog(null, "Error: \n"+ex);
        } finally{
            VistaSplash.dispose();            
            
            VistaPrincipal ventanaPrincipal = new VistaPrincipal();
            ControladorVistaPrincipal ve = new ControladorVistaPrincipal(ventanaPrincipal);
            //Dar paso al resto del sistema
            //ya sea el logino directo al sistema MVC
        }
    }
    
    
    
}
