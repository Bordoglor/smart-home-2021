package ru.sbt.mipt.oop;

import java.util.Objects;

import static ru.sbt.mipt.oop.SensorEventType.DOOR_OPEN;

public class DoorManaging {

    public static void doorManage(SmartHome smartHome, SensorEvent event) {
        for (Room room : smartHome.getRooms()) {
            for (Door door : room.getDoors()) {
                if (door.getId().equals(event.getObjectId())) {
                    if (event.getType() == DOOR_OPEN) {
                        door.setOpen(true);
                        System.out.println("Door " + door.getId() + " in room " + Room.getName() + " was opened.");
                    } else {
                        door.setOpen(false);
                        System.out.println("Door " + door.getId() + " in room " + Room.getName() + " was closed.");
                        // если мы получили событие о закрытие двери в холле - это значит, что была закрыта входная дверь.
                        // в этом случае мы хотим автоматически выключить свет во всем доме (это же умный дом!)
                        if (Objects.equals(Room.getName(), "hall")) {
                            AllLightManaging.allLightOff(smartHome);
                        }
                    }
                }
            }
        }
    }
}
