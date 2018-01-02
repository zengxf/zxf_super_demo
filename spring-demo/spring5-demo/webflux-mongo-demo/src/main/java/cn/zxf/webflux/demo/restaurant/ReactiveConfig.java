package cn.zxf.webflux.demo.restaurant;

import java.util.stream.IntStream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.config.WebFluxConfigurer;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@Slf4j
@Configuration
@EnableWebFlux
@EnableReactiveMongoRepositories
public class ReactiveConfig implements WebFluxConfigurer {

    @Bean
    public CommandLineRunner initData(RestaurantRepository restaurantRepository) {
        return args -> {
            restaurantRepository.deleteAll().block();
            Restaurant[] restaurants = IntStream.range(0, 3)
                    .mapToObj(String::valueOf)
                    .map(s -> new Restaurant(s, s, s))
                    .toArray(Restaurant[]::new);
            restaurantRepository.saveAll(Flux.just(restaurants)).subscribe();
            log.info( "CommandLineRunner - initData - OK" );
        };
    }
    
}
