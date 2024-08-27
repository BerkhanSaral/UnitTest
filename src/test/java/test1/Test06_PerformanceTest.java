package test1;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertTimeout;

public class Test06_PerformanceTest {

    @Test
    void testPerformancePrintNumbers() {

        assertTimeout(Duration.ofSeconds(1), () -> {
            IntStream.rangeClosed(1, 500000).forEach(System.out::println);
        });
    }
}
