package net.honux.neko;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Neko {

    private List<BufferedImage> cats;

    public Neko() {
        loadImage();
    }

    /**
     *
     * @param idx 이미지 번호
     * @return 고양이 이미
     */
    public BufferedImage getImage(long frame) {
        return cats.get((int)frame % cats.size());
    }

    private void loadImage() {
        cats = new ArrayList<>();
        int[] nums = {25, 26, 27, 28, 29, 30, 31, 32};
        for (var i : nums) {
            cats.add(getNekoImage(i));
        }
    }

    private BufferedImage getNekoImage(int i) {
        String path = "./resources/neko/";
        String ext = ".GIF";
        File f = new File(path + i + ext);
        System.out.println(f.getPath() + ":" + f.exists());
        try {
            return ImageIO.read(f);
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(new JFrame(), "Neko load error: " + e.getMessage(),
                    "Neko error", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
            return null;
        }
    }
}
