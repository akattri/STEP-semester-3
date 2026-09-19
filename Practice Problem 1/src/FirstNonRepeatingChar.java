import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNonRepeatingChar {
    public static void main(String[] args) {
        String[] testStrings = {"swiss", "aabbcc"};
        
        for (String text : testStrings) {
            System.out.println("Input: \"" + text + "\"");
            char result = findFirstNonRepeatingChar(text);
            
            if (result != '\0') {
                System.out.println("Output: First Non-Repeating Character: '" + result + "'\n");
            } else {
                System.out.println("Output: No Non-Repeating Character Found\n");
            }
        }
    }

    public static char findFirstNonRepeatingChar(String text) {
        // LinkedHashMap maintains insertion order
        Map<Character, Integer> charCount = new LinkedHashMap<>();
        
        for (char c : text.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }
        
        for (Map.Entry<Character, Integer> entry : charCount.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        
        // Return null character if no unique character exists
        return '\0'; 
    }
}
