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

    @Bean
    public RemoteControlRegistry getRemoteControlRegistry(Collection<RemoteControl> remoteControls) {
        RemoteControlRegistry registry = new RemoteControlRegistry();
        remoteControls.forEach(e -> {
            registry.registerRemoteControl(e);
        });
        return registry;
    }

    @Bean
    public SmartHomeRemoteControl getSmartHomeRemoteControl(Map<String, RemoteControlSignal> commands) {
        Map<String, String> nameToCode = Map.of(
                "turnOnLightCommand", "A",
                "closeHallDoorCommand", "B",
                "turnOnHallLightCommand", "C",
                "activateSignalingCommand", "D",
                "alarmSignalingCommand", "1",
                "turnOffLightCommand", "2"
        );
        SmartHomeRemoteControl remoteControl = new SmartHomeRemoteControl();
        commands.forEach((k, v) -> {
            remoteControl.setButton(nameToCode.get(k), v);
        });
        return remoteControl;
    }
}
