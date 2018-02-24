package cn.simple.test.jdkapi.juc.structure;

import java.util.concurrent.ArrayBlockingQueue;

public class TestArrayBlockingQueue {

    public static void main( String[] args ) {
        ArrayBlockingQueue<Integer> bqueue = new ArrayBlockingQueue<>( 20 );

        bqueue.offer( 1 );

        bqueue.poll();
    }

}
