package cn.zxf.redis.demo.biz.match;

import java.util.Random;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class CandidateCache {

    @Cacheable( key = "'match-candidate-' + #id", cacheManager = "matchCacheManager", cacheResolver = "matchCacheResolver", unless = "#result == null" )
    public CandidateBo getCacheById( String id ) {
	CandidateBo cache = new CandidateBo( id, "zxf", new Random().nextInt( 100 ) );
	log.info( "get cache: {}", cache );
	return cache;
    }

}
