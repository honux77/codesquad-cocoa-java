package net.honux.neko;

import javax.swing.*;
import java.awt.image.BufferedImage;

public class MainWindow extends JFrame {

    private final String TITLE = "Neko App";
    private final int W = 320;
    private final int H = 540;

    private BufferedImage background;
    /**
     * TODO:
     * 1 - initApp
     * 2 - Add Background
     *
     */
    public MainWindow() {
        initUI();
    }

    private void initUI() {
        setTitle(TITLE);
        setSize(W, H);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    public static void main(String[] args) {
        JFrame mainWindow = new MainWindow();
    }
}
