package cn.zxf.custom_configuration.test.config.position;

import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.springframework.boot.env.PropertySourcesLoader;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PropertySourceFactory;

@Deprecated // 并没有什么卵用
public class YamlPropertySourceFactory implements PropertySourceFactory {

    @SuppressWarnings( { "unchecked", "rawtypes" } )
    @Override
    public PropertySource<?> createPropertySource( String name, EncodedResource resource ) throws IOException {
        Resource src = resource.getResource();
        name = name != null ? name : getNameForResource( src );
        PropertySourcesLoader loader = new PropertySourcesLoader();
        PropertySource<?> rs = loader.load( src, name, null );
        Object source = rs.getSource();
        if ( source instanceof Map ) {
            Map<String, String> map = (Map) source;
            map.entrySet()
                    .stream()
                    .collect( Collectors.toMap( e -> {
                        String newKey = e.getKey();
                        String[] arr = newKey.split( "\\." );
                        return arr[1];
                    }, Entry::getValue ) )
                    .forEach( map::put );
        }
        System.out.println( source );
        return rs;
    }

    private static String getNameForResource( Resource resource ) {
        String name = resource.getDescription();
        if ( !org.springframework.util.StringUtils.hasText( name ) ) {
            name = resource.getClass()
                    .getSimpleName() + "@" + System.identityHashCode( resource );
        }
        return name;
    }
}
