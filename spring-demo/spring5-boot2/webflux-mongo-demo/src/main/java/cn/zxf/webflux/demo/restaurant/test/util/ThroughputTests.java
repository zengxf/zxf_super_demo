package cn.zxf.webflux.demo.restaurant.test.util;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
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
public class ThroughputTests extends BaseTests {

    private static List<Restaurant> load;

    @BeforeClass
    public static void beforeAll() {
        // initialize load
        load = IntStream.range(0, PACK_SIZE)
                .mapToObj(i -> new Restaurant("hello" + i, "hello" + i, "hello" + i))
                .collect(Collectors.toList());
    }

    @Test
    public void testImperative() throws InterruptedException {
        _runInParallel(CONCURRENT_SIZE, () -> {
            ImperativeRestaurantRepository.INSTANCE.insert(load);
        });
    }

    private void _runInParallel(int nThreads, Runnable task) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(nThreads);
        for (int i = 0; i < nThreads; i++) {
            executorService.submit(task);
        }
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.MINUTES);
    }

    @Test
    public void testReactive() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(CONCURRENT_SIZE);
        for (int i = 0; i < CONCURRENT_SIZE; i++) {
            ReactiveRestaurantRepository.INSTANCE.insert(load).subscribe(s -> {
            }, e -> latch.countDown(), latch::countDown);
        }
        latch.await();
    }
}
