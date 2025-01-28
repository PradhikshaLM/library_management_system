
package Model;


public class Admin extends User {
    
    
    public Admin(int id,String name,String contactInfo,String username,String pw){
         super(id,name,contactInfo,username,pw);
    }
    @Override
    public void login(){
        System.out.println("Admin has logged in");
    }
}
