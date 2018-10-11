package cn.zxf.unit_test;

import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.rules.SpringClassRule;
import org.springframework.test.context.junit4.rules.SpringMethodRule;

import junitparams.JUnitParamsRunner;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ActiveProfiles( "dev" )
@SpringBootTest( webEnvironment = WebEnvironment.NONE )
@RunWith( JUnitParamsRunner.class ) // XXX 注
public abstract class AbstractParamApplicationTest {

    @ClassRule // XXX 注
    public static final SpringClassRule SPRING_CLASS_RULE = new SpringClassRule();
    @Rule // XXX 注
    public final SpringMethodRule       springMethodRule  = new SpringMethodRule();

    public void info( String format, Object... arguments ) {
        System.out.println();
        System.out.println();
        log.info( format, arguments );
        System.out.println();
        System.out.println();
    }

}
