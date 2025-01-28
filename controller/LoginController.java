
package Controller;
import Model.User;
import Model.Admin;
import Model.Member;
import Model.MembershipCard;
import java.sql.*;
import Model.DbConnection;

public class LoginController {
    
    public User login(String username,String password){
       
         DbConnection.openConnection();
         Connection con=DbConnection.con;
               
                 try{
                  String adminQry="SELECT * FROM admindata WHERE username=? AND password=?";
                  PreparedStatement aps=con.prepareStatement(adminQry);
                  aps.setString(1, username);
                  aps.setString(2, password);
                  ResultSet ars=aps.executeQuery();
                  
                  if(ars.next()){
                      int id=ars.getInt("id");
                      String name=ars.getString("name");
                      String contactInfo=ars.getString("contactInfo");
                      String role="Admin";
                      Admin a=new Admin(id,name,contactInfo,username,password);
                      a.login();
                      return a;
                  }
                  String memQry="SELECT * FROM memberdata WHERE username=? AND password=?";
                  PreparedStatement ps=con.prepareStatement(memQry);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs=ps.executeQuery();

               if(rs.next()){
                   int id=rs.getInt("id");
                   String name=rs.getString("name");
                   String contactInfo=rs.getString("contactInfo");
                   int cardNo=rs.getInt("cardNo");
                   String expDate=rs.getString("expDate");
                   MembershipCard c=new MembershipCard(cardNo,expDate);
                   Member m=new Member(id,name,contactInfo,username,password,c);
                   m.login();
                   return m;
               }
               return null;
           
               
         }catch(SQLException e){
            System.err.print("Login error"+e.getMessage());
            e.printStackTrace();
          }finally{
                     DbConnection.closeConnection();
                 }
          return null;
           }
        
    
  
}

