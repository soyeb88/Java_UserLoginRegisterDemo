package UserLoginRegisterGUIDemo;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class userFrame {
        private JFrame Userframe = null;
        private Container userContainer = null;
        private JLabel userLavel = null;
        private Font f = null;
        private JButton onlineSearch = null;
        private JButton offlineSearch = null;
        private JButton Edit = null;
        private JButton setting = null;
        private JButton logout = null;

    
    userFrame(){
         Userframe = new JFrame();
         Userframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
         Userframe.setBounds(500, 120, 400, 500);
         Userframe.setTitle("User Account");
         Userframe.setVisible(true);
    }
    
    void display(String LoggedInUserName){
         
         f = new Font("Ariel", Font.BOLD, 14);         
         
         userContainer = Userframe.getContentPane();        
         userContainer.setLayout(null);
         userContainer.setBounds(20, 30, 150, 50);
         
         userLavel = new JLabel();
         userLavel.setText("Wellcome! "+ LoggedInUserName);        
         userLavel.setBounds(20, 10, 180, 50);
         userLavel.setFont(f);       
         userContainer.add(userLavel);   
         
         
         //Online Search button
         onlineSearch = new JButton("Online Search");
         onlineSearch.setBounds(130, 70, 120, 40);
         userContainer.add(onlineSearch);

         //Offline Search button
         offlineSearch = new JButton("Offline Search");
         offlineSearch.setBounds(130, 120, 120, 40);
         userContainer.add(offlineSearch);
         
         //Edi data to Query button
         Edit = new JButton("Edit data");
         Edit.setBounds(130, 170, 120, 40);
         userContainer.add(Edit);
         
         //Setting Account
         setting = new JButton("Setting Account");
         setting.setBounds(130, 220, 120, 40);
         userContainer.add(setting);
         
         //create go back to log out button
        logout = new JButton("Log Out");
        logout.setBounds(130, 270, 120, 40);
        userContainer.add(logout);
         
         setting.addActionListener(new ActionListener(){
             @Override
             public void actionPerformed(ActionEvent e) {
                SettingFrame settings = new SettingFrame();
                Userframe.setVisible(false);
                settings.display(LoggedInUserName);
             }
         });
        
        logout.addActionListener(new ActionListener(){
             @Override
             public void actionPerformed(ActionEvent ea) {
               Userframe.setVisible(false);
               new LogInFrame();           
             }
         }); 
    }
}
