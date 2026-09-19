import java.util.Arrays;

public class TopThreePodiumFinder {

    /**
     * Finds the top 3 scores in a single pass without sorting the array.
     * Returns the podium scores in descending order.
     *
     * @param scores array of scores (length >= 3)
     * @return an array of top 3 scores [first, second, third]
     */
    public static int[] findTopThreeScores(int[] scores) {
        if (scores == null || scores.length < 3) {
            return new int[]{};
        }

        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        int third = Integer.MIN_VALUE;

        // Single pass through scores, left to right
        for (int score : scores) {
            if (score >= first) {
                third = second;
                second = first;
                first = score;
            } else if (score >= second) {
                third = second;
                second = score;
            } else if (score > third) {
                third = score;
            }
        }

        return new int[]{first, second, third};
    }

    public static void main(String[] args) {
        // Sample Test Case
        int[] scores1 = {45, 82, 79, 90, 33, 90, 61};
        System.out.println("Scores: " + Arrays.toString(scores1));
        System.out.println("Top 3:  " + Arrays.toString(findTopThreeScores(scores1)));

        // Additional Test Case: All identical scores
        int[] scores2 = {100, 100, 100, 100};
        System.out.println("\nScores: " + Arrays.toString(scores2));
        System.out.println("Top 3:  " + Arrays.toString(findTopThreeScores(scores2)));

        // Additional Test Case: Strictly increasing
        int[] scores3 = {10, 20, 30, 40, 50};
        System.out.println("\nScores: " + Arrays.toString(scores3));
        System.out.println("Top 3:  " + Arrays.toString(findTopThreeScores(scores3)));
    }
}
