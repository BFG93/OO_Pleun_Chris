package qtrees;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class QTree {

    QTNode root;
    
    public QTree(Reader input) throws IOException {
        root = readQTree(input);
    }
    
    public QTree(Bitmap bitmap) {
        root = bitmap2QTree(0, 0, bitmap.getWidth(), bitmap);
    }
    
    public void fillBitmap(Bitmap bitmap) {
        root.fillBitmap(0, 0, bitmap.getWidth(), bitmap);
    }

    public void writeQTree(Writer sb) {
        root.writeNode(sb);
        System.out.println(sb);
    }

    private static QTNode readQTree(Reader input) throws IOException {
        char first = (char) input.read();
        return new GreyNode(input);

    }

    public static QTNode bitmap2QTree(int x, int y, int width, Bitmap bitmap) {
        int color = bitmap.checkQuadrant(x, y, width);
        if(color != 0) //black or white leaf
            return color == 1 ? new WhiteLeaf() : new BlackLeaf();
        //Else: GreyNode with 4 children
        GreyNode greyNode = new GreyNode();
        greyNode.setChild(0, bitmap2QTree(x,y,width/2,bitmap));
        greyNode.setChild(1, bitmap2QTree(x+width/2,y,width/2,bitmap));
        greyNode.setChild(2, bitmap2QTree(x+width/2,y+width/2,width/2,bitmap));
        greyNode.setChild(3, bitmap2QTree(x,y+width/2,width/2,bitmap));
        return greyNode;
    }

}
