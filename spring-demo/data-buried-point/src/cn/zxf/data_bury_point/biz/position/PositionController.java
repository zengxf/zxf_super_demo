package cn.zxf.data_bury_point.biz.position;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( "/api/position" )
public class PositionController {

    @GetMapping( "find-all" )
    @Deprecated
    public List<Object> findAll() {
	return Collections.emptyList();
    }

    @GetMapping( "get/{userId}/{positionId}" )
    @Deprecated
    public List<Object> get( //
            @PathVariable String userId, //
            @PathVariable String positionId //
    ) {
	return Collections.emptyList();
    }

    @PostMapping( "update" )
    public List<Object> update() {
	return Collections.emptyList();
    }

    @DeleteMapping
    public List<Object> delete( HttpServletResponse response ) {
	response.setHeader( "zxf-sign-1", "testa" );
	response.addHeader( "zxf-sign-2", "testb" );
	return Arrays.asList( "test1", "test2" );
    }

    @GetMapping
    @Deprecated
    public List<Object> get() {
	return Collections.emptyList();
    }

}
