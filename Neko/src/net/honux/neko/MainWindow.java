package net.honux.neko;

import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame implements Runnable {

    private final String TITLE = "Neko App";
    public final static int SCALE = 2;
    public static final int GAP = 1000 / 60;
    public static final int DELAY = 60 / 2;

    private Neko neko;
    private List<Coin> coins = new ArrayList<>();
    private int frame = 0;
    private Thread thread;
    private Input input;
    private Renderer renderer;

    public MainWindow() {
        initObjects();
        initComponent();
        initUI();
        initOthers();
    }

    public Input getInput() {
        return input;
    }

    public List<Coin> getCoins() {
        return coins;
    }

    private void initComponent() {
        renderer = new Renderer(this);
        input = new Input(this);

    }

    private void initOthers() {
        thread = new Thread(this);
    }

    private void initObjects() {
        neko = new Neko(this, DELAY);
    }

    private void initUI() {
        setTitle(TITLE);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        add(renderer, BorderLayout.CENTER);
        setSize(renderer.getSize());
        addMouseListener(input);
        addMouseMotionListener(input);
        setLocationRelativeTo(null);
        setResizable(false);
        neko.setPosition(getWidth() / 2, getHeight() / 2);

    }

    public Neko getNeko() {
        return neko;
    }

    public void start() {
        thread.start();
    }

    public int getFrame() {
        return frame;
    }

    public void update() {
        renderer.update();
    }

    private void render() {
        renderer.render();
    }

    public static void main(String[] args) {
        MainWindow mainWindow = new MainWindow();
        mainWindow.setVisible(true);
        mainWindow.start();
    }

    @Override
    public void run() {
        boolean running = true;
        while (running) {
            try {
                Thread.sleep(GAP);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            frame++;
            update();
            render();
        }
    }

    public void addCoin(int x, int y) {
        coins.add(new Coin(this, x, y));
    }
}
