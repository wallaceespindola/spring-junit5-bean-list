package com.wtech.core;

import com.wtech.core.car.Car;
import com.wtech.core.car.CrazyMultiMotorCar;
import com.wtech.core.car.TeslaModelX;
import com.wtech.core.config.SpringBeansConfig;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(loader = AnnotationConfigContextLoader.class, classes = Config.class)
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {SpringBeansConfig.class })
class CarTest {

    @Test
    void givenPrototypeInjection_WhenObjectFactory_ThenNewInstanceReturn() {

        ApplicationContext context = new AnnotationConfigApplicationContext(SpringBeansConfig.class);
        Car crazyCar = context.getBean(CrazyMultiMotorCar.class);

        ApplicationContext xmlContext = new ClassPathXmlApplicationContext("SpringBeans.xml");
        Car teslaCar = xmlContext.getBean(TeslaModelX.class);

        assertThat(crazyCar).isNotNull();
        assertThat(teslaCar).isNotNull();
        assertThat(crazyCar).isNotSameAs(teslaCar);
        assertThat(teslaCar).hasToString("Car [TeslaModelX] - Motor [[ElectricMotor1, ElectricMotor2]] - Engine [Eng v4 vol 2] - Transmission [Trans sliding]");
        assertThat(crazyCar).hasToString("Car [CrazyMultiMotorCar] - Motor [[CrazyMotor, CustomMotor, ThermicMotor]] - Engine [Eng v8 vol 5] - Transmission [Trans manual]");
    }

    @Test
    void givenCarIsTesla_WhenInstantiated_ThenItHas2ElectricMotors() {

        ApplicationContext xmlContext = new ClassPathXmlApplicationContext("SpringBeans.xml");
        Car teslaCar = xmlContext.getBean(TeslaModelX.class);

        assertThat(teslaCar).isNotNull();
        assertThat(teslaCar.getMotor()).isNotNull();
        assertThat(teslaCar.getMotor()).isNotEmpty();
        assertThat(teslaCar.getMotor()).hasSize(2);
        assertThat(teslaCar.getMotor().stream().allMatch(m -> m.toString().contains("Electric"))).isTrue();
    }

    @Test
    void givenCarIsCrazy_WhenInstantiated_ThenItHas4DifferentMotors() {

        ApplicationContext context = new AnnotationConfigApplicationContext(SpringBeansConfig.class);
        Car crazyCar = context.getBean(CrazyMultiMotorCar.class);

        assertThat(crazyCar).isNotNull();
        assertThat(crazyCar.getMotor()).isNotNull();
        assertThat(crazyCar.getMotor()).isNotEmpty();
        assertThat(crazyCar.getMotor()).hasSize(3);
        assertThat(crazyCar.getMotor().stream().noneMatch(m -> m.toString().contains("Electric"))).isTrue();
    }

}
