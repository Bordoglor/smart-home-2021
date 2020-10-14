package ru.sbt.mipt.oop;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static ru.sbt.mipt.oop.SensorEventType.ALARM_ACTIVATE;
import static ru.sbt.mipt.oop.SensorEventType.ALARM_DEACTIVATE;

class AlarmTest {

    @Test
    void activateIfDeactivateTest() {
        Room kitchen = new Room(Arrays.asList(new Light("1", false), new Light("2", true)),
                Arrays.asList(new Door(false, "1")),
                "kitchen");

        Alarm alarm = new Alarm();
        //SmartHome smartHome = new SmartHome(Arrays.asList(kitchen), alarm);
        String code = "12345";
        alarm.activate(code);
        assertTrue(alarm.getState() instanceof AlarmActive);
    }

    @Test
    void activateIfActivateTest(){
        Room kitchen = new Room(Arrays.asList(new Light("1", false), new Light("2", true)),
                Arrays.asList(new Door(false, "1")),
                "kitchen");

        Alarm alarm = new Alarm();
        alarm.setState(new AlarmActive());
        //SmartHome smartHome = new SmartHome(Arrays.asList(kitchen), alarm);
        String code = "12345";
        alarm.activate(code);
        assertTrue(alarm.getState() instanceof AlarmActive);
    }

    @Test
    void deactivateIfDeactivateTest(){
        Alarm alarm = new Alarm();
        alarm.setState(new AlarmDeactive());
        alarm.setCode("1111");
        String code = "12345";
        alarm.deactivate(code);
        assertTrue(alarm.getState() instanceof AlarmDeactive);
    }
    @Test
    void deactivateIfActivateTest() {
        //Room kitchen = new Room(Arrays.asList(new Light("1", false), new Light("2", true)),
          //      Arrays.asList(new Door(false, "1")),
            //    "kitchen");
        Alarm alarm = new Alarm();
        alarm.setCode("12345");
        alarm.setState(new AlarmActive());
        //SmartHome smartHome = new SmartHome(Arrays.asList(kitchen));
        String code = "12345";
        alarm.deactivate(code);
        assertTrue(alarm.getState() instanceof AlarmDeactive);
    }

    @Test
    void alarmAlertIfPasswordIsWrongTest() {
        Alarm alarm = new Alarm();
        alarm.setState(new AlarmActive());
        String code = "54321";
        alarm.deactivate(code);
        assertTrue(alarm.getState() instanceof AlarmAlert);
    }

    @Test
    void alarmAlearDeactiveIfPasswordIsCorrectTest() {
        Alarm alarm = new Alarm();
        String code = "12345";
        alarm.setCode(code);
        alarm.setState(new AlarmAlert());
        alarm.deactivate(code);
        assertTrue(alarm.getState() instanceof AlarmDeactive);
    }
}