
package Controladores;

import GUI.INGRESO;
import Metodos.Metodos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Controlador implements ActionListener{
    
    private INGRESO vr;
    private Metodos md;

    public Controlador(INGRESO vr, Metodos md) {
        this.vr = vr;
        this.md = md;
        this.vr.BTN_Buscar.addActionListener(this);
        this.vr.BTN_Cancelar.addActionListener(this);
        this.vr.BTN_Guardar.addActionListener(this);
        this.vr.BTN_Modificar.addActionListener(this);
        this.vr.BTN_Mostrar_Tabla.addActionListener(this);
        this.vr.BTN_Salir.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        md.setCantidad(vr.Campo_Cantidad.getText());
        md.setCodigo(Integer.parseInt(vr.Campo_Codigo.getText()));
        md.setCosto(vr.Campo_Costo.getText());
        md.setDescripcion(vr.Campo_Descripcion.getText());
        md.setObservacion(vr.Campo_Observacion.getText());
        md.setReferencia(vr.Campo_Referencia.getText());
        md.setTalla(vr.Campo_Talla.getText());
        
        if(e.getSource() == vr.BTN_Guardar){
            md.guardar();
              
        }
    }
    
}
