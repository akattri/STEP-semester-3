import java.util.Arrays;

public class HackathonScoreCurveBooster {

    /**
     * Curves all scores in the original array directly in place by adding a flat bonus.
     *
     * @param scores the original array of team scores to modify directly
     * @param bonus  the non-negative bonus to add to each score
     */
    public static void curveScores(int[] scores, int bonus) {
        if (scores == null) {
            return;
        }

        for (int i = 0; i < scores.length; i++) {
            scores[i] += bonus;
        }
    }

    public static void main(String[] args) {
        // Sample Test Case
        int[] scores = {70, 85, 60};
        System.out.println("Original: " + Arrays.toString(scores));
        curveScores(scores, 10);
        System.out.println("Curved:   " + Arrays.toString(scores));

        // Additional Test Case
        int[] scores2 = {45, 50, 55};
        System.out.println("\nOriginal: " + Arrays.toString(scores2));
        curveScores(scores2, 5);
        System.out.println("Curved:   " + Arrays.toString(scores2));
    }
}
