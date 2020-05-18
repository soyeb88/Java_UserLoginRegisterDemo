package UserLoginRegisterGUIDemo;

import UserLoginRegisterConsoleDemo.dataStructure;
import java.util.*;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class RegisterFrame {
    //initialize   
    private Container container = null;
    private JLabel firstName = null;
    private JLabel lastName = null;
    private JLabel email = null;
    private JLabel username = null;
    private JLabel password1 = null;
    private JLabel password2 = null;
    private JTextField firstNameInput = null;
    private JTextField lastNameInput = null;
    private JTextField emailInput = null;
    private JTextField userNameInput = null;
    private JPasswordField passwordInput1 = null;
    private JPasswordField passwordInput2 = null;
    private Font font = null;
    private JButton accountButton = null;
    private JButton backLoginButton = null;
    private Font font_errorMessage = null;
    private JLabel errorMessage = null;
    
       
    public RegisterFrame(){
        //create frame
         JFrame registerFrame = new JFrame();
         
        //create text font
        font = new Font("Ariel", Font.BOLD, 14);
         
        //create container 
        container = registerFrame.getContentPane();        
        container.setLayout(null);
        container.setBounds(20, 30, 150, 50);
        
        //create First Name 
        //create First Name Label
        firstName = new JLabel();
        firstName.setText("First Name: ");        
        firstName.setBounds(20, 30, 150, 50);
        firstName.setFont(font);       
        container.add(firstName);   
         
        //Create First Name Text Field
        firstNameInput = new JTextField();
        firstNameInput.setBounds(160, 40, 150, 30);
        firstNameInput.setFont(font);
        firstNameInput.setHorizontalAlignment(JTextField.CENTER);
        container.add(firstNameInput);
        
        //create Last Name 
        //create Last Name Label
        lastName = new JLabel();
        lastName.setText("Last Name: ");        
        lastName.setBounds(20, 70, 150, 50);
        lastName.setFont(font);       
        container.add(lastName);   
         
        //Create Last Name Text Field
        lastNameInput = new JTextField();
        lastNameInput.setBounds(160, 80, 150, 30);
        lastNameInput.setFont(font);
        lastNameInput.setHorizontalAlignment(JTextField.CENTER);
        container.add(lastNameInput);
        
        //create Email 
        //create Email Label
        email = new JLabel();
        email.setText("Email: ");        
        email.setBounds(20, 110, 150, 50);
        email.setFont(font);       
        container.add(email);   
         
        //Create Email Text Field
        emailInput = new JTextField();
        emailInput.setBounds(160, 120, 150, 30);
        emailInput.setFont(font);
        emailInput.setHorizontalAlignment(JTextField.CENTER);
        container.add(emailInput);
        
        //create Username 
        //create Username Label
        username = new JLabel();
        username.setText("User Name: ");        
        username.setBounds(20, 150, 150, 50);
        username.setFont(font);       
        container.add(username);   
         
        //Create UserName Text Field
        userNameInput = new JTextField();
        userNameInput.setBounds(160, 160, 150, 30);
        userNameInput.setFont(font);
        userNameInput.setHorizontalAlignment(JTextField.CENTER);
        container.add(userNameInput);
        
        //create Password 
        //create Password_1 Label
        password1 = new JLabel();
        password1.setText("Password: ");        
        password1.setBounds(20, 190, 150, 50);
        password1.setFont(font);       
        container.add(password1);
        
        //Create password input Field
        passwordInput1 = new JPasswordField();
        passwordInput1.setBounds(160, 200, 150, 30);
        passwordInput1.setFont(font);
        passwordInput1.setHorizontalAlignment(JTextField.CENTER);
        container.add(passwordInput1);
        
       //create Password_2 Label
        password2 = new JLabel();
        password2.setText("Retype Password: ");        
        password2.setBounds(20, 230, 150, 50);
        password2.setFont(font);       
        container.add(password2);
        
        //Create password input Field
        passwordInput2 = new JPasswordField();
        passwordInput2.setBounds(160, 240, 150, 30);
        passwordInput2.setFont(font);
        passwordInput2.setHorizontalAlignment(JTextField.CENTER);
        container.add(passwordInput2);
        
        //create account buuton
        //register button
        accountButton = new JButton("Register Account");
        accountButton.setBounds(160, 280, 150, 40);
        container.add(accountButton);
        
        //create go back to login frame button
        backLoginButton = new JButton("Back to Log in window ");
        backLoginButton.setBounds(160, 320, 170, 40);
        container.add(backLoginButton);
        
        //create register frame
        registerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
        registerFrame.setBounds(500, 120, 400, 500);
        registerFrame.setTitle("Register Account");
        registerFrame.setVisible(true);
                              
         
         accountButton.addActionListener(new ActionListener(){
             
             @Override
             public void actionPerformed(ActionEvent e) {


                //Declare array
                List l = new ArrayList(); 
                
                //Declare array
                List checkValidationList = new ArrayList();
                
                //header information
                 String header = "|id|firstName|lastName|Email|userName|password|userActive|date\n";
                 
                 StringBuffer s = new StringBuffer();
                 
                 
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
                
                
                //seperate email and userName to check its' existance
                String eamil = emailInput.getText().toString();
                String username = userNameInput.getText().toString(); 
                 
                checkValidationList.add(firstNameInput.getText().toString());
                checkValidationList.add(lastNameInput.getText().toString());
                checkValidationList.add(eamil);
                checkValidationList.add(username);
                checkValidationList.add(passwordInput1.getText().toString());
                checkValidationList.add(passwordInput2.getText().toString());

                
                                 
                dataUtilityGUI data_utility = new dataUtilityGUI();
                s = data_utility.FromValidation(checkValidationList);
                
                l.add(firstNameInput.getText().toString());
                l.add(lastNameInput.getText().toString());
                l.add(emailInput.getText().toString());
                l.add(userNameInput.getText().toString());
                
                //add encrypted password
                dataUtilityGUI encryption_decryption = null;
                try {
                    encryption_decryption = new dataUtilityGUI();
                } 
                catch (Exception ex) {
                    Logger.getLogger(RegisterFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
                String EncPassword ="";
                try {
                    EncPassword = data_utility.encrypt(passwordInput1.getText().toString());
                } 
                catch (Exception ex) {
                    Logger.getLogger(RegisterFrame.class.getName()).log(Level.SEVERE, null, ex);
                }                 
                l.add(EncPassword);
                
                l.add("yes");
                
                //add current date
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
                LocalDate localDate = LocalDate.now();
                String date = dtf.format(localDate);
                l.add(date);
                
                if(s.length() != 0){
                    //show the erro on frame
                    JOptionPane.showMessageDialog(null, s);
                }
                else{

                    try {
                        //write data
                        fmn.textFileWriter("userAccount.txt", header, l);
                    } 
                    catch (IOException ex) {
                        Logger.getLogger(RegisterFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    firstNameInput.setText("");
                    lastNameInput.setText("");
                    emailInput.setText("");
                    userNameInput.setText("");
                    passwordInput1.setText("");
                    passwordInput2.setText("");
                }
                  
             }
         });
         backLoginButton.addActionListener(new ActionListener(){
             @Override
             public void actionPerformed(ActionEvent ea) {
               registerFrame.setVisible(false);
               LogInFrame login_frame = new LogInFrame();            
             }
         }); 
       }
        //Test
        /*
        public static void main(String[] args) {

            RegisterFrame rehister = new RegisterFrame();
        }
        */
}
