package com.wtech.core;


import com.wtech.core.car.CrazyMultiMotorCar;
import com.wtech.core.car.TeslaModelX;
import com.wtech.core.config.SpringBeansConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestCar {

    public static void main(String[] args) {
        testTesla();
        testCrazyCar();
    }

    private static void testTesla() {
        System.out.println("\nStarting test...");
        ApplicationContext context = new ClassPathXmlApplicationContext("SpringBeans.xml");
        TeslaModelX modelx = (TeslaModelX) context.getBean("modelX");
        System.out.println("Testing: " + modelx);
        modelx.goForward();
    }

    private static void testCrazyCar() {
        System.out.println("\nStarting test...");
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringBeansConfig.class);
        CrazyMultiMotorCar crazyCar = context.getBean(CrazyMultiMotorCar.class);
        System.out.println("Testing: " + crazyCar);
        crazyCar.goForward();
    }
}