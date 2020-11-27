package net.honux.neko;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class Coin {

    List<BufferedImage> coins;

    public Coin() {
        coins = new ArrayList<>();

    }

    public BufferedImage getImage(long frame) {
        return coins.get((int) frame / MainWindow.DELAY % coins.size());
    }
}
