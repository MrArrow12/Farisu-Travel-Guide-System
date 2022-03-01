import java.io.FileReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */

interface FileIO
{   
    public void WriteFiles();
    public void SaveRecord(String Username, String Password);
    public void ReadFiles();
}
public class Databases implements FileIO {
    
     private String Username, Password;
     private boolean IsSaveRecord;
     private String filename,directory,path;
     private BufferedWriter fw =  new BufferedWriter( new FileWriter("User_Record.txt",true));
     
     
      private ArrayList<String> UsernameList = new ArrayList<String>(); // Create an ArrayList object
      private ArrayList<String> PasswordList = new ArrayList<String>(); // Create an ArrayList object
     File text = new File("User_Record.txt");
     
    Databases() throws FileNotFoundException, IOException
    {
       
      //Initialization
          ReadFiles();
       
    }
    
    public void setAccount(String inputUsername, String inputPassword) throws FileNotFoundException
    {
        Scanner read = new Scanner (text);
        read.useDelimiter(";");
        
        String ExtractName, ExtractPass;
        
        while(read.hasNext())
                {   
                    ExtractName = read.next();
                    ExtractPass = read.next();
                    
                    if(ExtractName.equals(inputUsername) && ExtractPass.equals(inputPassword))
                    {
                        Username = ExtractName;
                        Password = ExtractPass;
                        break;
                    }
                    
                     read.nextLine();
                }
        
        read.close();
        
    }
    
    public boolean Username_Exist(String getUserName)
    {   
        for(int i=0; i < UsernameList.size(); i++)
        {  
            if(UsernameList.get(i).equals(getUserName) )
            {
                return true;
            }
            
        }
        
        return false;
        
    }
    
    
    public String getUsername()
    {
        return Username;
    }
    
    public String getPassword()
    {
        return Password;
    }
    
    public void WriteFiles()
    {
        
    }
    
    public void SaveRecord(String Username, String Password)
    {
         try {
             fw.append(System.lineSeparator());
             fw.write(Username+";"+Password+";");
             
             fw.close();
             IsSaveRecord = true;
         } catch (IOException ex) {
             Logger.getLogger(Databases.class.getName()).log(Level.SEVERE, null, ex);
             IsSaveRecord = false;
         }
        
        
    }
    
    public boolean isSaveSucessful()
    {
        return IsSaveRecord;
    }
    
    public void ReadFiles()
    {
         try (Scanner read = new Scanner (text)) {
             read.useDelimiter(";");
             String ExtractName, ExtractPass;
             while(read.hasNext())
             {
                 ExtractName = read.next();
                 ExtractPass = read.next();
                 
                 UsernameList.add(ExtractName);
                 PasswordList.add(ExtractPass);
                 
                 read.nextLine();
                
             }
         } catch (FileNotFoundException ex) {
             Logger.getLogger(Databases.class.getName()).log(Level.SEVERE, null, ex);
         }
        
        System.out.println("Username: "+UsernameList.get(1));
        System.out.println("Password: "+PasswordList.get(1));
    }

}