package com.scheduler.cyraacs.service;

import org.springframework.stereotype.Service;

@Service
public class NotificationService {
    public void sendNotification(String message){
        System.out.println(message);
    }
}
