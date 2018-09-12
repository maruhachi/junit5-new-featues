package tech.yko.javaspock.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.parallel.ExecutionMode.CONCURRENT;

@Execution(CONCURRENT)
public class HomeServiceImpl2Test {

    private HomeServiceImpl homeService = new HomeServiceImpl();

    @Test
    public void add_1() throws InterruptedException {
        int result = homeService.add(1, 2);
        assertEquals(3, result);
    }
    @Test
    public void add_2() throws InterruptedException {
        int result = homeService.add(1, 5);
        assertEquals(6, result);
    }
    @Test
    public void add_3() throws InterruptedException {
        int result = homeService.add(1, 3);
        assertEquals(4, result);
    }
    @Test
    public void add_4() throws InterruptedException {
        int result = homeService.add(1, 4);
        assertEquals(5, result);
    }
}