package cn.simple.test.new_features.jdk18.juc;

import java.util.concurrent.atomic.AtomicInteger;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestAtomicInteger extends Util {
    public static void main( String[] args ) {
	test_updateAndGet();
	// test_accumulateAndGet();
	// test_getAndUpdate();
	// test_getAndAccumulate();
    }

    // ���ؼ���ǰ��ֵ
    static void test_getAndAccumulate() {
	AtomicInteger atomic = new AtomicInteger( 0 );
	int get = atomic.getAndAccumulate( 2, ( i, base ) -> ( i + 2 ) * base );
	log.info( "prev: {}, current: {}", get, atomic.get() );
    }

    // ���ظ���ǰ��ֵ
    static void test_getAndUpdate() {
	AtomicInteger atomic = new AtomicInteger( 0 );
	int get = atomic.getAndUpdate( i -> i + 2 );
	log.info( "prev: {}, current: {}", get, atomic.get() );
    }

    // ���ؼ�����ֵ
    static void test_accumulateAndGet() {
	AtomicInteger atomic = new AtomicInteger( 0 );
	int get = atomic.accumulateAndGet( 2, ( i, base ) -> ( i + 2 ) * base );
	log.info( "current: {}, current: {}", get, atomic.get() );
    }

    // ���ظ��º��ֵ
    static void test_updateAndGet() {
	AtomicInteger atomic = new AtomicInteger( 0 );
	int get = atomic.updateAndGet( i -> i + 2 );
	log.info( "current: {}, current: {}", get, atomic.get() );
    }
}
