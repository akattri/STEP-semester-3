import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlacementDriveShortlistingEngine {

    /**
     * CGPA-only filter: direct qualification on strong CGPA alone.
     *
     * @param cgpa candidate's CGPA
     * @return true if candidate qualifies directly
     */
    public static boolean isEligible(double cgpa) {
        return Candidate.isEligible(cgpa);
    }

    /**
     * Combined CGPA-and-coding-score filter for borderline cases.
     *
     * @param cgpa        candidate's CGPA
     * @param codingScore candidate's coding score
     * @return true if candidate qualifies on combined criteria
     */
    public static boolean isEligible(double cgpa, int codingScore) {
        return Candidate.isEligible(cgpa, codingScore);
    }

    /**
     * Shortlists candidates who clear either eligibility check and ranks them
     * in descending order of composite score using Arrays.sort.
     *
     * @param candidates array of candidates
     * @return formatted ranking string: "1. Name (score) | 2. Name (score) | ..."
     */
    public static String shortlistAndRank(Candidate[] candidates) {
        if (candidates == null || candidates.length == 0) {
            return "";
        }

        List<Candidate> shortlisted = new ArrayList<>();

        for (Candidate c : candidates) {
            if (c == null) {
                continue;
            }

            // Check if candidate qualifies via CGPA-only or combined criteria
            if (isEligible(c.getCgpa()) || isEligible(c.getCgpa(), c.getCodingScore())) {
                shortlisted.add(c);
            }
        }

        Candidate[] shortlistedArray = shortlisted.toArray(new Candidate[0]);

        // Sort candidates using Candidate's compareTo implementation
        Arrays.sort(shortlistedArray);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < shortlistedArray.length; i++) {
            if (i > 0) {
                sb.append(" | ");
            }
            sb.append(i + 1).append(". ")
              .append(shortlistedArray[i].getName())
              .append(String.format(java.util.Locale.US, " (%.1f)", shortlistedArray[i].getCompositeScore()));
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        // Sample Test Case
        Candidate[] candidates = {
            new Candidate("Aisha", 8.2, 40),
            new Candidate("Rohit", 6.8, 65),
            new Candidate("Meena", 6.0, 90),
            new Candidate("Karan", 7.5, 20)
        };

        String result = shortlistAndRank(candidates);
        System.out.println("Result: " + result);

        // Additional Test Case
        Candidate[] candidates2 = {
            new Candidate("Pooja", 9.0, 80),
            new Candidate("Vikas", 6.2, 50)
        };
        System.out.println("\nResult 2: " + shortlistAndRank(candidates2));
    }
}
