/**
 * SwingValidator class that checks to see if a TextField has some input and if
 * not, displays a pop up message box telling the user that the current
 * JTextComponent is a required field.
 */
package fritts.business;
import javax.swing.*;
import javax.swing.text.JTextComponent;


public class SwingValidator
{
    public boolean isPresent(JTextComponent c, String fieldName)
    {
        if (c.getText().length() == 0)
        {
            showMessage(c, fieldName + " is a required field.");
            c.requestFocusInWindow();
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
