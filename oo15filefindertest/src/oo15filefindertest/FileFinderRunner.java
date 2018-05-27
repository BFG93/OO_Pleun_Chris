/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oo15filefindertest;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author christianlammers
 */
public class FileFinderRunner implements Runnable {

    private File file;
    private String fileName;
    FileFinder ff;
    public FileFinderRunner(File file, String fileName) throws IOException{
        this.file = file;
        this.fileName = fileName;
        this.ff = new FileFinder(file.toString());
        
        
    }
    @Override
    public void run() {
        try {
            ff.findFile(fileName);
        } catch (IOException ex) {
            Logger.getLogger(FileFinderRunner.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
