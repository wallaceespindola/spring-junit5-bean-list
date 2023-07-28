package com.wtech.core.car;

import com.wtech.core.motor.Motor;
import com.wtech.core.parts.Engine;
import com.wtech.core.parts.Transmission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * This class is using SpringBeansConfig.java as config
 */
@Component
public class CrazyMultiMotorCar extends AbstractCar {

    public CrazyMultiMotorCar() {
        // prevent instantiation
    }

    @Autowired
    public CrazyMultiMotorCar(List<Motor> motor, Engine engine, Transmission transmission) {
        this.motor = motor;
        this.engine = engine;
        this.transmission = transmission;
    }

}
