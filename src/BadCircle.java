import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BadCircle{
    private int x_;
    private int y_;
    private int r_;

    final int speed = 5;
    final int width = 600;
    final int height = 350;

    private Integer up = new Integer(1);
    private Integer right = new Integer(1);
    private Integer down = new Integer(1);
    private Integer left = new Integer(1);

    private int way;
    private int ways;

    private Random rand = new Random();

    List<Integer> waysarr = new ArrayList<>();

    private Color color_ = Color.BLUE;

    BadCircle(int x, int y, int r){x_=x;y_=y;r_=r;}

    void paint(Graphics g){
        g.setColor(color_);
        g.fillOval(x_,y_,r_,r_);
    }

    void checkState(VisualComponent vc){
        int bcWidth = x_ + r_;
        int bcHeight = y_ + r_;
        Circle1 c = vc.c1;
        int cWidth = c.getX_() + c.getR_();
        int cHeight = c.getY_() + c.getR_();

        if (x_-1 <= cWidth && x_-1 >= c.getX_() && ((y_ >= c.getY_() && y_ <= cHeight) || (bcHeight >= c.getY_() && bcHeight <= cHeight)) ){
            vc.looser = true;
        }
        if (bcWidth+1 >=c.getX_() && bcWidth+1 <= cWidth && ((bcHeight >= c.getY_() && bcHeight <= cHeight) || (y_>= c.getY_() && y_<= cHeight)) ){
            vc.looser = true;
        }
        if (y_-1 >=c.getY_() && y_-1 <= cHeight && ((bcWidth >= c.getX_() && bcWidth <= cWidth) || (x_>= c.getX_() && x_<= cWidth)) ){
            vc.looser = true;
        }
        if (bcHeight+1 >=c.getY_() && bcHeight+1 <= cHeight && ((bcWidth >= c.getX_() && bcWidth <= cWidth) || (x_>= c.getX_() && x_<= cWidth)) ){
            vc.looser = true;
        }
    }

    void move(VisualComponent vc){

        for (DataModel dm : vc.allModels) {

            int bcWidth = x_ + r_;
            int bcHeight = y_ + r_;
            int dWidth = dm.getX_() + dm.getW_();
            int dHeight = dm.getY_() + dm.getH_();

            checkState(vc);

            if (bcWidth + speed > width || (bcWidth + speed >= dm.getX_()
                    && bcWidth + speed <= dWidth
                    && (
                    (y_ >= dm.getY_()&& y_ <= dHeight)
                            ||
                            (bcHeight >= dm.getY_() && bcHeight <= dHeight)))) {
                right = new Integer(0);
            }

            if (x_ - speed < 0 || (x_ - speed <= dWidth
                    && x_ - speed >= dm.getX_()
                    && (
                    (y_ >= dm.getY_()&& y_ <= dHeight)
                            ||
                            (bcHeight >= dm.getY_() && bcHeight <= dHeight)))) {
                left = new Integer(0);
            }

            if (y_ - speed < 0 || (y_ - speed <= dHeight
                    && y_ - speed >= dm.getY_()
                    && (
                    (x_ >= dm.getX_()&& x_ <= dWidth)
                            ||
                            (bcWidth >= dm.getX_() && bcWidth <= dWidth)))) {
                up = new Integer(0);
            }

            if (bcHeight + speed > height || (bcHeight + speed <= dHeight
                    && bcHeight + speed >= dm.getY_()
                    && (
                    (x_ >= dm.getX_()&& x_ <= dWidth)
                            ||
                            (bcWidth >= dm.getX_() && bcWidth <= dWidth)))) {
                down = new Integer(0);
            }

        }

        if (way == 1 && up == 1 && ways == up + right + down + left) {
            y_-=5;
        } else if (way == 2 && right == 1 && ways == up + right + down + left){
            x_+=5;
        } else if (way == 3 && down == 1 && ways == up + right + down + left){
            y_+=5;
        } else if (way == 4 && left == 1 && ways == up + right + down + left){
            x_-=5;
        } else {
            ways = up + right + down + left;

            waysarr.clear();

            if (up>0){waysarr.add(up);}
            if (right>0){waysarr.add(right);}
            if (down>0){waysarr.add(down);}
            if (left>0){waysarr.add(left);}

            int randomNum = rand.nextInt(waysarr.size());

            if (waysarr.get(randomNum) == up){
                y_-=5;
                way = 1;
            } else if (waysarr.get(randomNum) == right){
                x_+=5;
                way = 2;
            } else if (waysarr.get(randomNum) == down){
                y_+=5;
                way = 3;
            } else if (waysarr.get(randomNum) == left){
                x_-=5;
                way = 4;
            }


        }


        up =new Integer(1);
        left=new Integer(1);
        down=new Integer(1);
        right=new Integer(1);

    }
}