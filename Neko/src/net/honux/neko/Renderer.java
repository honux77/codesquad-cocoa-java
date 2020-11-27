package net.honux.neko;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Renderer extends JPanel {

    private MainWindow window;
    private BufferedImage background;
    private long frame = 0;

    public Renderer(MainWindow window) {
        this.window = window;
        setupBackGround();
    }

    //Load bg image and setup panel
    private void setupBackGround() {
        try {
            background = ImageIO.read(new File("./resources/bg.png"));
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(new JFrame(), "BG loading error: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
        setDoubleBuffered(true);
        setSize(background.getWidth(), background.getHeight());
    }

    @Override
    public void paintComponents(Graphics g) {
        if (g == null) return;

        Neko neko = window.getNeko();
        g.drawImage(background, 0, 0, window);

        int w = neko.getW();
        int h = neko.getH();
        int x = neko.getX();
        int y= neko.getY();
        g.drawImage(neko.getImage(window.getFrame()), x, y, x + w * 2, y + h * 2, 0, 0, w, h, this);
    }

    public void update() {
        System.out.println(window.getFrame());
        Neko neko = window.getNeko();
        neko.update(window.getFrame());
    }

    public void render() {
        paintComponents(this.getGraphics());
    }
}
