package gamelogic;

import domain.HandFigure;
import domain.Opponent;
import domain.Winner;
import strategy.ComputerWins;
import strategy.NoWinner;
import strategy.PlayerWins;
import strategy.Solver;
import javafx.beans.property.*;

import java.util.Arrays;
import java.util.List;

public class GameEngine {

    private final ComputerController computerController;
    private final Opponent player = new Opponent();
    private final Opponent computer = new Opponent();

    private final StringProperty resultText = new SimpleStringProperty();
    private final IntegerProperty scorePlayer = new SimpleIntegerProperty();
    private final IntegerProperty scoreComputer = new SimpleIntegerProperty();

    private HandFigure playerHandFigure;
    private final ObjectProperty<HandFigure> computerHandFigure = new SimpleObjectProperty<>();

    /**
     * Constructor game engine
     *
     * @param computerController
     *            the computer controller
     */
    public GameEngine (final ComputerController computerController) {
        this.computerController = computerController;
    }

    /**
     * When triggered from the user (player), game is played.
     */
    public void play() {
        // set opponents
        player.setHandFigure(playerHandFigure);
        computerHandFigure.set(computerController.getHandFigure());
        computer.setHandFigure(computerHandFigure.get());

        resultText.set(determineWinner(player, computer));
        updateScore(player, computer);
    }

    /**
     * Determine the winner by using the strategies for possible outcomes
     *
     * @param player
     *            player as opponent
     * @param computer
     *            computer as opponent
     *
     * @return text with result of the game
     */
    private String determineWinner(final Opponent player, final Opponent computer) {
        final Solver[] gameSolver = {new ComputerWins(), new PlayerWins(), new NoWinner()};
        final List<Solver> solvers = Arrays.asList(gameSolver);

        Winner winner;
        for(final Solver solver : solvers) {
            winner = solver.determineOutcome(player, computer);
            if(winner != null) return winner.getWinnerLabel();
        }
        return "";
    }

    /**
     * Triggers update of the score labels.
     *
     * @param player
     *            player as opponent
     * @param computer
     *            computer as opponent
     */
    private void updateScore(final Opponent player, final Opponent computer) {
        scorePlayer.set(player.getScore());
        scoreComputer.set(computer.getScore());
    }

    public void setPlayerHandFigure(final HandFigure playerHandFigure) {
        this.playerHandFigure = playerHandFigure;
    }

    public StringProperty getResultTextProperty() {
        return resultText;
    }

    public IntegerProperty getScorePlayerProperty() {
        return scorePlayer;
    }

    public ObjectProperty getComputerHandFigureProperty() {
        return computerHandFigure;
    }

    public IntegerProperty getScoreComputerProperty() {
        return scoreComputer;
    }
}
