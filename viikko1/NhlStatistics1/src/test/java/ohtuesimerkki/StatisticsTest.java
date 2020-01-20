package ohtuesimerkki;

import org.junit.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.*;

public class StatisticsTest {
    double vertailuTarkkuus = 0.0001;
    
    Reader readerStub = new Reader() {
 
        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<>();
 
            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri",   "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));
 
            return players;
        }
    };
 
    Statistics stats;
    
    @Before
    public void setUp(){
        stats = new Statistics(readerStub);
    }
    
    @Test
    public void pelaajaLoydetaan(){
        assertEquals("Kurri                EDM 37 + 53 = 90", stats.search("Kurri").toString());
    }
    
    @Test
    public void olematontaPelaajaEiLoydy(){
        assertEquals(null, stats.search("Tikkanen"));
    }
    
    @Test
    public void parasPistemiesOnOikea(){
        assertEquals("Gretzky", stats.topScorers(1).get(0).getName());
    }
    
    @Test
    public void joukkueenPelaajatLoytyvat(){
        assertEquals(3, stats.team("EDM").size());
    }
}
