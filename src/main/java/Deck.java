import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    private ArrayList<Card> cards;

    public Deck(){
        this.cards = new ArrayList<Card>();
    }
    public void addCard(Card card){
        cards.add(card);
    }
    public void populate(){
        SuitType[] suits = SuitType.values();
        RankType[] ranks = RankType.values();

        for (SuitType suit: suits){
            for(RankType rank: ranks){
                cards.add(new Card(suit, rank));
            }
        }
    }
    public int sizeOfDeck() {
    return cards.size();
    }
    public Card getFirstCard(){
        return cards.get(0);
    }
    public void shuffle(){
        Collections.shuffle(cards);
    }
    public Card removeCard(){
        return cards.remove(0);
    }

}
