package ohtuesimerkki;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class StatisticsTest {

    Reader readerStub = new Reader() {

        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<>();

            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri", "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));

            return players;
        }
    };

    Statistics stats;

    @Before
    public void setUp() {
        // luodaan Statistics-olio joka käyttää "stubia"
        stats = new Statistics(readerStub);
    }

    @Test
    public void pelaajaLoytyy() {
        Player player = stats.search("Semenko");

        assertEquals(player, stats.search("Semenko"));
    }
    
     @Test
    public void pelaajaaEiLoydy() {
        Player player = stats.search("Semenkonen");

        assertEquals(null, player);
    }


    @Test
    public void kaikkiJoukkueenPelaajat() {
        List<Player> players = stats.team("EDM");

        assertEquals(true, players.size()== 3);
    }
    
    @Test
    public void topPelaajat() {
        List<Player> topPlayers = stats.topScorers(4);

        assertEquals(true, topPlayers.size() == 5);
    }

    
    

}
   
