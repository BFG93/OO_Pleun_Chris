/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qtrees;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Christian Lammers s4578236
 * @author Pleun Scholten s4822250
 */
public class GreyNode implements QTNode {

    private QTNode[] children;
    private char c;

    public GreyNode() {
        children = new QTNode[4];
    }

    GreyNode(Reader input) throws IOException {
        children = new QTNode[4];

        for (int i = 0; i < children.length; i++) {
            children[i] = makeChildren(input);

        }
    }
    
    public void setChild(int index, QTNode node) {
        children[index] = node;
    }

    @Override
    public void fillBitmap(int x, int y, int width, Bitmap bitmap) {
       children[0].fillBitmap(x, y, width/2, bitmap);
       children[1].fillBitmap(x+width/2, y, width/2, bitmap);
       children[2].fillBitmap(x+width/2, y+width/2, width/2, bitmap);
       children[3].fillBitmap(x, y+width/2, width/2, bitmap);
    }

    @Override
    public void writeNode(Writer out) {
        try {
            out.write('1');
        } catch (IOException ex) {
            Logger.getLogger(GreyNode.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (QTNode child: children) {
            child.writeNode(out);
            
        }
    }

    private QTNode makeChildren(Reader input) throws IOException {
        c = (char) input.read();
        if (Character.getNumericValue(c) == -1) {
            System.out.println("Done reading");
        } else if (c == '1') {
            return new GreyNode(input);
        } else if ((char) input.read() == '0') {
            return new BlackLeaf();
        } else {
            return new WhiteLeaf();
        }
        return null;
    }
}
