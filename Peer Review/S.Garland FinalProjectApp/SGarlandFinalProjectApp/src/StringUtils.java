/*
 * Description: class StringUtils contains method to pad customer information
 *              for display purposes
 *
 * @author Samantha Garland
 * @created 3/24/2014
 */

public class StringUtils 
{
    public static String padWithSpaces(String s, int length)
    {
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
