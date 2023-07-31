package com.wtech.core.car;

import com.wtech.core.motor.Motor;
import com.wtech.core.parts.Engine;
import com.wtech.core.parts.Transmission;

import java.util.List;

public abstract class AbstractCar implements Car {

    protected List<Motor> motor;

    protected Engine engine;

    protected Transmission transmission;

    public List<Motor> getMotor() {
        return motor;
    }

    public void setMotor(List<Motor> motor) {
        this.motor = motor;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    public void goForward() {
        for (Motor m : motor) {
            m.start();
        }
        System.out.println(this.getClass().getSimpleName() + " is going forward.");
    }

    @Override
    public String toString() {
        return String.format("Car [%s] - Motor [%s] - Engine [%s] - Transmission [%s]", this.getClass().getSimpleName(), motor, engine, transmission);
    }
}
