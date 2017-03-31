package cn.simple.util.serial;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerialUtil {

    public static < T extends Serializable > void writeObject( T obj, String filePath ) {
	try ( ObjectOutputStream oos = new ObjectOutputStream( new FileOutputStream( filePath ) ) ) {
	    oos.writeObject( obj );
	} catch ( IOException e ) {
	    e.printStackTrace();
	}
    }

    @SuppressWarnings( "unchecked" )
    public static < T extends Serializable > T readObject( String filePath ) {
	try ( ObjectInputStream ois = new ObjectInputStream( new FileInputStream( filePath ) ) ) {
	    Object obj = ois.readObject();
	    return (T) obj;
	} catch ( IOException | ClassNotFoundException e ) {
	    e.printStackTrace();
	}
	return null;
    }

}
