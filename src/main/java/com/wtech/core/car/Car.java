package com.wtech.core.car;

import com.wtech.core.motor.Motor;

import java.util.List;

public interface Car {
    void goForward();

    List<Motor> getMotor();
}
