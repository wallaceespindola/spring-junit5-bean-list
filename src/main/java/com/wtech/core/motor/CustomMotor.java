package com.wtech.core.motor;

import org.springframework.stereotype.Component;

@Component
public class CustomMotor implements Motor {
    public void start() {
        System.out.println("Custom Motor Started.");
    }
}
