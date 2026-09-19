import java.util.Arrays;

public class FantasyTeamScoreMultiplier {

    /**
     * Applies captain (2.0x) and vice-captain (1.5x) multipliers directly
     * to the lineup's player score array in place.
     *
     * @param playerScores     the original lineup score array to modify directly
     * @param captainIndex     index of the captain (receives 2.0x multiplier)
     * @param viceCaptainIndex index of the vice-captain (receives 1.5x multiplier)
     */
    public static void applyMultipliers(double[] playerScores, int captainIndex, int viceCaptainIndex) {
        if (playerScores == null) {
            return;
        }

        // Apply 2x multiplier directly to captain's score
        if (captainIndex >= 0 && captainIndex < playerScores.length) {
            playerScores[captainIndex] *= 2.0;
        }

        // Apply 1.5x multiplier directly to vice-captain's score
        if (viceCaptainIndex >= 0 && viceCaptainIndex < playerScores.length) {
            playerScores[viceCaptainIndex] *= 1.5;
        }
    }

    public static void main(String[] args) {
        // Sample Test Case
        double[] scores = {40, 55, 30, 62};
        System.out.println("Original Scores: " + Arrays.toString(scores));
        applyMultipliers(scores, 1, 3);
        System.out.println("Boosted Scores:  " + Arrays.toString(scores));

        // Additional Test Case
        double[] scores2 = {10, 20, 30};
        System.out.println("\nOriginal Scores: " + Arrays.toString(scores2));
        applyMultipliers(scores2, 0, 2);
        System.out.println("Boosted Scores:  " + Arrays.toString(scores2));
    }
}
