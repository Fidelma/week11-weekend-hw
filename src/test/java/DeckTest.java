import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DeckTest {
    Deck deck;
    Card card;

    @Before
    public void setup(){
        deck = new Deck();
        card = new Card(SuitType.HEARTS, RankType.ACE);
    }

    @Test
    public void deckIsEmpty(){
        assertEquals(0, deck.sizeOfDeck());
    }

    @Test
    public void canAddCard() {
        deck.addCard(card);
        assertEquals(1, deck.sizeOfDeck());
    }

                @Test
        public void canPopulateDeck(){
            deck.populate();
            assertEquals(52, deck.sizeOfDeck());
        }

    @Test
    public void canGetFirstCard() {
        deck.populate();
        Card card1 = deck.getFirstCard();
        assertEquals(RankType.ACE, card1.getRank());
    }
//    @Test
//    public void canShuffle() {
//        deck.populate();
//        deck.shuffle();
//        Card card1 = deck.getFirstCard();
//        assertEquals(RankType.ACE, card1.getRank());
//    }

    @Test
    public void canRemoveCardFromDeck() {
        deck.populate();
        deck.shuffle();
        deck.removeCard();
        assertEquals(51, deck.sizeOfDeck());
    }
}
