package UserLoginRegisterConsoleDemo;
import UserLoginRegisterConsoleDemo.fileManagement;
import java.io.IOException;
import java.util.*;

public class dataStructure {
    
    //split the words
    public List splitWord(String fullText){
        
        List l = new ArrayList(); 
        
        for(String strVal : fullText.split("\\|")){
            //System.out.println(strVal);
            l.add(strVal);
        }       
        
        return l;
    }
    
    //add data
    public void addData(List l) throws IOException{
        System.out.println("-- Add Records --");
        
        Scanner input = new Scanner(System.in);
                
        System.out.println("Employer Name: ");              
        String name = input.nextLine();        
        
        System.out.println("Employer Address: ");              
        String address = input.nextLine();        
        
        System.out.println("Employer Phone Number: ");              
        String phone = input.nextLine();
        
                
        int getLastIndex = l.size() - 4;  
        String lastIndexStr = (String) (l.get(getLastIndex));
        int lastIndexNum = 1 + (Integer.parseInt(lastIndexStr));
        String lastIndexStrNew = Integer.toString(lastIndexNum);
                
        l.add(lastIndexStrNew);
        l.add(name);
        l.add(address);
        l.add(phone);        
        
        fileManagement fr = new fileManagement(); 
        fr.textFileWriter("input.txt", l); 
        return;
    }
    
    //search data by index
    public void searchData(List data) throws IOException{
        
        System.out.println("-- Search Records --");
        
        Scanner input = new Scanner(System.in);
                
        System.out.println("Please enter Index Number: ");              
        String indexStr = input.next();        
        	
        int index = data.indexOf(indexStr);
        
        if(index == -1){
            System.out.println("User not found!");
        }
        else{

            System.out.print("Id: " + data.get(index) + "\t");
            System.out.print("Name: " + data.get(index + 1) + "\t");
            System.out.print("Address: " + data.get(index + 2) + "\t");
            System.out.print("Phone Number: " + data.get(index + 3) + "\t");
        }
        myConsole mc = new myConsole();
        mc.myDrive();
    }
    
    //Edit data by index
    public void editData(List data) throws IOException{
                     
        System.out.println("-- Edit Records --");
        
        fileManagement fr = new fileManagement(); 
        
        Scanner input = new Scanner(System.in);
                
        System.out.println("Please enter Index Number to Edit: ");              
        String indexStr = input.next();                  	
        int index = data.indexOf(indexStr);

                    
        char inputChar; 
       
        
        if(index == -1){
            System.out.println("User not found!");
        }
        else{
            System.out.println("Edit your data: ");
            System.out.println("-- Edit name Press n --");
            System.out.println("-- Edit address Press a --");
            System.out.println("-- Edit Phone Number Press p --");  
            
                   
        
            do {                
                inputChar = input.next().charAt(0); 
                if(inputChar == 'n'){                                   
                    System.out.println("Edit Name: ");              
                    String indexName = input.next(); 
                    data.set(index + 1, indexName);
               }
               else if(inputChar == 'a'){
                   System.out.println("Edit Address: ");              
                   String indexAddress = input.next();
                   data.set(index + 2, indexAddress);
               }
               else if(inputChar == 'p'){
                     System.out.println("Edit Phone: ");              
                     String indexPhone = input.next();
                     data.set(index + 3, indexPhone + "\n");
               }
            } while(inputChar != 'q');                
            fr.textFileWriter("input.txt", data);
        }
        myConsole mc = new myConsole();
        mc.myDrive();
    }
    
    //delete data
    public void deleteData(List data) throws IOException{
        
        Scanner input = new Scanner(System.in);
        
        System.out.println("Please enter Index Number to remove: ");              
        String indexStr = input.next();                  	
        int index = data.indexOf(indexStr);
        data.remove(index);
        data.remove(index);
        data.remove(index);
        data.remove(index);
        
        fileManagement fr = new fileManagement(); 
        fr.textFileWriter("input.txt", data); 
        myConsole mc = new myConsole();
        mc.myDrive();
    }
    
}
