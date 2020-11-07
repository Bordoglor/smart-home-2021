package ru.sbt.mipt.oop;

import org.springframework.stereotype.Component;

@Component
public class TurnOnHallLightSignal implements RemoteControlSignal{
    private final SmartHome smartHome;

    public TurnOnHallLightSignal(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public void execute() {
        smartHome.execute(object -> {
            if (!(object instanceof Room)) {
                return;
            }
            Room room = (Room) object;
            if ("hall".equals(room.getName())) {
                room.execute(obj -> {
                    if (!(obj instanceof Light)) {
                        return;
                    }
                    Light light = (Light) obj;
                    light.setOn(true);
                    System.out.println("Hall-light was turned on.");
                });
            }
        });
    }
}
