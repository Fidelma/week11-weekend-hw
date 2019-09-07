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
        int aces = containsACE();
        int total = 0;
        for(Card card : hand){
            total += card.getValueFromEnum();
        }
        if(total > 21 && aces > 0){
            total -= (10 * aces);
        }
        return total;
    }

    public String checkIfBust() {
        int hand = getHandValue();
        String result = null;
        if(hand > 21){
            result = "bust";
        }
        return result;
    }

    public int containsACE() {
        int aces = 0;
        for(Card card : hand){
            if (card.getRank() == RankType.ACE){
                aces += 1;
            }
        }
        return aces;
    }

    public boolean blackJack() {
        boolean blackJack = false;
        if(sizeOfHand() == 2 && getHandValue() == 21){
            blackJack = true;
        }
        return blackJack;
    }

    public String showCard(int cardPosition) {
        Card card = hand.get(cardPosition);
        return String.format("%s of %s", card.getRank(), card.getSuit());
    }

//    public void turn(String action) {
//        if(action == "twist"){
//            addCard()
//        }
//    }
}
