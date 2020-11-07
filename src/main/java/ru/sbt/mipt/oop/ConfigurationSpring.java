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
    public SensorEventsManager sensorEvent(Collection<Controllable> managers, SmartHome smartHome, Converter converter){
        SensorEventsManager sensorEventsManager= new SensorEventsManager();
        managers.stream()
                .map(manager -> new SensorEventAdapter(manager, smartHome, converter))
                .forEach(sensorEventsManager::registerEventHandler);
        return sensorEventsManager;
    }

    @Bean
    public Controllable doorManaging(){
        return new DecoratorAlarm(new DoorManaging());
    }

    @Bean
    public Controllable lightManaging(){
        return new DecoratorAlarm(new LightManaging());
    }

    @Bean
    public Controllable doorHallManaging(){
        return new DecoratorAlarm(new DecoratorMessage(new DoorHallManaging()));
    }

    @Bean
    public RemoteControlRegistry remoteControlRegistry(Collection<RemoteControl> remoteControls) {
        RemoteControlRegistry registry = new RemoteControlRegistry();
        remoteControls.forEach(e -> {
            registry.registerRemoteControl(e);
        });
        return registry;
    }

    @Bean
    public SmartHomeRemoteControl smartHomeRemoteControl(Map<String, RemoteControlSignal> commands) {
        Map<String, String> nameToCode = Map.of(
                "turnOnLightsSignal", "A",
                "closeHallDoorSignal", "B",
                "turnOnHallLightSignal", "C",
                "alarmActivateSignal", "D",
                "alarmAlertSignal", "1",
                "turnOffLightsSignal", "2"
        );
        SmartHomeRemoteControl remoteControl = new SmartHomeRemoteControl();
        commands.forEach((k, v) -> {
            remoteControl.setButton(nameToCode.get(k), v);
        });
        return remoteControl;
    }
}
