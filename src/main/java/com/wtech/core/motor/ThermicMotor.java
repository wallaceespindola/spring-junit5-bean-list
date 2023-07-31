package com.wtech.core.motor;

import org.springframework.stereotype.Component;

@Component
public class ThermicMotor extends AbstractMotor {
    public void start() {
        System.out.println("Thermic Motor Started.");
    }
}
