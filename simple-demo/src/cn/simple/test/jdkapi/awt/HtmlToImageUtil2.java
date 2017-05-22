package cn.simple.test.jdkapi.awt;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.font.FontRenderContext;
import java.awt.font.LineBreakMeasurer;
import java.awt.font.TextAttribute;
import java.awt.font.TextLayout;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.text.AttributedCharacterIterator;
import java.text.AttributedString;

import javax.swing.JEditorPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import lombok.extern.slf4j.Slf4j;

@Deprecated
@Slf4j
public class HtmlToImageUtil2 {

    static String CSSCOLOR = "#bf8f79";
    static float  ALPHA	   = 0.4f;

    public static BufferedImage toImage( String html ) throws IOException {
	JEditorPane ed = new JEditorPane( "text/html", html );
	ed.setSize( 1000, 1000 );

	Dimension prefSize = ed.getPreferredSize();
	log.info( "size: {}", prefSize );
	BufferedImage image = new BufferedImage( prefSize.width, prefSize.height, BufferedImage.TYPE_INT_ARGB );

	Graphics2D g2d = image.createGraphics();

	SwingUtilities.paintComponent( g2d, ed, new JPanel(), 0, 0, image.getWidth(), image.getHeight() );

	{ // 设置水印

	    g2d.setColor( Color.decode( CSSCOLOR ) );
	    g2d.setComposite( AlphaComposite.getInstance( AlphaComposite.SRC_ATOP, ALPHA ) );

	    int angle = 12;
	    double radian = Math.toRadians( angle );
	    double tan = Math.tan( radian );
	    g2d.rotate( radian, 0, 0 ); // 设置水印旋转

	    AttributedCharacterIterator iter = buildFont( "猎萌 HUNTERPLUS", "微软雅黑", 30 );

	    { // 计算水印字体宽，高
		FontRenderContext fontRenderContext = g2d.getFontRenderContext();
		LineBreakMeasurer lbm = new LineBreakMeasurer( iter, fontRenderContext );
		TextLayout textLayout = lbm.nextLayout( Integer.MAX_VALUE );
		Rectangle2D bound = textLayout.getBounds();
		double fontWidth = bound.getWidth();
		double fontHeight = bound.getHeight();
		log.info( "fontWidth: {}, fontHeight: {}", fontWidth, fontHeight );
	    }

	    for ( int i = 0; i < 3; i++ ) {
		for ( int j = 0; j < 10; j++ ) {
		    int x = 50 + i * 400;
		    int y = 50 + j * 100;
		    int actualY = (int) ( y - x * tan );
		    g2d.drawString( iter, x, actualY );
		}
	    }

	    g2d.dispose();
	}

	return image;
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
