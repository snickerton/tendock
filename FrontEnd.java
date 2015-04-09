
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Dimension;
import java.util.List;
import java.util.Vector;

import javax.swing.Box;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class FrontEnd {
	List<String> messageList;
	
	public FrontEnd() {
		
	// Top Level Frame
	JFrame myFrame = new JFrame("Message Board");
	myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	myFrame.setPreferredSize( new Dimension(750,500));
	myFrame.setLocation(300, 100);
	
	// Create a box inside top level frame
	Box bigBox = Box.createVerticalBox();
	
	// bigBox has multiple Horizonal Boxes inside it
	// First Horizontal Row is a Label
	JLabel createUser = new JLabel("Create New User");
	
	bigBox.add(createUser);
	
	// Second Horizontal Row is a box to add a new User
	// This box "createUserBox" has a Label, TextField and Button
	Box createUserBox = Box.createHorizontalBox();
	JLabel newUser = new JLabel("Username");
	newUser.setSize(40, 20);
	final JTextField newUserInput = new JTextField();
	//newUserInput.setSize(40, 20);
	JButton create = new JButton("Create");
	
	createUserBox.add(newUser);
	createUserBox.add(newUserInput);
	createUserBox.add(create);
	
	bigBox.add(createUserBox);
	
	// Third Horizontal Row has a Label
	JLabel lookup = new JLabel("Add and View Messages");
	bigBox.add(lookup);
	
	// Fourth Horizontal Row has a Label and JComboBox
	// This is to select the User
	Box selectUserBox = Box.createHorizontalBox();
	JLabel select = new JLabel("Select User");
	select.setSize(40, 20);
	
	//  - get List of Users from the BackEnd
    List<String> myList = BackEnd.getUsers();
    //String [] myList = {"A","B","C"};
    
	final DefaultComboBoxModel model = new DefaultComboBoxModel();
    final JComboBox selectUser = new JComboBox(model);
	selectUserBox.add(select);
	selectUserBox.add(selectUser);
	
	bigBox.add(selectUserBox);
	
	// Fifth Horizontal Row has a Label, TextField and Button
	// This row is used to enter and add a new message
	Box newMessageBox = Box.createHorizontalBox();
	JLabel newMessage = new JLabel("Enter Message:");
	newMessage.setSize(40, 20);
	final JTextField enterMessage = new JTextField();
	JButton add = new JButton("Add");
	newMessageBox.add(newMessage);
	newMessageBox.add(enterMessage);
	newMessageBox.add(add);
	
	bigBox.add(newMessageBox);
	
	// Sixth Horizontal Row has a Label and Text Area
	// This is where the Messages for selected User get displayed
	Box viewMessageBox = Box.createHorizontalBox();
	JLabel viewMessage = new JLabel("Message History:");
	final JTextArea myMessages = new JTextArea();
	viewMessageBox.add(viewMessage);
	viewMessageBox.add(myMessages);
	
	bigBox.add(viewMessageBox);
	
	// Add Action Listener for the "create" button. 
	// When the button is pressed, it calls the backEnd Method to add the user to the list.
	// We also need to refresh the list of users displayed in the JComboBox.
	create.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				String x = null; 
				BackEnd myBackEnd = new BackEnd();
				
				x = newUserInput.getText();
				//popup box
				JOptionPane.showMessageDialog(null, ("New User " + x + " Added"));
				//System.out.println("Adding User " + x);
				
				BackEnd.addMessage(x, null);
				
				// Refresh list of Users in "model" JComboBox
				model.addElement(x);
			}
		} );
	
	// Create and register listener for "selectUser" JComboBox
	// When a user is selected from drop down box, get the Messages for the selected User from backend
	// Display the messages in the TextArea "myMessages"
	   
    selectUser.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent evt) {
			JComboBox cb = (JComboBox) evt.getSource();
			//newItem has the name of the selected User
		    String newItem = (String) cb.getSelectedItem();
		    System.out.println(newItem);
		
		    // Call back end method to get messages for user "newItem"
			BackEnd myBackEnd = new BackEnd();
		    messageList = BackEnd.getMessage(newItem);
		    String messageString = "";
		    for( String s: messageList)
			{
				messageString+= s + "\n";
			}
		    // Display listofMessages in the TextArea myMessages
		    myMessages.setText(messageString);
		}
    	
    } );
    
    // Action Listener for the "add" button
    // When the "add" button is clicked, the message in "enterMessage" needs to be sent 
    // to the backEnd for selectedUser from JComboBox "selectUser"
    // The new message should also get displayed in the Message TextArea "myMessages"
    add.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent evt) {

			// Get name of User from "selectUser" JComboBox
			String myUser = (String) selectUser.getSelectedItem();
			
			
			// Get the message that has been typed
			String messageEntered = enterMessage.getText();
			System.out.println("create message - user is: " + myUser + " message is " + messageEntered);
		    // Call back end method to add the "messageEntered" to "myUser"
			BackEnd myBackEnd = new BackEnd();
			BackEnd.addMessage(myUser, messageEntered);
		    
			// Next get the List of messages from back end and display in the TextArea
			// String[] messageList = backEnd.getMessages(myUser);
		    // Temporary hack
		    //String[] messageList = {"one","two","three"};
		    String messageString = "";
		    for( String s: messageList)
			{
				messageString+= s + "\n";
			}
		    // Display listofMessages in the TextArea myMessages
		    myMessages.setText(messageString);
		    
		    //Blank out myMessages
		    enterMessage.setText(" ");
		}
    	
    } );
		
	myFrame.add(bigBox);
	myFrame.pack();
	myFrame.setVisible(true);
	}
}
