package com.mycompany.myapp.helpers;
import java.awt.Color;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
/**
 *
 * @author Houta
 */
public class DataValidator {
    public static void validateEmpty(JTextField field, StringBuilder sb, String errorMessage){
        if(field.getText().equals("")){
            sb.append(errorMessage).append("\n");
            field.setBackground(Color.red);
            field.requestFocus();
        }else{
            field.setBackground(Color.white);
        }
    }
    public static void validateEmpty(JPasswordField field, StringBuilder sb, String errorMessage){        
        if(new String(field.getPassword()).equals("")){
            sb.append(errorMessage).append("\n");
            field.setBackground(Color.red);
            field.requestFocus();
        }else{
            field.setBackground(Color.white);
        }
    }
    public static void validateErrorDate(JTextField field, StringBuilder sb, String errorMessage){
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            sdf.parse(field.getText());
            field.setBackground(Color.white);
        } catch (ParseException ex) {
            sb.append(errorMessage).append("\n");
            field.setBackground(Color.red);
            field.requestFocus();
            Logger.getLogger(DataValidator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
