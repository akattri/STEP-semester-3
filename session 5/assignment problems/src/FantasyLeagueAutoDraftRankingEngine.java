import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FantasyLeagueAutoDraftRankingEngine {

    /**
     * Experience-only draft qualification rule (matches >= 10 regardless of injury).
     *
     * @param matchesPlayed matches played by player
     * @return true if player qualifies on experience alone
     */
    public static boolean isDraftable(int matchesPlayed) {
        return Player.isDraftable(matchesPlayed);
    }

    /**
     * Combined matches and fitness qualification rule.
     *
     * @param matchesPlayed matches played by player
     * @param injured       injury status
     * @return true if player is fit and has sufficient matches (>= 5)
     */
    public static boolean isDraftable(int matchesPlayed, boolean injured) {
        return Player.isDraftable(matchesPlayed, injured);
    }

    /**
     * Filters draftable players using the overloaded rules and ranks them
     * in descending order of fantasy points/batting average using Arrays.sort.
     *
     * @param players input array of players
     * @return formatted ranking string: "1. Name | 2. Name | ..."
     */
    public static String draftAndRank(Player[] players) {
        if (players == null || players.length == 0) {
            return "";
        }

        List<Player> draftableList = new ArrayList<>();

        for (Player player : players) {
            if (player == null) {
                continue;
            }

            // Qualify if cleared by experience-only rule OR combined fitness-and-matches rule
            if (isDraftable(player.getMatchesPlayed())
                    || isDraftable(player.getMatchesPlayed(), player.isInjured())) {
                draftableList.add(player);
            }
        }

        Player[] draftableArray = draftableList.toArray(new Player[0]);

        // Sort draftable players using Player's compareTo implementation
        Arrays.sort(draftableArray);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < draftableArray.length; i++) {
            if (i > 0) {
                sb.append(" | ");
            }
            sb.append(i + 1).append(". ").append(draftableArray[i].getName());
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        // Sample Test Case from specification
        Player[] players = {
            new Player("Virat", 15, 48.0, false),
            new Player("Rahul", 7, 55.0, false),
            new Player("Sameer", 3, 60.0, false),
            new Player("Dev", 12, 20.0, true)
        };

        String result = draftAndRank(players);
        System.out.println("Result: " + result);

        // Additional Test Case: All qualify
        Player[] players2 = {
            new Player("Rohit", 20, 52.0, false),
            new Player("Gill", 8, 58.0, false)
        };
        System.out.println("\nResult 2: " + draftAndRank(players2));
    }
}
