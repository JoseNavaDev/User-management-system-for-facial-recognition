package controlador;

import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import modelo.ConsultasUsuario;
import modelo.ModeloUsuario;
import vista.VistaConsultarUsuario;
import vista.VistaLoginConsulta;
import vista.VistaModificarUsuario;
import vista.VistaPrincipal;

public class ControladorVistaLoginConsulta implements MouseListener {
    
    private ModeloUsuario ModeloUsuario;
    private VistaLoginConsulta VistaLoginConsulta;
    private ConsultasUsuario ConsultasUsuario;
    
    private boolean bandera;
    

    public ControladorVistaLoginConsulta(ModeloUsuario ModeloUsuario, VistaLoginConsulta VistaLoginConsulta) {
        this.ModeloUsuario = ModeloUsuario;
        this.VistaLoginConsulta = VistaLoginConsulta;        
        oyentes();
        VistaLoginConsulta.setVisible(true);
        this.bandera = ModeloUsuario.isBandera();
    }
    
    @Override
    public void mouseClicked(MouseEvent me) {
        if (me.getSource()==VistaLoginConsulta.BtnAceptar) {            
            ConsultasUsuario = new ConsultasUsuario();
            llenarModelo();                        
            if(ConsultasUsuario.consultar(ModeloUsuario)){
                System.out.println("Usuario encontrado correctamente");
                VistaLoginConsulta.setVisible(false);
                
                if (bandera) {
                    VistaConsultarUsuario VistaConsultarUsuario = new VistaConsultarUsuario();
                    ControladorVistaConsultarUsuario ControladorVistaConsultarUsuario = new ControladorVistaConsultarUsuario(ModeloUsuario,VistaConsultarUsuario);
                } else {                    
                    VistaModificarUsuario VistaModificarUsuario = new VistaModificarUsuario();
                    ControladorVistaModificarUsuario ControladorVistaModificarUsuario = new ControladorVistaModificarUsuario(ModeloUsuario,VistaModificarUsuario); 
                }                              
                
            } else {
               JOptionPane.showMessageDialog(null, "Usuario no registrado");
            }
                     
            
        }
        
        if (me.getSource()==VistaLoginConsulta.iconoRegreso) {
            VistaLoginConsulta.setVisible(false);
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
        if (me.getSource()==VistaLoginConsulta.iconoRegreso) {
            VistaLoginConsulta.iconoRegreso.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }

    private void oyentes() {
        VistaLoginConsulta.BtnAceptar.addMouseListener(this);
        VistaLoginConsulta.iconoRegreso.addMouseListener(this);
        
    }

    private void llenarModelo() {
        ModeloUsuario.setCodigo(VistaLoginConsulta.TxtCodigo.getText());
    }  
    
}
