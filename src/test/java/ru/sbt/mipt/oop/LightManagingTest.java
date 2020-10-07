package ru.sbt.mipt.oop;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static ru.sbt.mipt.oop.SensorEventType.*;

class LightManagingTest {

    @Test
    void lightManageTestLightIsOff() {
        Light light = new Light("3", true);
        Room bathroom = new Room(Arrays.asList(light),
                Arrays.asList(new Door(false, "2")),
                "bathroom");
        SmartHome smartHome = new SmartHome(Arrays.asList(bathroom));
        List<Manageable> managers = new ArrayList<>();
        managers.add(new LightManaging());

        SensorEvent event = new SensorEvent(LIGHT_OFF, "3");
        for (Manageable manager : managers) {
            manager.manage(smartHome, event);
        }
        boolean result = light.isOn();
        assertFalse(result);
    }

    @Test
    void lightManageTestLightIsOn() {
        Light light = new Light("3", false);
        Room bathroom = new Room(Arrays.asList(light),
                Arrays.asList(new Door(false, "2")),
                "bathroom");
        SmartHome smartHome = new SmartHome(Arrays.asList(bathroom));
        List<Manageable> managers = new ArrayList<>();
        managers.add(new LightManaging());

        SensorEvent event = new SensorEvent(LIGHT_ON, "3");
        for (Manageable manager : managers) {
            manager.manage(smartHome, event);
        }
        boolean result = light.isOn();
        assertTrue(result);
    }
}