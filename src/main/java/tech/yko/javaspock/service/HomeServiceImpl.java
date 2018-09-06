package tech.yko.javaspock.service;

import org.springframework.stereotype.Service;

@Service
public class HomeServiceImpl implements HomeService {

    @Override
    public int add(int a, int b) throws InterruptedException {
        Thread.sleep(1000);
        return a + b;
    }
}
