package ProjectA;

import java.util.ArrayList;
import java.io.*;
import javax.xml.stream.*;  // StAX API

/**
 * This class reads from an XML file and stores the data in an array.
 * The array can be used to write to an XML file to make changes or update the 
 * file. This class is used to upload 10 customers that are stored on an
 * XML file.
 * 
 * @author  Carlos Igreja
 * @created 4/2/2014
 */
public class CustomerXML implements CustomerConstants
{
    private static String customersFilename = "customers.xml";

    // read customer data from xml file
    public static ArrayList<Customer> readCustomers()
    {
        ArrayList<Customer> customers = new ArrayList<>();
        Customer c = null;

        // create an XMLInputFactory object
        XMLInputFactory inputFactory = XMLInputFactory.newFactory();
        try{
            // create an XMLStreamReader object
            FileReader fileReader = new FileReader(customersFilename);
            XMLStreamReader reader = inputFactory.createXMLStreamReader(fileReader);
            
            //Read XML here
            while(reader.hasNext()){
                int eventType = reader.getEventType();
                switch(eventType){
                    case XMLStreamConstants.START_ELEMENT:
                        String elementName = reader.getLocalName();
                        if(elementName.equals("record")){
                            c = new Customer();
                        }
                        if(elementName.equals("email")){
                            String email = reader.getElementText();
                            c.setEmail(email);
                        }
                        if(elementName.equals("firstName")){
                            String firstName = reader.getElementText();
                            c.setFirstName(firstName);
                        }
                        if(elementName.equals("lastName")){
                            String lastName = reader.getElementText();
                            c.setLastName(lastName);
                        }
                        break;
                    case XMLStreamConstants.END_ELEMENT:
                        elementName = reader.getLocalName();
                        if(elementName.equals("record")){
                            customers.add(c);
                        }
                        break;
                    default:
                        break;
                }
                reader.next();
            }
        }catch(IOException | XMLStreamException e){
            System.out.println(e);
        }
        return customers;
    }

    // write customer data to xml file
    public static void writeCustomers(ArrayList<Customer> customers)
    {
        // create the XMLOutputFactory object
        XMLOutputFactory outputFactory = XMLOutputFactory.newFactory();
        try{
            //create XMLStreamWriter object
            FileWriter fileWriter = new FileWriter(customersFilename);
            XMLStreamWriter writer = outputFactory.createXMLStreamWriter(fileWriter);
            
            // write the customers to the file
            writer.writeStartDocument("1.0");
            writer.writeStartElement("records");
            for (Customer c : customers){
                writer.writeStartElement("record");
                writer.writeAttribute("email",c.getEmail());
                writer.writeStartElement("firstName");
                writer.writeCharacters(c.getFirstName());
                writer.writeEndElement();
                writer.writeStartElement("lastName");
                writer.writeCharacters(c.getLastName());
                writer.writeEndElement();
                writer.writeEndElement();
            }
            writer.writeEndElement();
            writer.flush();
            writer.close();
        }catch(IOException | XMLStreamException e){
            System.out.println(e);
        }
    }

    //print all customers data to console
    public static void printCustomers(ArrayList<Customer> customers)
    {
        for (Customer p : customers)
        {
            printCustomer(p);
        }
        System.out.println();
    }

    //print a single customers data to console
    public static void printCustomer(Customer c)
    {
        String productString =
            StringUtils.padWithSpaces(c.getFirstName(), FIRST_NAME_SIZE) +
            StringUtils.padWithSpaces(c.getLastName(), LAST_NAME_SIZE) +
            c.getEmail();

        System.out.println(productString);
    }
}