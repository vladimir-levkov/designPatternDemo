package strategy;

import domain.Opponent;
import domain.Winner;

/**
 * This class implements a strategy to determine when player is winner
 */
public class PlayerWins implements Solver {

    @Override
    public Winner determineOutcome(Opponent player, Opponent computer) {
        if (player.getHandFigure().isPredecesorOf(computer.getHandFigure())) {
            player.setScore(player.getScore() + 1);
            return Winner.PLAYER;
        }
        return null;
    }
}
