import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;

public class VisualComponent  extends JComponent implements ActionListener {
    boolean winner = false;
    boolean looser = false;

    java.util.List<DataModel> allModels;
    HashSet<EatModel> eatModels;
    Circle1 c1;
    BadCircle bc1;
    BadCircle bc2;

    VisualComponent(){
        allModels = new ArrayList<>();
        allModels.add(new DataModel(50,50,250,50));
        allModels.add(new DataModel(350,50,200,50));
        allModels.add(new DataModel(50,250,250,50));
        allModels.add(new DataModel(350,250,200,50));
        allModels.add(new DataModel(50,150,250,50));
        allModels.add(new DataModel(350,150,200,50));

        eatModels = new HashSet<>();
        eatModels.add(new EatModel(122,22,5,5));
        eatModels.add(new EatModel(172,22,5,5));
        eatModels.add(new EatModel(222,22,5,5));
        eatModels.add(new EatModel(72,22,5,5));
        eatModels.add(new EatModel(272,22,5,5));
        eatModels.add(new EatModel(322,22,5,5));
        eatModels.add(new EatModel(372,22,5,5));
        eatModels.add(new EatModel(422,22,5,5));
        eatModels.add(new EatModel(472,22,5,5));
        eatModels.add(new EatModel(522,22,5,5));
        eatModels.add(new EatModel(122,122,5,5));
        eatModels.add(new EatModel(172,122,5,5));
        eatModels.add(new EatModel(222,122,5,5));
        eatModels.add(new EatModel(72,122,5,5));
        eatModels.add(new EatModel(272,122,5,5));
        eatModels.add(new EatModel(322,122,5,5));
        eatModels.add(new EatModel(372,122,5,5));
        eatModels.add(new EatModel(422,122,5,5));
        eatModels.add(new EatModel(472,122,5,5));
        eatModels.add(new EatModel(522,122,5,5));
        eatModels.add(new EatModel(122,222,5,5));
        eatModels.add(new EatModel(172,222,5,5));
        eatModels.add(new EatModel(222,222,5,5));
        eatModels.add(new EatModel(72,222,5,5));
        eatModels.add(new EatModel(272,222,5,5));
        eatModels.add(new EatModel(322,222,5,5));
        eatModels.add(new EatModel(372,222,5,5));
        eatModels.add(new EatModel(422,222,5,5));
        eatModels.add(new EatModel(472,222,5,5));
        eatModels.add(new EatModel(522,222,5,5));
        eatModels.add(new EatModel(122,322,5,5));
        eatModels.add(new EatModel(172,322,5,5));
        eatModels.add(new EatModel(222,322,5,5));
        eatModels.add(new EatModel(72,322,5,5));
        eatModels.add(new EatModel(272,322,5,5));
        eatModels.add(new EatModel(322,322,5,5));
        eatModels.add(new EatModel(372,322,5,5));
        eatModels.add(new EatModel(422,322,5,5));
        eatModels.add(new EatModel(472,322,5,5));
        eatModels.add(new EatModel(522,322,5,5));

        c1 = new Circle1(1,1,48);

        bc1 = new BadCircle(551,1,48);

        bc2 = new BadCircle(551,251,48);

        timer.start();

    }

    Timer timer = new Timer(100, this);

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==timer){
            bc1.move(bc1,this);

            bc2.move(bc2,this);
            repaint();
        }
    }

    public void paint(Graphics g){

        g.setColor(Color.WHITE);
        g.fillRect(0,0,600,350);
        g.setColor(Color.blue);

        for (DataModel dm : allModels){
            g.setColor(dm.color_);
            g.fillRect(dm.x_,dm.y_,dm.w_,dm.h_);
        }

        c1.paint(g,c1);

        bc1.paint(g,bc1);
        bc2.paint(g,bc2);

        for (EatModel em : eatModels){
            em.paint(g,em);
        }

        if (winner){
            g.setColor(Color.WHITE);
            g.fillRect(0,0,600,350);
        }

        if (looser){
            g.setColor(Color.BLACK);
            g.fillRect(0,0,600,350);
        }
    }
}
