package net.honux.neko;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame implements Runnable {

    private final String TITLE = "Neko App";
    private final int SCALE = 2;
    public static final int GAP = 1000 / 60;
    public static final int DELAY = 60 / 2;

    private Neko neko;
    private int frame = 0;
    private Thread thread;
    private Input input;
    private Renderer renderer;

    public MainWindow() {
        initNeko();
        initComponent();
        initUI();
        initOthers();
    }

    public Input getInput() {
        return input;
    }

    private void initComponent() {
        renderer = new Renderer(this);
        input = new Input(this);

    }

    private void initOthers() {
        thread = new Thread(this);
    }

    private void initNeko() {
        neko = new Neko(this, DELAY);
    }

    private void initUI() {
        setTitle(TITLE);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());
        add(renderer, BorderLayout.CENTER);
        setSize(renderer.getSize());
        addMouseListener(input);
        addMouseMotionListener(input);
        setLocationRelativeTo(null);
        setResizable(false);

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
}
