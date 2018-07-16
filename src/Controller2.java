import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Controller2 implements KeyListener {

    private final VisualComponent visualComponent_;

    public Controller2(VisualComponent visualComponent) {
        visualComponent_ = visualComponent;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT){
            visualComponent_.c1.x_ = visualComponent_.c1.x_ + 10;
            visualComponent_.repaint();
            System.out.println("sdasd");
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {


    }
}