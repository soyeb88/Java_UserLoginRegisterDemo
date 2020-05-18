package UserLoginRegisterGUIDemo;
import java.io.*;
import java.util.List;
import java.util.ListIterator;
import javax.swing.JOptionPane;

public class fileManagementGUI{
    
    public static String textFileReader(String fileName) throws IOException{
        FileInputStream fis = null;
        String str="";
        
        try {
            fis = new FileInputStream(fileName);
            int i;
            char c;
            
            while ((i = fis.read()) != -1) {
                c = (char) i;
                str += c;
            }
            
        } catch (Exception e) {
            System.out.println("File doesn't exists.");
        }
        finally{
            if(fis != null){
                fis.close();
            }
        }
        
        return str;
    }
    
    //text File writer to create new file and add data
    public static void textFileWriter(String fileName,String header,List l) throws IOException{
        //check file exists and build up header
    
        File f = new File(fileName);
        
        
        if(!f.exists() && !f.isDirectory()){
            FileWriter myWriter = new FileWriter(fileName);
            myWriter.write(header);
            myWriter.close();
            JOptionPane.showMessageDialog(null, "File doesn't exixts. File created successfully! please resubmit.");
        }
        else{
            dataUtilityGUI data_structure_gui = new dataUtilityGUI();
            String result = data_structure_gui.setIndex(header, l);
            try {
                FileWriter myWriter = new FileWriter(fileName);
                myWriter.write(result);
                myWriter.close();
               JOptionPane.showMessageDialog(null, "Your Account created successfully!");
             } 
            catch (IOException e) {
              System.out.println("An error occurred.");
              e.printStackTrace();
            }
        }
    }
    
    //text File writer to add data old file
    public void textFileWriter(String fileName, List l) throws IOException{
        
        String StringBuffer="";
        
        ListIterator<String> iterator = l.listIterator(); 
          
        
        while (iterator.hasNext()) {
            if(iterator.nextIndex() + 1 == l.size()){
                StringBuffer += iterator.next() + "\n";
            }
            else{
                StringBuffer += iterator.next() + "|";
            }
        }
        
         try {
            FileWriter myWriter = new FileWriter("userAccount.txt");
            myWriter.write(StringBuffer);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } 
        catch (IOException e) {
          System.out.println("An error occurred.");
          e.printStackTrace();
        }
    }
}