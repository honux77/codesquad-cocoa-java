package net.honux.neko;

import com.sun.tools.javac.Main;

public class Neko extends GameObject {

    public Neko(MainWindow window, int delay) {
        super(window, delay);
        setStatus(CatStatus.STAND.toString());
    }

    //Neko class test
    public static void main(String[] args) {
        Neko neko = new Neko(null, 3);
        for (int i = 0; i < 30; i++) {
            System.out.println(neko.getImage(i));
        }
    }

    @Override
    public void addStatusForImages() {
        for(var status: CatStatus.values()) {
            addStatus(status.toString());
        }
    }

    @Override
    public void addStatusImages() {
        setStatusImages("STAND", 25, 26, 27, 28, 27);
    }

    @Override
    public void update(int frame) {
        System.out.println(status);
    }
}
