
package ProjectA;

import java.util.ArrayList;

/**
 * This interface has the abstract methods for writing customer data to a 
 * file.
 * 
 * @author Carlos Igreja
 * @version 4/2/2014
 */
public interface CustomerWriter {
    
    boolean addCustomer(Customer c);
    boolean updateCustomer(Customer c);
    boolean updateCustomer(Customer newCustomer, Customer original);
    boolean deleteCustomer(Customer c);
    boolean setCustomers(ArrayList<Customer> customers);
     
}
