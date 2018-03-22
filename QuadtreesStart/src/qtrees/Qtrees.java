package qtrees;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;

public class Qtrees {

    public static void main(String[] args) throws IOException {
        String test_tekst = "10011010001010010001010101100011000101000000";
        StringReader input = new StringReader(test_tekst);
        QTree qt = new QTree( input );
        //StringWriter w = new StringWriter();
        //qt.writeQTree(w);
        //Bitmap bit = new Bitmap(8,8);
        //qt.fillBitmap(bit);
        //System.out.println(bit);
        
    }

}
