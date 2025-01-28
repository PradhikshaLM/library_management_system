
package Model;


public abstract class User {
    private int id;
    private String name;
    private String contactInfo;
    private String username;
    private String password;
    
    
    public User(int id,String name,String contactInfo,String username,String pw){
        this.id=id;
        this.name=name;
        this.contactInfo=contactInfo;
        this.username=username;
        this.password=pw;
        
    }
    public abstract void login();
    
    public void setId(int id){
        this.id=id;
    }
    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public void setContact(String contactInfo){
        this.contactInfo=contactInfo;
    }
    public String getContact(){
        return contactInfo;
    }
    public void setUsername(String username){
        this.username=username;
    }
    public String getUsername(){
        return username;
    }
    public void setPw(String password){
        this.password=password;
    }
    public String getPw(){
        return password;
    }
   
    
}
