package cn.zxf.mongo.big_decimal.position;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.zxf.mongo.big_decimal.position.dto.PositionCreateDto;
import cn.zxf.mongo.big_decimal.position.dto.PositionListItemDto;

@RestController
@RequestMapping( "/api/position" )
public class PositionController {

    @Autowired
    private PositionRepository repository;

    @PostMapping( "create" )
    public PositionListItemDto createPosition( //
            @RequestBody PositionCreateDto dto //
    ) {
        Position p = new Position();
        BeanUtils.copyProperties( dto, p );
        repository.insert( p );

        PositionListItemDto itemDto = new PositionListItemDto();
        BeanUtils.copyProperties( p, itemDto );
        return itemDto;
    }

    @GetMapping( "find-all" )
    public List<PositionListItemDto> findAll() {
        List<PositionListItemDto> dtoList = repository.findAll().stream() //
                .map( p -> {
                    PositionListItemDto itemDto = new PositionListItemDto();
                    BeanUtils.copyProperties( p, itemDto );
                    return itemDto;
                } ) //
                .collect( Collectors.toList() );
        return dtoList;
    }

}
