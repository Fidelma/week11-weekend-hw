import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameTest {
    Game game;
    Deck deck;
    Player player1;
    Player player2;
    Card card1;
    Card card2;

    @Before
    public void setup(){
        deck = new Deck();
        player1 = new Player("Player1");
        player2 = new Player("Player2");
        game = new Game(deck);
        card1 = new Card(SuitType.HEARTS, RankType.ACE);
        card2 = new Card(SuitType.HEARTS, RankType.TEN);
    }

    @Test
    public void canDealCard() {
        deck.populate();
        deck.shuffle();
        game.addPlayer(player1);
        game.addPlayer(player2);
        game.deal(2);
        assertEquals(2, player1.sizeOfHand());
        assertEquals(48, deck.sizeOfDeck());
    }



    @Test
    public void canPlayGame() {
        deck.populate();
        game.addPlayer(player2);
        game.addPlayer(player1);
        game.deal(2);
        assertEquals(player1, game.play());
    }

    @Test
    public void canCheckDraw() {
        player1.addCard(card1);
        player1.addCard(card2);
        player2.addCard(card2);
        player2.addCard(card1);
        game.addPlayer(player1);
        game.addPlayer(player2);
        assertEquals(true, game.checkDraw());
    }
}