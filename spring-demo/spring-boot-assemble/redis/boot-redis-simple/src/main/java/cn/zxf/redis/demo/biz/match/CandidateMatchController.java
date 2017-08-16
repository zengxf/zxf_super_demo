package cn.zxf.redis.demo.biz.match;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( "/api/match/candidate" )
public class CandidateMatchController {

    @Autowired
    private CandidateCache cache;

    @GetMapping( "/get-cache-by-id" )
    public CandidateBo getCacheById( @RequestParam String id ) {
	CandidateBo cdd = cache.getCacheById( id );
	return cdd;
    }
    
    
}
