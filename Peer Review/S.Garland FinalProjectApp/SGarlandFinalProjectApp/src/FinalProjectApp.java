/*
 * Description: FinalProjectApp created for Baker College course Java CS242
 *              Project is made to maintain a customer database.
 *              
 *
 * @author Samantha Garland
 * @created 3/25/2014
 */
import java.util.Scanner;
import java.util.ArrayList;

public class FinalProjectApp implements CustomerConstants
{

    // declare class variables
    private static CustomerDAO customerDAO = null;
    private static Scanner sc = null;

    public static void main(String args[])
    {
        // display a welcome message
        System.out.println("Welcome to the Product Maintenance application\n");

        // set class variables
        customerDAO = DAOFactory.getCustomerDAO();
        sc = new Scanner(System.in);

        // display the main menu
        displayMenu();

        // choice variable
        String choice = "";
        while (!choice.equalsIgnoreCase("exit"))
        {
            // get the input from the user
            choice = Validator.getString(sc,
                    "Enter a command: ");
            System.out.println();

            if (choice.equalsIgnoreCase("list"))
                displayAllCustomers();
            else if (choice.equalsIgnoreCase("add"))
                addCustomer();
            else if (choice.equalsIgnoreCase("update")
                    || choice.equalsIgnoreCase("upd"))
                updateCustomer();
            else if (choice.equalsIgnoreCase("del") 
                    || choice.equalsIgnoreCase("delete"))
                deleteCustomer();
            else if (choice.equalsIgnoreCase("help") 
                    || choice.equalsIgnoreCase("menu"))
                displayMenu();
            else if (choice.equalsIgnoreCase("exit") 
                    || choice.equalsIgnoreCase("quit"))
                System.out.println("Bye.\n");
            else
                System.out.println("Error! Not a valid command.\n");
        }
    }

    public static void displayMenu()
    {
        System.out.println("COMMAND MENU");
        System.out.println("list    - List all customers");
        System.out.println("add     - Add a customer");
        System.out.println("upd     - Update a customer");
        System.out.println("del     - Delete a customer");
        System.out.println("help    - Show this menu");
        System.out.println("exit    - Exit this application\n");
    }

    public static void displayAllCustomers()
    {
        System.out.println("CUSTOMER LIST");

        ArrayList<Customer> customers = customerDAO.getCustomers();
        Customer c = null;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < customers.size(); i++)
        {        
            c = customers.get(i);
            sb.append(StringUtils.padWithSpaces(
                    c.getEmail(), EMAIL_SIZE + 4));
            sb.append(StringUtils.padWithSpaces(
                    c.getFName(), FIRST_NAME_SIZE + 4));
            sb.append(StringUtils.padWithSpaces(
                    c.getLName(), LAST_NAME_SIZE));
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    public static void addCustomer()
    {
        String email = Validator.getEmailChecker(
                sc, "Enter customer email: ");
        String fName = Validator.getCustomerInfo(
                sc, "Enter customer first name: ");
        String lName = Validator.getCustomerInfo(
                sc, "Enter customer last name: ");

        Customer customer = new Customer();
        customer.setEmail(email);
        customer.setFName(fName);
        customer.setLName(lName);
        customerDAO.addCustomer(customer);

        System.out.println();
        System.out.println(fName + " " + lName 
                + " has been added.\n");
    }
    
    public static void updateCustomer()
    {
        String email = Validator.getEmailChecker(sc, "Enter customer email to "
                + "update:  ");
        String updateMenu = "\nUpdate First or Last name? "
                + "\n" + "F  -first name"
                + "\n" + "L   -last name"
                + "\n\n" + "Update option: ";
        
        String choice = Validator.getString(sc, updateMenu);
        
        Customer customer = customerDAO.getCustomer(email);
        Customer updatedCustomer = new Customer();
        updatedCustomer = customer;
        
        if (choice.equalsIgnoreCase("first") || choice.equalsIgnoreCase("F"))
        {
            String newFName = Validator.getCustomerInfo(sc, 
                    "New first name: ");
            updatedCustomer.setFName(newFName);
            customerDAO.deleteCustomer(customer);
            customerDAO.addCustomer(updatedCustomer);
        }
        else if (choice.equalsIgnoreCase("last") || choice.equalsIgnoreCase("L"))
        {
            String newLName = Validator.getCustomerInfo(sc,
                    "New last name: ");
            updatedCustomer.setLName(newLName);
            customerDAO.deleteCustomer(customer);
            customerDAO.addCustomer(updatedCustomer);
        }
        else
            System.out.println("Only first or last name is allowed for update."
                    + " Try again.");
    }

    public static void deleteCustomer()
    {
        String email = Validator.getString(sc,
                "Enter customer email to delete: ");

        Customer c = customerDAO.getCustomer(email);

        System.out.println();
        if (c != null)
        {
            customerDAO.deleteCustomer(c);
            System.out.println(c.getEmail()
            + " has been deleted.\n");
        }
        else
        {
            System.out.println("No customer matches that email.\n");
        }
    }
}
