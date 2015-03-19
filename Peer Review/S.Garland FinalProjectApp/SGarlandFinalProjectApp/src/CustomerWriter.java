/*
 * Description: CustomerWriter interface calls the methods addCustomer,
 *              updateCustomer, and deleteCustomer
 *
 * @author Samantha Garland
 * @created 3/24/2014
 */
public interface CustomerWriter 
{
    boolean addCustomer(Customer c);
    boolean updateCustomer(Customer c);
    boolean deleteCustomer(Customer c);
    
}
