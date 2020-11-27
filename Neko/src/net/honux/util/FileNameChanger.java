package net.honux.util;

import java.io.File;
import java.io.IOException;

public class FileNameChanger {

    public static void fileNameChange(String srcPath, String targetName, String ext) throws IOException {
        String path = "./resources/" + srcPath + "/";
        File f = new File(path);
        String[] files = f.list();
        for (var file: files) {
            System.out.println(file);
            File inner = new File(path + file);
            File rename = new File(path + targetName + "-" + file.split("\\.")[0] + "." + ext);
            boolean ret = inner.renameTo(rename);
            if (!ret) throw new IOException("Rename Error: " + rename);
        }
    }
    public static void main(String[] args) throws IOException {
        fileNameChange("neko", "neko", "gif");
    }
}
