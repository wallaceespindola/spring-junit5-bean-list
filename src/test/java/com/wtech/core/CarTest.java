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
public class CarTest {

    @Test
    public void givenPrototypeInjection_WhenObjectFactory_ThenNewInstanceReturn() {

        ApplicationContext context = new AnnotationConfigApplicationContext(SpringBeansConfig.class);
        Car crazyCar = context.getBean(CrazyMultiMotorCar.class);

        ApplicationContext xmlContext = new ClassPathXmlApplicationContext("SpringBeans.xml");
        Car teslaCar = xmlContext.getBean(TeslaModelX.class);

        assertThat(crazyCar).isNotSameAs(teslaCar);
        assertThat(crazyCar).hasToString("Car [CrazyMultiMotorCar] - Engine [Eng v8 vol 5] - Transmission [Trans manual]");
        assertThat(teslaCar).hasToString("Car [TeslaModelX] - Engine [Eng v4 vol 2] - Transmission [Trans sliding]");
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
        assertThat(teslaCar).hasToString("Car [TeslaModelX] - Engine [Eng v4 vol 2] - Transmission [Trans sliding]");
    }

    @Test
    void givenCarIsCrazy_WhenInstantiated_ThenItHas4DifferentMotors() {

        ApplicationContext context = new AnnotationConfigApplicationContext(SpringBeansConfig.class);
        Car crazyCar = context.getBean(CrazyMultiMotorCar.class);

        assertThat(crazyCar).isNotNull();
        assertThat(crazyCar.getMotor()).isNotNull();
        assertThat(crazyCar.getMotor()).isNotEmpty();
        assertThat(crazyCar.getMotor()).hasSize(4);
        assertThat(crazyCar).hasToString("Car [CrazyMultiMotorCar] - Engine [Eng v8 vol 5] - Transmission [Trans manual]");
    }

}
