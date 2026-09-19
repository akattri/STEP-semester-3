import java.util.Arrays;

public class MatchDayGridAnalyzer {

    /**
     * Calculates the average runs scored per over for a single match.
     * Helper method called once per match row.
     *
     * @param row runs scored in each over for one match
     * @return average runs per over
     */
    static double rowAverage(int[] row) {
        if (row == null || row.length == 0) {
            return 0.0;
        }

        double sum = 0;
        for (int runs : row) {
            sum += runs;
        }

        return sum / row.length;
    }

    /**
     * Classifies each match as "Power Surge" (average >= threshold) or "Normal" (average < threshold).
     *
     * @param runsPerOver 2D array of runs per over for each match (may be jagged)
     * @param threshold   scoring rate threshold
     * @return formatted classification string across all matches
     */
    public static String classifyMatches(int[][] runsPerOver, int threshold) {
        if (runsPerOver == null || runsPerOver.length == 0) {
            return "";
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < runsPerOver.length; i++) {
            double avg = rowAverage(runsPerOver[i]);
            String classification = (avg >= threshold) ? "Power Surge" : "Normal";

            if (i > 0) {
                sb.append(" | ");
            }
            sb.append("Match ").append(i).append(": ").append(classification);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        // Sample Test Case
        int[][] runs = {
            {4, 6, 8},
            {10, 12, 14},
            {2, 3, 1}
        };
        int threshold = 8;
        System.out.println("Threshold: " + threshold);
        System.out.println("Result: " + classifyMatches(runs, threshold));

        // Additional Test Case: Jagged array with different over counts
        int[][] runs2 = {
            {6, 12, 18, 24}, // avg 15
            {5, 5}           // avg 5
        };
        int threshold2 = 10;
        System.out.println("\nThreshold: " + threshold2);
        System.out.println("Result: " + classifyMatches(runs2, threshold2));
    }
}
