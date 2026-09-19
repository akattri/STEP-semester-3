public class WordReversalEncoder {

    /**
     * Reverses each word in a sentence individually while maintaining the original word order.
     *
     * @param sentence the input sentence where words are separated by single spaces
     * @return the sentence with each individual word reversed
     */
    public static String reverseEachWord(String sentence) {
        if (sentence == null || sentence.isEmpty()) {
            return sentence;
        }

        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            StringBuilder reversedWord = new StringBuilder();

            // Reverse the current word character-by-character using a loop and StringBuilder
            for (int j = word.length() - 1; j >= 0; j--) {
                reversedWord.append(word.charAt(j));
            }

            result.append(reversedWord);

            // Maintain space separation between words
            if (i < words.length - 1) {
                result.append(" ");
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        // Sample Test Case
        String sampleInput = "hello club";
        String sampleOutput = reverseEachWord(sampleInput);
        System.out.println(sampleOutput);

        // Additional Test Case
        String test2 = "Java String Manipulation";
        System.out.println(reverseEachWord(test2));
    }
}
