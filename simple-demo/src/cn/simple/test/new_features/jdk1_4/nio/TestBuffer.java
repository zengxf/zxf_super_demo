package cn.simple.test.new_features.jdk14.nio;

import java.nio.CharBuffer;

public class TestBuffer {
    public static void main( String[] args ) {
        CharBuffer buf = CharBuffer.allocate( 1024 );
        buf.put( 'c' ); // 写数据
        // inChannel.read(buf); // read into buffer

        buf.flip(); // 从写模式切换到读模式

        char c = buf.get(); // 读数据
        // inChannel.write(buf); // read from buffer into channel.
        System.out.println( c );

        buf.rewind(); // 将position置为0，可以重复读取buffer中的数据
        System.out.println( buf.get() );

        {
            System.out.println( "-==-=-===--=-=-=" );
            buf.clear(); // 重置position为0，limit为capacity，一些数据没有读取完，调用clear就会导致这部分数据被“遗忘”
            buf.put( 'a' );
            buf.put( 'b' );
            buf.flip();
            System.out.println( buf.get() );

            System.out.println( "-==-=-===--=-=-=" );
            buf.compact(); // 保留未读数据
            buf.put( 'c' );
            buf.flip();
            System.out.println( buf.get() );
            System.out.println( buf.get() );
        }

        {
            buf.clear();
            // 通过mark方法可以标记当前的position，通过reset来恢复mark的位置
            buf.put( 'a' );
            buf.put( 'b' );
            buf.put( 'c' );

            buf.flip();
            System.out.println( "-==-=-===--=-=-=" );
            System.out.println( buf.get() );
            buf.mark();
            System.out.println( buf.get() );
            System.out.println( buf.get() );
            buf.reset();
            System.out.println( "----- 111" );
            System.out.println( buf.get() );
            System.out.println( buf.get() );
        }

        {
            // equals() 需满足： • 类型相同 • buffer中剩余字节数相同 • 所有剩余字节相等
            // compareTo() 也是比较buffer中的剩余元素
        }
    }
}
