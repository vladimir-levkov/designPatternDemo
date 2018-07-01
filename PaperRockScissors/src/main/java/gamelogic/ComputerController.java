package gamelogic;

import domain.HandFigure;

import java.util.Random;

/**
 * Computer controller class.
 * It generates random pick from the set of HandFigures.
 */
public class ComputerController {

    private static final int TOTAL_NUMBER_OF_HAND_FIGURES = 3;

    /**
     * Generates random HangFigure choice by using the Java embedded random generator.
     *
     * @return random {@link HandFigure} for the Computer turn.
     */
    private HandFigure generateRandomHandFigure() {
        final Random randomGenerator = new Random();
        final int randomChoice = randomGenerator.nextInt(TOTAL_NUMBER_OF_HAND_FIGURES);
        return HandFigure.valueOf(randomChoice);
    }

    public HandFigure getHandFigure() {
        return generateRandomHandFigure();
    }
}
