import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class AddKeylistener {
    public static void add(JFrame jf, VisualComponent paintComponent){

        jf.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

                Circle1 c = paintComponent.c1;
                int speed = 5;
                int width = 600;
                int height = 350;
                int cWidth = c.getX_() + c.getR_();
                int cHeight = c.getY_() + c.getR_();

                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    boolean ok = true;
                    for (DataModel dm : paintComponent.allModels) {

                        int dWidth = dm.getX_() + dm.getW_();
                        int dHeight = dm.getY_() + dm.getH_();

                        if (cWidth + speed > width || (cWidth + speed >= dm.getX_()
                                && cWidth + speed <= dWidth
                                && (
                                (c.getY_() >= dm.getY_() && c.getY_() <= dHeight)
                                        ||
                                        (cHeight >= dm.getY_() && cHeight <= dHeight)))) {
                            ok = false;
                        }
                    }
                    if (ok) {
                        c.speedX(speed);
                        paintComponent.repaint();
                    }
                    paintComponent.checkForEnd();

                }
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    boolean ok = true;
                    for (DataModel dm : paintComponent.allModels) {

                        int dWidth = dm.getX_() + dm.getW_();
                        int dHeight = dm.getY_() + dm.getH_();

                        if (c.getX_() - speed < 0 || (c.getX_() - speed <= dWidth
                                && c.getX_() - speed >= dm.getX_()
                                && (
                                (c.getY_() >= dm.getY_() && c.getY_() <= dHeight)
                                        ||
                                        (cHeight >= dm.getY_() && cHeight <= dHeight)))) {
                            ok = false;
                        }
                    }
                    if (ok) {
                        c.speedX(-speed);
                        paintComponent.repaint();
                    }
                    paintComponent.checkForEnd();
                }
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    boolean ok = true;
                    for (DataModel dm : paintComponent.allModels) {

                        int dWidth = dm.getX_() + dm.getW_();
                        int dHeight = dm.getY_() + dm.getH_();

                        if (c.getY_() - speed < 0 || (c.getY_() - speed <= dHeight
                                && c.getY_() - speed >= dm.getY_()
                                && (
                                (c.getX_() >= dm.getX_() && c.getX_() <= dWidth)
                                        ||
                                        (cWidth >= dm.getX_() && cWidth <= dWidth)))) {
                            ok = false;

                        }
                    }
                    if (ok) {
                        c.speedY(-speed);
                        paintComponent.repaint();
                    }
                    paintComponent.checkForEnd();
                }
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    boolean ok = true;
                    for (DataModel dm : paintComponent.allModels) {

                        int dWidth = dm.getX_() + dm.getW_();
                        int dHeight = dm.getY_() + dm.getH_();

                        if (cHeight + speed > height || (cHeight + speed <= dHeight
                                && cHeight + speed >= dm.getY_()
                                && (
                                (c.getX_() >= dm.getX_() && c.getX_() <= dWidth)
                                        ||
                                        (cWidth >= dm.getX_() && cWidth <= dWidth)))) {
                            ok = false;

                        }
                    }
                    if (ok) {
                        c.speedY(speed);
                        paintComponent.repaint();
                    }
                    paintComponent.checkForEnd();
                }

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
    }
}
