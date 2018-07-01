package domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class HandFigureTest {

    @Test
    public void testCreateHandFigureByValue() {
        // given

        // when
        final HandFigure handFigure = HandFigure.valueOf(2);

        // then
        assertEquals(HandFigure.SCISSORS, handFigure);
    }

    @Test
    public void testIsPaperPredecessorOfRock() {
        // given

        // when
        final boolean isPaperPredecesorOfRock = HandFigure.PAPER.isPredecesorOf(HandFigure.ROCK);

        // then
        assertTrue(isPaperPredecesorOfRock);
    }


    @Test
    public void testIsScissorsPredecessorOfPaper() {
        // given

        // when
        final boolean isScissorsPredecessorOfPaper = HandFigure.SCISSORS.isPredecesorOf(HandFigure.PAPER);

        // then
        assertTrue(isScissorsPredecessorOfPaper);
    }
}