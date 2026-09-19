public class MaskedPhoneNumberFormatter {

    /**
     * Validates and masks a 10-digit phone number.
     * Produces a string in the format "XXXXXX-DDDD" where DDDD is the last 4 digits.
     *
     * @param phone the input phone number string
     * @return masked phone number, or error message if invalid
     */
    public static String maskPhoneNumber(String phone) {
        if (phone == null || phone.length() != 10) {
            String errorMsg = "Invalid phone number";
            System.out.println(errorMsg);
            return errorMsg;
        }

        // Validate that all characters are numeric digits
        for (int i = 0; i < phone.length(); i++) {
            if (!Character.isDigit(phone.charAt(i))) {
                String errorMsg = "Invalid phone number";
                System.out.println(errorMsg);
                return errorMsg;
            }
        }

        // Build masked string: "XXXXXX" + last 4 digits
        StringBuilder sb = new StringBuilder();
        sb.append("XXXXXX");
        sb.append(phone.substring(6));

        // Insert '-' between the mask and the last 4 digits
        sb.insert(6, "-");

        String masked = sb.toString();
        System.out.println(masked);
        return masked;
    }

    public static void main(String[] args) {
        // Sample Test Case 1: Valid 10-digit number
        maskPhoneNumber("9876543210");

        // Sample Test Case 2: Invalid short number
        maskPhoneNumber("98765");

        // Additional Test Cases
        maskPhoneNumber("98765abcde");
        maskPhoneNumber(null);
    }
}
