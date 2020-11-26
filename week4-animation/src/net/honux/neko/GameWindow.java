package net.honux.neko;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GameWindow extends JFrame implements Runnable{

    private BufferedImage background;
    private Neko neko;
    private final int GAP = 1000 / 4;
    private long frame = 0;
    private Thread thread;
    private Input input;
    private int scale = 3;

    public GameWindow() {
        loadImage("./resources/bg.png");
        init();
        initNeko();
        thread = new Thread(this);
        addEvent();
    }

    private void addEvent() {
        input = new Input();
        addMouseListener(input);
        addMouseMotionListener(input);

    }

    private void initNeko() {
        neko = new Neko();
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
        //g.drawImage(neko.getImage((int)frame), input.getX(), input.getY(), this);
        BufferedImage c = neko.getImage(frame);
        g.drawImage(c,
                input.getX(), input.getY(), input.getX() + c.getWidth() * scale, input.getY() + c.getHeight() * scale,
                0, 0, c.getWidth(), c.getHeight(), this);
    }

    public static void main(String[] args) {
        GameWindow frame = new GameWindow();
        frame.setVisible(true);
        frame.start();
        System.out.println("Main Thread");
    }

    public void start() {
        thread.start();
    }
    @Override
    public void run() {
        while(true) {
            update();
            try {
                Thread.sleep(GAP);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    private void update() {
        frame++;
        System.out.println(frame);
        repaint();
    }
}
