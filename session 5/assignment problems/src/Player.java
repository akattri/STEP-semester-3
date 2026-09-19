public class Player implements Comparable<Player> {
    private String name;
    private int matchesPlayed;
    private double battingAverage;
    private boolean injured;

    /**
     * Constructs a new Player.
     *
     * @param name           player's name
     * @param matchesPlayed  total career matches played
     * @param battingAverage fantasy metric / batting average
     * @param injured        current injury status
     */
    public Player(String name, int matchesPlayed, double battingAverage, boolean injured) {
        this.name = name;
        this.matchesPlayed = matchesPlayed;
        this.battingAverage = battingAverage;
        this.injured = injured;
    }

    public String getName() {
        return name;
    }

    public int getMatchesPlayed() {
        return matchesPlayed;
    }

    public double getBattingAverage() {
        return battingAverage;
    }

    public boolean isInjured() {
        return injured;
    }

    /**
     * Experience-only draft qualification rule (matches >= 10 regardless of injury).
     *
     * @param matchesPlayed matches played by player
     * @return true if player qualifies on experience alone
     */
    public static boolean isDraftable(int matchesPlayed) {
        return matchesPlayed >= 10;
    }

    /**
     * Combined matches and fitness qualification rule.
     *
     * @param matchesPlayed matches played by player
     * @param injured       injury status
     * @return true if player is fit and has sufficient matches (>= 5)
     */
    public static boolean isDraftable(int matchesPlayed, boolean injured) {
        return !injured && matchesPlayed >= 5;
    }

    /**
     * Compares players in descending order of batting average for Arrays.sort.
     *
     * @param other another Player to compare against
     * @return negative if this > other, positive if this < other, 0 if equal
     */
    @Override
    public int compareTo(Player other) {
        return Double.compare(other.battingAverage, this.battingAverage);
    }

    @Override
    public String toString() {
        return name + " (" + battingAverage + ")";
    }
}
