package cn.zxf.security_base.demo.config;

import java.util.Collection;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode( callSuper = false )
public class IpAuthenticationToken extends AbstractAuthenticationToken {

    private static final long serialVersionUID = 1L;

    private String            ip;

    public IpAuthenticationToken( String ip ) {
        super( null );
        this.ip = ip;
        super.setAuthenticated( false );// 注意这个构造方法是认证时使用的
    }

    public IpAuthenticationToken( String ip, Collection<? extends GrantedAuthority> authorities ) {
        super( authorities );
        this.ip = ip;
        super.setAuthenticated( true );// 注意这个构造方法是认证成功后使用的

    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return this.ip;
    }

}
