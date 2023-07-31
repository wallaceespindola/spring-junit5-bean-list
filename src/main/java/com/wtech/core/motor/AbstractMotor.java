package com.wtech.core.motor;

public abstract class AbstractMotor implements Motor {

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
