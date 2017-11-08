package cn.test.api.impl;

import org.springframework.stereotype.Service;

import cn.test.api.IUserRpc;
import cn.test.api.UserDto;

@Service
public class UserRpcImpl implements IUserRpc {

    @Override
    public UserDto find( String id ) {
        UserDto dto = new UserDto();
        dto.setAge( 32 );
        dto.setName( "zxf-" + id );
        return dto;
    }

}
