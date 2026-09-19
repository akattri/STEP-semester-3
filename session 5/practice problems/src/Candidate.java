public class Candidate implements Comparable<Candidate> {
    private String name;
    private double cgpa;
    private int codingScore;

    /**
     * Constructs a new Candidate.
     *
     * @param name        candidate's name
     * @param cgpa        candidate's CGPA (0.0 to 10.0)
     * @param codingScore candidate's score in the coding test (0 to 100)
     */
    public Candidate(String name, double cgpa, int codingScore) {
        this.name = name;
        this.cgpa = cgpa;
        this.codingScore = codingScore;
    }

    public String getName() {
        return name;
    }

    public double getCgpa() {
        return cgpa;
    }

    public int getCodingScore() {
        return codingScore;
    }

    /**
     * Computes the composite score: (CGPA * 10) + (codingScore * 0.5).
     *
     * @return calculated composite score
     */
    public double getCompositeScore() {
        return (cgpa * 10.0) + (codingScore * 0.5);
    }

    /**
     * Quick filter: direct qualification based on strong CGPA alone (>= 7.5).
     *
     * @param cgpa candidate's CGPA
     * @return true if candidate qualifies on CGPA alone
     */
    public static boolean isEligible(double cgpa) {
        return cgpa >= 7.5;
    }

    /**
     * Combined filter: borderline CGPA (>= 6.5) with strong coding score (>= 60).
     *
     * @param cgpa        candidate's CGPA
     * @param codingScore candidate's coding test score
     * @return true if candidate clears combined borderline criteria
     */
    public static boolean isEligible(double cgpa, int codingScore) {
        return cgpa >= 6.5 && codingScore >= 60;
    }

    /**
     * Compares candidates in descending order of composite score for Arrays.sort.
     *
     * @param other another Candidate to compare against
     * @return negative if this > other, positive if this < other, 0 if equal
     */
    @Override
    public int compareTo(Candidate other) {
        return Double.compare(other.getCompositeScore(), this.getCompositeScore());
    }

    @Override
    public String toString() {
        return String.format("%s (%.1f)", name, getCompositeScore());
    }
}
