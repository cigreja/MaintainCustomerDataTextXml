
package ProjectA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;

/**
 * Implements the methods specified by the CustomerDAO interface. 
 * Stores the customer data in a text file.
 * 
 * @author Carlos Igreja
 * @version 4/2/2014
 */
public final class CustomerTextFile implements CustomerDAO {
    
    private ArrayList<Customer> customers = null;
    private Path customersPath = null;
    private File customersFile = null;

    private final String FIELD_SEP = "\t";

    public CustomerTextFile()
    {
        //customersPath = Paths.get("customers.txt");
        //customersPath = Paths.get("src/files","customers.txt");
        customersPath = Paths.get("./customers.txt");
        customersFile = customersPath.toFile();
        customers = this.getCustomers();
    }

    public ArrayList<Customer> getCustomers()
    {
        // if the customers file has already been read, don't read it again
        if (customers != null)
            return customers;        

        customers = new ArrayList<>();        
        
        if (Files.exists(customersPath))  // prevent the FileNotFoundException
        {
            try
            {
                // open the input stream
                BufferedReader in = 
                     new BufferedReader(
                     new FileReader(customersFile));
                
                // read all customers stored in the file
                // into the array list
                String line = in.readLine();
                while(line != null)
                {
                    String[] columns = line.split(FIELD_SEP);
                    String firstName = columns[0];
                    String lastName = columns[1];
                    String email = columns[2];

                    Customer c = new Customer(
                        firstName, lastName, email);

                    customers.add(c);

                    line = in.readLine();                    
                }
                
                // close the input stream
                in.close();
            }
            catch(IOException e)
            {
                printToLogFile(e);
                return null;
            }
        }
        return customers;            
    }
    
    public boolean setCustomers(ArrayList<Customer> customers)
    {
        this.customers = customers;
        return saveCustomers();
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

    public boolean updateCustomer(Customer newCustomer)
    {
        // get the old customer and remove it
        Customer oldCustomer = this.getCustomer(newCustomer.getEmail());
        int i = customers.indexOf(oldCustomer);
        customers.remove(i);

        // add the updated customer
        customers.add(i, newCustomer);

        return this.saveCustomers();
    }
    
    public boolean updateCustomer(Customer newCustomer, Customer original)
    {
        // get the old customer and remove it
        Customer oldCustomer = this.getCustomer(original.getEmail());
        int i = customers.indexOf(oldCustomer);
        customers.remove(i);

        // add the updated customer
        customers.add(i, newCustomer);

        return this.saveCustomers();
    }

    private boolean saveCustomers()
    {        
	try
        {
            // open the output stream
            PrintWriter out = new PrintWriter(
                              new BufferedWriter(
                              new FileWriter(customersFile)));

            // write all customers in the array list
            // to the file
            for (Customer c : customers)
            {
                out.print(c.getFirstName()+ FIELD_SEP);
                out.print(c.getLastName()+ FIELD_SEP);
                out.println(c.getEmail());
            }
            
            // close the output stream
            out.close();
        }
        catch(IOException e)
        {
            printToLogFile(e);
            return false;
        }

        return true;
    }	
    
    public boolean printToLogFile(IOException e){
        try
        {
            // open the output stream
            PrintWriter out = new PrintWriter(
                              new BufferedWriter(
                              new FileWriter("errorLog.txt", true)));
            
            // append the date and time this exception occurred
            Date time = new Date();
            out.print("Exception occurred on ");
            out.println(time);
            
            // append the information about the exception
            e.printStackTrace(out);
            out.println(); // line break
            
            // close the output stream
            out.close();
        }
        //handles the output stream IOException
        catch(IOException ose)
        {
            System.out.println("Could not access errorLog File :");
            System.out.println(ose);
            return false;
        }
        return true;
    }
}

