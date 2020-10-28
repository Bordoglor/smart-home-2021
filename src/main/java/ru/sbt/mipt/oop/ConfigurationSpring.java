package ru.sbt.mipt.oop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Collection;

@Configuration
@ComponentScan
public class ConfigurationSpring {

    @Bean
    public SmartHome getSmartHome(SmartHomeReader smartHomeReader){
        return smartHomeReader.getSmartHome();
    }

    @Bean
    public SensorEventsManager getSensorEvent(Collection<Controllable> managers, SmartHome smartHome, Converter converter){
        SensorEventsManager sensorEventsManager= new SensorEventsManager();
        managers.stream()
                .map(manager -> new SensorEventAdapter(manager, smartHome, converter))
                .forEach(sensorEventsManager::registerEventHandler);
        return sensorEventsManager;
    }

    @Bean
    public Controllable getDoorManaging(){
        return new DecoratorAlarm(new DoorManaging());
    }

    @Bean
    public Controllable getLightManaging(){
        return new DecoratorAlarm(new LightManaging());
    }

    @Bean
    public Controllable getDoorHallManaging(){
        return new DecoratorAlarm(new DecoratorMessage(new DoorHallManaging()));
    }
}
