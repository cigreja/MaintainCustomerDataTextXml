package ProjectA;

import javax.swing.*;
import javax.swing.text.JTextComponent;


/**
 * validate the user’s data field entries. 
 * 
 * @author  Carlos Igreja
 * @created 4/2/2014
 */
public class Validator {
    
    public boolean isPresent(JTextComponent c, String title)
    {
        if (c.getText().length() == 0)
        {
            showMessage(c, title + " is a required field.\n"
                + "Please re-enter.");
            c.requestFocusInWindow();
            return false;
        }
        return true;
    }
    
    public boolean isName(JTextComponent jtc, String title){
        
        char[] chars = jtc.getText().toCharArray();

        for (char c : chars) {
            if(!Character.isLetter(c)) {
                showMessage(jtc, title + " is an invalid entry.\n"
                    + "Please re-enter.");
                jtc.requestFocusInWindow();
                return false;
            }
        }
        return true;
    }
    
    public boolean isEmail(JTextComponent jtc, String title){
        
        StringBuilder sb = new StringBuilder(jtc.getText());
        sb.trimToSize();
        
        if(sb.indexOf("@") != -1 &&
                sb.indexOf(".") != -1 &&
                sb.indexOf("@") > 0 &&
                sb.indexOf("@") + 1 < sb.indexOf(".") &&
                sb.indexOf(".") < sb.length() - 1){
            
            char[] chars = jtc.getText().toCharArray();
            
            int count = 0;
            for (char c : chars) {
                if(Character.compare(c, '@') == 0 ||
                        Character.compare(c, '.') == 0 ){
                    count++;
                }
            }
            
            if (count != 2){
                showMessage(jtc, title + " is an invalid entry.\n"
                    + "Please re-enter.");
                jtc.requestFocusInWindow();
                return false;
            }
        }else {
            showMessage(jtc, title + " is an invalid entry.\n"
                + "Please re-enter.");
            jtc.requestFocusInWindow();
            return false;
        }
        return true;
    }

    private void showMessage(JTextComponent c, String message)
    {
        JOptionPane.showMessageDialog(c, message, "Invalid Entry",
            JOptionPane.ERROR_MESSAGE);
    }
}

