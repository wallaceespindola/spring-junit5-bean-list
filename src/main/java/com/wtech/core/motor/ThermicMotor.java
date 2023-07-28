package com.wtech.core.motor;

import org.springframework.stereotype.Component;

@Component
public class ThermicMotor implements Motor {
    public void start() {
        System.out.println("Thermic Motor Started.");
    }
}
