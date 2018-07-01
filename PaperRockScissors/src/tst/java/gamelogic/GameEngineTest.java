package gamelogic;

import static junit.framework.TestCase.assertEquals;

import domain.HandFigure;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class GameEngineTest {

    @InjectMocks
    private GameEngine gameEngine;

    @Mock
    private ComputerController computerController;

    @Test
    public void testPlayerWins() {
        // given
        when(computerController.getHandFigure()).thenReturn(HandFigure.PAPER);
        gameEngine.setPlayerHandFigure(HandFigure.SCISSORS);

        // when
        gameEngine.play();

        // then
        assertEquals(1, gameEngine.getScorePlayerProperty().get());
        assertEquals(0, gameEngine.getScoreComputerProperty().get());
    }

    @Test
    public void testComputerWins() {
        // given
        when(computerController.getHandFigure()).thenReturn(HandFigure.ROCK);
        gameEngine.setPlayerHandFigure(HandFigure.SCISSORS);

        // when
        gameEngine.play();

        // then
        assertEquals(0, gameEngine.getScorePlayerProperty().get());
        assertEquals(1, gameEngine.getScoreComputerProperty().get());
    }

    @Test
    public void testNoWinner() {
        // given
        when(computerController.getHandFigure()).thenReturn(HandFigure.PAPER);
        gameEngine.setPlayerHandFigure(HandFigure.PAPER);

        // when
        gameEngine.play();

        // then
        assertEquals(0, gameEngine.getScorePlayerProperty().get());
        assertEquals(0, gameEngine.getScoreComputerProperty().get());
    }

    @Test
    public void testPlayerDoubleWinner() {
        // given
        when(computerController.getHandFigure()).thenReturn(HandFigure.ROCK);
        gameEngine.setPlayerHandFigure(HandFigure.PAPER);

        // when
        gameEngine.play();
        gameEngine.play();

        // then
        assertEquals(2, gameEngine.getScorePlayerProperty().get());
        assertEquals(0, gameEngine.getScoreComputerProperty().get());
    }
}