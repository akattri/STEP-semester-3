public class VowelConsonantCounter {

    /**
     * Counts and prints vowels and consonants in a text string.
     * Vowels (a, e, i, o, u) are case-insensitive.
     * Spaces are ignored.
     *
     * @param text the input string containing letters and spaces
     */
    public static void countVowelsAndConsonants(String text) {
        if (text == null) {
            System.out.println("Vowels: 0 | Consonants: 0");
            return;
        }

        int vowels = 0;
        int consonants = 0;

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            // Ignore spaces
            if (ch == ' ') {
                continue;
            }

            char lower = Character.toLowerCase(ch);

            if (lower == 'a' || lower == 'e' || lower == 'i' || lower == 'o' || lower == 'u') {
                vowels++;
            } else if (Character.isLetter(ch)) {
                consonants++;
            }
        }

        System.out.printf("Vowels: %d | Consonants: %d%n", vowels, consonants);
    }

    public static void main(String[] args) {
        // Sample Test Case
        countVowelsAndConsonants("Java Programming");

        // Additional Test Case
        countVowelsAndConsonants("Hello World");
    }
}
