import java.util.ArrayList;

public class Game {
    private Deck deck;
    private ArrayList<Player> players;
    private Player dealer;


    public Game(Deck deck){
        this.deck = deck;
        this.players = new ArrayList<Player>();
        this.dealer = new Player("dealer");

    }

    public void addPlayer(Player player){
        players.add(player);
    }

    public void deal(int numberOfCards){
        for(int i = 0; i < numberOfCards; i ++){
            dealer.addCard(deck.removeCard());
        }
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

    public boolean turn(Player player, String turn) {
        TurnType turnType;
        boolean validTurn = false;
        if(turn == "twist"){
            turnType = TurnType.TWIST;
            validTurn = true;
        } else if(turn == "stick"){
            turnType = TurnType.STICK;
            validTurn = true;
        }else {
            turnType = TurnType.STICK;
        }
        if (turnType == TurnType.TWIST){
            player.addCard(deck.removeCard());
        }
        return validTurn;
    }

    public int getDealerHand() {
        return dealer.getHandValue();
    }

    public String dealerTurn() {
        String turnType;
        if(dealer.getHandValue() < 16){
            dealer.addCard(deck.removeCard());
            turnType = "Twist";
        } else {
            turnType = "Stick";
        }
        return turnType;
    }

    public String showDealerCard() {
        return dealer.showCard(0);
    }

    public Player getPlayer(int i) {
        return players.get(i);
    }
}
