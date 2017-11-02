
package cn.simple.test.jdkapi.awt;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.font.TextAttribute;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.AttributedCharacterIterator;
import java.text.AttributedString;
import java.util.stream.Collectors;

import javax.imageio.ImageIO;
import javax.swing.JLabel;

import lombok.extern.slf4j.Slf4j;

@Deprecated // 瀵煎嚭鍥剧墖鐨勬晥鏋滀笉濂�
@Slf4j
public class HtmlToImage {
    static String CSSCOLOR = "#bf8f79";
    static float  ALPHA	   = 0.4f;

    public static void main( String[] args ) throws IOException, URISyntaxException {
	URI uri = HtmlToImage.class.getResource( "test.html" ).toURI();
	String html = Files.readAllLines( Paths.get( uri ) ).stream().collect( Collectors.joining( "" ) );
	log.info( "uri: {}", uri );
	log.info( "html: {}", html );

	JLabel label = new JLabel( html );
	Dimension labelSize = label.getPreferredSize();

	int imgWidth = labelSize.width;
	log.info( "imgWidth : {}", imgWidth );
	imgWidth = imgWidth > 500 ? 500 : imgWidth;

	labelSize.width = imgWidth;

	label.setSize( labelSize );

	BufferedImage img = new BufferedImage( imgWidth, labelSize.height, BufferedImage.TYPE_INT_ARGB );
	Graphics2D g2d = img.createGraphics();
	label.printAll( g2d );

	{ // 璁剧疆姘村嵃
	    int width = img.getWidth( null );
	    int height = img.getHeight( null );
	    System.out.println( width + "\t" + height );

	    AttributedCharacterIterator iter = buildFont( "灏� fuck aa", "榛戜綋", 16 );
	    Color color = Color.decode( CSSCOLOR );
	    g2d.setColor( color );
	    // 璁剧疆姘村嵃鏃嬭浆
	    g2d.rotate( Math.toRadians( 45 ), (double) img.getWidth() / 2, (double) img.getHeight() / 2 );
	    g2d.setComposite( AlphaComposite.getInstance( AlphaComposite.SRC_ATOP, ALPHA ) );
	    g2d.drawString( iter, 10, height );
	}

	g2d.dispose();
	try {
	    ImageIO.write( img, "png", new File( "E:/Text.png" ) );
	} catch ( IOException ex ) {
	    ex.printStackTrace();
	}
    }

    // 褰㈡垚瀛椾綋灞炴��
    static AttributedCharacterIterator buildFont( String markContent, String fontType, int fontSize ) {
	AttributedString ats = new AttributedString( markContent );
	Font f = new Font( fontType, Font.PLAIN, fontSize );
	ats.addAttribute( TextAttribute.FONT, f, 0, markContent.length() );
	AttributedCharacterIterator iter = ats.getIterator();
	return iter;
    }

}
