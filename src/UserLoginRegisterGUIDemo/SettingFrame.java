package UserLoginRegisterGUIDemo;

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

public class SettingFrame {
    private JFrame Userframe = null;
    private Container userContainer = null;
    private JLabel userLoggedIn = null;
    private JLabel userFirstName = null;
    private JLabel userLastName = null;
    private JLabel userEmail = null;
    private JLabel userName = null;
    private JLabel partitionPasswordChange = null;
    private JLabel password1 = null;
    private JLabel password2 = null;
    private JTextField userFirstNameInput = null;
    private JTextField userLastNameInput = null;
    private JTextField userEmailInput = null;
    private JTextField userNameInput = null;
    private JPasswordField passwordInput1 = null;
    private JPasswordField passwordInput2 = null;
    private Font f = null;
    private JButton onlineSearch = null;
    private JButton offlineSearch = null;
    private JButton saveButton = null;
    private JButton backWindow = null;
    
    //initial data
    List singleUserData = null;
    List singleUserDataValidation = null;
    
    String UniqueEmailNameToCheck = "";
    String UniqueUserNameToCheck = "";
    
    
    SettingFrame(){
         Userframe = new JFrame();
         Userframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
         Userframe.setBounds(500, 120, 400, 600);
         Userframe.setTitle("Setting Account");
         Userframe.setVisible(true);
    }
    
