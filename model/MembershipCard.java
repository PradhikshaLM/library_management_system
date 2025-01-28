
package Model;


public class MembershipCard {
    private int cardNumber;
    private String expDate;
    
    public MembershipCard(int cardNumber,String expDate){
        this.cardNumber=cardNumber;
        this.expDate=expDate;
    }
    
    public int getCardNumber(){
        return cardNumber;
    }
    public String getExpdate(){
        return expDate;
    }
}
