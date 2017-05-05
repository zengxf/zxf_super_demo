package cn.simple.test.jdkapi.awt;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.font.TextAttribute;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.AttributedCharacterIterator;
import java.text.AttributedString;
import java.util.stream.Collectors;

import javax.imageio.ImageIO;
import javax.swing.JEditorPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HtmlToImage2 {

    static String CSSCOLOR = "#bf8f79";
    static float  ALPHA	   = 0.4f;

    static void generateOutput() throws Exception {

	URI uri = HtmlToImage2.class.getResource( "test.html" ).toURI();
	String html = Files.readAllLines( Paths.get( uri ) ).stream().collect( Collectors.joining( "" ) );
	log.info( "uri: {}", uri );
	log.info( "html: {}", html );

	JEditorPane ed = new JEditorPane( "text/html", html );
	ed.setSize( 200, 200 );

	// create a new image
	BufferedImage image = new BufferedImage( ed.getWidth(), ed.getHeight(), BufferedImage.TYPE_INT_ARGB );

	Graphics2D g2d = image.createGraphics();

	// paint the editor onto the image
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

	// save the image to file
	ImageIO.write( image, "png", new File( "E:/html.png" ) );
	
	ByteArrayOutputStream os = new ByteArrayOutputStream();
	ImageIO.write(image, "gif", os);
	InputStream is = new ByteArrayInputStream(os.toByteArray());
	System.out.println( is.available() );
    }

    // 形成字体属性
    static AttributedCharacterIterator buildFont( String markContent, String fontType, int fontSize ) {
	AttributedString ats = new AttributedString( markContent );
	Font f = new Font( fontType, Font.PLAIN, fontSize );
	ats.addAttribute( TextAttribute.FONT, f, 0, markContent.length() );
	AttributedCharacterIterator iter = ats.getIterator();
	return iter;
    }

    public static void main( String[] args ) {
	try {
	    generateOutput();
	} catch ( Exception e ) {
	    e.printStackTrace();
	}
    }

}
