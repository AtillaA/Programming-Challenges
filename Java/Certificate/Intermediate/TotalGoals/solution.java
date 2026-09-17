import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Solution {

    public static int getTotalGoals(String team, int year) {
        int homeGoals = getGoalsForTeamRole(team, year, "team1"); // sum goals scored by team1
        int visitingGoals = getGoalsForTeamRole(team, year, "team2"); // sum goals scored by team2
        
        return homeGoals + visitingGoals; // return total goals scored
    }

    private static int getGoalsForTeamRole(String team, int year, String teamRole) {
        int totalGoals = 0;
        int currentPage = 1;
        int totalPages = 1;

        try {
            // URL encode the team name to handle spaces
            String encodedTeam = java.net.URLEncoder.encode(team, "UTF-8");

            while (currentPage <= totalPages) {
                String urlString = String.format(
                    "https://jsonmock.com",
                    year, teamRole, encodedTeam, currentPage
                );

                URL url = new URL(urlString);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");

                int responseCode = conn.getResponseCode();
                if (responseCode == 200) {
                    BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                    String inputLine;
                    StringBuilder response = new StringBuilder();

                    while ((inputLine = in.readLine()) != null) {
                        response.append(inputLine);
                    }
                    in.close();

                    String jsonResponse = response.toString();

                    // parse total_pages from the response on the first loop execution
                    if (currentPage == 1) {
                        totalPages = parseTotalPages(jsonResponse);
                    }

                    // accumulate goals from the current page data
                    totalGoals += parseGoalsFromPage(jsonResponse, teamRole);
                }
                currentPage++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return totalGoals;
    }

    // simple parser to extract total_pages from JSON
    private static int parseTotalPages(String json) {
        String key = "\"total_pages\":";
        int index = json.indexOf(key);
        if (index == -1) return 1;
        
        int start = index + key.length();
        int end = json.indexOf(",", start);
        if (end == -1) {
            end = json.indexOf("}", start);
        }
        
        return Integer.parseInt(json.substring(start, end).trim());
    }

    // manual parser to scan the data array for goals
    private static int parseGoalsFromPage(String json, String teamRole) {
        int goalsOnPage = 0;
        // determine which goals key to look up
        String goalKey = teamRole.equals("team1") ? "\"team1goals\":\"" : "\"team2goals\":\"";
        
        int index = json.indexOf(goalKey);
        while (index != -1) {
            int start = index + goalKey.length();
            int end = json.indexOf("\"", start);
            
            String goalStr = json.substring(start, end);
            goalsOnPage += Integer.parseInt(goalStr);
            
            // advance to find the next match record entry
            index = json.indexOf(goalKey, end);
        }
        
        return goalsOnPage;
    }

    public static void main(String[] args) {
        // sample case testing
        String team = "Barcelona";
        int year = 2011;
        System.out.println("Total Goals: " + getTotalGoals(team, year)); // expected: 35
    }
}
