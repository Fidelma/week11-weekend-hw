import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CardTest {
    Card card;

    @Before
    public void setup() {
        card = new Card(SuitType.HEARTS, RankType.ACE);
    }

    @Test
    public void canGetSuit() {
        assertEquals(SuitType.HEARTS, card.getSuit());
    }
    @Test
    public void canGetRank() {
        assertEquals(RankType.ACE, card.getRank());
    }
    @Test
    public void queenHasValueTen() {
        card = new Card(SuitType.HEARTS, RankType.QUEEN);
        assertEquals(10, card.getValueFromEnum());
    }

}
