import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class GameTest {
    @Test
    public void testGame() {
        Player playerA = new Player("Player A", 50, 5, 10);
        Player playerB = new Player("Player B", 100, 10, 5);

        Game game = new Game(playerA, playerB);
        game.play();

        assertTrue(playerA.getHealth() == 0 || playerB.getHealth() == 0);
    }

    @Test
    public void testRollDie() {
        Game game = new Game(new Player("Player A", 50, 5, 10), new Player("Player B", 100, 10, 5));
        int roll = game.rollDie();
        assertTrue(roll >= 1 && roll <= 6);
    }
}
