package strategy;

import domain.Opponent;
import domain.Winner;

public interface Solver {

    /**
     * Implement strategy to determine the outcome of the duel
     * between the player and the computer
     *
     * @param player
     *           player as opponent
     * @param computer
     *           computer as opponent
     * @return Winner if the strategy determines the winner
     *          otherwise it returns null
     */
    Winner determineOutcome(Opponent player, Opponent computer);
}
