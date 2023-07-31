package com.wtech.core.motor;

import org.springframework.stereotype.Component;

@Component
public class CustomMotor extends AbstractMotor {
    public void start() {
        System.out.println("Custom Motor Started.");
    }
}
