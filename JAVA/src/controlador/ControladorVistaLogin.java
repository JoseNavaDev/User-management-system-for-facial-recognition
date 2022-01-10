package controlador;

import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import static java.time.Clock.system;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import modelo.ConsultasUsuario;
import modelo.ModeloUsuario;
import org.apache.commons.codec.digest.DigestUtils;
import vista.VistaLogin;
import vista.VistaAltaUsuarios;
import vista.VistaConsultarUsuario;
import vista.VistaLoginConsulta;
import vista.VistaModificarUsuario;
import vista.VistaPrincipal;

public class ControladorVistaLogin implements MouseListener{
    private ModeloUsuario ModeloUsuario;
    private VistaAltaUsuarios VistaAltaUsuarios;
    private VistaLogin vistaLogin;
    private VistaConsultarUsuario VistaConsultarUsuario;
    private ControladorVistaConsultarUsuario ControladorVistaConsultarUsuario;
    private ConsultasUsuario ConsultasUsuario;
    boolean bandera;

    public ControladorVistaLogin(ModeloUsuario ModeloUsuario, VistaLogin vistaLogin) {
        this.vistaLogin = vistaLogin;
        oyentes();
        this.vistaLogin.setVisible(true);
        this.bandera = ModeloUsuario.isBandera();

    }   

    @Override
    public void mouseClicked(MouseEvent me) {
        if (me.getSource()==vistaLogin.botonAceptar) {
                ModeloUsuario = new ModeloUsuario();
                ConsultasUsuario = new ConsultasUsuario();
                InfoLogin();

                if(ConsultasUsuario.buscarLogin(ModeloUsuario)){
                    vistaLogin.setVisible(false);
                    System.out.println("Bandera: "+bandera);                   
                    
                    if (bandera) {
                        VistaAltaUsuarios = new VistaAltaUsuarios();
                        ControladorVistaAltaUsuarios ControladorVistaAltaUsuarios = new ControladorVistaAltaUsuarios(VistaAltaUsuarios);
                    }
                    else {
                        VistaLoginConsulta VistaLoginConsulta = new VistaLoginConsulta();
                        VistaLoginConsulta.LblDescripcion.setText("Ingrese el código del profesor a modificar");
                        ControladorVistaLoginConsulta ControladorVistaLoginConsulta = new ControladorVistaLoginConsulta(ModeloUsuario,VistaLoginConsulta);
                        
                        }                
                } else {
                    JOptionPane.showMessageDialog(null, "Usuario no encontrado");
                }               
            
            
            
                       
        }
        
        if (me.getSource()==vistaLogin.iconoRegreso) {
            VistaPrincipal VistaPrincipal = new VistaPrincipal();
            ControladorVistaPrincipal ControladorVistaPrincipal = new ControladorVistaPrincipal(VistaPrincipal);
            vistaLogin.setVisible(false);
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
        if (me.getSource()==vistaLogin.iconoRegreso) {
            vistaLogin.iconoRegreso.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }
        
        
    }

    @Override
    public void mouseExited(MouseEvent me) {
        
    }

        
    //METODOS
    private void loggin() {
        //String Usuario = control.Txt_Usuario.getText();
        //String Pass = control.Txt_Contrasena.getText();
        //System.out.println(""+Usuario);
        //System.out.println(""+Pass);        
    }

    private void oyentes() {
        vistaLogin.botonAceptar.addMouseListener(this);
        vistaLogin.iconoRegreso.addMouseListener(this);
    }

    private void InfoLogin() {
        String Usuario = DigestUtils.md5Hex(vistaLogin.Txf_Usuario.getText());
        ModeloUsuario.setUsuario(Usuario);        
        String Encriptador = DigestUtils.md5Hex(vistaLogin.Txp_Contrasena.getText());
        ModeloUsuario.setContrasena(Encriptador);
    }

       
}
