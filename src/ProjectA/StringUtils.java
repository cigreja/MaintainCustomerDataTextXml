
package ProjectA;

/**
 * Use spaces to align the customer data in columns on the console. 
 * 
 * @author  Carlos Igreja
 * @created 4/2/2014
 */
public class StringUtils {
    
    public static String padWithSpaces(String s, int length){
        if (s.length() < length)
        {
            StringBuilder sb = new StringBuilder(s);
            while(sb.length() < length)
            {
                sb.append(" ");
            }
            return sb.toString();
        }
        else
        {
            return s.substring(0, length);
        }
    }   
}
