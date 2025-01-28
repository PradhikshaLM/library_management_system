
package Controller;
import Model.Book;
import Model.Author;
import Model.DbConnection;
import java.sql.*;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.text.SimpleDateFormat;

public class BookController {
    private final ArrayList<Book>bookArr;
    
    
    public BookController(){
        bookArr=new ArrayList<>();
        
    }
    
    public void insertData(){
           DbConnection.openConnection();
           Connection con=DbConnection.con;
        try{
         
            
            for (Book b:bookArr){
                int id=b.getId();
                String title=b.getTitle();
                String publishedYear=b.getPublishedYear();
                Author a1=b.getAuthor();
                String authorName=a1.getName();
                String authorEmail=a1.getEmail();
                
                String qry="INSERT INTO book(id,title,publishedYear,authorName,authorEmail)"+ "VALUES('"+id+"','"+title+"','"+publishedYear+"','"+authorName+"','"+authorEmail+"')";
                Statement st=con.createStatement();
                st.executeUpdate(qry);
                
            }
        }catch(Exception ex){
            System.out.println("Connection error!");
        }finally{
            DbConnection.closeConnection();
        }
    }
     public void add(Book book){
        int response=JOptionPane.showConfirmDialog(null, "Confirm data","Confirmation",JOptionPane.YES_NO_OPTION);
        if(response==JOptionPane.YES_OPTION){
            bookArr.add(book);
            JOptionPane.showMessageDialog(null, "New book was added successfully");
        }
            

}
     public void updateBook(Book book ){
            DbConnection.openConnection();
            Connection con=DbConnection.con;
        try{
             
            String qry= "UPDATE book SET title=?,publishedYear=?,authorName=?,authorEmail=? WHERE id=?";
            PreparedStatement ps=con.prepareStatement(qry);
            ps.setString(1,book.getTitle());
            ps.setString(2, book.getPublishedYear());
            ps.setString(3, book.getAuthor().getName());
            ps.setString(4, book.getAuthor().getEmail());
            ps.setInt(5, book.getId());
            
            if(ps.executeUpdate()>0){
            JOptionPane.showMessageDialog(null, "Book details updated successfully");
        }else{
                JOptionPane.showMessageDialog(null, "Book was not found with that id");
            }
                
            }catch(Exception ex){
            System.out.println("Connection error!");
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
     public void searchBook(String title){
         for(Book b:bookArr){
             if(b.getTitle().equalsIgnoreCase(title)){
                 JOptionPane.showMessageDialog(null,b.searchBook(title));
                 return;
             }
         }
         JOptionPane.showMessageDialog(null,"No book shown with that title:"+title);
     }
     
     public void searchBook(String title,String author){
         for(Book b:bookArr){
             if(b.getTitle().equalsIgnoreCase(title)&&b.getAuthor().getName().equalsIgnoreCase(author)){
                 JOptionPane.showMessageDialog(null, b.searchBook(title, author));
                 return;
             }
         }
         JOptionPane.showMessageDialog(null, "No book found with that title and author:"+title+","+author);
     }
     
     public ArrayList<Book> searchFromDb(String title,String authorName){
            DbConnection.openConnection();
            Connection con=DbConnection.con;
        ArrayList<Book>result=new ArrayList<>();
        
        try{
             
             String qry;
             PreparedStatement ps;
             
            if(authorName==null||authorName.trim().isEmpty()){
             qry="SELECT * FROM book WHERE title LIKE ?";
             ps=con.prepareStatement(qry);
             ps.setString(1,"%"+ title +"%");
            }else{
                qry="SELECT * FROM book WHERE title LIKE ? AND authorName LIKE ?";
                ps=con.prepareStatement(qry);
                ps.setString(1,"%"+ title +"%");
                ps.setString(2,"%"+ authorName +"%");
            }
               
            ResultSet rs=ps.executeQuery();
            
            while(rs.next()){
                Author a=new Author(rs.getString("authorName"),rs.getString("authorEmail"));
                Book b=new Book(rs.getInt("id"),rs.getString("title"),rs.getString("publishedYear"),a);
                result.add(b);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Connection error"+e.getMessage());
        } finally{
              DbConnection.closeConnection();
            }
            return result;
        }
     
     public void deleteBook(int id){
         DbConnection.openConnection();
         Connection con=DbConnection.con;
         try{
            
             String qry="DELETE FROM book WHERE id=?";
             PreparedStatement ps=con.prepareStatement(qry);
             ps.setInt(1, id);
             if(ps.executeUpdate()>0){
                 JOptionPane.showMessageDialog(null,"Book deleted successfully");
                 
             }else{
                 JOptionPane.showMessageDialog(null, "Book not found with that id");
             }
         }catch(Exception e){
             System.err.println("Conection error");
             e.printStackTrace();
         }finally{
            DbConnection.closeConnection();
         }
         
     }
     
     public boolean issueBook(int memberId,int bookId,java.util.Date issueDate,java.util.Date dueDate){
              DbConnection.openConnection();
              Connection con=DbConnection.con;
              SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
              
              
         try{
             String fid=df.format(issueDate);
             String fdd=df.format(dueDate);
             String qry="INSERT INTO issue(member_id,book_id,issue_date,due_date,return_date) VALUES(?,?,?,?,NULL)";
             PreparedStatement ps=con.prepareStatement(qry);
             ps.setInt(1, memberId);
             ps.setInt(2, bookId);
             ps.setString(3, fid);
             ps.setString(4, fdd);
             
           int rowsAffected=ps.executeUpdate();
           return rowsAffected>0;
             }catch(SQLException e){
                 e.printStackTrace();
                 return false;
         }finally{
             DbConnection.closeConnection();
         }
     }
     
     public boolean returnBook(int memberId, int bookId) {
    DbConnection.openConnection();
    Connection con = DbConnection.con;
    try {
       
        String qry = "UPDATE issue SET return_date = CURRENT_DATE WHERE member_id = ? AND book_id = ? AND return_date IS NULL";
        PreparedStatement ps = con.prepareStatement(qry);
        ps.setDate(1, new java.sql.Date(System.currentTimeMillis()));
        ps.setInt(1, memberId);
        ps.setInt(2, bookId);
        
       
        int rowsAffected = ps.executeUpdate();
        return rowsAffected > 0;
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    } finally {
        DbConnection.closeConnection();
    }
}

     } 
         
     
     
   
     

