package cn.zxf.data_bury_point.biz.candidate;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.zxf.data_bury_point.biz.candidate.dto.SearchDto;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping( "/api/candidate" )
@Slf4j
public class CandidateController {

    @GetMapping( "find-all" )
    public List<Object> findAll() {
	log.info( "find - all - ok" );
	if ( new Random().nextInt( 10 ) < 5 ) {
	    throw new RuntimeException( "random error !!!" );
	}
	return Collections.emptyList();
    }

    @PostMapping( "upload" )
    public List<Object> upload() {
	return Collections.emptyList();
    }

    @PostMapping( "search-list" )
    public List<Object> searchList( //
            @RequestBody SearchDto dto //
    ) {
	log.info( "search-dto: {}", dto );
	return Collections.emptyList();
    }

}
