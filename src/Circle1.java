import java.awt.*;

public class Circle1{
    private int x_;
    private int y_;
    private int r_;

    private Color color_ = Color.yellow;

    Circle1(int x, int y, int r){x_=x;y_=y;r_=r;}

    void paint(Graphics g){
        g.setColor(color_);
        g.fillOval(x_,y_,r_,r_);
    }

    int getX_(){
        return x_;
    }
    int getY_(){
        return y_;
    }
    int getR_(){
        return r_;
    }

    void speedX(int a){
        x_ +=a;
    }
    void speedY(int a){
        y_ +=a;
    }
}