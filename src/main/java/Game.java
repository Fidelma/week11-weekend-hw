import java.util.ArrayList;

public class Game {
    private Deck deck;
    private ArrayList<Player> players;
    private Player dealer;
    private ArrayList<Player> winners;


    public Game(Deck deck){
        this.deck = deck;
        this.players = new ArrayList<Player>();
        this.dealer = new Player("dealer");
        this.winners = new ArrayList<Player>();

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
        int drawHand = dealer.getHandValue();
        for (Player player : players){
            if (player.getHandValue() != drawHand){
                draw = false;
            }
        }
        return draw;
    }


    public void play(){
        if (dealer.getHandValue() == 21 && dealer.sizeOfHand() == 2){
            winners.add(dealer);
        }

        for(Player blackJack: players){
                if (blackJack.getHandValue() == 21 && blackJack.sizeOfHand() == 2) {
                    winners.add(blackJack);
            }
        }

        if(winners.size() == 0) {
            for (Player player : players) {
                if (player.getHandValue() > dealer.getHandValue() && player.getHandValue() <= 21) {
                    winners.add(player);
                }
            }
        }

        if(winners.size() == 0 && dealer.getHandValue() <= 21){
                winners.add(dealer);
            }

    }

    public void turn(Player player) {

        player.addCard(deck.removeCard());
    }

    public int getDealerHand() {
        return dealer.getHandValue();
    }

    public String dealerTurn() {
        String turnType;
        if(dealer.getHandValue() < 16){
            dealer.addCard(deck.removeCard());
            turnType = "Twist";
        } else if(dealer.getHandValue() > 21){
            turnType = "Bust";
        }else {
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

    public TurnType getTurnType(String turn) {
        TurnType turnType;
        if (turn.equalsIgnoreCase("twist")) {
            turnType = TurnType.TWIST;
        } else if (turn.equalsIgnoreCase("stick")) {
            turnType = TurnType.STICK;
        } else {
            turnType = TurnType.FAULT;
        }
        return turnType;
    }

    public int getNumberOfWinners() {
        return winners.size();
    }

    public String getWinnerNames(){
        String winners = "Winners: ";
        for( Player player : this.winners){
            winners += player.getName();
            winners += ", ";
        }
        return winners;
    }
}
