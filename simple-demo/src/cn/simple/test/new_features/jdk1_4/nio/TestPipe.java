package cn.simple.test.new_features.jdk14.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;

/**
 * <pre>
 * �����̼߳䵥�������ݵ�����
 * ������д��sink channel�У���Щ���ݿ���ͬ��source channel�ٶ�ȡ����
 * </pre>
 * 
 * <p>
 * Created by zengxf on 2017-08-14
 */
public class TestPipe {
    public static void main( String[] args ) throws IOException {
        Pipe pipe = Pipe.open();

        {
            Pipe.SinkChannel sinkChannel = pipe.sink();
            String newData = "New String to write to file..." + System.currentTimeMillis();
            ByteBuffer buf = ByteBuffer.allocate( 48 );
            buf.clear();
            buf.put( newData.getBytes() );
            buf.flip();
            while ( buf.hasRemaining() ) {
                sinkChannel.write( buf );
            }
        }

        {
            Pipe.SourceChannel sourceChannel = pipe.source();
            ByteBuffer buf = ByteBuffer.allocate( 48 );
            int bytesRead = sourceChannel.read( buf );
            System.out.println( bytesRead );
            System.out.println( new String(buf.array()) );
        }
    }
}
