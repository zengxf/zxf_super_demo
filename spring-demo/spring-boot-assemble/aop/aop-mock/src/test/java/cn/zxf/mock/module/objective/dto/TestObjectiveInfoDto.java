package cn.zxf.mock.module.objective.dto;

import java.lang.reflect.Field;
import java.util.stream.Stream;

import org.apache.commons.lang3.reflect.FieldUtils;
import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestObjectiveInfoDto {

    @Test
    public void testGetFields() {
        Field[] fields = FieldUtils.getAllFields( ObjectiveInfoDto.class );
        Stream.of( fields ).forEach( f -> log.info( "field: {}", f ) );
    }

}
