package oo15filefindertest;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author pieterkoopman
 */
public class FileFinder {

    private final File rootDir;

    public FileFinder(String root) throws IOException {
        rootDir = new File(root);
        if (!(rootDir.exists() && rootDir.isDirectory())) {
            throw new IOException(root + " is not a directory");
        }
    }

    public void findFile(String file) throws IOException {
        find(rootDir, file);
    }

    private void find(File rootDir, String fileName) throws IOException {
        File[] files = rootDir.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.getName().equals(fileName)) {
                    System.out.println("Found at: " + file.getAbsolutePath());
                    System.exit(0);
                    return;
                } else if (file.isDirectory()) {
                    FileFinderRunner r =  new FileFinderRunner(file, fileName);
                    Thread t = new Thread(r);
                    t.start();
                }
            }
        }
    }

}
