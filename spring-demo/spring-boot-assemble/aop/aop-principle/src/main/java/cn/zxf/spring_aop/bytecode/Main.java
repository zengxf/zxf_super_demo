package cn.zxf.spring_aop.bytecode;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * 导出字节码
 * 
 * <p>
 * Created by zengxf on 2017-10-27
 */
public class Main {
    public static void main( String[] args ) throws IOException, URISyntaxException {
        Path path = Paths.get( Main.class.getResource( "/" ).toURI() );
        Path savePath = path.resolve( "../export/bytecode" ).normalize().toAbsolutePath();
        Files.createDirectories( savePath );

        System.out.println( "class 存放路径：" );
        System.out.println( savePath );
        System.out.println( "----------------------" );

        export( savePath, ByteCode.class );
        export( savePath, ClassLoader.class );
    }

    static void export( Path savePath, Class<?> clazz ) throws IOException {
        Path filePath = savePath.resolve( clazz.getSimpleName() + ".class" );
        InputStream is = clazz.getResourceAsStream( "/" + clazz.getName().replace( ".", "/" ) + ".class" );
        System.out.println( ClassLoader.class );
        System.out.println( "class 文件大小：" + is.available() );
        System.out.println( "class 文件保存：" + filePath );
        if ( Files.exists( filePath ) )
            Files.delete( filePath );
        Files.copy( is, filePath );
        System.out.println( "----------------------" );
    }

}
