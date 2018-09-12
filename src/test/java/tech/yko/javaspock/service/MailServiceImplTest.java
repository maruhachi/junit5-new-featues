package tech.yko.javaspock.service;

import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.rule.OutputCapture;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MailServiceImplTest {

    MailServiceImpl mailService = new MailServiceImpl();

    @Rule
    public OutputCapture capture = new OutputCapture();

    @Test
    void send() {

        mailService.send("in the implementation");

        assertEquals(capture.toString(), "msg is in the implementation in the implementation");
    }
}