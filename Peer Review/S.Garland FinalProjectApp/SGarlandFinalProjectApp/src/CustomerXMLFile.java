/*
 * Description: CustomerXMLFile class uses a StAX api
 *
 *
 *
 * @author Samantha Garland
 * @created 3/24/2014
 */
import java.util.*;
import java.io.*;
import java.nio.file.*;
import javax.xml.stream.*;

public class CustomerXMLFile implements CustomerDAO
{
    private Path customersPath = null;
    private ArrayList<Customer> customers = null;
    
    public CustomerXMLFile()
    {
        customersPath = Paths.get("customers.xml");
        customers = this.getCustomers();
    }
    
    private boolean saveCustomers()
    {
        //create the XMLOutputFactory object
        XMLOutputFactory outputFactory = XMLOutputFactory.newFactory();
        try
        {
            //create XMLStreamWriter object
            FileWriter fileWriter = new
                FileWriter(customersPath.toFile());
            XMLStreamWriter writer = outputFactory.createXMLStreamWriter(fileWriter);
            
            //write the customers to the file
            writer.writeStartDocument("1.0");
            writer.writeStartElement("Customers");
            for (Customer c : customers)
            {
                writer.writeStartElement("Customer");
                writer.writeAttribute("Email", c.getEmail());
                
                writer.writeStartElement("First_Name");
                writer.writeCharacters(c.getFName());
                writer.writeEndElement();
                
                writer.writeStartElement("Last_Name");
                writer.writeCharacters(c.getLName());
                writer.writeEndElement();
                
                writer.writeEndElement();
            }
            writer.writeEndElement();
            writer.flush();
            writer.close();
            
        }
        catch(IOException | XMLStreamException e)
        {
            System.err.println(e);
            return false;
        }
        return true;
    }
    
    public ArrayList<Customer> getCustomers()
    {
        //if the XML file has already been read, don't read it again
        if (customers != null)
            return customers;
        
        customers = new ArrayList<>();
        Customer c = null;
        if (Files.exists(customersPath)) //prevent FileNotFoundException
        {
            //create the XMLInputFactory object
            XMLInputFactory inputFactory = XMLInputFactory.newFactory();
            try
            {
            //create a XMLStreamReader object
            FileReader fileReader = new FileReader(customersPath.toFile());
            XMLStreamReader reader = inputFactory.createXMLStreamReader(fileReader);
            
            //read the customers from the file
            while (reader.hasNext())
            {
                int eventType = reader.getEventType();
                switch (eventType)
                {
                    case XMLStreamConstants.START_ELEMENT:
                        String elementName = reader.getLocalName();
                        if (elementName.equals("Customer"))
                        {
                            c = new Customer();
                            String email = reader.getAttributeValue(0);
                            c.setEmail(email);
                        }
                        if (elementName.equals("First_Name"))
                        {
                            String fName = reader.getElementText();
                            c.setFName(fName);
                        }
                        if (elementName.equals("Last_Name"))
                        {
                            String lName = reader.getElementText();
                            c.setLName(lName);
                        }
                        break;
                    case XMLStreamConstants.END_ELEMENT:
                        elementName = reader.getLocalName();
                        if (elementName.equals("Customer"))
                        {
                            customers.add(c);
                        }
                        break;
                    default:
                        break;
                        
                    }
                    reader.next();
                }
            }
            catch(IOException | XMLStreamException e)
            {
                System.err.println(e);
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
        //get the old customer and remove it
        Customer oldCustomer = this.getCustomer(newCustomer.getEmail());
        int i = customers.indexOf(oldCustomer);
        customers.remove(i);
        
        //add the update customer
        customers.add(i, newCustomer);
        
        return this.saveCustomers();
        
    }
}
