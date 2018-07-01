package view;

import domain.HandFigure;
import gamelogic.ComputerController;
import gamelogic.GameEngine;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class GameView {

    private GameEngine gameEngine;

    @FXML
    private ImageView playerChoice;
    @FXML
    private ImageView computerChoice;

    @FXML
    private Label playerScore;
    @FXML
    private Label computerScore;
    @FXML
    private Label winner;

    @FXML
    public void initialize() {
        gameEngine = new GameEngine(new ComputerController());
        gameEngine.getResultTextProperty().addListener(
                (observable, oldValue, newValue) -> winner.setText(newValue));
        gameEngine.getScorePlayerProperty().addListener(
                (observable, oldValue, newValue) -> playerScore.setText(newValue.toString()));
        gameEngine.getScoreComputerProperty().addListener(
                (observable, oldValue, newValue) -> computerScore.setText(newValue.toString()));
        gameEngine.getComputerHandFigureProperty().addListener(
                (observable, oldValue, newValue) -> updateOpponentChoice(computerChoice, (HandFigure) newValue));
    }

    @FXML
    void onPlayerChoicePaper() {
        setChoiceAndPlay(HandFigure.PAPER);
    }

    @FXML
    void onPlayerChoiceRock() {
        setChoiceAndPlay(HandFigure.ROCK);
    }

    @FXML
    void onPlayerChoiceScissors() {
        setChoiceAndPlay(HandFigure.SCISSORS);
    }

    private void setChoiceAndPlay(final HandFigure handFigure) {
        gameEngine.setPlayerHandFigure(handFigure);
        updateOpponentChoice(playerChoice, handFigure);
        gameEngine.play();
    }

    private void updateOpponentChoice(final ImageView view, final HandFigure handFigure) {
        Image image;
        switch(handFigure) {
            case PAPER:
                image = new Image("paper.jpg");
                break;
            case ROCK:
                image = new Image("rock.jpg");
                break;
            case SCISSORS:
                image = new Image("scissors.jpg");
                break;
            default:
                image = new Image("rock-paper-scissors.jpg");
        }
        view.setImage(image);
    }
}
