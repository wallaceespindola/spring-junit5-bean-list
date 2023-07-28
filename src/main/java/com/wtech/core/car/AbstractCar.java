package com.wtech.core.car;

import com.wtech.core.motor.Motor;
import com.wtech.core.parts.Engine;
import com.wtech.core.parts.Transmission;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public abstract class AbstractCar implements Car {

    protected List<Motor> motor;

    protected Engine engine;

    protected Transmission transmission;

    public void goForward() {
        for (Motor m : motor) {
            m.start();
        }
        System.out.println(this.getClass().getSimpleName() + " is going forward.");
    }

    public List<Motor> getMotor() {
        return motor;
    }

    @Override
    public String toString() {
        return String.format("Car [%s] - Engine [%s] - Transmission [%s]", this.getClass().getSimpleName(), engine, transmission);
    }
}
