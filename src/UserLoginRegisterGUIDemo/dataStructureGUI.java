package UserLoginRegisterGUIDemo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import UserLoginRegisterConsoleDemo.dataStructure;

public class dataStructureGUI {
    
    public List getData(String userName){

        //Declare array to get data from reading file
         List readData = new ArrayList(); 
         
         //Declare array to get data from reading file
         List returnData = new ArrayList(); 
         
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
        readData = ds.splitWord(f);
        
        //get backword third index data at target data value
        returnData.add(readData.indexOf(userName) - 3);
        returnData.add(readData.get(readData.indexOf(userName) - 3).toString());
        
        //get backword second index data at target data vareadDataue
        returnData.add(readData.indexOf(userName) - 2);
        returnData.add(readData.get(readData.indexOf(userName) - 2).toString());
        
        //get backword first index data at target data value
        returnData.add(readData.indexOf(userName) - 1);
        returnData.add(readData.get(readData.indexOf(userName) - 1).toString());        
        
        //get target data index vakue at target data value
        returnData.add(readData.indexOf(userName));
        returnData.add(readData.get(readData.indexOf(userName)).toString());        
        
        
        //get forward first index data at target data value
        returnData.add(readData.indexOf(userName) + 1);
        returnData.add(readData.get(readData.indexOf(userName) + 1).toString());        
        
        //get forward second index data at target data value
         returnData.add(readData.indexOf(userName) + 2);
        returnData.add(readData.get(readData.indexOf(userName) + 2).toString());        
        
        //get forward third index data at target data value
        returnData.add(readData.indexOf(userName) + 3);
        returnData.add(readData.get(readData.indexOf(userName) + 3).toString());        
        
        //return data
        return returnData;
    }
    
    //Edit data by index
    public void editData(List singleUserdata) throws IOException{
              
        //Declare array to get data from reading file
         List readData = new ArrayList(); 
         
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
        readData = ds.splitWord(f);
        
        readData.set(Integer.parseInt(singleUserdata.get(0).toString()), singleUserdata.get(1).toString());
        readData.set(Integer.parseInt(singleUserdata.get(2).toString()), singleUserdata.get(3).toString());
        readData.set(Integer.parseInt(singleUserdata.get(4).toString()), singleUserdata.get(5).toString());
        readData.set(Integer.parseInt(singleUserdata.get(6).toString()), singleUserdata.get(7).toString());
        readData.set(Integer.parseInt(singleUserdata.get(8).toString()), singleUserdata.get(9).toString());



        System.out.println(readData);
        
       
        fileManagementGUI fr = new fileManagementGUI(); 
        fr.textFileWriter("userAccount.txt", readData);
        
        //show the update message
        JOptionPane.showMessageDialog(null, "Account Update Successfully!");
    }
    
    //test Purpose
    /*
    public static void main(String[] args) {
        List getUserData = new ArrayList(); 
        dataStructureGUI dataGui = new dataStructureGUI();
        getUserData = dataGui.getData("soyeb88");
        System.out.println(getUserData);
    }
    */
}
