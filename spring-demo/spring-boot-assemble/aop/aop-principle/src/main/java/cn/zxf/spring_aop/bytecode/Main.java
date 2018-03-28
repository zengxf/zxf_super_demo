package cn.zxf.spring_aop.bytecode;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.function.Function;

import org.springframework.beans.Mergeable;

/**
 * 导出字节码
 * 
 * <p>
 * Created by zengxf on 2017-10-27
 */
public class Main {
    public static void main( String[] args ) throws IOException, URISyntaxException {
        Path path = Paths.get( Main.class.getResource( "/" )
                .toURI() );
        Path savePath = path.resolve( "../export/bytecode" )
                .normalize()
                .toAbsolutePath();
        Files.createDirectories( savePath );

        System.out.println( "class 存放路径：" );
        System.out.println( savePath );
        System.out.println( "----------------------" );

        export( savePath, ByteCode.class );
        export( savePath, ClassLoader.class );
        export( savePath, Function.class );
        export( savePath, Mergeable.class );
    }

    static void export( Path saveFolder, Class<?> clazz ) throws IOException {
        Path savePath = saveFolder.resolve( clazz.getSimpleName() + ".class" );
        String classPath = "/" + clazz.getName()
                .replace( ".", "/" ) + ".class";
        InputStream is = clazz.getResourceAsStream( classPath );
        System.out.println( ClassLoader.class );
        System.out.println( "class 文件大小：" + is.available() );
        System.out.println( "class 文件保存：" + savePath );
        if ( Files.exists( savePath ) )
            Files.delete( savePath );
        Files.copy( is, savePath );
        System.out.println( "----------------------" );
    }

}
