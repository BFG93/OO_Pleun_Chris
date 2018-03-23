package qtrees;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;

public class Qtrees {

    public static void main(String[] args) {
        try {
            String test_tekst = "10011010001010010001010101100011000101000000";
            StringReader input = new StringReader(test_tekst);
            QTree qt = new QTree(input); // makes QTree from binary code
            StringWriter w = new StringWriter();
            qt.writeQTree(w); // makes binary code from Qtree
            Bitmap bit = new Bitmap(8, 8);
            qt.fillBitmap(bit); //makes bitmap from QTree
            System.out.println("\n"+bit);
            QTree qt2 = new QTree(bit); // makes QTree from bitmap
            StringWriter w2 = new StringWriter();
            qt2.writeQTree(w2); // writes the binary code from the new QTree, to check if the two codes are the same.
        } catch (IOException e) {
            System.out.println(e);
        }
    }

}