       void display(String LoggedInUserName){
         
        singleUserData = new ArrayList(); 
        
        dataStructureGUI dataGui = new dataStructureGUI();
        singleUserData = dataGui.getData(LoggedInUserName);  
        
         //GUI PART  
         f = new Font("Ariel", Font.BOLD, 14);         
         
         userContainer = Userframe.getContentPane();        
         userContainer.setLayout(null);
         userContainer.setBounds(20, 30, 150, 50);
         
         userLoggedIn = new JLabel();
         userLoggedIn.setText("Wellcome! "+ LoggedInUserName);        
         userLoggedIn.setBounds(20, 0, 180, 50);
         userLoggedIn.setFont(f);       
         userContainer.add(userLoggedIn);   
         
         userLoggedIn = new JLabel();
         userLoggedIn.setText("Edit Your Account");        
         userLoggedIn.setBounds(150, 30, 180, 50);
         userLoggedIn.setFont(f);       
         userContainer.add(userLoggedIn);
         
         userFirstName = new JLabel();
         userFirstName.setText("First Name: ");        
         userFirstName.setBounds(20, 70, 150, 50);
         userFirstName.setFont(f);       
         userContainer.add(userFirstName);  
         
         userFirstNameInput = new JTextField(singleUserData.get(1).toString());
         userFirstNameInput.setBounds(150, 80, 150, 30);
         userFirstNameInput.setFont(f);
         userFirstNameInput.setHorizontalAlignment(JTextField.CENTER);
         userContainer.add(userFirstNameInput);
         
         userLastName = new JLabel();
         userLastName.setText("Last Name: ");        
         userLastName.setBounds(20, 120, 150, 50);
         userLastName.setFont(f);       
         userContainer.add(userLastName);  
         
         userLastNameInput = new JTextField(singleUserData.get(3).toString());
         userLastNameInput.setBounds(150, 130, 150, 30);
         userLastNameInput.setFont(f);
         userLastNameInput.setHorizontalAlignment(JTextField.CENTER);
         userContainer.add(userLastNameInput);
         
         //eidt
         userEmail = new JLabel();
         userEmail.setText("Email Address: ");        
         userEmail.setBounds(20, 170, 150, 50);
         userEmail.setFont(f);       
         userContainer.add(userEmail);  
         
         userEmailInput = new JTextField(singleUserData.get(5).toString());
         userEmailInput.setBounds(150, 180, 150, 30);
         userEmailInput.setFont(f);
         userEmailInput.setHorizontalAlignment(JTextField.CENTER);
         userContainer.add(userEmailInput);
         
         userName = new JLabel();
         userName.setText("User Name: ");        
         userName.setBounds(20, 230, 150, 50);
         userName.setFont(f);       
         userContainer.add(userName);  
         
         userNameInput = new JTextField(singleUserData.get(7).toString());
         userNameInput.setBounds(150, 240, 150, 30);
         userNameInput.setFont(f);
         userNameInput.setHorizontalAlignment(JTextField.CENTER);
         userContainer.add(userNameInput);
         
         partitionPasswordChange = new JLabel();
         partitionPasswordChange.setText("Password Change");        
         partitionPasswordChange.setBounds(150, 280, 250, 50);
         partitionPasswordChange.setFont(f);       
         userContainer.add(partitionPasswordChange);
         
         password1 = new JLabel();
         password1.setText("Password: ");        
         password1.setBounds(20, 320, 150, 50);
         password1.setFont(f);       
         userContainer.add(password1);
        
        //Create password input Field
        passwordInput1 = new JPasswordField();
        passwordInput1.setBounds(150, 330, 150, 30);
        passwordInput1.setFont(f);
        passwordInput1.setHorizontalAlignment(JTextField.CENTER);
        userContainer.add(passwordInput1);
        
        password2 = new JLabel();
        password2.setText("Retype Password: ");        
        password2.setBounds(20, 370, 160, 50);
        password2.setFont(f);       
        userContainer.add(password2);
        
        //Create password input Field
        passwordInput2 = new JPasswordField();
        passwordInput2.setBounds(150, 380, 150, 30);
        passwordInput2.setFont(f);
        passwordInput2.setHorizontalAlignment(JTextField.CENTER);
        userContainer.add(passwordInput2);
        
        //register button
        saveButton = new JButton("Save Change");
        saveButton.setBounds(150, 430, 140, 40);
        userContainer.add(saveButton);
        
        //create go back to login frame button
        backWindow = new JButton("Back");
        backWindow.setBounds(150, 480, 140, 40);
        userContainer.add(backWindow);
        
        saveButton.addActionListener(new ActionListener(){ 
            dataStructureGUI dataGui = new dataStructureGUI();
            
             @Override
             public void actionPerformed(ActionEvent ea) {
               int userChoice = JOptionPane.showConfirmDialog(null, "Do you want to save the Change? If Yes it will be permanently changed!", "Alerm", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
               
               if(userChoice == JOptionPane.YES_OPTION){
                   //Seperate first input before modify singleUserData
                   UniqueEmailNameToCheck = singleUserData.get(5).toString();
                   UniqueUserNameToCheck = singleUserData.get(7).toString();

                   StringBuffer s = new StringBuffer();

                   dataStructureGUI editUser = new dataStructureGUI();
                   singleUserData.set(1, userFirstNameInput.getText());
                   singleUserData.set(3, userLastNameInput.getText());
                   singleUserData.set(5, userEmailInput.getText());
                   singleUserData.set(7, userNameInput.getText());
                   
                   
                  //add encrypted password
                  dataUtilityGUI data_utility = new dataUtilityGUI();
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
                    
                    
                    
                   String email = "";
                   String userName = ""; 
                    
                   String password1 = passwordInput1.getText();;
                   String password2 = passwordInput1.getText();;

                   //an algrithm to help to access empty password
                   if(!password1.isEmpty()){
                       System.out.println("if!");
                      //set userName and Email
                      password1  = passwordInput1.getText();
                      password2  = passwordInput2.getText();
                      
                      //set new Password
                      singleUserData.set(9 ,EncPassword);
                   }
                   else{
                       System.out.println("else!");
                       
                       //set default password
                       password1 = "Dhaka1994";
                       password2 = "Dhaka1994";
                       
                      //set old Password
                      singleUserData.set(9 ,singleUserData.get(9).toString());
                   }
                   
                   //an algorithm to help to access and to verify unique email address
                   if(!singleUserData.get(5).toString().equals(UniqueEmailNameToCheck)){
                       //set  Email
                       email = userEmailInput.getText();
                   }
                   else{
                       System.out.println("else!");
                       
                       //set default email
                       email = "abc@gmail.com";
                   }
                   
                   //an algrithm to help to access and to verify unique username
                   if(!singleUserData.get(7).toString().equals(UniqueUserNameToCheck)){
                       //set userName 
                       userName = userNameInput.getText();
                   }
                   else{
                       System.out.println("else!");
                       //set default email
                       userName = "abc";
                   }
                   
                   
                   
                   //set new List for validation
                   singleUserDataValidation = new ArrayList();
                   singleUserDataValidation.add(userFirstNameInput.getText());
                   singleUserDataValidation.add(userLastNameInput.getText());
                   singleUserDataValidation.add(email);
                   singleUserDataValidation.add(userName);
                   singleUserDataValidation.add(password1);
                   singleUserDataValidation.add(password2);
                   
                   s = data_utility.FromValidation(singleUserDataValidation);
                   
                   if(s.length() != 0){
                        //show the erro on frame
                        JOptionPane.showMessageDialog(null, s);
                        //reset the ArrayList
                        singleUserData = dataGui.getData(LoggedInUserName); 
                   }
                   else{
                        try {
                            editUser.editData(singleUserData);
                        } 
                        catch (IOException ex) {
                            Logger.getLogger(SettingFrame.class.getName()).log(Level.SEVERE, null, ex);
                        }
                   }
               }
               else{
                   //show the erro on frame
                   JOptionPane.showMessageDialog(null, "No change!");
               }
             }
         });
        
        backWindow.addActionListener(new ActionListener(){
             @Override
             public void actionPerformed(ActionEvent ea) {
               Userframe.setVisible(false);
               userFrame user = new userFrame();
               user.display(LoggedInUserName);           
             }
         });          
    }
    
    //Test Purpose
    /*  
    public static void main(String[] args) {
           
        SettingFrame settings = new SettingFrame();
        settings.display("soyeb88");
    }
    */
    
}
