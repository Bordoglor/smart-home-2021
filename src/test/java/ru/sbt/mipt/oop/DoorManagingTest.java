package ru.sbt.mipt.oop;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
<<<<<<< Updated upstream
import static ru.sbt.mipt.oop.SensorEventType.DOOR_CLOSED;
import static ru.sbt.mipt.oop.SensorEventType.DOOR_OPEN;
=======
import static ru.sbt.mipt.oop.SensorEventType.*;
>>>>>>> Stashed changes

class DoorManagingTest {


    @Test
    void doorManageTestDoorIsOpened() {
<<<<<<< Updated upstream
=======
        Alarm alarm = new Alarm();
>>>>>>> Stashed changes
        Door door = new Door(false, "1");
        Room kitchen = new Room(Arrays.asList(new Light("1", false), new Light("2", true)),
                Arrays.asList(door),
                "kitchen");
        SmartHome smartHome = new SmartHome(Arrays.asList(kitchen));
<<<<<<< Updated upstream
        List<Manageable> managers = new ArrayList<>();
        managers.add(new DoorManaging());

        SensorEvent event = new SensorEvent(DOOR_OPEN, "1");
        for (Manageable manager : managers) {
=======
        List<Controllable> managers = new ArrayList<>();
        managers.add(new DoorManaging());

        SensorEvent event = new SensorEvent(DOOR_OPEN, "1");
        for (Controllable manager : managers) {
>>>>>>> Stashed changes
            manager.manage(smartHome, event);
        }
        boolean result = door.isOpen();
        assertTrue(result);

    }

    @Test
    void doorManageTestDoorIsClosed() {
<<<<<<< Updated upstream
=======
        Alarm alarm = new Alarm();
>>>>>>> Stashed changes
        Door door = new Door(true, "1");
        Room kitchen = new Room(Arrays.asList(new Light("1", false),
                new Light("2", true)),
                Arrays.asList(door),
                "kitchen");
        SmartHome smartHome = new SmartHome(Arrays.asList(kitchen));
<<<<<<< Updated upstream
        List<Manageable> managers = new ArrayList<>();
        managers.add(new DoorManaging());

        SensorEvent event = new SensorEvent(DOOR_CLOSED, "1");
        for (Manageable manager : managers) {
=======
        List<Controllable> managers = new ArrayList<>();
        managers.add(new DoorManaging());

        SensorEvent event = new SensorEvent(DOOR_CLOSED, "1");
        for (Controllable manager : managers) {
>>>>>>> Stashed changes
            manager.manage(smartHome, event);
        }
        boolean result = door.isOpen();
        assertFalse(result);

    }
}