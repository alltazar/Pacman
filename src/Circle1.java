import java.awt.*;

public class Circle1{
    int x_;
    int y_;
    int r_;

    Color color_ = Color.yellow;

    Circle1(int x, int y, int r){x_=x;y_=y;r_=r;}

    void paint(Graphics g, Circle1 e){
        g.setColor(color_);
        g.fillOval(e.x_,e.y_,e.r_,e.r_);
    }
}