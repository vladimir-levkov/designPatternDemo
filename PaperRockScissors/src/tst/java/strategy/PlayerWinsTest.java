package strategy;

import domain.HandFigure;
import domain.Opponent;
import domain.Winner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PlayerWinsTest {

    @InjectMocks
    PlayerWins playerWins;

    @Mock
    Opponent computer;

    @Test
    public void testPlayerWins() {
        // given
        final Opponent player = new Opponent();
        player.setHandFigure(HandFigure.ROCK);
        when(player.getHandFigure()).thenReturn(HandFigure.ROCK);
        when(computer.getHandFigure()).thenReturn(HandFigure.SCISSORS);

        // when
        final Winner winner = playerWins.determineOutcome(player, computer);

        // then
        assertEquals(Winner.PLAYER, winner);
        assertEquals(1, player.getScore());
    }

    @Test
    public void testPlayerNotWins() {
        // given
        final Opponent player = new Opponent();
        player.setHandFigure(HandFigure.PAPER);
        when(computer.getHandFigure()).thenReturn(HandFigure.SCISSORS);

        // when
        final Winner winner = playerWins.determineOutcome(player, computer);

        // then
        assertNull(winner);
        assertEquals(0, player.getScore());
    }
}