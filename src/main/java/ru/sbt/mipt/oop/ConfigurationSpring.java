package ru.sbt.mipt.oop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Collection;
import java.util.Map;

@Configuration
@ComponentScan
public class ConfigurationSpring {

    @Bean
    public SmartHome smartHome(SmartHomeReader smartHomeReader){
        return smartHomeReader.getSmartHome();
    }

    @Bean
    public SensorEventsManager sensorEvent(Collection<Converter> adapters){
        SensorEventsManager sensorEventsManager = new SensorEventsManager();
        adapters.forEach(sensorEventsManager::registerEventHandler);
        return sensorEventsManager;
    }

    @Bean
    public Map<String, SensorEventType> converterMap() {
        return Map.of("LightIsOn", SensorEventType.LIGHT_ON,
        "LightIsOff", SensorEventType.LIGHT_OFF,
        "DoorIsOpen", SensorEventType.DOOR_OPEN,
        "DoorIsClosed", SensorEventType.DOOR_CLOSED,
        "DoorIsLocked", SensorEventType.ALARM_ACTIVATE,
        "DoorIsUnlocked", SensorEventType.ALARM_DEACTIVATE);
    }

    @Bean
    public Converter doorManaging(SmartHome smartHome){
        return new Converter(new DecoratorAlarm(new DecoratorMessage(new DoorManaging())), smartHome, converterMap());
    }

    @Bean
    public Converter lightManaging(SmartHome smartHome){
        return new Converter(new DecoratorAlarm(new LightManaging()), smartHome, converterMap());
    }

    @Bean
    public Converter doorHallManaging(SmartHome smartHome){
        return new Converter(new DecoratorAlarm(new DoorHallManaging()), smartHome, converterMap());
    }

    @Bean
    public Converter signalingHandlerAdapter(AlarmManaging alarmManaging, SmartHome smartHome){
        return new Converter(alarmManaging, smartHome, converterMap());
    }
}
