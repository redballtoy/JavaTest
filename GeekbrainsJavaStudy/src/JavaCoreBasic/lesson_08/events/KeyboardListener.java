package JavaCoreBasic.lesson_08.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KeyboardListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        System.out.println("Действие");

    }
}
