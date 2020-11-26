package net.honux.neko;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MainWindow extends JFrame {

    private final String TITLE = "Neko App";

    private BufferedImage background;
    /**
     * TODO:
     * 1 - initApp
     * 2 - Add Background
     * 3 - fix hard coded size
     * 4 - add Mouse Event
     *
     */
    public MainWindow() {
        initUI();
    }

    private void initUI() {
        setTitle(TITLE);
        addBackground();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    private void addBackground() {
        try {
            background = ImageIO.read(new File("./resources/bg.png"));
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(new JFrame(), "BG loading error: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
        setSize(background.getWidth(), background.getHeight());
    }

    @Override
    public void paint(Graphics g) {
       g.drawImage(background,0, 0, this);
    }

    public static void main(String[] args) {
        JFrame mainWindow = new MainWindow();
        mainWindow.setVisible(true);
    }
}
