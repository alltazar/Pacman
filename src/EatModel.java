import java.awt.*;

public class EatModel{
    int x_;
    int y_;
    int w_;
    int h_;

    Color color_ = Color.blue;

    EatModel(int x, int y, int w, int h){x_=x;y_=y;w_=w;h_=h;}

    void paint(Graphics g, EatModel e){
        g.setColor(color_);
        g.fillOval(e.x_,e.y_,e.w_,e.h_);
    }
}