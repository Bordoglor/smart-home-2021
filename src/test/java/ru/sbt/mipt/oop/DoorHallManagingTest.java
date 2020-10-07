package ru.sbt.mipt.oop;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static ru.sbt.mipt.oop.SensorEventType.DOOR_CLOSED;

class DoorHallManagingTest {

    @Test
    void doorHallManageTestLightOff() {
        //Door door = new Door(true, "4");
        Light light1 = new Light("7", true);
        Light light2 = new Light("8", true);
        Room hall = new Room(Arrays.asList(light1, light2), Arrays.asList(new Door(true, "4")), "hall");
        SmartHome smartHome = new SmartHome(Arrays.asList(hall));
        List<Manageable> managers = new ArrayList<>();
        managers.add(new LightManaging());
        managers.add(new DoorHallManaging());
        SensorEvent event = new SensorEvent(DOOR_CLOSED, "4");
        for (Manageable manager: managers) {
            manager.manage(smartHome, event);
        }

        boolean light1Result = light1.isOn();
        boolean light2Result = light2.isOn();
        assertFalse(light1Result);
        assertFalse(light2Result);
    }

    @Test
    void doorHallManageTestLightOffAnotherRoom() {
        Light light1 = new Light("4", true);
        Light light2 = new Light("5", true);
        Room bedroom = new Room(Arrays.asList(light1, light2),
                Arrays.asList(new Door(true, "3")),
                "bedroom");
        Room hall = new Room(Arrays.asList(new Light("7", false)), Arrays.asList(new Door(true, "4")), "hall");
        SmartHome smartHome = new SmartHome(Arrays.asList(bedroom, hall));
        List<Manageable> managers = new ArrayList<>();
        managers.add(new DoorManaging());
        managers.add(new LightManaging());
        managers.add(new DoorHallManaging());
        SensorEvent event = new SensorEvent(DOOR_CLOSED, "4");
        for (Manageable manager: managers) {
            manager.manage(smartHome, event);
        }

        boolean light1Result = light1.isOn();
        boolean light2Result = light2.isOn();
        assertFalse(light1Result);
        assertFalse(light2Result);
    }
}