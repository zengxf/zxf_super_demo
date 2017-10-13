package cn.simple.test.new_features.jdk1_4.nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 
 * <p>
 * Created by zengxf on 2017-08-14
 */
public class TestFileChannel {
    public static void main( String[] args ) throws IOException {
        // test_base();
        // test_transferFrom();
        // test_transferTo();
        test_truncate();
    }

    static void test_base() throws FileNotFoundException, IOException {
        String path = TestFileChannel.class.getResource( "_test-read.txt" ).getPath();
        System.out.println( path );
        RandomAccessFile aFile = new RandomAccessFile( path, "rw" );
        FileChannel inChannel = aFile.getChannel();

        // create buffer with capacity of 48 bytes
        ByteBuffer buf = ByteBuffer.allocate( 48 );

        int bytesRead = inChannel.read( buf ); // read into buffer.
        while ( bytesRead != -1 ) {

            buf.flip(); // make buffer ready for read

            while ( buf.hasRemaining() ) {
                System.out.print( (char) buf.get() ); // read 1 byte at a time
            }

            System.out.println( "=====================" );

            buf.clear(); // make buffer ready for writing
            bytesRead = inChannel.read( buf );
        }
        aFile.close();
    }

    /**
     * scatter / gather �ֿ�����header��body��������ʹ����������
     * <p>
     * "scattering read"�ǰ����ݴӵ���Channelд�뵽���buffer
     * 
     * <pre>
     * ByteBuffer header = ByteBuffer.allocate( 128 );
     * ByteBuffer body = ByteBuffer.allocate( 1024 );
     * ByteBuffer[] bufferArray = { header, body };
     * channel.read( bufferArray ); // һ��bufferд���󣬽���д����һ��buffer��
     * </pre>
     * 
     * "gathering write"�Ѷ��buffer������д�뵽ͬһ��channel��
     * 
     * <pre>
     * // write data into buffers
     * ByteBuffer[] bufferArray = { header, body };
     * channel.write(bufferArray)
     * </pre>
     */
    static void test_scatter_gather() {

    }

    /**
     * transferFrom���������ݴ�ͨ��Դ���䵽FileChannel
     * 
     * @throws IOException
     */
    static void test_transferFrom() throws IOException {
        String fromPath = TestFileChannel.class.getResource( "_test-fromFile.txt" ).getPath();
        String toPath = TestFileChannel.class.getResource( "_test-toFile.txt" ).getPath();
        System.out.println( toPath );
        try ( //
                RandomAccessFile fromFile = new RandomAccessFile( fromPath, "rw" ); //
                RandomAccessFile toFile = new RandomAccessFile( toPath, "rw" ) //
        ) {
            FileChannel fromChannel = fromFile.getChannel();
            FileChannel toChannel = toFile.getChannel();
            long position = toChannel.size(); // to Channel ��λ��
            long count = fromChannel.size();
            toChannel.transferFrom( fromChannel, position, count ); // ���Ḳ��
        }
    }

    /**
     * transferTo������FileChannel���ݴ��䵽��һ��channel
     * 
     * @throws IOException
     */
    static void test_transferTo() throws IOException {
        String fromPath = TestFileChannel.class.getResource( "_test-fromFile.txt" ).getPath();
        String toPath = TestFileChannel.class.getResource( "_test-toFile.txt" ).getPath();
        System.out.println( toPath );
        try ( //
                RandomAccessFile fromFile = new RandomAccessFile( fromPath, "rw" ); //
                RandomAccessFile toFile = new RandomAccessFile( toPath, "rw" ) //
        ) {
            FileChannel fromChannel = fromFile.getChannel();
            FileChannel toChannel = toFile.getChannel();
            long position = 0; // from Channel ��λ�á�Ҫȫ��д��Ϊ 0
            long count = 10;
            fromChannel.transferTo( position, count, toChannel ); // �Ḳ��...
        }
    }

    static void test_truncate() throws IOException {
        String fromPath = TestFileChannel.class.getResource( "_test-fromFile.txt" ).getPath();
        System.out.println( fromPath );
        try ( //
                RandomAccessFile fromFile = new RandomAccessFile( fromPath, "rw" ); //
        ) {
            FileChannel fromChannel = fromFile.getChannel();
            FileChannel toChannel = fromChannel.truncate( 10 );
            ByteBuffer dst = ByteBuffer.allocate( 100 );
            toChannel.read( dst );
            System.out.println( new String( dst.array() ) );
        }
    }

}
