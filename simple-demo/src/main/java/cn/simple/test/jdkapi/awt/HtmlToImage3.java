package cn.simple.test.jdkapi.awt;

import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

import javax.imageio.ImageIO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Deprecated
public class HtmlToImage3 {

    static String CSSCOLOR = "#bf8f79";
    static float  ALPHA	   = 0.4f;

    static void generateOutput() throws Exception {
	URI contentUri = HtmlToImage3.class.getResource( "test.html" ).toURI();
	String contentHtml = Files.readAllLines( Paths.get( contentUri ) ).stream().collect( Collectors.joining( "" ) );

	URI templateUri = HtmlToImage3.class.getResource( "morning-template.html" ).toURI();
	String templateHtml = Files.readAllLines( Paths.get( templateUri ) ).stream().collect( Collectors.joining( "" ) );

	String html = templateHtml.replace( "#content#", contentHtml );
	String headImagePath = HtmlToImageUtil3.class.getResource( "morning-head_bg.png" ).getFile();
	String paperImagePath = HtmlToImageUtil3.class.getResource( "morning-paper_bg.png" ).getFile();

	log.info( "{}", html );

	BufferedImage image2 = HtmlToImageUtil3.toImage( html, headImagePath, paperImagePath );
	ImageIO.write( image2, "png", new File( "E:/html3.png" ) );
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
