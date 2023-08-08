package com.wtech.core.motor;

//@Component
public class ElectricMotor1 extends AbstractMotor implements ElectricMotor {
    public void start() {
        System.out.println("Electric Motor 1 Started.");
    }
}
