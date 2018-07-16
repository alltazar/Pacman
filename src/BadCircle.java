import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BadCircle{
    int x_;
    int y_;
    int r_;

    Integer up = new Integer(1);
    Integer right = new Integer(1);
    Integer down = new Integer(1);
    Integer left = new Integer(1);

    int way;
    int ways;

    Random rand = new Random();

    List<Integer> waysarr = new ArrayList<>();

    Color color_ = Color.BLUE;

    BadCircle(int x, int y, int r){x_=x;y_=y;r_=r;}

    void paint(Graphics g, BadCircle e){
        g.setColor(color_);
        g.fillOval(e.x_,e.y_,e.r_,e.r_);
    }

    void move(BadCircle bc, VisualComponent vc){
        for (DataModel dm : vc.allModels) {
            if (bc.x_ + bc.r_ + 5 > 600 || (bc.x_ + bc.r_ + 5 >= dm.x_
                    && bc.x_ + 5 + bc.r_ <= dm.w_ + dm.x_
                    && (
                    (bc.y_ >= dm.y_&& bc.y_ <= dm.h_ + dm.y_)
                            ||
                            (bc.y_ + bc.r_ >= dm.y_ && bc.y_ + bc.r_ <= dm.y_ + dm.h_)))) {

                bc.right = new Integer(0);

            }

            if (bc.x_-1<=vc.c1.x_+vc.c1.r_ && bc.x_-1>=vc.c1.x_ && ((bc.y_ >= vc.c1.y_ && bc.y_ <= vc.c1.y_ + vc.c1.r_) || (bc.y_ + bc.r_>= vc.c1.y_ && bc.y_ + bc.r_<= vc.c1.y_ + vc.c1.r_)) ){
                vc.looser = true;
            }

            if (bc.x_ - 5 < 0 || (bc.x_ - 5 <= dm.x_ + dm.w_
                    && bc.x_ - 5 >= dm.x_
                    && (
                    (bc.y_ >= dm.y_&& bc.y_ <= dm.h_ + dm.y_)
                            ||
                            (bc.y_ + bc.r_ >= dm.y_ && bc.y_ + bc.r_ <= dm.y_+dm.h_)))) {

                bc.left = new Integer(0);


            }
            if (bc.x_+bc.r_+1 >=vc.c1.x_ && bc.x_+bc.r_+1 <= vc.c1.x_ + vc.c1.r_ && ((bc.y_ + bc.r_ >= vc.c1.y_ && bc.y_ + bc.r_ <= vc.c1.y_ + vc.c1.r_) || (bc.y_>= vc.c1.y_ && bc.y_<= vc.c1.y_ + vc.c1.r_)) ){
                vc.looser = true;
            }

            if (bc.y_ - 5 < 0 || (bc.y_ - 5 <= dm.y_ + dm.h_
                    && bc.y_ - 5 >= dm.y_
                    && (
                    (bc.x_ >= dm.x_&& bc.x_ <= dm.x_ + dm.w_)
                            ||
                            (bc.x_ + bc.r_ >= dm.x_ && bc.x_ + bc.r_ <= dm.x_+dm.w_)))) {

                bc.up = new Integer(0);

            }
            if (bc.y_-1 >=vc.c1.y_ && bc.y_-1 <= vc.c1.y_ + vc.c1.r_ && ((bc.x_ + bc.r_ >= vc.c1.x_ && bc.x_ + bc.r_ <= vc.c1.x_ + vc.c1.r_) || (bc.x_>= vc.c1.x_ && bc.x_<= vc.c1.x_ + vc.c1.r_)) ){
                vc.looser = true;
            }

            if (bc.y_ + bc.r_ + 5 > 350 || (bc.y_ + bc.r_ + 5 <= dm.y_ + dm.h_
                    && bc.y_ + bc.r_ + 5 >= dm.y_
                    && (
                    (bc.x_ >= dm.x_&& bc.x_ <= dm.x_ + dm.w_)
                            ||
                            (bc.x_ + bc.r_ >= dm.x_ && bc.x_ + bc.r_ <= dm.x_+dm.w_)))) {

                bc.down = new Integer(0);

            }
            if (bc.y_+bc.r_+1 >=vc.c1.y_ && bc.y_+bc.r_+1 <= vc.c1.y_ + vc.c1.r_ && ((bc.x_ + bc.r_ >= vc.c1.x_ && bc.x_ + bc.r_ <= vc.c1.x_ + vc.c1.r_) || (bc.x_>= vc.c1.x_ && bc.x_<= vc.c1.x_ + vc.c1.r_)) ){
                vc.looser = true;
            }

        }

        if (bc.way == 1 && bc.up == 1 && bc.ways == bc.up + bc.right + bc.down + bc.left) {
            bc.y_-=5;
        } else if (bc.way == 2 && bc.right == 1 && bc.ways == bc.up + bc.right + bc.down + bc.left){
            bc.x_+=5;
        } else if (bc.way == 3 && bc.down == 1 && bc.ways == bc.up + bc.right + bc.down + bc.left){
            bc.y_+=5;
        } else if (bc.way == 4 && bc.left == 1 && bc.ways == bc.up + bc.right + bc.down + bc.left){
            bc.x_-=5;
        } else {
            bc.ways = bc.up + bc.right + bc.down + bc.left;

            bc.waysarr.clear();

            if (bc.up>0){bc.waysarr.add(bc.up);}
            if (bc.right>0){bc.waysarr.add(bc.right);}
            if (bc.down>0){bc.waysarr.add(bc.down);}
            if (bc.left>0){bc.waysarr.add(bc.left);}

            int randomNum = rand.nextInt(bc.waysarr.size());

            if (bc.waysarr.get(randomNum) == bc.up){
                bc.y_-=5;
                bc.way = 1;
            } else if (bc.waysarr.get(randomNum) == bc.right){
                bc.x_+=5;
                bc.way = 2;
            } else if (bc.waysarr.get(randomNum) == bc.down){
                bc.y_+=5;
                bc.way = 3;
            } else if (bc.waysarr.get(randomNum) == bc.left){
                bc.x_-=5;
                bc.way = 4;
            }


        }


        bc.up =new Integer(1);
        bc.left=new Integer(1);
        bc.down=new Integer(1);
        bc.right=new Integer(1);

    }
}