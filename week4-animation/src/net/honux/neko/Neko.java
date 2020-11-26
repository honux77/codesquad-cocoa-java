package net.honux.neko;


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
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
        standing = readImage(25);
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
