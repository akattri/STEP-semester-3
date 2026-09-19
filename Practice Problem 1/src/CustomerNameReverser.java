public class CustomerNameReverser {
    public static void main(String[] args) {
        String originalName = "Sunil";
        String reversedName = reverseCustomerName(originalName);
        
        System.out.println("Input: \"" + originalName + "\"");
        System.out.println("Original Name: " + originalName);
        System.out.println("Reversed Name: " + reversedName);
    }

    public static String reverseCustomerName(String customerName) {
        char[] characters = customerName.toCharArray();
        StringBuilder reversed = new StringBuilder();
        
        // Traverse the character array backwards
        for (int i = characters.length - 1; i >= 0; i--) {
            reversed.append(characters[i]);
        }
        
        return reversed.toString();
    }
}
