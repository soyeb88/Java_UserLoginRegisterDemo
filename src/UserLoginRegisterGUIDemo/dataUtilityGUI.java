package UserLoginRegisterGUIDemo;

import UserLoginRegisterConsoleDemo.dataStructure;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.ListIterator;
import java.util.logging.Level;
import java.util.logging.Logger;

public class dataUtilityGUI {
    /* Split data */
    public List splitWord(String fullText){
        
        List l = new ArrayList(); 
        
        for(String strVal : fullText.split("\\|")){
            //System.out.println(strVal);
            l.add(strVal);
        }       
        
        return l;
    }
    
    /* encrypt password */   
    public String encrypt(String password) throws Exception {
        String originalInput = password;
        String encodedString = Base64.getEncoder().encodeToString(originalInput.getBytes());
        return encodedString;
    }

       
    /* decrypt password */   
    public String decrypt(String password) throws Exception {
         byte[] decodedBytes = Base64.getDecoder().decode(password);
         String decodedString = new String(decodedBytes);
         return decodedString;
    }
    
    /* Set the index number and design the data*/
    String setIndex(String header,List l){
       
        String result = "";
            
        dataStructure ds = new dataStructure();
        List s = ds.splitWord(header);


        //this number is determined by the header length - 1
        int primeNum = s.size() - 1;

        //added data into the file if it is the first line
        if(l.lastIndexOf("date\n") == l.size()-primeNum){
            l.add(primeNum+1, "0");
            ListIterator<String> iterator = l.listIterator(); 
            //add data to the String
            while (iterator.hasNext()) {
                if(iterator.nextIndex() + 1 == l.size()){
                    result += iterator.next() + "\n";
                }
                else{
                    result += iterator.next() + "|";
                }
            }
        }
        else{
            //added data into the file after first line
            int getLastIndex = l.size() - (primeNum+(primeNum - 1));  
            String lastIndexStr = (String) (l.get(getLastIndex));
            int lastIndexNum = 1 + (Integer.parseInt(lastIndexStr));
            String lastIndexStrNew = Integer.toString(lastIndexNum);

            l.add(l.size() - (primeNum-1), lastIndexStrNew);
            ListIterator<String> iterator = l.listIterator(); 
            while (iterator.hasNext()) {
                if(iterator.nextIndex() + 1 == l.size()){
                    result += iterator.next() + "\n";
                }
                else{
                    result += iterator.next() + "|";
                }
            }
        }
        
       return result;
    }
    
    //validation of user input
    StringBuffer FromValidation(List list){
        
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
        
        //create StringBuffer to store error message
        StringBuffer s = new StringBuffer();
        
        //check email validity
         if(list.get(0).toString().isEmpty() || list.get(1).toString().isEmpty()){
             s.append("You must be complete the all blank fields\n");
         }   

        //check email name validity
         if(!isValidEmail(list.get(2).toString())){
             s.append("The email address is not valid!\n");
         }
         
         //check unique email validity
         if(l.indexOf(list.get(2).toString()) != -1 && !list.get(2).toString().isEmpty()){
             s.append("The email has already exists.\n");
         }
         
         //check blank email validity
         if(list.get(2).toString().isEmpty()){
             s.append("You must give the email adddress.\n");
         }

         //check username validity
         if(!isValidUserName(list.get(3).toString())){
             s.append("The User Name is not valid!\n");
         }
         
         //check unique user name validity
         if(l.indexOf(list.get(3).toString()) != -1){
             s.append("The User Name has already exists.\n");
         }
         
         //check blank user name validity
         if(list.get(3).toString().isEmpty()){
             s.append("You must give the user name.\n");
         }
         
         //check validation of the passwords
         if(!list.get(4).toString().equals(list.get(5).toString())){
             s.append("Doesn't match the password!\n");
         }
         if(list.get(4).toString().length() < 6){
             s.append("Password must be greater than 5!");
         }
         return s;
    }
   
    //construct method to valid email
    boolean isValidUserName(String username) {
        String regex = "^[\\w]+[\\w-_\\.]*[\\w]$";
        return username.matches(regex);
    }

    //construct method to valid email
    boolean isValidEmail(String email) {
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        return email.matches(regex);
    }
}
