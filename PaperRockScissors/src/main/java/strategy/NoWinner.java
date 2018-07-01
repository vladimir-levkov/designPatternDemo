package strategy;

import domain.Opponent;
import domain.Winner;

/**
 * This class implements a strategy to determine when there is no winner.
 */
public class NoWinner implements Solver {

    @Override
    public Winner determineOutcome(Opponent player, Opponent computer) {
        return player.getHandFigure().equals(computer.getHandFigure()) ? Winner.NO_WINNER : null;
    }
}
