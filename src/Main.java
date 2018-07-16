import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main {
    public static void main(String[] args) {

        JPanel contentPanel = new JPanel(new BorderLayout());

        VisualComponent paintComponent = new VisualComponent();
        contentPanel.add(paintComponent, BorderLayout.CENTER);
        Controller2 controller2 = new Controller2(paintComponent);
        paintComponent.addKeyListener(controller2);

        JFrame frame = new JFrame("Paint Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(contentPanel);

        AddKeylistener.add(frame, paintComponent);

        frame.setBounds(0, 0, 615, 390);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}