/*
 * Description: DAOFactory class utilizes the method maps to CustomerDAO
 *              interface to the appropriate data storage mechanism
 *
 * @author Samantha Garland
 * @created 3/24/2014
 */
public class DAOFactory 
{
    
    public static CustomerDAO getCustomerDAO()
    {
        CustomerDAO cDAO = new CustomerXMLFile();
        return cDAO;
    }
}
