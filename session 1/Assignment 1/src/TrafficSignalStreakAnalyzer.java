public class TrafficSignalStreakAnalyzer {

    public static void findLongestStreak(String signalLog) {
        if (signalLog == null || signalLog.isEmpty()) {
            System.out.println("Log is empty or invalid.");
            return;
        }

        char longestColor = signalLog.charAt(0);
        int maxStreak = 1;

        char currentColor = signalLog.charAt(0);
        int currentStreak = 1;

        for (int i = 1; i < signalLog.length(); i++) {
            char nextColor = signalLog.charAt(i);

            if (nextColor == currentColor) {
                currentStreak++;
            } else {
                // Streak ended; reset for the new color
                currentColor = nextColor;
                currentStreak = 1;
            }

            // Update max streak whenever current streak exceeds it
            if (currentStreak > maxStreak) {
                maxStreak = currentStreak;
                longestColor = currentColor;
            }
        }

        System.out.printf("Longest Streak: '%c' repeated %d times%n", longestColor, maxStreak);
    }

    public static void main(String[] args) {
        // Test Case 1
        findLongestStreak("RRGGGYRR");

        // Test Case 2
        findLongestStreak("RRRRYYGG");
    }
}