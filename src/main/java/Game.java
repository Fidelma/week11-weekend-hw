import java.util.ArrayList;

public class Game {
    private Deck deck;
    private ArrayList<Player> players;

    public Game(Deck deck){
        this.deck = deck;
        this.players = new ArrayList<Player>();

    }

    public void addPlayer(Player player){
        players.add(player);
    }

    public void deal(int numberOfCards){
        for (Player player : players){
            for(int i = 0; i < numberOfCards; i ++) {
                player.addCard(deck.removeCard());
            }
        }
    }

    public boolean checkDraw() {
        boolean draw = true;
        int drawHand = players.get(0).getHandValue();
        for (Player player : players){
            if (player.getHandValue() != drawHand){
                draw = false;
            }
        }
        return draw;
    }


    public Player play(){
        int highest = 0;
        Player winner = null;


        for (Player player : players){
            if(player.getHandValue() > highest){
                highest = player.getHandValue();
                winner = player;
            }

        }

        return winner;
    }
}
