package domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OpponentTest {

    private static final int TEST_SCORE = 5;

    @Test
    public void testScore() {
        // given
        Opponent opponent = new Opponent();

        // when
        opponent.setScore(TEST_SCORE);

        // then
        assertEquals(TEST_SCORE, opponent.getScore());
    }

    @Test
    public void testHandFigure() {
        // given
        Opponent opponent = new Opponent();

        // when
        opponent.setHandFigure(HandFigure.PAPER);

        // then
        assertEquals(HandFigure.PAPER, opponent.getHandFigure());
    }
}