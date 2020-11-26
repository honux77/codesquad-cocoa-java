package net.honux.neko;


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Neko {
    private List<BufferedImage> sleep;
    private List<BufferedImage> left;
    private List<BufferedImage> right;
    private List<BufferedImage> up;
    private List<BufferedImage> down;

    public BufferedImage getStanding() {
        return standing;
    }

    private BufferedImage standing;


    public Neko() {
        //init staind
        standing = readImage(25);
        //init sleep
        initSleep();
    }

    private void initSleep() {
        sleep = new LinkedList<>();
        int start = 26;
        int end = 32;
        int frame = 20;
        for (int i = start; i <= end; i++) {
            sleep.add(readImage(i));
            frame += 20;
        }
    }

    public BufferedImage getSleepImage(long frame) {
        return getImage(frame, sleep);
    }

    private BufferedImage getImage(long frame, List<BufferedImage> cats) {
        return cats.get((int) frame % cats.size());
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
