public class CsvStudentRecordParser {

    /**
     * Parses a CSV student record line and prints the formatted record.
     * Expects exactly 3 fields: "Name,RollNumber,Department".
     *
     * @param csvLine comma-separated record
     */
    public static void parseStudentRecord(String csvLine) {
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

        String name = fields[0].trim();
        String rollNo = fields[1].trim();
        String dept = fields[2].trim();

        System.out.printf("Name: %s | Roll No: %s | Dept: %s%n", name, rollNo, dept);
    }

    public static void main(String[] args) {
        // Sample Test Case 1: Valid record
        parseStudentRecord("Ananya Verma,RA2211003010123,CSE");

        // Sample Test Case 2: Invalid record (missing field)
        parseStudentRecord("Ananya Verma,CSE");
    }
}
