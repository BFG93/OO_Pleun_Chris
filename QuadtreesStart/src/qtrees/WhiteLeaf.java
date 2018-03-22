/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qtrees;

import java.io.IOException;
import java.io.Writer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Christian Lammers s4578236
 * @author Pleun Scholten s
 */

public class WhiteLeaf implements QTNode {

    @Override
    public void fillBitmap(int x, int y, int width, Bitmap bitmap) {
        bitmap.fillArea(x, y, width, true);
    }

    @Override
    public void writeNode(Writer out) {
        try {
            out.write('0');
            out.write('1');
        } catch (IOException ex) {
            Logger.getLogger(WhiteLeaf.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
