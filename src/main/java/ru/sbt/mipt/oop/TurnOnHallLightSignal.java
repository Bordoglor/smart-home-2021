package ru.sbt.mipt.oop;

import org.springframework.stereotype.Component;

@Component
public class TurnOnHallLightSignal implements RemoteControlSignal{
    private final SmartHome smartHome;

    public TurnOnHallLightSignal(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    private void turnOnLight(Light light) {
        light.setOn(true);
        System.out.println("Hall-light was turned on.");
    }

    @Override
    public void execute() {
        smartHome.execute(o -> {
            if (!(o instanceof Room)) {
                return;
            }
            Room room = (Room) o;
            if ("hall".equals(room.getName())) {
                room.execute(c -> {
                    if (!(c instanceof Light)) {
                        return;
                    }
                    Light light = (Light) c;
                    turnOnLight(light);
                });
            }
        });
    }
}
