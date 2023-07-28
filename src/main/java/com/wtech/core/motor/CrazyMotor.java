package com.wtech.core.motor;

import org.springframework.stereotype.Component;

@Component
public class CrazyMotor implements Motor {
    public void start() {
        System.out.println("Crazy Motor Started.");
    }
}
