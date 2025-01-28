
package Controller;
import Model.DbConnection;
import Model.Member;
import Model.MembershipCard;
import java.sql.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;
public class MemController {
    ArrayList<Member>memberArr;
    
    public MemController(){
        memberArr=new ArrayList<>();
        
    }
    
    public void add(Member member){
        int response=JOptionPane.showConfirmDialog(null,"Confirm Data","Confirmation", JOptionPane.YES_NO_OPTION);
        if(response==JOptionPane.YES_OPTION){
            memberArr.add(member);
            JOptionPane.showMessageDialog(null, "New member added successfully.");
        }else{
            
        }
    }
    
    public void insertDataToDb(){
           DbConnection.openConnection();
           Connection con=DbConnection.con;
        try {
           
            for(Member m:memberArr){
               
                int id=m.getId();
                String name=m.getName();
                String contactInfo=m.getContact();
                String username=m.getUsername();
                String password=m.getPw();
               
                MembershipCard mc=m.getMemberCard();
                int cardNo=mc.getCardNumber();
                String expDate=mc.getExpdate();
                String qry="INSERT INTO memberData(id,name,contactInfo,username,password,cardNo,expDate)" + " VALUES('"+id+"','"+name+"','"+contactInfo+"','"+username+"','"+password+"','"+cardNo+"','"+expDate+"')";
              
               Statement st=con.createStatement();
                
                st.executeUpdate(qry);
                
            }
        } catch (Exception e) {
            System.err.println("Connection error");
           e.printStackTrace();
        }finally{
            try{
                if(con!=null){
                    con.close();
            System.out.println("Connection closed"); 
                }
                
            }catch(SQLException e){
                System.out.println(e.getMessage());
            }
           
        }
    }
    
    
    
    public void updateMember(Member member){
         DbConnection.openConnection();
         Connection con=DbConnection.con;
        try {
           
            
           String qry="UPDATE memberData SET name=?,contactInfo=?,username=?,password=?,cardNo=?,expDate=? WHERE id=?";
           PreparedStatement ps=con.prepareStatement(qry);
           ps.setString(1,member.getName());
           ps.setString(2, member.getContact());
           ps.setString(3, member.getUsername());
           ps.setString(4, member.getPw());
           
           ps.setInt(5, member.getMemberCard().getCardNumber());
           ps.setString(6,member.getMemberCard().getExpdate());
           ps.setInt(7, member.getId());
           
           if(ps.executeUpdate()>0){
               JOptionPane.showMessageDialog(null, "Member details updated successfully");
           }else{
               JOptionPane.showMessageDialog(null, "Member not found with that id");
           }
           
    
        }catch (Exception e) {
            System.err.println("Connection error");
          
        }finally{
            try{
                if(con!=null){
                    con.close();
            System.out.println("Connection closed"); 
                }
                
            }catch(SQLException e){
                System.out.println(e.getMessage());
            }
        }
    }
    
    
    public void deleteMember(int id){
           DbConnection.openConnection();
           Connection con=DbConnection.con;
        try {
           
             
              String qry="DELETE FROM memberData WHERE id=?";
              PreparedStatement pr=con.prepareStatement(qry);
              pr.setInt(1, id);
              if(pr.executeUpdate()>0){
                  JOptionPane.showMessageDialog(null, "Member deleted successfully");
           }else{
               JOptionPane.showMessageDialog(null, "Member not found with that id");
           }
           
    
        }catch (Exception e) {
            System.err.println("Connection error");
           e.printStackTrace();
        }finally{
            try{
                if(con!=null){
                    con.close();
            System.out.println("Connection closed"); 
                }
                
            }catch(SQLException e){
                System.out.println(e.getMessage());
            }
              }
    }
}
        
    
    


