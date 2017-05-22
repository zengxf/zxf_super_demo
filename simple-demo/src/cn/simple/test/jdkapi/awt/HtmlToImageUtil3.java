package cn.simple.test.jdkapi.awt;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JEditorPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import lombok.extern.slf4j.Slf4j;

/**
 * HTML 转换成图片的帮助类
 * <p>
 * Created by zxf on 2017-05-11
 */
@Slf4j
@Deprecated
public class HtmlToImageUtil3 {

    private final static Color BG_COLOR = new Color( 255, 255, 255 );

    /**
     * 转换成图片
     * 
     * @param html
     * @param headImagePath
     * @param paperImagePath
     * @return
     * @throws IOException
     */
    public static BufferedImage toImage( String html, String headImagePath, String paperImagePath ) throws IOException {
	File headFile = new File( headImagePath );
	Image headImage = ImageIO.read( headFile );
	int headWidth = headImage.getWidth( null );
	int headHeight = headImage.getHeight( null );

	JEditorPane ed = new JEditorPane( "text/html", html );
	ed.setSize( 800, 800 );

	Dimension prefSize = ed.getPreferredSize();
	log.info( "size: {}", prefSize );

	BufferedImage image = new BufferedImage( prefSize.width, prefSize.height + headHeight, BufferedImage.TYPE_INT_ARGB );
	int width = image.getWidth( null );
	int height = image.getHeight( null );

	Graphics2D g2d = image.createGraphics();

	SwingUtilities.paintComponent( g2d, ed, new JPanel(), 0, headHeight, image.getWidth(), image.getHeight() );

	{ // 设置头
	    g2d.setBackground( BG_COLOR ); // 设置背景色
	    g2d.clearRect( 0, 0, width, headHeight ); // 用背景色进行填充来清除指定的矩形

	    int x = ( width - headWidth ) / 2;
	    int y = 0;
	    g2d.drawImage( headImage, x, y, headWidth, headHeight, null );
	}

	{ // 设置水印
	    File paperFile = new File( paperImagePath );
	    Image paperImage = ImageIO.read( paperFile );
	    int paperWidth = paperImage.getWidth( null );
	    int paperHeight = paperImage.getHeight( null );
	    int x = ( width - paperWidth ) / 2;
	    int y = ( height - paperHeight ) / 2;
	    g2d.drawImage( paperImage, x, y, paperWidth, paperHeight, null );
	}

	g2d.dispose(); // 结束

	return image;
    }

    /**
     * 将文件路径转换为URL
     * 
     * @param filePath
     * @return
     */
    public static String toURL( String filePath ) {
	if ( filePath.contains( ".jar!" ) ) {
	    String prefix = "";
	    if ( !filePath.startsWith( "jar:" ) ) {
		prefix += "jar:";
	    }
	    if ( !filePath.startsWith( "file:" ) ) {
		prefix += "file:";
	    }
	    return prefix + filePath;
	}
	if ( !filePath.startsWith( "file:" ) ) {
	    return "file:" + filePath;
	}
	return filePath;
    }

}
