package cn.zxf.cache_redis.user.dto;

import java.util.ArrayList;
import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Builder;
import lombok.Data;

@Data
public class JwtUser {

    private String             username;
    private String             password;
    private Collection<String> roleList    = new ArrayList<>(); // 用户具有的角色与权限
    @JsonIgnore
    private Collection<Role>   authorities = new ArrayList<>(); // 用户具有的角色与权限

    public static JwtUser      NULL        = new JwtUser();

    /**
     * 添加权限
     */
    public JwtUser addAuthority( String role ) {
        this.roleList.add( role );
        this.authorities.add( Role.builder()
                .name( role )
                .build() );
        return this;
    }

    public void setRoleList( Collection<String> roleList ) {
        this.roleList = roleList;
        roleList.forEach( role -> this.authorities.add( Role.builder()
                .name( role )
                .build() ) );
    }

    @JsonIgnore
    public boolean isAccountNonExpired() {
        return true;
    }

    @Data
    @Builder
    public static class Role {
        private String name;
    }

}
