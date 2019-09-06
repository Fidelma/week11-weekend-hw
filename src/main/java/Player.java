import java.util.ArrayList;

public class Player {

    private String name;
    private ArrayList<Card> hand;

    public Player(String name){
        this.name = name;
        this.hand = new ArrayList<Card>();
    }

    public String getName(){
        return name;
    }

    public int sizeOfHand(){
        return hand.size();
    }

    public void addCard(Card card){
        hand.add(card);
    }

    public int getHandValue() {
        int total = 0;
        for(Card card : hand){
            total += card.getValueFromEnum();
        }
        return total;
    }

//    public void turn(String action) {
//        if(action == "twist"){
//            addCard()
//        }
//    }
}
