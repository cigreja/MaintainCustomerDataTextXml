/**
 * class used to work with text file 'customers.txt'
 */
package fritts.business;
import java.util.*;
import java.io.*;
import java.nio.file.*;

public final class CustomerTextFile implements CustomerDAO
{
    private ArrayList<Customer> customers = null;
    private Path customersPath = null;
    private File customersFile = null;
    
    private final String FIELD_SEP = "\t";
    
    public CustomerTextFile()
    {
        //initialize the class variables
        customersPath = Paths.get("customers.txt");
        customersFile = customersPath.toFile();
        customers = this.getCustomers();
    }
    
    /**
     * implement the CustomerReader interface
     */
    public ArrayList<Customer> getCustomers()
    {
        CustomerMaintFrame cust = new CustomerMaintFrame();
        //if customers file has already been read, don't read it again
        if (customers != null)
            return customers;
       
        customers = new ArrayList<>();
        
        //load the arraylist with Customer objects created from the data in the file
        if (Files.exists(customersPath))    //prevents FileNotFoundException
        {
            try (BufferedReader in =
                    new BufferedReader(
                    new FileReader(customersFile)))
            {
                //read all customers stored in file into the array list
                String line = in.readLine();
                while (line != null)
                {
                    String[] columns = line.split(FIELD_SEP);
                    
                    String firstName = columns[0];
                    String lastName = columns[1];
                    String email = columns[2];
                    
                    Customer c = new Customer(firstName, lastName, email);
                    customers.add(c);
                    
                    line = in.readLine();
                }
            }
            catch (IOException e)
            {                
                cust.displayMessage(e.toString());
                return null;
            }
        }
        return customers;
    }
    
    public Customer getCustomer(String email)
    {
        for (Customer c : customers)
        {
            if (c.getEmail().equals(email))
                return c;
        }
        return null;
    }
    
    /**
     * implement the CustomerWriter interface
     */
    public boolean addCustomer(Customer c)
    {
        customers.add(c);
        return this.saveCustomers();
    }
    
    public boolean deleteCustomer(Customer c)
    {
        customers.remove(c);
        return this.saveCustomers();
    }
    
    //ended up not using this method but kept it in here in case I had time to
    //integrate its use into the form
    public boolean updateCustomer(Customer newCustomer)
    {
        //get the old customer and remove it
        Customer oldCustomer = this.getCustomer(newCustomer.getEmail());
        int i = customers.indexOf(oldCustomer);
        customers.remove(i);
        
        //add the updated customer
        customers.add(i, newCustomer);
        
        return this.saveCustomers();
    }
    
    private boolean saveCustomers()
    {
        //save the Customer objects in the array list to the file
        CustomerMaintFrame cust = new CustomerMaintFrame();
        try (PrintWriter out = new PrintWriter(
                new BufferedWriter(
                new FileWriter(customersFile))))
        {
            //write all customers in the array list to the file
            for (Customer c : customers)
            {
                out.print(c.getFirstName() + FIELD_SEP);
                out.print(c.getLastName() + FIELD_SEP);
                out.print(c.getEmail() + "\n");
            }
        }
        catch (IOException e)
        {
            cust.displayMessage(e.toString());
            return false;
        }
        return true;
    }  
}
