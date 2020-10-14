package ru.sbt.mipt.oop;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static ru.sbt.mipt.oop.SensorEventType.*;

class DoorManagingTest {


    @Test
    void doorManageTestDoorIsOpened() {
        Alarm alarm = new Alarm();
        Door door = new Door(false, "1");
        Room kitchen = new Room(Arrays.asList(new Light("1", false), new Light("2", true)),
                Arrays.asList(door),
                "kitchen");
        SmartHome smartHome = new SmartHome(Arrays.asList(kitchen));
        List<Manageable> managers = new ArrayList<>();
        managers.add(new DoorManaging());

        SensorEvent event = new SensorEvent(DOOR_OPEN, "1");
        for (Manageable manager : managers) {
            manager.manage(smartHome, event);
        }
        boolean result = door.isOpen();
        assertTrue(result);

    }

    @Test
    void doorManageTestDoorIsClosed() {
        Alarm alarm = new Alarm();
        Door door = new Door(true, "1");
        Room kitchen = new Room(Arrays.asList(new Light("1", false),
                new Light("2", true)),
                Arrays.asList(door),
                "kitchen");
        SmartHome smartHome = new SmartHome(Arrays.asList(kitchen));
        List<Manageable> managers = new ArrayList<>();
        managers.add(new DoorManaging());

        SensorEvent event = new SensorEvent(DOOR_CLOSED, "1");
        for (Manageable manager : managers) {
            manager.manage(smartHome, event);
        }
        boolean result = door.isOpen();
        assertFalse(result);

    }
}