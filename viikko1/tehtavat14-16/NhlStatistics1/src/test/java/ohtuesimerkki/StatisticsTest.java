package ohtuesimerkki;

import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;

public class StatisticsTest {
 
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
        // luodaan Statistics-olio joka käyttää "stubia"
        stats = new Statistics(readerStub);
    } 

    @Test
    public void searchReturnsTheCorrectPlayer() {
        assertEquals("Semenko", stats.search("Semenko").getName());
    }

    @Test
    public void searchReturnsNullIfPlayerNotFound() {
        assertNull(stats.search("null"));
    }

    @Test
    public void teamReturnsTheCorrectAmountOfPlayers() {
        assertEquals(3, stats.team("EDM").size());
    }

    @Test
    public void topScorersReturnsTheCorrectPlayers() {
        List<Player> top = stats.topScorers(3);
        assertTrue(top.get(0).getName().equals("Gretzky"));
        assertTrue(top.get(1).getName().equals("Lemieux"));
        assertTrue(top.get(2).getName().equals("Yzerman"));
    }
}