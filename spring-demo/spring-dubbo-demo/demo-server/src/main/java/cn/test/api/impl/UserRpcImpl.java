package cn.test.api.impl;

import com.alibaba.dubbo.config.annotation.Service;

import cn.test.api.IUserRpc;
import cn.test.api.UserDto;

// @Service
@Service( version = "1.0.0" )
public class UserRpcImpl implements IUserRpc {

    @Override
    public UserDto find( String id ) {
        UserDto dto = new UserDto();
        dto.setAge( 32 );
        dto.setName( "zxf-" + id );
        return dto;
    }

}
