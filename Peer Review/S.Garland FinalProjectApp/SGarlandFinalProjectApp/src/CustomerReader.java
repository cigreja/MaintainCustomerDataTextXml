/*
 * Description: CustomerReader interface calls the getCustomer & an 
 *              ArrayList to getCustomers
 *
 * @author Samantha Garland
 * @created 3/24/2014
 */
import java.util.ArrayList;

public interface CustomerReader 
{
    Customer getCustomer(String email);
    ArrayList<Customer> getCustomers();
}
