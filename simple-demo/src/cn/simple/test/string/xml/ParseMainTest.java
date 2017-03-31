package cn.simple.test.string.xml;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;

public class ParseMainTest {

    public static void main( String[] args ) {
	testUser();
    }

    static void testUser() {
	JAXBContext jaxbContext;
	try {
	    String xmlContent = readXml( "user.xml" );

	    // 加载映射bean类
	    jaxbContext = JAXBContext.newInstance( User.class );
	    // 创建解析
	    Unmarshaller um = jaxbContext.createUnmarshaller();
	    StreamSource streamSource = new StreamSource( new StringReader( xmlContent ) );
	    User root = (User) um.unmarshal( streamSource );
	    System.out.println( root );

	    jaxbContext.createMarshaller().marshal( root, new File( "D:/user.xml" ) );
	} catch ( Exception e ) {
	    e.printStackTrace();
	}
    }

    static String readXml( String fileName ) throws IOException {
	StringBuffer buffer = null;
	String path = ParseMainTest.class.getResource( "" ).getPath() + fileName;
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
