package com.wtech.core.motor;

import org.springframework.stereotype.Component;

@Component
public class ElectricMotor1 implements Motor {
    public void start() {
        System.out.println("Electric Motor 1 Started.");
    }
}
