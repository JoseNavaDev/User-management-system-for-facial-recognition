
package vista;

import com.sun.awt.AWTUtilities;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class VistaSplash extends JFrame {
    
    ImageIcon ImSplash = new ImageIcon(getClass().getResource("/imagenes/cantilever.gif"));
    public JLabel LblSplash = new JLabel(ImSplash);

    public VistaSplash() {
        configuracion();
        this.add(LblSplash);
    }

    private void configuracion() {
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE); //Libera memoria y continua con instrucciones
        //adaptar el JFrame a la imagen
        this.setSize(ImSplash.getIconWidth(),ImSplash.getIconHeight());
        
        //Quitar el decorado del JFrame (borde,barra_titulo, etc)
        this.setUndecorated(true);
        
        //Quitar el fondo del JFrame
        AWTUtilities.setWindowOpaque(this,false);
        this.setAlwaysOnTop(true);
        
        this.setLocationRelativeTo(null);
    }
    
    

    
}
