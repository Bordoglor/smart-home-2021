package ru.sbt.mipt.oop;

import org.springframework.stereotype.Component;

@Component
public class CloseHallDoorSignal implements RemoteControlSignal{
    private final SmartHome smartHome;

    public CloseHallDoorSignal(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    private void closeDoor(Door door) {
        door.setOpen(false);
        System.out.println("Hall-door was closed.");
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
                    if (!(c instanceof Door)) {
                        return;
                    }
                    Door door = (Door) c;
                    closeDoor(door);
                });
            }
        });
    }
}
