package strategy;

import domain.Opponent;
import domain.Winner;

/**
 * This class implements a strategy to determine when computer is winner
 */
public class ComputerWins implements Solver {

    @Override
    public Winner determineOutcome(Opponent player, Opponent computer) {
        if (computer.getHandFigure().isPredecesorOf(player.getHandFigure())) {
            computer.setScore(computer.getScore() + 1);
            return Winner.COMPUTER;
        }
        return null;
    }
}