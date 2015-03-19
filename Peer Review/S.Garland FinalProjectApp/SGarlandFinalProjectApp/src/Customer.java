/*
 * Description: Customer class creates a customer constructor. Contains class 
 *              level variables. Contains methods to get and set Customer 
 *              information. Contains a method to compare customer objects.
 *              Contains method to override the toString
 *
 * @author Samantha Garland
 * @created 3/25/2014
 */

public class Customer 
{
    private String email;
    private String fName;
    private String lName;
    
    public Customer()
    {
        this("", "", "");
    }
    
    public Customer(String email, String fName, String lName)
    {
        this.email = email;
        this.fName = fName;
        this.lName = lName;
    }
    
    public void setEmail(String email)
    {
        this.email = email;
    }
    
    public String getEmail()
    {
        return email;
    }
    
    public void setFName(String fName)
    {
        this.fName = fName;
    }
    
    public String getFName()
    {
        return fName;
    }
    
    public void setLName(String lName)
    {
        this.lName = lName;
    }
    
    public String getLName()
    {
        return lName;
    }
    
    public boolean equals(Object object)
    {
        if (object instanceof Customer)
        {
            Customer customer2 = (Customer) object;
            if (email.equals(customer2.getEmail()) 
                && fName.equals(customer2.getFName())
                && lName.equals(customer2.getLName()))
                    return true;
        }
        return false;
    }  
    
    @Override
    public String toString()
    {
        return    "Email:       " + email + "\n"
                + "First Name:  " + fName + "\n"
                + "Last Name:   " + lName + "\n";
    }
}
