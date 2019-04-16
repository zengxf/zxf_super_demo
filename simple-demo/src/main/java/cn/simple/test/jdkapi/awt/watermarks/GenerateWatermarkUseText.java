package cn.simple.test.jdkapi.awt.watermarks;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * 用文字生成水印
 * <p>
 * Created by zengxf on 2019-04-16
 */
public class GenerateWatermarkUseText {

    public static void main( String[] args ) {
        String targetPath = "C:\\Users\\Administrator\\Desktop\\aa";
        String outPath = targetPath + "\\文字水印";
        mkdir( outPath );

    }

    static void mkdir( String path ) {
        try {
            Path filePath = Paths.get( path );
            if ( Files.exists( filePath ) && Files.isDirectory( filePath ) )
                return;
            Files.createDirectory( filePath );
        } catch ( IOException e ) {
            e.printStackTrace();
        }
    }

}
