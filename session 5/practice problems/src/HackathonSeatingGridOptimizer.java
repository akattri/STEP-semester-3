import java.util.Arrays;

public class HackathonSeatingGridOptimizer {

    /**
     * Computes the average score for a single seating row.
     * Reusable helper called once per row.
     *
     * @param row scores for a single row of teams
     * @return average score of the row
     */
    static double rowAverage(int[] row) {
        if (row == null || row.length == 0) {
            return 0.0;
        }

        double sum = 0;
        for (int score : row) {
            sum += score;
        }

        return sum / row.length;
    }

    /**
     * Classifies each row as "Buzzing Zone" (average >= threshold) or "Quiet Zone" (average < threshold).
     * Handles jagged rows safely.
     *
     * @param seatingScores 2D array of scores per seating row
     * @param threshold     threshold score
     * @return formatted classification string across all rows
     */
    public static String classifyRows(int[][] seatingScores, int threshold) {
        if (seatingScores == null || seatingScores.length == 0) {
            return "";
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < seatingScores.length; i++) {
            double avg = rowAverage(seatingScores[i]);
            String zone = (avg >= threshold) ? "Buzzing Zone" : "Quiet Zone";

            if (i > 0) {
                sb.append(" | ");
            }
            sb.append("Row ").append(i).append(": ").append(zone);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        // Sample Test Case
        int[][] seating = {
            {40, 50, 45},
            {85, 90, 95},
            {30, 20, 25}
        };
        int threshold = 60;
        System.out.println("Threshold: " + threshold);
        System.out.println("Result: " + classifyRows(seating, threshold));

        // Additional Test Case: Jagged rows
        int[][] seating2 = {
            {70, 80},
            {50, 55, 60, 65}
        };
        int threshold2 = 70;
        System.out.println("\nThreshold: " + threshold2);
        System.out.println("Result: " + classifyRows(seating2, threshold2));
    }
}
