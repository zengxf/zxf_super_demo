package cn.zxf.webflux.demo.restaurant.test.util;

import java.time.Duration;
import java.time.LocalDateTime;

import org.junit.After;
import org.junit.Before;

import cn.zxf.webflux.demo.restaurant.test.ImperativeRestaurantRepository;

/**
 * @author Emac
 * @since 2017-06-04
 */
public class BaseTests {

    public static final int CONCURRENT_SIZE = 100;
    public static final int PACK_SIZE = 10_000;

    private LocalDateTime start;

    @Before
    public void beforeEach() {
        // start from scratch
        ImperativeRestaurantRepository.INSTANCE.deleteAll();
        start = LocalDateTime.now();
    }

    @After
    public void afterEach() {
        System.out.println(Duration.between(start, LocalDateTime.now()).toMillis());
    }
}
