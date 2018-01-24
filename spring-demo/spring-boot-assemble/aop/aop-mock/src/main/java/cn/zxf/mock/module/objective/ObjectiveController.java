package cn.zxf.mock.module.objective;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.zxf.mock.common.domain.PageAndSortDto;
import cn.zxf.mock.common.mock.DevelopMock;
import cn.zxf.mock.module.objective.dto.ObjectiveInfoDto;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping( "/api/objective" )
public class ObjectiveController {

    @DevelopMock
    @GetMapping( "find-one/{id}" )
    public ObjectiveInfoDto findOne( //
            @PathVariable String id, //
            @RequestParam String name //
    ) {
        log.info( "find-one ..." );
        return null;
    }

    @DevelopMock
    @GetMapping( "find-all" )
    public List<ObjectiveInfoDto> findAll() {
        log.info( "find-all ..." );
        return null;
    }

    @DevelopMock( collectionSize = 3 )
    @GetMapping( "find-by-page" )
    public PageAndSortDto<ObjectiveInfoDto> findByPage() {
        log.info( "find-by-page ..." );
        return null;
    }

}
