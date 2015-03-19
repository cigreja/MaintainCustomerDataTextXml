/**
 * @author Joe Fritts
 * CS242 Final Project
 * 04-02-14
 * This program is a GUI application that maintains customer data using a text
 * file. It stores the customers' first name, last name, and email; allows
 * the entry of new customers and the deletion of customers. This project
 * taught me how to work with classes, interfaces, methods, ArrayLists, 
 * data validation, forms and events.
 */
package fritts.business;

import java.util.ArrayList;

public class CustomerMaintFrame extends javax.swing.JFrame implements CustomerConstants
{

    //declare class variables
    private static CustomerDAO customerDAO = null;
    /**
     * Creates new form CustomerMaintFrame
     * Constructor also calls displayMessage method to display welcome message
     */
    public CustomerMaintFrame() {
        initComponents();
        String welcome = "Welcome to the Customer Maintenance Application\n\n" +
                "You may start by pressing the List button to view the current " +
                "customers. Or you can add or delete a customer from the list " +
                "by filling out information to the right and pressing the " +
                "appropriate button. If you need help later you can press the " +
                "Help button any time.";
        displayMessage(welcome);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        outputTextArea = new javax.swing.JTextArea();
        listButton = new javax.swing.JButton();
        helpButton = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        addNewCustomerLabel = new javax.swing.JLabel();
        addEmailLabel = new javax.swing.JLabel();
        addFirstNameLabel = new javax.swing.JLabel();
        addLastNameLabel = new javax.swing.JLabel();
        addEmailTextField = new javax.swing.JTextField();
        addFirstNameTextField = new javax.swing.JTextField();
        addLastNameTextField = new javax.swing.JTextField();
        addButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        deleteCustomerLabel = new javax.swing.JLabel();
        deleteEmailLabel = new javax.swing.JLabel();
        deleteEmailTextField = new javax.swing.JTextField();
        deleteButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Customer Maintenance Program");

        outputTextArea.setColumns(20);
        outputTextArea.setLineWrap(true);
        outputTextArea.setRows(5);
        outputTextArea.setWrapStyleWord(true);
        jScrollPane1.setViewportView(outputTextArea);

        listButton.setMnemonic('l');
        listButton.setText("List");
        listButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listButtonActionPerformed(evt);
            }
        });

        helpButton.setMnemonic('h');
        helpButton.setText("Help");
        helpButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                helpButtonActionPerformed(evt);
            }
        });

        exitButton.setMnemonic('x');
        exitButton.setText("Exit");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setName(""); // NOI18N

        addNewCustomerLabel.setText("Add New Customer");
        addNewCustomerLabel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        addEmailLabel.setText("Email");

        addFirstNameLabel.setText("First Name");

        addLastNameLabel.setText("Last Name");

        addButton.setMnemonic('a');
        addButton.setText("Add");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(addEmailLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addEmailTextField))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(addNewCustomerLabel)
                        .addGap(0, 124, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(addFirstNameLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addFirstNameTextField))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(addLastNameLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addLastNameTextField)))
                .addGap(10, 10, 10))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(addButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(addNewCustomerLabel)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addEmailLabel)
                    .addComponent(addEmailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addFirstNameLabel)
                    .addComponent(addFirstNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addLastNameLabel)
                    .addComponent(addLastNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(addButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        deleteCustomerLabel.setText("Delete Customer");
        deleteCustomerLabel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        deleteEmailLabel.setText("Email");

        deleteButton.setMnemonic('d');
        deleteButton.setText("Delete");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(deleteCustomerLabel)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(deleteEmailLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteEmailTextField)))
                .addGap(10, 10, 10))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(deleteButton)
                .addContainerGap(169, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(deleteCustomerLabel)
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deleteEmailLabel)
                    .addComponent(deleteEmailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(deleteButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(listButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(helpButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(exitButton)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(listButton)
                    .addComponent(helpButton)
                    .addComponent(exitButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Event handler displays directions for user
     */
    private void helpButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_helpButtonActionPerformed
        displayMenu();
    }//GEN-LAST:event_helpButtonActionPerformed

    /**
     * Event handler exits application
     */
    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitButtonActionPerformed
    
    /**
     * Event handler displays all current customer information in the file 
     */
    private void listButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listButtonActionPerformed
        displayAllCustomers();
    }//GEN-LAST:event_listButtonActionPerformed

    /**
     * Event handler adds entered customer's first name, last name, and email
     * address to the file
     */
    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        if (isValidAdd())    //checks text fields in add section for valid data
        {
            Customer customer = new Customer(); //create new customer object
            customer.setFirstName(addFirstNameTextField.getText());
            customer.setLastName(addLastNameTextField.getText());
            customer.setEmail(addEmailTextField.getText());
            customerDAO.addCustomer(customer);
            
            outputTextArea.setText(customer.getFirstName() + " " +
                    customer.getLastName() + " has been added.");
        }
        addFirstNameTextField.setText("");      //clears text fields
        addLastNameTextField.setText("");
        addEmailTextField.setText(""); 
    }//GEN-LAST:event_addButtonActionPerformed

    /**
     * Event handler finds customer based on email and deletes that customer
     * from the file
     */
    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        if (isValidDelete())    //just confirms that something is in email field
        {
            Customer c = customerDAO.getCustomer(deleteEmailTextField.getText().toString());
            if (c != null)
            {
                customerDAO.deleteCustomer(c);
                outputTextArea.setText(c.getName() + " has been deleted.\n");
            }
            else
                outputTextArea.setText("No customer matches that email.");
        }
        deleteEmailTextField.setText("");   //clears text field box
    }//GEN-LAST:event_deleteButtonActionPerformed

    /**
     * Method uses StringBuilder class to output all customers in the ArrayList
     * to the text area of the form
     */
    private void displayAllCustomers()
    {
        ArrayList<Customer> customers = customerDAO.getCustomers();
        Customer c = null;
        StringBuilder sb = new StringBuilder();
        for (int i=0; i < customers.size(); i++)
        {
            c = customers.get(i);
            sb.append(StringUtils.padWithSpaces(c.getName(), NAME_SIZE + 2));
            sb.append(c.getEmail());
            sb.append("\n");
        }
        outputTextArea.setText(sb.toString());
    }
    
    /**
     * Method displays a help menu in the text area of the form
     */
    private void displayMenu()
    {
        String helpMenu = "HELP MENU\nList Button - List all customers\n" +
                "Add Button - Add a customer\n" +
                "Delete Button - Delete a customer\n" +
                "Help Button - Displays help menu\n" +
                "Exit Button - Exit the application";
        outputTextArea.setText(helpMenu);
    }
    
    /**
     * Method displays whatever String is sent to it in the text area of the form
     */
    public void displayMessage(String s)
    {
        outputTextArea.setText(s);
    }
    
    /**
     * Method returns a boolean value based on whether or not TextFields in the 
     * add section of the form have some input in them and if the email address
     * is the correct pattern
     */
    private boolean isValidAdd()
    {
        SwingValidator sv = new SwingValidator();
        EmailFormatValidator ev = new EmailFormatValidator();
        return
                sv.isPresent(addEmailTextField, "Email") &&
                ev.validate(addEmailTextField, "Email") &&
                sv.isPresent(addFirstNameTextField, "First Name") &&
                sv.isPresent(addLastNameTextField, "Last Name");
    }
    
    /**
     * Method returns a boolean value based on whether or not the email
     * TextField has any input
     */
    private boolean isValidDelete()
    {
        SwingValidator sv = new SwingValidator();
        return
                sv.isPresent(deleteEmailTextField, "Email");
    }
    
    public static void main(String args[]) {
        //set the class variables
        customerDAO = DAOFactory.getCustomerDAO();
        
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CustomerMaintFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CustomerMaintFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CustomerMaintFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CustomerMaintFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run() {
                CustomerMaintFrame frame = new CustomerMaintFrame();
                frame.setVisible(true);
                frame.setLocationRelativeTo(null);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JLabel addEmailLabel;
    private javax.swing.JTextField addEmailTextField;
    private javax.swing.JLabel addFirstNameLabel;
    private javax.swing.JTextField addFirstNameTextField;
    private javax.swing.JLabel addLastNameLabel;
    private javax.swing.JTextField addLastNameTextField;
    private javax.swing.JLabel addNewCustomerLabel;
    private javax.swing.JButton deleteButton;
    private javax.swing.JLabel deleteCustomerLabel;
    private javax.swing.JLabel deleteEmailLabel;
    private javax.swing.JTextField deleteEmailTextField;
    private javax.swing.JButton exitButton;
    private javax.swing.JButton helpButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton listButton;
    private javax.swing.JTextArea outputTextArea;
    // End of variables declaration//GEN-END:variables
}