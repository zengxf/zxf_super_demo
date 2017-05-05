package cn.simple.test.new_features.jdk14;

import java.util.logging.ConsoleHandler;

public class MyConsoleHandler extends ConsoleHandler {

    public MyConsoleHandler() {
	super.setOutputStream( System.out );
    }

}
