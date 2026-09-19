import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class StopWordFilteredWordFrequencyReport {

    // Small fixed list of stop words to exclude as filler
    private static final Set<String> STOP_WORDS = new HashSet<>(
        Arrays.asList("the", "was", "and", "a", "is", "of", "in")
    );

    /**
     * Normalizes feedback text, filters out common stop words, counts word frequencies,
     * and prints unique words sorted by frequency in descending order.
     *
     * @param feedback paragraph of text to analyze
     */
    public static void printFilteredWordFrequency(String feedback) {
        if (feedback == null || feedback.trim().isEmpty()) {
            return;
        }

        // Normalize: convert to lowercase and strip punctuation using replace()
        String cleaned = feedback.toLowerCase()
                                 .replace(".", "")
                                 .replace(",", "");

        // Split the cleaned text into words using whitespace pattern
        String[] words = cleaned.trim().split("\\s+");

        // Count frequency of each remaining unique word
        Map<String, Integer> frequencyMap = new LinkedHashMap<>();
        for (String word : words) {
            if (word.isEmpty() || STOP_WORDS.contains(word)) {
                continue;
            }
            frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
        }

        // Sort entries by frequency count in descending order
        List<Map.Entry<String, Integer>> entries = new ArrayList<>(frequencyMap.entrySet());
        entries.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));

        // Print each unique word with its count
        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        // Sample Test Case
        String feedback = "The mentor was great, the session was great and clear.";
        printFilteredWordFrequency(feedback);
    }
}
