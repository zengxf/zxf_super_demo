package cn.zxf.webflux.demo.restaurant;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface RestaurantRepository extends ReactiveCrudRepository<Restaurant, String> {

}