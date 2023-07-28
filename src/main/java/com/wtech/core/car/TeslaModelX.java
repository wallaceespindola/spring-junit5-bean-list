package com.wtech.core.car;

import com.wtech.core.motor.Motor;
import com.wtech.core.parts.Engine;
import com.wtech.core.parts.Transmission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * This class is using SpringBeans.xml as config
 */
public class TeslaModelX extends AbstractCar {

    private TeslaModelX() {
        // prevent instantiation
    }

    //@Autowired
    public TeslaModelX(List<Motor> motor, Engine engine, Transmission transmission) {
        this.motor = motor;
        this.engine = engine;
        this.transmission = transmission;
    }

}
