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
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    boolean ok = true;
                    for (DataModel dm : paintComponent.allModels) {
                        if (paintComponent.c1.x_ + paintComponent.c1.r_ + 5 > 600 || (paintComponent.c1.x_ + paintComponent.c1.r_ + 5 >= dm.x_
                                && paintComponent.c1.x_ + 5 + paintComponent.c1.r_ <= dm.w_ + dm.x_
                                && (
                                (paintComponent.c1.y_ >= dm.y_ && paintComponent.c1.y_ <= dm.h_ + dm.y_)
                                        ||
                                        (paintComponent.c1.y_ + paintComponent.c1.r_ >= dm.y_ && paintComponent.c1.y_ + paintComponent.c1.r_ <= dm.y_ + dm.h_)))) {
                            ok = false;
                        }
                    }
                    if (ok) {
                        paintComponent.c1.x_ += 5;
                        paintComponent.repaint();
                    }
                    EatModel del = null;
                    for (EatModel em : paintComponent.eatModels) {
                        if (em.x_ >= paintComponent.c1.x_ && em.x_ <= paintComponent.c1.x_ + paintComponent.c1.r_ && em.y_ >= paintComponent.c1.y_ && em.y_ <= paintComponent.c1.y_ + paintComponent.c1.r_) {
                            del = em;
                        }
                    }
                    if (del != null) {
                        paintComponent.eatModels.remove(del);
                    }
                    if (paintComponent.eatModels.size() == 0) {
                        paintComponent.winner = true;
                    }

                }
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    boolean ok = true;
                    for (DataModel dm : paintComponent.allModels) {
                        if (paintComponent.c1.x_ - 5 < 0 || (paintComponent.c1.x_ - 5 <= dm.x_ + dm.w_
                                && paintComponent.c1.x_ - 5 >= dm.x_
                                && (
                                (paintComponent.c1.y_ >= dm.y_ && paintComponent.c1.y_ <= dm.h_ + dm.y_)
                                        ||
                                        (paintComponent.c1.y_ + paintComponent.c1.r_ >= dm.y_ && paintComponent.c1.y_ + paintComponent.c1.r_ <= dm.y_ + dm.h_)))) {
                            ok = false;
                        }
                    }
                    if (ok) {
                        paintComponent.c1.x_ -= 5;
                        paintComponent.repaint();
                    }
                    EatModel del = null;
                    for (EatModel em : paintComponent.eatModels) {
                        if (em.x_ >= paintComponent.c1.x_ && em.x_ <= paintComponent.c1.x_ + paintComponent.c1.r_ && em.y_ >= paintComponent.c1.y_ && em.y_ <= paintComponent.c1.y_ + paintComponent.c1.r_) {
                            del = em;
                        }
                    }
                    if (del != null) {
                        paintComponent.eatModels.remove(del);
                    }
                    if (paintComponent.eatModels.size() == 0) {
                        paintComponent.winner = true;
                    }
                }
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    boolean ok = true;
                    for (DataModel dm : paintComponent.allModels) {
                        if (paintComponent.c1.y_ - 5 < 0 || (paintComponent.c1.y_ - 5 <= dm.y_ + dm.h_
                                && paintComponent.c1.y_ - 5 >= dm.y_
                                && (
                                (paintComponent.c1.x_ >= dm.x_ && paintComponent.c1.x_ <= dm.x_ + dm.w_)
                                        ||
                                        (paintComponent.c1.x_ + paintComponent.c1.r_ >= dm.x_ && paintComponent.c1.x_ + paintComponent.c1.r_ <= dm.x_ + dm.w_)))) {
                            ok = false;

                        }
                    }
                    if (ok) {
                        paintComponent.c1.y_ -= 5;
                        paintComponent.repaint();
                    }
                    EatModel del = null;
                    for (EatModel em : paintComponent.eatModels) {
                        if (em.x_ >= paintComponent.c1.x_ && em.x_ <= paintComponent.c1.x_ + paintComponent.c1.r_ && em.y_ >= paintComponent.c1.y_ && em.y_ <= paintComponent.c1.y_ + paintComponent.c1.r_) {
                            del = em;
                        }
                    }
                    if (del != null) {
                        paintComponent.eatModels.remove(del);
                    }
                    if (paintComponent.eatModels.size() == 0) {
                        paintComponent.winner = true;
                    }
                }
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    boolean ok = true;
                    for (DataModel dm : paintComponent.allModels) {
                        if (paintComponent.c1.y_ + paintComponent.c1.r_ + 5 > 350 || (paintComponent.c1.y_ + paintComponent.c1.r_ + 5 <= dm.y_ + dm.h_
                                && paintComponent.c1.y_ + paintComponent.c1.r_ + 5 >= dm.y_
                                && (
                                (paintComponent.c1.x_ >= dm.x_ && paintComponent.c1.x_ <= dm.x_ + dm.w_)
                                        ||
                                        (paintComponent.c1.x_ + paintComponent.c1.r_ >= dm.x_ && paintComponent.c1.x_ + paintComponent.c1.r_ <= dm.x_ + dm.w_)))) {
                            ok = false;

                        }
                    }
                    if (ok) {
                        paintComponent.c1.y_ += 5;
                        paintComponent.repaint();
                    }
                    EatModel del = null;
                    for (EatModel em : paintComponent.eatModels) {
                        if (em.x_ >= paintComponent.c1.x_ && em.x_ <= paintComponent.c1.x_ + paintComponent.c1.r_ && em.y_ >= paintComponent.c1.y_ && em.y_ <= paintComponent.c1.y_ + paintComponent.c1.r_) {
                            del = em;
                        }
                    }
                    if (del != null) {
                        paintComponent.eatModels.remove(del);
                    }
                    if (paintComponent.eatModels.size() == 0) {
                        paintComponent.winner = true;
                    }
                }

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
    }
}
