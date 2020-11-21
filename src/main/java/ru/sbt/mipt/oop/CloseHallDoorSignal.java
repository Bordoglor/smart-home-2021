package ru.sbt.mipt.oop;

import org.springframework.stereotype.Component;

@Component
public class CloseHallDoorSignal implements RemoteControlSignal{
    private final SmartHome smartHome;

    public CloseHallDoorSignal(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public void execute() {
        smartHome.execute(object -> {
            if (!(object instanceof Room)) {
                return;
            }
            Room room = (Room) object;
            if (room.getName().equals("hall")) {
                room.execute(obj -> {
                    if (!(obj instanceof Door)) {
                        return;
                    }
                    Door door = (Door) obj;
                    door.setOpen(false);
                    System.out.println("Hall door was closed.");
                });
            }
        });
    }
}
