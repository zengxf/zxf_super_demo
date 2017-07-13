package cn.zxf.unit_test.position;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.zxf.unit_test.position.dto.PositionDto;

@Component
public class PositionService {

    @Autowired
    private PositionMongoDao dao;

    public PositionDto insert( PositionDto dto ) {
	Position position = new Position();
	BeanUtils.copyProperties( dto, position );
	position = dao.insert( position );
	BeanUtils.copyProperties( position, dto );
	return dto;
    }

    public void save( PositionDto dto ) {
	Position position = new Position();
	BeanUtils.copyProperties( dto, position );
	dao.save( position );
    }

    public List<PositionDto> findAll() {
	List<Position> all = dao.findAll();
	List<PositionDto> dtoList = all.stream().map( pos -> {
	    PositionDto dto = new PositionDto();
	    BeanUtils.copyProperties( pos, dto );
	    return dto;
	} ).collect( Collectors.toList() );
	return dtoList;
    }

}
