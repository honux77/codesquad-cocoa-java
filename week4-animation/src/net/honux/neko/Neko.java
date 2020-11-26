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
    public static final int WAIT = 8;

    private Map<CatStatus, List<BufferedImage>> cats = new HashMap<>();
    private CatStatus status;
    private long lastFrame;
    private boolean noOp;


    public void setStatus(CatStatus status, long frame) {
        this.status = status;
        lastFrame = frame;
    }



    public void update(long frame) {
        System.out.println(status);
        if (status == CatStatus.SLEEPING && frame > lastFrame + cats.get(status).size()) {
            setStatus(CatStatus.SLEEP, frame);
        }

        if (status == CatStatus.WAKE_UP && frame > lastFrame + cats.get(status).size()) {
            setStatus(CatStatus.STAND, frame);
        }

        if (status == CatStatus.STAND && frame > lastFrame + WAIT) {
            setStatus(CatStatus.SLEEPING, frame);
        }
    }

    public Neko() {
        for (var s: CatStatus.values()) {
            cats.put(s, new ArrayList<>());
        }
        initStand();
        initSleeping();
        initSleep();
        initWakeUp();
    }

    private void initWakeUp() {
        int[] nums = {31, 32};
        addList(CatStatus.WAKE_UP, nums);
    }

    private void initSleep() {
        int[] nums = {29, 30};
        addList(CatStatus.SLEEP, nums);
    }

    private void initStand() {
        int[] nums = {25, 26, 27};
        addList(CatStatus.STAND, nums);
    }

    private void initSleeping() {
        int[] nums = {26, 27, 28};
        for (var i:nums) {
            cats.get(CatStatus.SLEEPING).add(readImage(i));
        }

    }

    private void addList(CatStatus status, int[] nums) {
        for (var i:nums) {
            cats.get(status).add(readImage(i));
        }
    }

    public BufferedImage getImage(long frame) {
        List<BufferedImage> catList = cats.get(status);
        if (catList.isEmpty()) return null;
        return catList.get((int)frame % catList.size());
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
