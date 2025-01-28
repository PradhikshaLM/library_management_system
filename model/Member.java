
package Model;


public class Member extends User {
    private MembershipCard membercard;
    
     public Member(int id,String name,String contactInfo,String username,
                   String pw,MembershipCard membercard){
         super(id,name,contactInfo,username,pw);
         this.membercard=membercard;
     }
    @Override
    public void login(){
        System.out.println("Member"+" "+getName()+" "+"has logged in");
    }

      public MembershipCard getMemberCard(){
         return membercard;
     }
    
    
}
