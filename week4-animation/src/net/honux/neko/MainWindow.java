package net.honux.neko;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MainWindow extends JFrame implements Runnable {

    private final String TITLE = "Neko App";
    private final int SCALE = 2;
    private final int GAP = 1000 / 4;

    private BufferedImage background;
    private Neko neko;
    private Thread thread;
    private long frame  = 0;

    /**
     * TODO:
     * 1 - initApp
     * 2 - Add Background
     * 3 - fix hard coded size
     * 4 - add Mouse Event
     */
    public MainWindow() {
        initUI();
        initNeko();
        initOthers();

    }

    private void initOthers() {
        thread = new Thread(this);
    }

    private void initNeko() {
        neko = new Neko();
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
        g.drawImage(background, 0, 0, this);
        int x = getWidth() / 2;
        int y = getHeight() / 2;
        int w = Neko.W;
        int h = Neko.H;

        neko.setStatus(CatStatus.SLEEPING);
        g.drawImage(neko.getImage(frame), x, y, x + w * 2, y + h * 2, 0, 0, w, h, this);
    }

    public void start() {
        thread.run();
    }

    public static void main(String[] args) {
        MainWindow mainWindow = new MainWindow();
        mainWindow.setVisible(true);
        mainWindow.start();
    }



    @Override
    public void run() {
        while (true) {
            frame++;
            try {
                Thread.sleep(GAP);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            repaint();
            System.out.println(frame);
        }
    }
}
