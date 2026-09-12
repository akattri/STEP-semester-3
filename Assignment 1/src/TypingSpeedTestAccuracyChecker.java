public class TypingSpeedTestAccuracyChecker {

    public static void checkTypingAccuracy(String original, String typed) {
        if (original == null || typed == null) {
            System.out.println("Invalid input: Strings cannot be null.");
            return;
        }

        if (original.length() != typed.length()) {
            System.out.println("Error: Input strings must be of equal length.");
            return;
        }

        int total = original.length();
        if (total == 0) {
            System.out.println("Matched: 0/0 | Accuracy: 100.00% | No Mismatches");
            return;
        }

        int matchedCount = 0;
        int firstMismatchPos = -1;
        char expectedChar = ' ';
        char typedChar = ' ';

        for (int i = 0; i < total; i++) {
            char orig = original.charAt(i);
            char user = typed.charAt(i);

            if (orig == user) {
                matchedCount++;
            } else if (firstMismatchPos == -1) {
                // Record the 1-based position and characters of the very first mismatch
                firstMismatchPos = i + 1;
                expectedChar = orig;
                typedChar = user;
            }
        }

        double accuracy = ((double) matchedCount / total) * 100.0;

        if (firstMismatchPos == -1) {
            System.out.printf("Matched: %d/%d | Accuracy: %.2f%% | No Mismatches%n",
                    matchedCount, total, accuracy);
        } else {
            System.out.printf("Matched: %d/%d | Accuracy: %.2f%% | First Mismatch at position %d ('%c' vs '%c')%n",
                    matchedCount, total, accuracy, firstMismatchPos, expectedChar, typedChar);
        }
    }

    public static void main(String[] args) {
        // Test Case 1: Single typo at the end
        checkTypingAccuracy("hello world", "hello worlt");

        // Test Case 2: Exact match
        checkTypingAccuracy("coding", "coding");
    }
}