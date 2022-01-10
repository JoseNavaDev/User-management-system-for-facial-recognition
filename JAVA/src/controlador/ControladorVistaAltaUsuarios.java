package controlador;

import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import modelo.Carpetas;
import modelo.ConsultasUsuario;
import modelo.Externos;
import modelo.ModeloUsuario;
import vista.VistaAltaUsuarios;
import vista.VistaPrincipal;

public class ControladorVistaAltaUsuarios implements MouseListener {
    private ModeloUsuario ModeloUsuario;
    private VistaAltaUsuarios VistaAltaUsuarios;
    private ConsultasUsuario ConsultasUsuario;

    public ControladorVistaAltaUsuarios(VistaAltaUsuarios VistaAltaUsuarios) {
        this.VistaAltaUsuarios = VistaAltaUsuarios;
        oyentes();
        this.VistaAltaUsuarios.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        if (me.getSource()==VistaAltaUsuarios.botonAceptar) {           
            ModeloUsuario = new ModeloUsuario();
            ConsultasUsuario = new ConsultasUsuario();
            llenarModelo();
            
            
            if(ConsultasUsuario.insertar(ModeloUsuario)){
                JOptionPane.showMessageDialog(null, "Usuario registrado correctamente");
                VistaAltaUsuarios.setVisible(false);
                crearCarpeta();
                Externos hilo = new Externos();                
                hilo.run();
                VistaPrincipal VistaPrincipal = new VistaPrincipal();
                ControladorVistaPrincipal ControladorVistaPrincipal = new ControladorVistaPrincipal(VistaPrincipal);
            } else {
               JOptionPane.showMessageDialog(null, "Usuario no registrado");
            }
        }
        
        if (me.getSource()==VistaAltaUsuarios.iconoRegreso) {
            VistaAltaUsuarios.setVisible(false);
            VistaPrincipal VistaPrincipal = new VistaPrincipal();
            ControladorVistaPrincipal ControladorVistaPrincipal = new ControladorVistaPrincipal(VistaPrincipal);
        }
        
    }

    @Override
    public void mousePressed(MouseEvent me) {
        
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        if (me.getSource()==VistaAltaUsuarios.iconoRegreso) {
            VistaAltaUsuarios.iconoRegreso.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }
    
    
    
    private void llenarModelo(){
        ModeloUsuario.setCodigo(VistaAltaUsuarios.TxfCodigo.getText());
        ModeloUsuario.setNombres(VistaAltaUsuarios.TxfNombre.getText());
        ModeloUsuario.setApellidoPaterno(VistaAltaUsuarios.TxfApePaterno.getText());
        ModeloUsuario.setApellidoMaterno(VistaAltaUsuarios.TxfApeMaterno.getText());
    }
    
    private void llamarModelo(){
        System.out.println(ModeloUsuario.getCodigo());
        System.out.println(ModeloUsuario.getNombres());
        System.out.println(ModeloUsuario.getApellidoPaterno());
        System.out.println(ModeloUsuario.getApellidoMaterno());
    }    

    private void oyentes() {
        VistaAltaUsuarios.botonAceptar.addMouseListener(this);
        VistaAltaUsuarios.iconoRegreso.addMouseListener(this);
    }

    private void crearCarpeta() {
        String Nombre = VistaAltaUsuarios.TxfNombre.getText() + VistaAltaUsuarios.TxfApePaterno.getText() + 
                VistaAltaUsuarios.TxfApeMaterno.getText();
        Carpetas carpetas = new Carpetas();
        carpetas.pedirDatos(Nombre);
    }    
    
}
