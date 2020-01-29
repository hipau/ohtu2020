package ohtu;

import com.google.gson.Gson;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import org.apache.http.client.fluent.Request;


class PointsComparator implements Comparator<Player> {
    @Override
    public int compare(Player p1, Player p2) {
        if((p1.getGoals() + p1.getAssists()) == (p2.getGoals() + p2.getAssists()))
            return p1.getGoals() - p2.getGoals();
        return (p1.getGoals() + p1.getAssists()) - (p2.getGoals() + p2.getAssists());
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        String url = "https://nhlstatisticsforohtu.herokuapp.com/players";
        
        String bodyText = Request.Get(url).execute().returnContent().asString();
                
        Gson mapper = new Gson();
        List<Player> finnishPlayers = Arrays.asList(mapper.fromJson(bodyText, Player[].class)).stream().filter(p -> p.getNationality().equals("FIN")).collect(Collectors.toList());                
        Collections.sort(finnishPlayers, new PointsComparator().reversed());
        
        System.out.println("Players from FIN ");
        for (Player player : finnishPlayers) {
            System.out.println(player);
        }   
    }  
}
