package tech.yko.javaspock.service;

import org.springframework.stereotype.Service;

@Service
public class MailServiceImpl implements MailService {

    @Override
    public String send(String message) {
        String repeatMsg = message + " " + message;
        System.out.println("msg is " + repeatMsg);

        return repeatMsg;
    }
}
