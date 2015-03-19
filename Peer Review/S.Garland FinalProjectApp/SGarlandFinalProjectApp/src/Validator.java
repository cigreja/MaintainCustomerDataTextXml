/*
 * Description: Validator class checks user entry for errors 
 *              getCustomerInfo checks to make sure info is not null. 
 *              getString simply gets a string from user
 *              getEmailChecker gets an email & confirms it has correct
 *              email format of user@serverName.type
 *
 * @author Samantha Garland
 * @created 3/24/2014
 */
import java.util.Scanner;

public class Validator
{
    //check user entry of customer info for actual data
    public static String getCustomerInfo(Scanner sc, String prompt)
    {
        String s = "";
        boolean entryCheck = false;
        while (entryCheck == false)
        {
            s = getString(sc, prompt);
            
            if(s == null | s.isEmpty())
                System.out.println("Error! No customer information was entered.");
            else    
                entryCheck = true;
        }      
        return s;
    }
    
    public static String getString(Scanner sc, String prompt)
    {
        System.out.print(prompt);
        String s = sc.next();  //read the first string on the line
        sc.nextLine();      //discard rest of information on line
        return s;
    }
    
//check email using parsing
    public static String getEmailChecker(Scanner sc, String prompt)
    {
        //declare local variables
        String s = "";
        String userName = "";
        String serverName = "";
        String serverType = "";
        boolean emailInfoValid = false;
        
        while (emailInfoValid == false)
        {
            s = getCustomerInfo(sc, prompt);
            s = s.trim();
            int indexOfSpace = s.indexOf("@");

            if (indexOfSpace == 0)
            {
                System.out.println("Error! No information was supplied before "
                        + "the @ sign");
            }
            else 
            {
                userName = s.substring(0, indexOfSpace);
                
                int indexOfSpace2 = s.indexOf(".");
                int indexTotalCheck = indexOfSpace2 - indexOfSpace;
            
                if (indexTotalCheck <= 1)
                {
                    System.out.println("Error! No data between @ and . symbols."
                            + " Try again.");
                }
                else 
                {
                    indexOfSpace++;
                    serverName = s.substring(indexOfSpace, indexOfSpace2);
                    
                    indexOfSpace2++;
                    indexTotalCheck=s.length() - indexOfSpace - indexOfSpace2 + 2;
                    
                    if (indexTotalCheck != 3)
                    {
                        System.out.println("Error! Incorrect length of email "
                                + "type. Try again.");
                    }
                    else 
                    {
                        serverType = s.substring(indexOfSpace2);
                        emailInfoValid = true;
                    }
                }
            }   
        }
        return s;
    }
 
}
