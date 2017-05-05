package cn.simple.test.jdkapi.awt;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.font.TextAttribute;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.AttributedCharacterIterator;
import java.text.AttributedString;

import javax.imageio.ImageIO;
import javax.swing.JEditorPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class HtmlToImageUtil {

    static String CSSCOLOR = "#bf8f79";
    static float  ALPHA	   = 0.4f;

    public static InputStream toStream( String html ) throws IOException {
	JEditorPane ed = new JEditorPane( "text/html", html );
	ed.setSize( 200, 200 );

	BufferedImage image = new BufferedImage( ed.getWidth(), ed.getHeight(), BufferedImage.TYPE_INT_ARGB );

	Graphics2D g2d = image.createGraphics();

	SwingUtilities.paintComponent( g2d, ed, new JPanel(), 0, 0, image.getWidth(), image.getHeight() );

	{ // 设置水印

	    int width = image.getWidth( null );
	    int height = image.getHeight( null );
	    System.out.println( width + "\t" + height );

	    AttributedCharacterIterator iter = buildFont( "小 fuck aa", "黑体", 16 );
	    Color color = Color.decode( CSSCOLOR );
	    g2d.setColor( color );
	    // 设置水印旋转
	    g2d.rotate( Math.toRadians( 45 ), (double) image.getWidth() / 2, (double) image.getHeight() / 2 );
	    g2d.setComposite( AlphaComposite.getInstance( AlphaComposite.SRC_ATOP, ALPHA ) );
	    g2d.drawString( iter, 50, height );

	    g2d.dispose();
	}

	ByteArrayOutputStream os = new ByteArrayOutputStream();
	ImageIO.write( image, "png", os );
	InputStream is = new ByteArrayInputStream( os.toByteArray() );

	return is;
    }

    // 形成字体属性
    static AttributedCharacterIterator buildFont( String markContent, String fontType, int fontSize ) {
	AttributedString ats = new AttributedString( markContent );
	Font f = new Font( fontType, Font.PLAIN, fontSize );
	ats.addAttribute( TextAttribute.FONT, f, 0, markContent.length() );
	AttributedCharacterIterator iter = ats.getIterator();
	return iter;
    }

}
