import java.io.*;
import java.net.*;
import java.net.http.*;
import java.util.regex.*;


class Result {

  public static int getWinnerTotalGoals(String competition, int year) {
    try {
      HttpClient client = HttpClient.newHttpClient();
      
      // fetch competition info to find the winning team
      String compUrl = String.format("https://jsonmock.com/api/football_competitions?name=%s&year=%s",
                                      URLEncoder.encode(competition, "UTF-8"), year);
      
      HttpRequest request = HttpRequest.newBuilder().uri(URI.create(compUrl)).build();
      HttpResponse<String> response = client.send(request, HttpResponsse.BodyHandlers.ofString());
      
      // extract winner using regex
      Matcher winnerMatcher = Pattern.compile("\"winner\"\\s*:\\s*\"([^\"]+)\"").matcher(response.body());
                                                  
      if (!winnerMatcher.find()) {
        return 0;
      }
                                                
      String winner = winnerMatcher.group(1);
      
      // fetch goals scored by the winning team as team1 and team2
      int totalGoals = 0;
      totalGoals += fetchGoals(client, competition, year, winner, "team1");
      totalGoals += fetchGoals(client, competition, year, winner, "team2");
      
      return totalGoals;
    } catch (Exception e) {
      e.printStackTrace();
      return 0;
    }

    private static int fetchGoals(HttpClient client, String competition, int year, String team, String teamParam) throws Exception {
      int totalGoals = 0;
      int page = 1;
      int totalPages = 1;
    
      while (page <= totalPages) {
        String url = String.format("https://jsonmock.com/api/football_matches?competition=%s&year=%s&%s=%s&page=%s",
                                    URLEncoder.encode(competition, "UTF-8"), year, teamParam, URLEncoder.encode(team, "UTF-8"), page);
                                   
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String json = response.body();
        
        // parse total_pages
        Matcher pageMatcher = Pattern.compile("\"total_pages\"\\s*:\\s*(\\d+)").matcher(json);
        if (pageMatcher.find()) {
            totalPages = Integer.parseInt(pageMatcher.group(1));
        }
          
        // parse goals scored in matches on current page
        String goalsKey = teamParam + "goals";
        Matcher goalsMatcher = Pattern.compile("\"" + goalsKey + "\"\\s*:\\s*\"(\\d+)\"").matcher(json);
        
        while (goalsMatcher.find()) {
            totalGoals += Integer.parseInt(goalsMatcher.group(1));
        }
        
        page++;
      }
      
      return totalGoals;
    }
}
