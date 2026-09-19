public class ProductInventoryCsvParser {

    /**
     * Parses a CSV line representing an inventory record and prints a formatted summary.
     * Expects exactly 3 fields: "ProductName,SKU,Quantity".
     *
     * @param csvLine comma-separated inventory update record
     */
    public static void parseInventoryRecord(String csvLine) {
        if (csvLine == null) {
            System.out.println("Invalid Record");
            return;
        }

        String[] fields = csvLine.split(",");

        // Validate that exactly 3 fields are present
        if (fields.length != 3) {
            System.out.println("Invalid Record");
            return;
        }

        String productName = fields[0].trim();
        String sku = fields[1].trim();
        String quantity = fields[2].trim();

        System.out.printf("Product: %s | SKU: %s | Qty: %s%n", productName, sku, quantity);
    }

    public static void main(String[] args) {
        // Sample Test Case 1: Valid record
        parseInventoryRecord("Wireless Mouse,WM-2201,150");

        // Sample Test Case 2: Incomplete record (missing field)
        parseInventoryRecord("Wireless Mouse,150");

        // Additional Test Cases
        parseInventoryRecord(null);
        parseInventoryRecord("Mechanical Keyboard,MK-88,75,ExtraField");
    }
}
