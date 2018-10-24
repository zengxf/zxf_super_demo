package cn.zxf.webflux.demo.restaurant.test.util;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.BeforeClass;
import org.junit.Test;

import cn.zxf.webflux.demo.restaurant.Restaurant;
import cn.zxf.webflux.demo.restaurant.test.ImperativeRestaurantRepository;
import cn.zxf.webflux.demo.restaurant.test.ReactiveRestaurantRepository;

/**
 * @author Emac
 * @since 2017-06-04
 */
public class PerformanceTests extends BaseTests {

    private static List<Restaurant> load;

    @BeforeClass
    public static void beforeAll() {
        // initialize load
        load = IntStream.range(0, PACK_SIZE * 10)
                .mapToObj(i -> new Restaurant("hello" + i, "hello" + i, "hello" + i))
                .collect(Collectors.toList());
    }

    @Test
    public void testImperative() {
        // insert
        ImperativeRestaurantRepository.INSTANCE.insert(load);
        // findAll
//        Assertions.assertEquals(load.size(), ImperativeRestaurantRepository.INSTANCE.findAll().size());
    }

    @Test
    public void testReactive() {
        // insert
        ReactiveRestaurantRepository.INSTANCE.insert(load).blockLast();
        // findAll
//        Assertions.assertEquals(load.size(), ReactiveRestaurantRepository.INSTANCE.findAll().count().block().intValue());
    }
}
