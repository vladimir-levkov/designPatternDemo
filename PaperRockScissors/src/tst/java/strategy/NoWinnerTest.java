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
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class NoWinnerTest {

    @InjectMocks
    NoWinner noWinner;

    @Mock
    Opponent player;

    @Mock
    Opponent computer;

    @Test
    public void testPlayerWins() {
        // given
        when(player.getHandFigure()).thenReturn(HandFigure.ROCK);
        when(computer.getHandFigure()).thenReturn(HandFigure.ROCK);

        // when
        final Winner winner = noWinner.determineOutcome(player, computer);

        // then
        assertEquals(Winner.NO_WINNER, winner);
    }

    @Test
    public void testPlayerNotWins() {
        // given
        when(player.getHandFigure()).thenReturn(HandFigure.PAPER);
        when(computer.getHandFigure()).thenReturn(HandFigure.SCISSORS);

        // when
        final Winner winner = noWinner.determineOutcome(player, computer);

        // then
        assertNull(winner);
    }
}