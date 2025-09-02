
package Metodos;
import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class Placeholder extends JTextField implements FocusListener {
    
    private String placeHolder;
    private Color colorNormal;
    private Color placeholderColor;
    private boolean mostrarPlaceholder;
    
    
    
    public Placeholder(String placeHolder){
        super();
        this.placeHolder = placeHolder;
        this.colorNormal = this.getForeground();
        this.placeholderColor = Color.BLUE;
        this.mostrarPlaceholder = true;
        
        super.setForeground(placeholderColor);
        super.setText(placeHolder);
        super.addFocusListener(this);
    }

    @Override
    public void focusGained(FocusEvent e) {
     if(this.mostrarPlaceholder){
         super.setText("");
         super.setForeground(colorNormal);
         this.mostrarPlaceholder = false;
     }   
    }
    @Override
    public void focusLost(FocusEvent e) {
        if(super.getText().isEmpty()){
            super.setText(placeHolder);
            super.setForeground(placeholderColor);
            this.mostrarPlaceholder = true;
        }
        
    }

    
}
