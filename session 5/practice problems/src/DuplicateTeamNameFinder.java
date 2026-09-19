import java.util.Arrays;

public class DuplicateTeamNameFinder {

    /**
     * Scans the list of registered team names and reports the first duplicate found.
     * Uses plain nested loops without any Collections class.
     *
     * @param teamNames array of registered team names
     * @return "Duplicate Found: <name>" or "No Duplicates Found"
     */
    public static String findDuplicateTeam(String[] teamNames) {
        if (teamNames == null || teamNames.length <= 1) {
            return "No Duplicates Found";
        }

        for (int i = 0; i < teamNames.length; i++) {
            for (int j = i + 1; j < teamNames.length; j++) {
                if (teamNames[i] != null && teamNames[i].equals(teamNames[j])) {
                    return "Duplicate Found: " + teamNames[i];
                }
            }
        }

        return "No Duplicates Found";
    }

    public static void main(String[] args) {
        // Sample Test Case 1: Duplicate team found
        String[] teams1 = {"ByteForce", "CodeCrafters", "ByteForce"};
        System.out.println("Teams: " + Arrays.toString(teams1));
        System.out.println("Result: " + findDuplicateTeam(teams1));

        // Sample Test Case 2: No duplicates
        String[] teams2 = {"ByteForce", "CodeCrafters", "NullPointers"};
        System.out.println("\nTeams: " + Arrays.toString(teams2));
        System.out.println("Result: " + findDuplicateTeam(teams2));

        // Additional Test Case
        String[] teams3 = {"Alpha", "Beta", "Gamma", "Beta"};
        System.out.println("\nTeams: " + Arrays.toString(teams3));
        System.out.println("Result: " + findDuplicateTeam(teams3));
    }
}
