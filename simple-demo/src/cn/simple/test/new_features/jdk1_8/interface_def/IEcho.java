package cn.simple.test.new_features.jdk18.interface_def;

public interface IEcho extends IPrint {
    default void print() {
	System.out.println( "fuck from IEcho" );
    }
}
