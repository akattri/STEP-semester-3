public class FileExtensionValidator {

    /**
     * Validates if a filename ends with an accepted extension (pdf, docx, zip)
     * regardless of case.
     *
     * @param filename the name of the file to check
     * @return "Accepted" or "Rejected — invalid file type"
     */
    public static String validateFileExtension(String filename) {
        if (filename == null) {
            String result = "Rejected — invalid file type";
            System.out.println(result);
            return result;
        }

        int dotIndex = filename.lastIndexOf('.');
        if (dotIndex == -1 || dotIndex == filename.length() - 1) {
            String result = "Rejected — invalid file type";
            System.out.println(result);
            return result;
        }

        String extension = filename.substring(dotIndex + 1);

        if (extension.equalsIgnoreCase("pdf")
                || extension.equalsIgnoreCase("docx")
                || extension.equalsIgnoreCase("zip")) {
            String result = "Accepted";
            System.out.println(result);
            return result;
        } else {
            String result = "Rejected — invalid file type";
            System.out.println(result);
            return result;
        }
    }

    public static void main(String[] args) {
        // Sample Test Case 1: Uppercase PDF
        validateFileExtension("Assignment1.PDF");

        // Sample Test Case 2: Unaccepted extension (.txt)
        validateFileExtension("notes.txt");

        // Additional Test Cases
        validateFileExtension("archive.zip");
        validateFileExtension("report.DOCX");
        validateFileExtension("noextension");
    }
}
