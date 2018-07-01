package domain;

public enum Winner {
    NO_WINNER("No winner"),
    PLAYER("Player wins"),
    COMPUTER("Computer wins");

    private String winnerLabel;

    Winner(final String winnerLabel) {
        this.winnerLabel = winnerLabel;
    }

    public String getWinnerLabel() {
        return winnerLabel;
    }
}
