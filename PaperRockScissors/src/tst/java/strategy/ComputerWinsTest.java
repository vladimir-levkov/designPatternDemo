package strategy;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;
import static org.mockito.Mockito.when;

import domain.HandFigure;
import domain.Opponent;
import domain.Winner;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ComputerWinsTest {

    @InjectMocks
    ComputerWins computerWins;

    @Mock
    Opponent player;

    @Test
    public void testComputerWins() {
        // given
        when(player.getHandFigure()).thenReturn(HandFigure.PAPER);
        final Opponent computer = new Opponent();
        computer.setHandFigure(HandFigure.SCISSORS);

        // when
        final Winner winner = computerWins.determineOutcome(player, computer);

        // then
        assertEquals(Winner.COMPUTER, winner);
        assertEquals(1, computer.getScore());
    }

    @Test
    public void testComputerNotWins() {
        // given
        when(player.getHandFigure()).thenReturn(HandFigure.PAPER);
        final Opponent computer = new Opponent();
        computer.setHandFigure(HandFigure.ROCK);

        // when
        final Winner winner = computerWins.determineOutcome(player, computer);

        // then
        assertNull(winner);
        assertEquals(0, computer.getScore());
    }
}