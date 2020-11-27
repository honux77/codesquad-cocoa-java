package net.honux.neko;


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Neko {
    public static final int W = 32;
    public static final int H = 32;
    public static final int WAIT = 120;
    private static final int DELAY = 60 / 2;

    private double dx = 1.0f;
    private double dy = 1.0f;
    private int x;
    private int y;

    private Map<CatStatus, List<BufferedImage>> cats = new HashMap<>();
    private CatStatus status;
    private long lastFrame;
    private MainWindow window;

    public void setStatus(CatStatus status, long frame) {
        this.status = status;
        lastFrame = frame;
    }


    public Neko(MainWindow window) {
        for (var s : CatStatus.values()) {
            cats.put(s, new ArrayList<>());
        }
        initStand();
        initSleeping();
        initSleep();
        initWakeUp();
        setStatus(CatStatus.STAND, 0);
        this.window = window;
    }

    public void update(long frame) {

        if (x == window.getInput().getMouseX() && y == window.getInput().getMouseY()) {
            status = CatStatus.SLEEP;
        }
            if (status == CatStatus.SLEEP && frame > lastFrame + cats.get(status).size() * DELAY) {
                setStatus(CatStatus.SLEEPING, frame);
            }

        if (status == CatStatus.WAKE_UP && frame > lastFrame + cats.get(status).size() * DELAY) {
            setStatus(CatStatus.STAND, frame);
        }

        if (status == CatStatus.STAND && frame > lastFrame + WAIT) {
            setStatus(CatStatus.SLEEP, frame);
        }
    }

    private void initWakeUp() {
        int[] nums = {31, 31, 32, 32};
        addList(CatStatus.WAKE_UP, nums);
    }

    private void initSleep() {
        int[] nums = {29, 30};
        addList(CatStatus.SLEEP, nums);
    }

    private void initStand() {
        int[] nums = {25, 26, 27, 28, 27, 26};
        addList(CatStatus.STAND, nums);
    }

    private void initSleeping() {
        int[] nums = {26, 27, 28};
        for (var i : nums) {
            cats.get(CatStatus.SLEEPING).add(readImage(i));
        }
    }

    private void addList(CatStatus status, int[] nums) {
        for (var i : nums) {
            cats.get(status).add(readImage(i));
        }
    }

    public BufferedImage getImage(long frame) {
        List<BufferedImage> catList = cats.get(status);
        if (catList.isEmpty()) return null;
        return catList.get((int) frame / DELAY % catList.size());
    }

    private BufferedImage readImage(int num) {
        final String ext = ".GIF";
        final String path = "./resources/neko/";
        String fname = path + num + ext;
        try {
            return ImageIO.read(new File(fname));
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(new JFrame(), "Can't load " + fname + ": " + e.getMessage(),
                    "Cat Loading Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

}
