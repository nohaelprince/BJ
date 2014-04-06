package blackjack;
//import java.io.InputStream;
import java.util.Scanner; 
/**
 * @author Noha Elprince
 * Date: April 2014
 *  This program lets the user play Blackjack.  The computer
         acts as the dealer.  The user has a stake of $100, and
         makes a bet on each game.  The user can leave at any time,
         or will be kicked out when he loses all the money.
         House rules:  The dealer hits on a total of 16 or less
         and stands on a total of 17 or more.  Dealer wins ties.
         A new deck of cards is used for each game.
 * */

public class BlackJackMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      
      int money;          // Amount of money the user has.
      int bet;            // Amount user bets on a game.
      boolean userWins;   // Did the user win the game?
      Scanner scanner = new Scanner( System.in );//create a scanner using the InputStream
      
      System.out.println("Welcome to the game of Blackjack.");
      System.out.println();
      
      money = 100;  // User starts with $100.
   
      while (true) {
          System.out.println("You have " + money + " dollars.");
          do {
             System.out.println("How many dollars do you want to bet?  (Enter 0 to end.)");
             String input = scanner.nextLine(); // read from the user's console.
             bet = Integer.parseInt(input); //convert a String into an int value. 
             System.out.println("You will bet with "+ bet);
             if (bet < 0 || bet > money)
                 System.out.println("Sorry, Your answer must be between 0 and " + money + '.');
          } while (bet < 0 || bet > money);
          if (bet == 0)
             break;
          Game g; g= new Game();
          userWins = g.play();
          if (userWins)
             money = money + bet;
          else
             money = money - bet;
          System.out.println();
          if (money == 0) {
             System.out.println("Sorry! It looks like you've got out of money!");
             break;
          }
      }
      
      System.out.println();
      System.out.println("You leave with $" + money + '.');
      

 
    }
    
}
