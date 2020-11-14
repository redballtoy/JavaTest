package JavaCoreAdvanced.lesson_01.fx_test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Test {


    private JButton createButton() {
        return new JButton() {
            private boolean flag;

            //Constructor for anon class
            {
                addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        flag = !flag;
                    }
                });
            }

            @Override
            public void paint(Graphics graphics) {
                super.paint(graphics);

                if (flag) {
                    graphics.drawOval(0, this.getHeight() / 4, getWidth(), getWidth());
                    graphics.setColor(Color.RED);
                    graphics.fillOval(0, this.getHeight() / 4, getWidth(), getWidth());
                }
                else {
                    Graphics2D g2d = (Graphics2D) graphics;
                    g2d.setStroke(new BasicStroke(10));
                    g2d.setColor(Color.BLUE);
                    g2d.drawLine(0, 0, this.getWidth(), this.getHeight());
                    g2d.drawLine(this.getWidth(), 0,  0, this.getHeight());
                }
            }
        };

    }
}
