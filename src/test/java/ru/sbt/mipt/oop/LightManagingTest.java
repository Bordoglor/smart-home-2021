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
<<<<<<< Updated upstream
=======
        Alarm alarm = new Alarm();
>>>>>>> Stashed changes
        Light light = new Light("3", true);
        Room bathroom = new Room(Arrays.asList(light),
                Arrays.asList(new Door(false, "2")),
                "bathroom");
        SmartHome smartHome = new SmartHome(Arrays.asList(bathroom));
<<<<<<< Updated upstream
        List<Manageable> managers = new ArrayList<>();
        managers.add(new LightManaging());

        SensorEvent event = new SensorEvent(LIGHT_OFF, "3");
        for (Manageable manager : managers) {
=======
        List<Controllable> managers = new ArrayList<>();
        managers.add(new LightManaging());

        SensorEvent event = new SensorEvent(LIGHT_OFF, "3");
        for (Controllable manager : managers) {
>>>>>>> Stashed changes
            manager.manage(smartHome, event);
        }
        boolean result = light.isOn();
        assertFalse(result);
    }

    @Test
    void lightManageTestLightIsOn() {
<<<<<<< Updated upstream
=======
        Alarm alarm = new Alarm();
>>>>>>> Stashed changes
        Light light = new Light("3", false);
        Room bathroom = new Room(Arrays.asList(light),
                Arrays.asList(new Door(false, "2")),
                "bathroom");
        SmartHome smartHome = new SmartHome(Arrays.asList(bathroom));
<<<<<<< Updated upstream
        List<Manageable> managers = new ArrayList<>();
        managers.add(new LightManaging());

        SensorEvent event = new SensorEvent(LIGHT_ON, "3");
        for (Manageable manager : managers) {
=======
        List<Controllable> managers = new ArrayList<>();
        managers.add(new LightManaging());

        SensorEvent event = new SensorEvent(LIGHT_ON, "3");
        for (Controllable manager : managers) {
>>>>>>> Stashed changes
            manager.manage(smartHome, event);
        }
        boolean result = light.isOn();
        assertTrue(result);
    }
}