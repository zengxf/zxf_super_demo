package cn.simple.test.jdkapi.awt;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.font.TextAttribute;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.AttributedCharacterIterator;
import java.text.AttributedString;

import javax.imageio.ImageIO;

public class CreateImage1 {

    static int	  width	   = 1200;
    static int	  height   = 400;
    static String CSSCOLOR = "#666666";
    static float  ALPHA	   = 1.0f;
    static Color  BG_COLOR = new Color( 255, 255, 255 );

    public static void main( String[] args ) {

	BufferedImage img = new BufferedImage( width, height, BufferedImage.TYPE_INT_ARGB );
	Graphics2D g2d = img.createGraphics();

	g2d.setBackground( BG_COLOR ); // ���ñ���ɫ
	g2d.clearRect( 0, 0, width, height ); // �ñ���ɫ������������ָ���ľ���

	String content = "2017��5��12��  ������";
	String[] fonts = { "������ͤ�ڼ���", "FZLanTingHeiS-R-GB", "΢���ź�", "����", "�����������" //
	        , "Liberation Mono", "�����ּ�-���������" };

	for ( int i = 0; i < fonts.length; i++ ) {
	    AttributedCharacterIterator iter = buildFont( content + "     ���� " + fonts[i], fonts[i], 36 );
	    Color color = Color.decode( CSSCOLOR );
	    g2d.setColor( color );
	    g2d.setComposite( AlphaComposite.getInstance( AlphaComposite.SRC_ATOP, ALPHA ) );
	    g2d.drawString( iter, 10, 50 + i * 50 );
	}

	g2d.dispose();
	try {
	    String saveFile;
	    if ( System.getProperty( "os.name" ).startsWith( "Windows" ) ) {
		saveFile = "C:\\Users\\Administrator\\Desktop/test-1.png";
	    } else {
		saveFile = HtmlToImage4.class.getResource( "" ).getPath() + "test-linux-1.png";
	    }
	    ImageIO.write( img, "png", new File( saveFile ) );
	    System.out.println( "OK !!!" );
	} catch ( IOException ex ) {
	    ex.printStackTrace();
	}
    }

    // �γ���������
    static AttributedCharacterIterator buildFont( String markContent, String fontType, int fontSize ) {
	AttributedString ats = new AttributedString( markContent );
	Font f = new Font( fontType, Font.PLAIN, fontSize );
	ats.addAttribute( TextAttribute.FONT, f, 0, markContent.length() );
	AttributedCharacterIterator iter = ats.getIterator();
	return iter;
    }
}
