package cn.simple.test.string.xml;

import java.io.StringReader;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.transform.stream.StreamSource;

public class ParseSscTest {

    public static void main( String[] args ) {
	JAXBContext jaxbContext;
	try {
	    String xmlContent = ParseMainTest.readXml( "ssc.xml" );

	    // ����ӳ��bean��
	    jaxbContext = JAXBContext.newInstance( ParseResult.class );
	    // ��������
	    Unmarshaller um = jaxbContext.createUnmarshaller();
	    StreamSource streamSource = new StreamSource( new StringReader( xmlContent ) );
	    ParseResult root = (ParseResult) um.unmarshal( streamSource );
	    System.out.println( root );
	} catch ( Exception e ) {
	    e.printStackTrace();
	}
    }

    @XmlRootElement( name = "xml" )
    static class ParseResult {

	@XmlElement
	public List<Row> row;

    }

    /**
     * �м�¼
     */
    @XmlRootElement( name = "row" )
    static class Row {

	@XmlAttribute
	public String expect;
	@XmlAttribute
	public String opencode;
	@XmlAttribute
	public String opentime;

    }

}
