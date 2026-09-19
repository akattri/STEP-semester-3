public class LibraryIsbnNormalizer {

    /**
     * Normalizes an ISBN-style code by trimming surrounding whitespace
     * and converting the 3-letter publisher code prefix to uppercase.
     *
     * @param raw the unnormalized raw input code
     * @return normalized code string
     */
    public static String normalizeCode(String raw) {
        if (raw == null) {
            return "";
        }
        String trimmed = raw.trim();
        if (trimmed.length() < 3) {
            return trimmed.toUpperCase();
        }
        return trimmed.substring(0, 3).toUpperCase() + trimmed.substring(3);
    }

    /**
     * Validates an ISBN-style code and returns either a formatted display line
     * or a specific invalid reason message.
     *
     * Rules:
     * - Exactly 13 characters
     * - First 3 characters are letters
     * - Remaining 10 characters are digits
     *
     * @param code the normalized code string
     * @return formatted record or failure explanation
     */
    public static String validateAndFormat(String code) {
        if (code == null || code.length() != 13) {
            return "Invalid: wrong length (must be exactly 13 characters)";
        }

        // Validate publisher code (first 3 characters must be letters)
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(code.charAt(i))) {
                return "Invalid: publisher code must be 3 letters";
            }
        }

        // Validate body (remaining 10 characters must be digits)
        for (int i = 3; i < 13; i++) {
            if (!Character.isDigit(code.charAt(i))) {
                return "Invalid: remaining 10 characters must be digits";
            }
        }

        // Build formatted display line using StringBuilder
        StringBuilder sb = new StringBuilder();
        sb.append("[")
          .append(code.substring(0, 3))
          .append("] YEAR: ")
          .append(code.substring(3, 7))
          .append(" | CATALOG: ")
          .append(code.substring(7));

        return sb.toString();
    }

    /**
     * Helper to normalize, validate, and print the resulting output.
     *
     * @param raw the raw input string
     */
    public static void processCode(String raw) {
        String normalized = normalizeCode(raw);
        String result = validateAndFormat(normalized);
        System.out.println(result);
    }

    public static void main(String[] args) {
        // Sample Test Case 1: Mixed-case publisher with extra spaces
        processCode(" pen2026004251 ");

        // Sample Test Case 2: Publisher code containing digits
        processCode("12N2026004251");

        // Additional Test Cases: wrong length & non-digit body
        processCode("pen2026");
        processCode("pen202600425X");
    }
}
