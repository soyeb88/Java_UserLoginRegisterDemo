package UserLoginRegisterGUIDemo;

import UserLoginRegisterConsoleDemo.dataStructure;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LogInFrame {
             
    private Container c = null;
    private JLabel userLavel = null;
    private JLabel passLavel = null;
    private JTextField userNameInput = null;
    private Font f = null;
    private JPasswordField userPassword = null;
    private JButton logIn = null;
    private JButton register_button = null;
       
    public LogInFrame(){

         JFrame frame = new JFrame();
         
         f = new Font("Ariel", Font.BOLD, 14);
         
         
         c = frame.getContentPane();        
         c.setLayout(null);
         c.setBounds(20, 30, 150, 50);
         
         
         userLavel = new JLabel();
         userLavel.setText("User Name: ");        
         userLavel.setBounds(20, 30, 150, 50);
         userLavel.setFont(f);       
         c.add(userLavel);   
         
         userNameInput = new JTextField();
         userNameInput.setBounds(120, 40, 150, 30);
         userNameInput.setFont(f);
         userNameInput.setHorizontalAlignment(JTextField.CENTER);
         c.add(userNameInput);
        
         
         passLavel = new JLabel("Password: ");       
         passLavel.setBounds(20, 80, 150, 50);  
         passLavel.setFont(f);
         c.add(passLavel);
         
                  
         userPassword = new JPasswordField();
         userPassword.setEchoChar('*');
         userPassword.setBounds(120, 90, 150, 30);
         userPassword.setFont(f);
         userPassword.setHorizontalAlignment(JPasswordField.CENTER);
         c.add(userPassword);

         //submit button
         logIn = new JButton("Log In");
         logIn.setBounds(120, 140, 100, 40);
         c.add(logIn);
         
         //register button
         register_button = new JButton("Register");
         register_button.setBounds(120, 190, 100, 40);
         c.add(register_button);
         
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
         frame.setBounds(500, 120, 400, 500);
         frame.setTitle("myApplication");
         frame.setVisible(true);
                     
         //Declare array
         String[] arr = new String[2];
         
         //add actionListener for login button
         logIn.addActionListener(new ActionListener(){

             @Override
             public void actionPerformed(ActionEvent e) {
                 String userName = userNameInput.getText();
                 String password = userPassword.getText();
                 
                 //Declare array
                 List l = new ArrayList(); 
                 //read data
                 fileManagementGUI fmn = new fileManagementGUI();
                 String f="";
                 try {
                    f = fmn.textFileReader("userAccount.txt");
                 } 
                 catch (IOException ex) {
                    Logger.getLogger(RegisterFrame.class.getName()).log(Level.SEVERE, null, ex);
                 }

                //split header information
                dataStructure ds = new dataStructure();        
                l = ds.splitWord(f);
                 
                //get encrypted password index
                int decrypt_password_index = l.indexOf(userName) + 1;
                //get encrypted password
                String decrypt_password = l.get(decrypt_password_index).toString();
                
                //get decrypted password
                dataUtilityGUI encryption_decryption = null;
                try {
                    encryption_decryption = new dataUtilityGUI();
                } 
                catch (Exception ex) {
                    Logger.getLogger(RegisterFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
                String DecPassword ="";
                try {
                    DecPassword = encryption_decryption.decrypt(decrypt_password);
                } 
                catch (Exception ex) {
                    System.out.println("error occcurs" + ex);
                }
                
                if(password.equals(DecPassword) && l.indexOf(userName) != -1){
                    frame.setVisible(false);
                    userFrame user = new userFrame();
                    user.display(userName);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Your password or username doesn't match!");
                }
             }
         });
         
         //add actionListener for Register window button
         register_button.addActionListener(new ActionListener(){
             @Override
             public void actionPerformed(ActionEvent ea) {
               frame.setVisible(false);
               RegisterFrame register_frame = new RegisterFrame();            
             }
         });
   
       }
}
