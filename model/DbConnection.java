
package Model;
import java.sql.*;

public class DbConnection {

public static Connection con;

   
    
    public static void openConnection()  {
    String URL = "jdbc:mysql://localhost:3308/librarydb";
    String USER = "root";
    String PASSWORD = "";
  
        try {
           
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection(URL,USER,PASSWORD);
        } catch (Exception e) {
            System.err.println("Open connection error");
           
        }
        
    }

    public static void closeConnection(){
        try{
            con.close();
            System.out.println("Connection closed");
        }catch(Exception f){
            System.out.println("Close connection error");
        }
    }
}


