import java.io.FileReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
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
    public void SaveRecord(String Username, String Password);
    public void ReadRecord();
    public void UpdateRecord(int UserID,boolean UserChange, boolean PassChange, boolean ReceiptChange);
}
public class Databases implements FileIO {
    
     private String Username, Password, Receipt;
     private int ID;
     private boolean IsSaveRecord;
     private String filename,directory,path;
     private BufferedWriter fw =  new BufferedWriter( new FileWriter("User_Record.txt",true));
     
     private Connection conn = null;
      private ArrayList<String> UsernameList = new ArrayList<String>(); // Create an ArrayList object
      private ArrayList<String> PasswordList = new ArrayList<String>(); // Create an ArrayList object
      private ArrayList<Integer> UserID = new ArrayList<Integer>();
     File text = new File("User_Record.txt");
     
    Databases() throws FileNotFoundException, IOException
    {
       
      //Initialization
          ReadRecord();
  
    }
    
    public void setAccount(String inputUsername, String inputPassword) throws FileNotFoundException
    {  
        
       for(int i=0; i<UsernameList.size(); i++)
       {
           if(UsernameList.get(i).equals(inputUsername) && PasswordList.get(i).equals(inputPassword) )
           {
               Username = UsernameList.get(i);
               Password = PasswordList.get(i);
               ID = UserID.get(i);
               
           }
       }
       
        
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
    
    public int getID()
    {
        return ID;
    }
    
    public void setReceipt(String Receipt)
    {
        this.Receipt = Receipt;
    }
    
    public void UpdateRecord(int UserID, boolean UserChange, boolean PassChange, boolean ReceiptChange)
    {
         try{
            //Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/account","root","Then00bwar@156210");
            if(conn!=null)
            {
                System.out.println("Connected to databases");
                
            }
             if (ReceiptChange == true)
             {
             Statement stmt = conn.createStatement();
             String result = "UPDATE tourist SET receipt = ? WHERE id = ?";
             PreparedStatement preparedStmt = conn.prepareStatement(result);
             preparedStmt.setString   (1, Receipt);
             preparedStmt.setInt (2, UserID);
             preparedStmt.executeUpdate();
              System.out.println("Receipt has been Changed");
             }
             
             if (UserChange == true)
             {
                   Statement stmt = conn.createStatement();
                   String result = "UPDATE tourist SET Username = ? WHERE id = ?";
                   PreparedStatement preparedStmt = conn.prepareStatement(result);
                   preparedStmt.setString   (1, Username);
                   preparedStmt.setInt (2, UserID);
                   preparedStmt.executeUpdate();
                   System.out.println("Username has been Changed");
             }
             
             if (PassChange == true)
             {
                  Statement stmt = conn.createStatement();
                   String result = "UPDATE tourist SET password = ? WHERE id = ?";
                   PreparedStatement preparedStmt = conn.prepareStatement(result);
                   preparedStmt.setString   (1, Password);
                   preparedStmt.setInt (2, UserID);
                   preparedStmt.executeUpdate();
                   System.out.println("Password has been Changed");
             }
             
           
                
        }catch(Exception e)
        {
             System.out.println("SQLException: " + e.getMessage());
            
        }
    }
    public void SaveRecord(String Username, String Password)
    {
        try{
            //Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/account","root","Then00bwar@156210");
            if(conn!=null)
            {
                System.out.println("Connected to databases");
                
            }
            
             Statement stmt = conn.createStatement();
             String result = "INSERT INTO tourist (username,password) VALUES ('"+Username+"','"+Password+"')";
             stmt.executeUpdate(result);
             
              IsSaveRecord = true;
                
        }catch(Exception e)
        {
             System.out.println("SQLException: " + e.getMessage());
             IsSaveRecord = false;
        }
        
        
        
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
    
    public void ReadRecord()
    {    
          try{
            //Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/account","root","Then00bwar@156210");
            if(conn!=null)
            {   
                System.out.println("Connected to databases");
                
            }
            
             Statement stmt = conn.createStatement();
             String result = "SELECT * FROM tourist";
             ResultSet rs = stmt.executeQuery(result);
             
             
             while(rs.next())
             {
                 UsernameList.add(rs.getString("username"));
                 PasswordList.add(rs.getString("password"));
                 UserID.add(rs.getInt("id"));
             }
                
        }catch(Exception e)
        {
             System.out.println("SQLException: " + e.getMessage());
          
        }
       
        System.out.println("Username: "+UsernameList.get(0));
        System.out.println("Password: "+PasswordList.get(0));
        System.out.println("UserID: "+UserID.get(0));
    }

}