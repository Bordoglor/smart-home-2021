package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.DoorManaging.doorManage;
import static ru.sbt.mipt.oop.SensorEventType.*;
import static ru.sbt.mipt.oop.SensorEventType.DOOR_CLOSED;

public class EventManaging {
    public static void eventManage(SmartHome smartHome, SensorEvent event) {
        System.out.println("Got event: " + event);
        if (event.getType() == LIGHT_ON || event.getType() == LIGHT_OFF) {
            LightManaging.lightManage(smartHome, event);
        }
        if (event.getType() == DOOR_OPEN || event.getType() == DOOR_CLOSED) {
            // событие от двери
            doorManage(smartHome, event);
        }
    }
}
