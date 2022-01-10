package controlador;

import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import modelo.ModeloUsuario;
import vista.VistaConsultarUsuario;
import vista.VistaLoginConsulta;
import vista.VistaPrincipal;

public class ControladorVistaConsultarUsuario implements MouseListener {
    
    private ModeloUsuario ModeloUsuario;
    public VistaConsultarUsuario VistaConsultarUsuario;    

    public ControladorVistaConsultarUsuario(ModeloUsuario ModeloUsuario, VistaConsultarUsuario VistaConsultarUsuario) {
        this.ModeloUsuario = ModeloUsuario;
        this.VistaConsultarUsuario = VistaConsultarUsuario;        
        oyentes();
        vaciarInformacion();
        VistaConsultarUsuario.setVisible(true);
    }    

    @Override
    public void mouseClicked(MouseEvent me) {
        if (me.getSource()==VistaConsultarUsuario.iconoRegreso) {
            VistaPrincipal VistaPrincipal = new VistaPrincipal();
            ControladorVistaPrincipal ControladorVistaPrincipal = new ControladorVistaPrincipal(VistaPrincipal);
            VistaConsultarUsuario.setVisible(false);
        }
        if (me.getSource()==VistaConsultarUsuario.botonConsultarAgain) {
            VistaLoginConsulta VistaLoginConsulta = new VistaLoginConsulta();
            VistaLoginConsulta.LblDescripcion.setText("Ingrese el código del profesor a consultar");
            ControladorVistaLoginConsulta ControladorVistaLoginConsulta = new ControladorVistaLoginConsulta(ModeloUsuario,VistaLoginConsulta);
            VistaConsultarUsuario.setVisible(false);            
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
        if (me.getSource()==VistaConsultarUsuario.iconoRegreso) {
            VistaConsultarUsuario.iconoRegreso.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }
    
    
    private void oyentes() {
        VistaConsultarUsuario.iconoRegreso.addMouseListener(this);
        VistaConsultarUsuario.botonConsultarAgain.addMouseListener(this);
    }

    private void vaciarInformacion() {        
        VistaConsultarUsuario.BdCodigo.setText(ModeloUsuario.getCodigo());
        VistaConsultarUsuario.BdNombre.setText(ModeloUsuario.getNombres());
        VistaConsultarUsuario.BdApePaterno.setText(ModeloUsuario.getApellidoPaterno());
        VistaConsultarUsuario.BdApeMaterno.setText(ModeloUsuario.getApellidoMaterno());        
    }
        
    
    
}
