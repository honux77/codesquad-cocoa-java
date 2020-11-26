package net.honux.neko;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GameWindow extends JFrame {

    private BufferedImage background;

    public GameWindow() {
        loadImage("./resources/bg.png");
        init();
    }

    private void loadImage(String path) {
        try {
            File f = new File("./");
            System.out.println(f.getAbsolutePath());
            background = ImageIO.read(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(new JFrame(),
                    "BG loading error: " + e.getMessage(),
                    "Loading Error", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
    }

    private void init() {
        setTitle("Neko Game");
        setSize(background.getWidth(), background.getHeight());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(background, 0, 0, this);
    }

    public static void main(String[] args) {
        JFrame frame = new GameWindow();
        frame.setVisible(true);
    }
}
