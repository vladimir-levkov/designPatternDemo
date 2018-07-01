package domain;

/**
 * Domain class Opponent.
 * This bean represents the opponent with its properties:
 * score - total number of wins in the game
 * and hand figure - last choice by the opponent in the game
 */
public class Opponent {
    private int score = 0;
    private HandFigure handFigure;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public HandFigure getHandFigure() {
        return handFigure;
    }

    public void setHandFigure(HandFigure handFigure) {
        this.handFigure = handFigure;
    }
}
