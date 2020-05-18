package otherUtility;

import java.io.IOException;
import java.io.File;
import java.io.FileWriter;

/** This is created to add new file with header **/
public class FileIOGUI {
    
    public static void create_file(){
        String header = "id|firstName|lastName|email|userName|password\n";
        
        try {
           File myObj = new File("userAccountDetails.txt"); 
           if(myObj.createNewFile()){
               System.out.println("File created " + myObj.getName());
               
               FileWriter myWriter = new FileWriter(myObj.getName());
               myWriter.write(header);
               myWriter.close();
               System.out.println("Successfully wrote to the file.");              
           }
           else{
               System.out.println("File already exists");
           }
        }
        catch (IOException e){
            System.out.println("An error occurs");
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args){
        create_file();
    }
}    

