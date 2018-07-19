import java.awt.*;

public class EatModel{
    private int x_;
    private int y_;
    private int w_;
    private int h_;

    private Color color_ = Color.blue;

    EatModel(int x, int y, int w, int h){x_=x;y_=y;w_=w;h_=h;}

    void paint(Graphics g){
        g.setColor(color_);
        g.fillOval(x_,y_,w_,h_);
    }

    int getX_(){
        return x_;
    }
    int getY_(){
        return y_;
    }
    int getW_(){
        return w_;
    }
    int getH_(){
        return h_;
    }
}