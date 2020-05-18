package UserLoginRegisterConsoleDemo;
import java.io.*;
import java.util.List;
import java.util.ListIterator;

public class fileManagement{
    
    public String textFileReader(String fileName) throws IOException{
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
            System.out.println("Exceptional to read the file" + e);
        }
        finally{
            if(fis != null){
                fis.close();
            }
        }
        
        return str;
    }
    
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
            FileWriter myWriter = new FileWriter("input.txt");
            myWriter.write(StringBuffer);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } 
        catch (IOException e) {
          System.out.println("An error occurred.");
          e.printStackTrace();
        }
         myConsole mc = new myConsole();
         mc.myDrive();
    }
            
}