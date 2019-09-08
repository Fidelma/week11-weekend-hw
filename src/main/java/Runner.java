import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Runner {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Deck deck = new Deck();
        deck.populate();
        deck.shuffle();
        Game game = new Game(deck);

        System.out.println("Welcome to BlackJack!");
        System.out.println("How many people are playing?");

        String input = scanner.next();
        int players = parseInt(input);

        for(int i = 0; i < players; i ++) {
            String prompt = String.format("Player %s, enter your name: ", (i + 1));
            System.out.println(prompt);
            String playerName = scanner.next();
            Player player = new Player(playerName);
            game.addPlayer(player);
        }

        game.deal(2);
        System.out.println(String.format("dealer card: %s", game.showDealerCard()));

        for(int i = 0; i < players; i ++) {
            System.out.println(game.getPlayer(i).getName());
            System.out.println(game.getPlayer(i).showHand());
            int initialValue = game.getPlayer(i).getHandValue();
            System.out.println(String.format("total value: %s", initialValue));

            boolean keepPlaying = true;

            while(keepPlaying){
                System.out.println("Would you like to twist or stick?");
                String chooseTurn = scanner.next();
                TurnType turnType = game.getTurnType(chooseTurn);
                String output;
                if(turnType == TurnType.TWIST){
                    game.turn(game.getPlayer(i));
                    keepPlaying = true;
                    output = "Your turn again";
                }else if (turnType == TurnType.FAULT){
                    keepPlaying = true;
                    output = "sorry invalid input. Please try again";
                }else {
                    keepPlaying = false;
                    output = "Stick. End of turn";
            }
                int totalValue = game.getPlayer(i).getHandValue();
                String valueAfterTurn;
                if(totalValue > 21){
                    valueAfterTurn = "Sorry you've gone bust";
                    keepPlaying = false;
                } else {
                    valueAfterTurn = String.format("total value: %s", totalValue);
                    System.out.println(output);
                }

                System.out.println(game.getPlayer(i).showHand());
                System.out.println(valueAfterTurn);
            }
        }


        boolean dealerGo = true;
        String dealerTurn;
        while(dealerGo){
            System.out.println("dealer turn");
            System.out.println(game.getDealerHand());
            dealerTurn = game.dealerTurn();
            System.out.println(dealerTurn);
            System.out.println(game.getDealerHand());
            if (dealerTurn.equalsIgnoreCase("stick")) {
                dealerGo = false;

            } else if(dealerTurn.equalsIgnoreCase("bust")){
                dealerGo = false;
            }
        }

        game.play();
        System.out.println(game.getWinnerNames());


    }
}
