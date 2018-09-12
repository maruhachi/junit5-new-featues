package tech.yko.javaspock.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MailServiceImplTest {

    MailServiceImpl mailService = new MailServiceImpl();

    @Test
    void send() {
        System.out.println("in Test code.");
        mailService.send("in the implementation");
        System.out.println("test end.");
    }
}