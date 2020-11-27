package net.honux.neko;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;
import java.util.Map;

public abstract class GameObject {
    public Map<Integer, BufferedImage> images;
    public Map<String, List<BufferedImage>> statusImages;

    public GameObject(String Name) {
        loadAllImages(Name);
    }

    private void loadAllImages(String name) {
        final String path = "./resources/";
        String dir = path + getClass().getName() + "/";
        File f = new File(dir);
        System.out.println(f.isDirectory());
    }
}
