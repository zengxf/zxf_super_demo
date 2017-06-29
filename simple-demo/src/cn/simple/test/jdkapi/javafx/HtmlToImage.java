package cn.simple.test.jdkapi.javafx;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javafx.concurrent.Worker.State;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.embed.swing.JFXPanel;
import javafx.scene.web.WebView;

public class HtmlToImage {

    static JFrame   jFrame;
    static JFXPanel jfxPanel;
    static WebView  browser;

    public static void main( String args[] ) {

	jFrame = new JFrame( "Demo Browser" );
	jfxPanel = new JFXPanel();
	jFrame.add( jfxPanel );
	jFrame.setVisible( true );
	jFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

	SwingUtilities.invokeLater( new Runnable() {
	    @Override
	    public void run() {
		Platform.runLater( new Runnable() {
		    @SuppressWarnings( { "rawtypes", "unchecked" } )
		    @Override
		    public void run() {
			browser = new WebView();
			browser.getEngine().load( "http://www.baidu.com" );
			jfxPanel.setScene( browser.getScene() );
			jFrame.setSize( (int) browser.getWidth(), (int) browser.getHeight() );

			browser.getEngine().getLoadWorker().stateProperty().addListener( new ChangeListener() {
			    @Override
			    public void changed( ObservableValue observable, Object oldValue, Object newValue ) {
				System.out.println( oldValue.getClass() );
				State oldState = (State) oldValue;
				State newState = (State) newValue;
				if ( State.SUCCEEDED == newValue ) {
				    captureView();
				}
			    }
			} );
		    }
		} );
	    }
	} );
    }

    private static void captureView() {
	BufferedImage bi = new BufferedImage( 500, 500, BufferedImage.TYPE_INT_ARGB );
	Graphics graphics = bi.createGraphics();
	jfxPanel.paint( graphics );
	try {
	    String saveFile = "C:\\Users\\Administrator\\Desktop/test-1.png";
	    ImageIO.write( bi, "PNG", new File( saveFile ) );
	} catch ( IOException e ) {
	    e.printStackTrace();
	}
	graphics.dispose();
	bi.flush();
    }

}
