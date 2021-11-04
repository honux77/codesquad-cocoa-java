package net.honux.week4;

import java.awt.*;
import java.awt.event.*;

public class MainApp extends Frame {

    private Button b;
    public MainApp() {
        initUI();
        addButton();
        addEvent();
    }

    private void addButton() {
        b = new Button("Click me if you can");
        b.setSize(100, 30);
        b.setLocation(this.getWidth() / 2, this.getHeight() / 2);
        add(b);
    }

    private void initUI() {
        setTitle("Week4 App");
        setSize(640, 480);
    }

    private void addEvent() {
        //TODO: make a close button work
        System.out.println("Add Event Listener");
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                setVisible(false);
                System.out.println("닫힘 버튼 이벤트 발생");
                dispose();
                System.exit(0);
            }
        });

        b.addActionListener((ActionEvent e) -> {
            System.out.println(e.getActionCommand());
        });
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            Frame f = new MainApp();
            f.setVisible(true);
        });
    }
}
