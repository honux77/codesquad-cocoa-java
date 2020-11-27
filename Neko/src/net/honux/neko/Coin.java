package net.honux.neko;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class Coin extends GameObject{

    private final String NORMAL = "NORMAL";
    public Coin(MainWindow w, int x, int y) {
        super(w, w.DELAY);
        status=NORMAL;
        setPosition(x, y);
    }
    @Override
    public void addStatusForImages() {
        addStatus(NORMAL);
    }

    @Override
    public void addStatusImages() {
        setStatusImages(NORMAL, 1, 2, 3, 4);
    }

    @Override
    public void update(int frame) {
    }
}
