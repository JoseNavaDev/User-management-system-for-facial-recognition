package controlador;

import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import modelo.ConsultasUsuario;
import modelo.ModeloUsuario;
import vista.VistaModificarUsuario;
import vista.VistaPrincipal;

public class ControladorVistaModificarUsuario implements MouseListener {
    
    private ModeloUsuario ModeloUsuario;
    private VistaModificarUsuario VistaModificarUsuario;
    private ConsultasUsuario ConsultasUsuario;

    public ControladorVistaModificarUsuario(ModeloUsuario ModeloUsuario, VistaModificarUsuario VistaModificarUsuario) {
        this.ModeloUsuario = ModeloUsuario;
        this.VistaModificarUsuario = VistaModificarUsuario;
        vaciarInformacion();
        VistaModificarUsuario.setVisible(true);
        oyentes();
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        if (me.getSource()==VistaModificarUsuario.iconoRegreso) {
            VistaPrincipal VistaPrincipal = new VistaPrincipal();
            ControladorVistaPrincipal ControladorVistaPrincipal = new ControladorVistaPrincipal(VistaPrincipal);
            VistaModificarUsuario.setVisible(false);
        }
        
        if (me.getSource()==VistaModificarUsuario.botonModificar) {
            ModeloUsuario = new ModeloUsuario();
            ConsultasUsuario = new ConsultasUsuario();
            captarInformacion();
            if (ConsultasUsuario.modificar(ModeloUsuario)) {
                System.out.println("Usuario "+ModeloUsuario.getCodigo() +" modificado correctamente");
                JOptionPane.showMessageDialog(null, "Usuario "+ModeloUsuario.getCodigo() +" modificado correctamente");
                VistaModificarUsuario.setVisible(false);
                VistaPrincipal VistaPrincipal = new VistaPrincipal();
                ControladorVistaPrincipal ControladorVistaPrincipal = new ControladorVistaPrincipal(VistaPrincipal);
            }            
        }
        if (me.getSource()==VistaModificarUsuario.botonBorrar) {
            ModeloUsuario = new ModeloUsuario();
            ConsultasUsuario = new ConsultasUsuario();
            captarInformacion();
            if (ConsultasUsuario.eliminar(ModeloUsuario)) {
                System.out.println("Usuario "+ModeloUsuario.getCodigo() +" eliminado correctamente");
                JOptionPane.showMessageDialog(null, "Usuario "+ModeloUsuario.getCodigo() +" eliminado correctamente");
                VistaModificarUsuario.setVisible(false);
                VistaPrincipal VistaPrincipal = new VistaPrincipal();
                ControladorVistaPrincipal ControladorVistaPrincipal = new ControladorVistaPrincipal(VistaPrincipal);
            } 
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
        if (me.getSource()==VistaModificarUsuario.iconoRegreso) {
            VistaModificarUsuario.iconoRegreso.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }
    
    private void oyentes(){
        VistaModificarUsuario.iconoRegreso.addMouseListener(this);
        VistaModificarUsuario.botonModificar.addMouseListener(this);
        VistaModificarUsuario.botonBorrar.addMouseListener(this);
    }

    private void vaciarInformacion() {
        VistaModificarUsuario.TxtCodigo.setText(ModeloUsuario.getCodigo());
        VistaModificarUsuario.TxtNombre.setText(ModeloUsuario.getNombres());
        VistaModificarUsuario.TxtApePaterno.setText(ModeloUsuario.getApellidoMaterno());
        VistaModificarUsuario.TxtApeMaterno.setText(ModeloUsuario.getApellidoPaterno());
    }
    
    private void captarInformacion(){
        ModeloUsuario.setCodigo(VistaModificarUsuario.TxtCodigo.getText());
        ModeloUsuario.setNombres(VistaModificarUsuario.TxtNombre.getText());
        ModeloUsuario.setApellidoPaterno(VistaModificarUsuario.TxtApePaterno.getText());
        ModeloUsuario.setApellidoMaterno(VistaModificarUsuario.TxtApeMaterno.getText());
    }
    
    private void limpiarInformacion(){
       VistaModificarUsuario.TxtCodigo.setText("");
       VistaModificarUsuario.TxtNombre.setText("");
       VistaModificarUsuario.TxtApePaterno.setText("");
       VistaModificarUsuario.TxtApeMaterno.setText("");
       
    }
    
    
}
