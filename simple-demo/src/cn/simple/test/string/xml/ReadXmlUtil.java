package cn.simple.test.string.xml;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ReadXmlUtil {

    static String readXml( String fileName ) throws IOException {
        StringBuffer buffer = null;
        String path = ParseUserTest.class.getResource( "" ).getPath() + fileName;
        // 读入xml文件流
        InputStream is = new FileInputStream( new File( path ) );
        BufferedReader in = new BufferedReader( new InputStreamReader( is, "UTF8" ) );
        buffer = new StringBuffer();
        String line = "";
        while ( ( line = in.readLine() ) != null ) {
            buffer.append( line );
        }
        in.close();
        String xmlContent = buffer.toString();
        return xmlContent;
    }

}
