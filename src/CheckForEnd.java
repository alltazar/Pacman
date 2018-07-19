import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheckForEnd {

    VisualComponent vc = new VisualComponent();

    @Test
    void testCheckState(){
        vc.badModels.clear();
        vc.eatModels.clear();
        EatModel em = new EatModel(72,22,5,5);
        vc.eatModels.add(em);

        vc.checkForEnd();

        assertFalse(vc.winner);
    }

    @Test
    void testCheckState1(){
        vc.badModels.clear();
        vc.eatModels.clear();
        EatModel em = new EatModel(72,22,5,5);
        vc.eatModels.add(em);

        vc.c1.speedX(50);

        vc.checkForEnd();

        assertTrue(vc.winner);
    }

    @Test
    void testCheckState2(){
        vc.badModels.clear();
        vc.eatModels.clear();
        vc.c1 = new Circle1(72,1,48);
        EatModel em = new EatModel(22,22,5,5);
        vc.eatModels.add(em);

        vc.checkForEnd();

        assertFalse(vc.winner);
    }

    @Test
    void testCheckState3(){
        vc.badModels.clear();
        vc.eatModels.clear();
        vc.c1 = new Circle1(72,1,48);
        EatModel em = new EatModel(22,22,5,5);
        vc.eatModels.add(em);

        vc.c1.speedX(-50);

        vc.checkForEnd();

        assertTrue(vc.winner);
    }
}
