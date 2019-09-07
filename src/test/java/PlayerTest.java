
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlayerTest {
    Player player;
    Card card;
    Card card2;

    @Before
    public void setup(){
        player = new Player("Player1");
        card = new Card(SuitType.HEARTS, RankType.KING);
        card2 = new Card(SuitType.HEARTS, RankType.ACE);
    }

    @Test
    public void playerHasName() {
        assertEquals("Player1", player.getName());
    }

    @Test
    public void canAddCard() {
        player.addCard(card);
        assertEquals(1, player.sizeOfHand());
    }

    @Test
    public void canGetHandTotal() {
        player.addCard(card);
        player.addCard(card);
        assertEquals(20, player.getHandValue());
    }

    @Test
    public void canGoBust() {
        player.addCard(card);
        player.addCard(card);
        player.addCard(card);
        assertEquals("bust", player.checkIfBust());

    }

    @Test
    public void canCheckIfHandContainsAce() {
        player.addCard(card2);
        player.addCard(card);
        assertEquals(1, player.containsACE());
    }

    @Test
    public void checkAceCanBe1() {
        player.addCard(card);
        player.addCard(card);
        player.addCard(card2);
        assertEquals(21, player.getHandValue());
    }

    @Test
    public void checkCanHandleMultipleAces() {
        player.addCard(card);
        player.addCard(card2);
        player.addCard(card2);
        assertEquals(12, player.getHandValue());
    }

    @Test
    public void canCheckForBlackJack() {
        player.addCard(card);
        player.addCard(card2);
        assertEquals(true, player.blackJack());
    }

    @Test
    public void canShowCard() {
        player.addCard(card);
        player.addCard(card2);
        assertEquals("KING of HEARTS", player.showCard(0));
    }

    //    @Test
//    public void playerCanTwist() {
//        player.addCard(card);
//        player.addCard(card);
//        player.turn(card);
//        assertEquals(3, player.sizeOfHand());
//    }
}
