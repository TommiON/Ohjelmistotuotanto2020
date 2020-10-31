package ohtu.ohtuvarasto;

import org.junit.*;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import ohtuesimerkki.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


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
    public void palauttaaPelaajan() {
        Player p = stats.search("Gretzky");
        assertEquals("Gretzky", p.getName());
    }

    @Test
    public void palauttaaTyhjan() {
        Player p = stats.search("Eioo");
        assertNull(p);
    }

    @Test
    public void palauttaaJoukkueen() {
        List<Player> t = stats.team("EDM");
        assertEquals("Semenko", t.get(0).getName());
        assertEquals(3, t.size());
    }

    @Test
    public void palauttaaParhaatMaalintekijat() {
        List<Player> s = stats.topScorers(1);
        assertEquals(1, s.size());
        assertEquals("Gretzky", s.get(0).getName());
    }
}