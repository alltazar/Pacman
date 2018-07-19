import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheckStateTests {

    VisualComponent vc = new VisualComponent();

    @Test
    void testCheckState1(){
        vc.badModels.clear();
        BadCircle bc = new BadCircle(551,1,48);
        vc.badModels.add(bc);

        bc.checkState(vc);

        assertFalse(vc.looser);
    }

    @Test
    void testCheckState2(){
        vc.badModels.clear();
        BadCircle bc = new BadCircle(1,50,48);
        vc.badModels.add(bc);

        bc.checkState(vc);

        assertTrue(vc.looser);
    }

    @Test
    void testCheckState3(){
        vc.badModels.clear();
        BadCircle bc = new BadCircle(1,1,48);
        vc.badModels.add(bc);

        bc.checkState(vc);

        assertFalse(vc.looser);
    }

    @Test
    void testCheckState4(){
        vc.badModels.clear();
        BadCircle bc = new BadCircle(1,1,48);
        vc.badModels.add(bc);

        bc.checkState(vc);

        assertTrue(vc.looser);
    }

    @Test
    void testCheckState5(){
        vc.badModels.clear();
        BadCircle bc = new BadCircle(2,1,48);
        vc.badModels.add(bc);

        bc.checkState(vc);

        assertTrue(vc.looser);
    }
}
