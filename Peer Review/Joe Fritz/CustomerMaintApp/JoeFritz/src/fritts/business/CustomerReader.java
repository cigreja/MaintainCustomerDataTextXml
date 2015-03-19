
package fritts.business;
import java.util.ArrayList;

public interface CustomerReader
{
    Customer getCustomer(String email);
    ArrayList<Customer> getCustomers();
}
