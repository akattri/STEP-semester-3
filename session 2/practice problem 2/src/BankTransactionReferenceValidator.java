public class BankTransactionReferenceValidator {

    /**
     * Normalizes the reference code by trimming whitespace and
     * uppercasing the first 3 characters (bank code).
     *
     * @param raw unnormalized input string
     * @return normalized reference code
     */
    public static String normalizeReference(String raw) {
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
     * Validates an ISBN-style transaction reference code and formats it if valid.
     * Rules:
     * - Exactly 14 characters
     * - First 3 characters are letters (bank code)
     * - Remaining 11 characters are digits (6 for date ddMMyy, 5 for sequence number)
     *
     * @param reference the normalized reference code
     * @return formatted line or error reason
     */
    public static String validateAndFormat(String reference) {
        if (reference == null || reference.length() != 14) {
            return "Invalid: wrong length (must be exactly 14 characters)";
        }

        // Validate bank code (first 3 characters must be letters)
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(reference.charAt(i))) {
                return "Invalid: bank code must be 3 letters";
            }
        }

        // Validate body (remaining 11 characters must be digits)
        for (int i = 3; i < 14; i++) {
            if (!Character.isDigit(reference.charAt(i))) {
                return "Invalid: remaining 11 characters must be digits";
            }
        }

        String bankCode = reference.substring(0, 3);
        String day = reference.substring(3, 5);
        String month = reference.substring(5, 7);
        String year = reference.substring(7, 9);
        String seq = reference.substring(9, 14);

        // Build formatted display line using StringBuilder
        StringBuilder sb = new StringBuilder();
        sb.append("[")
          .append(bankCode)
          .append("] DATE: ")
          .append(day).append("/").append(month).append("/").append(year)
          .append(" | SEQ: ")
          .append(seq);

        return sb.toString();
    }

    /**
     * Helper to normalize, validate, and print the transaction reference.
     *
     * @param raw the raw input string
     */
    public static void processReference(String raw) {
        String normalized = normalizeReference(raw);
        String result = validateAndFormat(normalized);
        System.out.println(result);
    }

    public static void main(String[] args) {
        // Sample Test Case 1: Extra spaces and lowercase bank code
        processReference(" hdf03022600042 ");

        // Sample Test Case 2: Bank code containing digits
        processReference("12F03022600042");

        // Additional Test Cases
        processReference("hdf030226");           // wrong length
        processReference("hdf0302260004X");      // non-digit body
    }
}
