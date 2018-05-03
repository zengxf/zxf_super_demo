package cn.zxf.swagger2_test.module.position.position_oper;

import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping( value = "/api/position/operation" )
public class PositionOperationController {

    @ApiOperation( "查找单个" )
    @GetMapping( "find-one/{id}" )
    public PositionDto findOne( @PathVariable String id ) {
        return PositionDto.builder()
                .id( id )
                .name( "test-" + id )
                .expireDate( new Date() )
                .build();
    }

    @ApiOperation( "创建保存" )
    @PostMapping( "create" )
    public PositionDto create( @RequestBody PositionDto dto ) {
        return dto;
    }

}
