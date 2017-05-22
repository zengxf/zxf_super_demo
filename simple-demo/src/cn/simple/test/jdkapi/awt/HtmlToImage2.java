package cn.simple.test.jdkapi.awt;

import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

import javax.imageio.ImageIO;

import gui.ava.html.image.generator.HtmlImageGenerator;
import lombok.extern.slf4j.Slf4j;

@Deprecated
@Slf4j
public class HtmlToImage2 {

    static String CSSCOLOR = "#bf8f79";
    static float  ALPHA	   = 0.4f;

    static void generateOutput() throws Exception {
	URI uri = HtmlToImage2.class.getResource( "test2.html" ).toURI();
	String html = Files.readAllLines( Paths.get( uri ) ).stream().collect( Collectors.joining( "" ) );

	HtmlImageGenerator g = new HtmlImageGenerator();
	g.loadHtml( html );
	BufferedImage image1 = g.getBufferedImage();
	ImageIO.write( image1, "png", new File( "C:/Users/Administrator/Desktop/test-1.png" ) );

	BufferedImage image2 = HtmlToImageUtil2.toImage( html );
	ImageIO.write( image2, "png", new File( "C:/Users/Administrator/Desktop/test-2.png" ) );
    }

    public static void main( String[] args ) {
	try {
	    generateOutput();
	    log.info( "OK" );
	} catch ( Exception e ) {
	    e.printStackTrace();
	}
    }

}
