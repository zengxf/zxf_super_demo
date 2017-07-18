package cn.simple.test.new_features.jdk18.jl;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestMath {
    public static void main( String[] args ) {
	addExact();
	subtractExact();
	multiplyExact();
	incrementExact();
	decrementExact();
	negateExact();
	toIntExact();
    }

    // to int
    static void toIntExact() {
	long a = 10;
	log.info( "{} => {} ", a, Math.toIntExact( a ) );
	try {
	    a = 2147483648L;
	    Math.toIntExact( a );
	} catch ( ArithmeticException e ) {
	    log.info( "{} => {} to int ���!!!", a );
	}
    }

    // �为
    static void negateExact() {
	int a = 10;
	log.info( "{} => {} ", a, Math.negateExact( a ) );
	try {
	    a = Integer.MIN_VALUE;
	    Math.negateExact( a );
	} catch ( ArithmeticException e ) {
	    log.info( "{} => {} �为���!!!", a );
	}
    }

    // �Լ�
    static void decrementExact() {
	int a = 10;
	log.info( "{} => {} ", a, Math.decrementExact( a ) );
	try {
	    a = Integer.MIN_VALUE;
	    Math.decrementExact( a );
	} catch ( ArithmeticException e ) {
	    log.info( "{} => {} �Լ����!!!", a );
	}
    }

    // ����
    static void incrementExact() {
	int a = 10;
	log.info( "{} => {} ", a, Math.incrementExact( a ) );
	try {
	    a = Integer.MAX_VALUE;
	    Math.incrementExact( a );
	} catch ( ArithmeticException e ) {
	    log.info( "{} => {} �������!!!", a );
	}
    }

    // �˷�
    static void multiplyExact() {
	int a = 10, b = 10;
	log.info( "{} * {} = {}", a, b, Math.multiplyExact( a, b ) );
	try {
	    a = Integer.MAX_VALUE;
	    b = 2;
	    Math.multiplyExact( a, b );
	} catch ( ArithmeticException e ) {
	    log.info( "{} * {} ������!!!", a, b );
	}
    }

    // �ӷ�
    static void addExact() {
	int a = 10, b = 10;
	log.info( "{} + {} = {}", a, b, Math.addExact( a, b ) );
	try {
	    a = Integer.MAX_VALUE;
	    b = 1;
	    Math.addExact( a, b );
	} catch ( ArithmeticException e ) {
	    log.info( "{} + {} ������!!!", a, b );
	}
    }

    // ����
    static void subtractExact() {
	int a = 10, b = 10;
	log.info( "{} - {} = {}", a, b, Math.subtractExact( a, b ) );
	try {
	    a = Integer.MIN_VALUE;
	    b = 1;
	    Math.subtractExact( a, b );
	} catch ( ArithmeticException e ) {
	    log.info( "{} - {} ������!!!", a, b );
	}
    }

}
