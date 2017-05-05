package cn.zxf.spring.boot.mvc.download;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( "/api/morning_news" )
public class DownloadController {

    // http://localhost:8080/api/morning_news/download/1
    @GetMapping( "download/{id}" )
    public void download( @PathVariable String id, HttpServletResponse response ) throws IOException {
	String fileName = "早报 - 2017-05-05.png";
	fileName = URLEncoder.encode( fileName, "UTF-8" );
	fileName = URLDecoder.decode( fileName, "ISO-8859-1" );

	response.reset();
	response.setContentType( MediaType.APPLICATION_OCTET_STREAM_VALUE );
	response.setHeader( HttpHeaders.CONTENT_DISPOSITION, String.format( "attachment; filename=%s", fileName ) );

	BufferedImage image = ImageIO.read( new File( "E:/html.png" ) );
	OutputStream os = response.getOutputStream();
	ImageIO.write( image, "png", os );
    }

}
