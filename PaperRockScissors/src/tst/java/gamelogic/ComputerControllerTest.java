package gamelogic;

import domain.HandFigure;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;

public class ComputerControllerTest {

    @Test
    public void testRandomGenerator() {
        // given
        final ComputerController computerController = new ComputerController();

        // when
        HandFigure handFigure = computerController.getHandFigure();

        // then
        assertNotNull(handFigure);
    }
}