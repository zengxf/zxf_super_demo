package cn.zxf.admin_client_other_app.test.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.Builder;
import lombok.Data;

@RestController
@RequestMapping( value = "/api/user" )
public class UserController {

    @GetMapping( "show" )
    public UserDto show() {
        return UserDto.builder()
                .name( "zxf-001" )
                .build();
    }

    @Data
    @Builder
    static class UserDto {
        String name;
    }

}