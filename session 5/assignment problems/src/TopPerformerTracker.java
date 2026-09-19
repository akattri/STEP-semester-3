import java.util.Arrays;

public class TopPerformerTracker {

    /**
     * Finds the minimum score, maximum score, and their spread in a single pass
     * without sorting the array.
     *
     * @param scores array of player/team scores (length >= 2)
     * @return formatted string: "Min: <min> | Max: <max> | Spread: <spread>"
     */
    public static String findMinMaxSpread(int[] scores) {
        if (scores == null || scores.length == 0) {
            return "";
        }

        int min = scores[0];
        int max = scores[0];

        // Single pass through array
        for (int i = 1; i < scores.length; i++) {
            if (scores[i] < min) {
                min = scores[i];
            }
            if (scores[i] > max) {
                max = scores[i];
            }
        }

        int spread = max - min;
        return "Min: " + min + " | Max: " + max + " | Spread: " + spread;
    }

    public static void main(String[] args) {
        // Sample Test Case
        int[] scores1 = {45, 82, 79, 90, 33, 90, 61};
        System.out.println("Scores: " + Arrays.toString(scores1));
        System.out.println("Result: " + findMinMaxSpread(scores1));

        // Additional Test Case: Array with identical elements
        int[] scores2 = {50, 50, 50};
        System.out.println("\nScores: " + Arrays.toString(scores2));
        System.out.println("Result: " + findMinMaxSpread(scores2));

        // Additional Test Case: Two elements
        int[] scores3 = {100, 20};
        System.out.println("\nScores: " + Arrays.toString(scores3));
        System.out.println("Result: " + findMinMaxSpread(scores3));
    }
}
