
package ProjectA;

/**
 * This class is used to create a CustomerDAO object that is an instance of the 
 * CustomerTextFile class. The class maps the CustomerDAO interface to an 
 * instance of the CustomerTextFile class and returns the CustomerDAO object.
 * 
 * @author  Carlos Igreja
 * @created 4/2/2014
 */
public class DAOFactory {

    // this method maps the CustomerDAO interface
    // to an instance of the CustomerTextFile class
    public static CustomerDAO getCustomerDAO()
    {
        CustomerDAO cDAO = new CustomerTextFile();
        return cDAO;
    }
}
