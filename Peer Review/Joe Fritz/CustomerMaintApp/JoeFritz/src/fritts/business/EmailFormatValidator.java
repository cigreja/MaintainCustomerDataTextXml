/**
 * Class used to validate email addresses (Maravitsas, 2013)
 * Reference: Maravitsas, N. (2013, April 7). Validate Email Address with 
 * Java Regular Expression example. Retrieved March 27, 2014, 
 * from Java Code Geeks: http://examples.javacodegeeks.com/core-java/util/regex/
 * matcher/validate-email-address-with-java-regular-expression-example/
 */
package fritts.business;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.*;
import javax.swing.text.JTextComponent;

public class EmailFormatValidator
{
    private Pattern pattern;
    private Matcher matcher;

    private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    public EmailFormatValidator()
    {
	pattern = Pattern.compile(EMAIL_PATTERN);
    }

    public boolean validate(JTextComponent c, String fieldName)
    {

	matcher = pattern.matcher(c.getText());
	if (!matcher.matches())
        {
            showMessage(c, fieldName + " is not a valid email.");
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
