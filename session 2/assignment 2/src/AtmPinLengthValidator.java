public class AtmPinLengthValidator {

    /**
     * Validates that an ATM PIN is exactly 4 digits in length.
     *
     * @param pin the entered PIN string
     */
    public static void checkPinLength(String pin) {
        if (pin == null || pin.length() != 4) {
            System.out.println("Invalid PIN — must be exactly 4 digits.");
        } else {
            System.out.println("PIN length OK.");
        }
    }

    public static void main(String[] args) {
        // Test Case 1: Less than 4 digits
        checkPinLength("482");

        // Test Case 2: Exactly 4 digits
        checkPinLength("4820");

        // Additional edge test cases
        checkPinLength("12345");
        checkPinLength(null);
    }
}
