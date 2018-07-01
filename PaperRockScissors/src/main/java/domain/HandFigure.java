package domain;

import java.util.HashMap;
import java.util.Map;

/**
 * Hand Figure enum contains the symbols for playing Paper - Rock - Scissors
 */
public enum HandFigure {
    PAPER(0),
    ROCK(1),
    SCISSORS(2);

    private int value;
    private static Map<Integer, HandFigure> map = new HashMap<>();

    HandFigure(int value) {
        this.value = value;
    }

    static {
        for (HandFigure handFigure : HandFigure.values()) {
            map.put(handFigure.value, handFigure);
        }
    }

    public static HandFigure valueOf(int handFigure) {
        return map.get(handFigure);
    }

    public boolean isPredecesorOf(HandFigure handFigure) {
        final int totalNumberOfElements = map.size();
        return handFigure.value == ((this.value + 1) % totalNumberOfElements);
    }
}
