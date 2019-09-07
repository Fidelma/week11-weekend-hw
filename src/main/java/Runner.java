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
            String output = String.format("%s cards: %s and %s", game.getPlayer(i).getName(), game.getPlayer(i).showCard(0), game.getPlayer(i).showCard(1));
            System.out.println(output);
            int initialValue = game.getPlayer(i).getHandValue();
            System.out.println(String.format("total value: %s", initialValue));
            System.out.println("Would you like to twist or stick?");
            String turnType = scanner.next();
            boolean validTurn = game.turn(game.getPlayer(i), turnType);
            if(validTurn){
                int totalValue = game.getPlayer(i).getHandValue();
                System.out.println(String.format("total value: %s", totalValue));
            } else {
                System.out.println("invalid turn type");
            }
        }


    }
}
