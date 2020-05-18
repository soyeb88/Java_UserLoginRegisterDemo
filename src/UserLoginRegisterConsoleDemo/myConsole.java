package UserLoginRegisterConsoleDemo;

import UserLoginRegisterConsoleDemo.dataStructure;
import UserLoginRegisterConsoleDemo.fileManagement;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class myConsole {
    
    void myDrive() throws IOException{
        
    fileManagement fr = new fileManagement();        
        String returnText = fr.textFileReader("input.txt");
        
        //create new data structure class
        dataStructure ds = new dataStructure();
        
        //split data
        List l = ds.splitWord(returnText);
        
        Scanner input = new Scanner(System.in);
        System.out.println("Please select one of the option:");
        System.out.println("-- 'a' for Add Data --");
        System.out.println("-- 's' for Search Data --");
        System.out.println("-- 'e' for Edit Data --");
        System.out.println("-- 'd' for Delete Data --");
        System.out.println("-- 'q' for Quite the console --");
        char userInput = input.next().charAt(0);
        do {
            if('a' == userInput){
                //add data
                ds.addData(l);
            }
            else if('s' == userInput){
                //Search data             
                ds.searchData(l);
            }
            else if('e' == userInput){
                //Search data             
                ds.editData(l);
            }
            else if('d' == userInput){
                //Search data             
                ds.deleteData(l);
            }
        } while (userInput != 'q');
        
    }

}
