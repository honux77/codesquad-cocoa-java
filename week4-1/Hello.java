import java.awt.*;
import java.awt.event.*;

public class Hello {

    public void clickHandler(ActionEvent e) {
        System.out.println("event: " + e.getActionCommand());
    }
    public static void main(String[] args) {
        Frame f = new Frame("Login");
        f.setSize(300, 200);
        f.setLayout(null);

        Button b = new Button("Jung");
        
        ButtonClickListener bcl = new ButtonClickListener();
        b.addActionListener(bcl);

        b.setSize(100, 30);
        b.setLocation(100, 50);

        f.add(b);
        f.setVisible(true);

    }
}

