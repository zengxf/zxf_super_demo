package cn.zxf.unit_test.position;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.zxf.unit_test.position.dto.PositionDto;

@RestController
@RequestMapping( "/api/position" )
public class PositionController {

    @Autowired
    private PositionService service;

    @PostMapping( "insert" )
    public PositionDto insert( //
            @RequestBody PositionDto positionDto //
    ) {
	PositionDto dto = service.insert( positionDto );
	return dto;
    }

    @PostMapping( "save" )
    public void save( //
            @RequestBody PositionDto positionDto //
    ) {
	service.save( positionDto );
    }

    @GetMapping( "find-all" )
    public List<PositionDto> findAll() {
	List<PositionDto> dtoList = service.findAll();
	return dtoList;
    }

}
