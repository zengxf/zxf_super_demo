package cn.zxf.swagger2_test_security.module.position;

import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping( value = "/api/position" )
@Api( tags = "职位控制器" )
public class PositionController {

    @ApiOperation( "" )
    @GetMapping( "find-one/{id}" )
    public PositionDto findOne( @PathVariable String id ) {
        return PositionDto.builder()
                .id( id )
                .name( "test-" + id )
                .expireDate( new Date() )
                .build();
    }

    @ApiOperation( "" )
    @PostMapping( "create" )
    public PositionDto create( @RequestBody PositionDto dto ) {
        return dto;
    }

}
