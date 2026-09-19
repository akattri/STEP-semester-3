import java.util.Random;

public class RockPaperScissors {
    public static void main(String[] args) {
        // Predefined list of player moves for the live demo
        String[] playerMoves = {"Rock", "Paper", "Scissors", "Rock", "Paper"};
        String[] computerMoves = new String[5];
        String[] results = new String[5];
        String[] options = {"Rock", "Paper", "Scissors"};
        Random rand = new Random();

        int wins = 0, losses = 0, draws = 0;

        System.out.println("Round | Player Move | Computer Move | Result");
        System.out.println("----------------------------------------------");

        for (int i = 0; i < 5; i++) {
            // Generate computer move randomly
            computerMoves[i] = options[rand.nextInt(3)];
            
            // Determine result
            results[i] = playRound(playerMoves[i], computerMoves[i]);
            
            if (results[i].equals("Player Wins")) wins++;
            else if (results[i].equals("Computer Wins")) losses++;
            else draws++;

            System.out.printf("Round %d — Player: %s, Computer: %s | %s%n", 
                    i + 1, playerMoves[i], computerMoves[i], results[i]);
        }

        double winPercentage = (wins / 5.0) * 100;
        
        System.out.println("\nFinal Summary (after 5 rounds)");
        System.out.printf("Wins: %d | Losses: %d | Draws: %d | Win %% = %.1f%%%n", 
                wins, losses, draws, winPercentage);
    }

    public static String playRound(String playerMove, String computerMove) {
        if (playerMove.equals(computerMove)) {
            return "Draw";
        }
        
        if ((playerMove.equals("Rock") && computerMove.equals("Scissors")) ||
            (playerMove.equals("Paper") && computerMove.equals("Rock")) ||
            (playerMove.equals("Scissors") && computerMove.equals("Paper"))) {
            return "Player Wins";
        }
        
        return "Computer Wins";
    }
}
