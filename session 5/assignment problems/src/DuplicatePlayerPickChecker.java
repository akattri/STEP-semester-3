import java.util.Arrays;

public class DuplicatePlayerPickChecker {

    /**
     * Checks for a repeated player name in the lineup using plain nested loops.
     * Reports the first duplicate found in scanning order, or "No Duplicates Found".
     *
     * @param playerNames array of player names
     * @return "Duplicate Found: <name>" or "No Duplicates Found"
     */
    public static String findDuplicatePick(String[] playerNames) {
        if (playerNames == null || playerNames.length <= 1) {
            return "No Duplicates Found";
        }

        // Compare each name against names that come after it
        for (int i = 0; i < playerNames.length; i++) {
            for (int j = i + 1; j < playerNames.length; j++) {
                if (playerNames[i] != null && playerNames[i].equals(playerNames[j])) {
                    return "Duplicate Found: " + playerNames[i];
                }
            }
        }

        return "No Duplicates Found";
    }

    public static void main(String[] args) {
        // Sample Test Case 1: Duplicate exists
        String[] lineup1 = {"Kohli", "Bumrah", "Kohli", "Rohit"};
        System.out.println("Lineup: " + Arrays.toString(lineup1));
        System.out.println("Result: " + findDuplicatePick(lineup1));

        // Sample Test Case 2: No duplicates
        String[] lineup2 = {"Kohli", "Bumrah", "Rohit"};
        System.out.println("\nLineup: " + Arrays.toString(lineup2));
        System.out.println("Result: " + findDuplicatePick(lineup2));

        // Additional Test Case: Adjacent duplicate
        String[] lineup3 = {"Dhoni", "Jadeja", "Jadeja"};
        System.out.println("\nLineup: " + Arrays.toString(lineup3));
        System.out.println("Result: " + findDuplicatePick(lineup3));
    }
}
