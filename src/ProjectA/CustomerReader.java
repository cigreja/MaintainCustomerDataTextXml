
package ProjectA;

import java.util.ArrayList;

/**
 * This interface has the abstract methods for reading customer data to a 
 * file.
 * 
 * @author Carlos Igreja
 * @version 4/2/2014
 */
public interface CustomerReader {
    Customer getCustomer(String email);
    ArrayList<Customer> getCustomers();
}
