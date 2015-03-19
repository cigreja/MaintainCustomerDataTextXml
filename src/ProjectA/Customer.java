
package ProjectA;

import java.util.Comparator;


/**
 * Stores data for the customers email address, 
 * first name, and last name
 * 
 * @author Carlos Igreja
 * @version 4/2/2014
 */
public class Customer implements CustomerConstants{
    
    String firstName;
    String lastName;
    String email;
    
    public Customer(){
        
        firstName = "";
        lastName = "";
        email = "";
    }
    
    public Customer(String firstName, String lastName, String email)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
                
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getFirstName(){
        return firstName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getEmail()
    {
        return email;
    }

    public static class SortByFirstName implements Comparator<Customer>
    {
        @Override
        public int compare(Customer c, Customer c1) {
            return c.getFirstName().compareTo(c1.getFirstName());
        }    
    }
    
    public static class SortByLastName implements Comparator<Customer>
    {
        @Override
        public int compare(Customer c, Customer c1) {
            return c.getLastName().compareTo(c1.getLastName());
        }    
    }
    
    public static class SortByEmail implements Comparator<Customer>
    {
        @Override
        public int compare(Customer c, Customer c1) {
            return c.getEmail().compareTo(c1.getEmail());
        }  
    }
    
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        
        sb.append(StringUtils.padWithSpaces(
                            getFirstName(), FIRST_NAME_SIZE));
                    sb.append(StringUtils.padWithSpaces(
                            getLastName(), LAST_NAME_SIZE));
                    sb.append(StringUtils.padWithSpaces(
                            getEmail(), EMAIL_SIZE));
        return sb.toString();
    }
}
