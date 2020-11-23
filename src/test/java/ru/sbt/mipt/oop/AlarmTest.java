package ru.sbt.mipt.oop;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class AlarmTest {

    @Test
    void activateIfDeactivateTest() {
        Room kitchen = new Room(Arrays.asList(new Light("1", false), new Light("2", true)),
                Arrays.asList(new Door(false, "1")),
                "kitchen");

        Alarm alarm = new Alarm();
        String code = "12345";
        alarm.activate(code);
        assertTrue(alarm.isActivated());
    }

    @Test
    void activateIfActivateTest(){
        Room kitchen = new Room(Arrays.asList(new Light("1", false), new Light("2", true)),
                Arrays.asList(new Door(false, "1")),
                "kitchen");

        Alarm alarm = new Alarm();
        alarm.setState(new AlarmActive());
        String code = "12345";
        alarm.activate(code);
        assertTrue(alarm.isActivated());
    }

    @Test
    void deactivateIfDeactivateTest(){
        Alarm alarm = new Alarm();
        alarm.setState(new AlarmDeactive());
        String code = "12345";
        alarm.deactivate(code);
        assertTrue(alarm.isDeactivated());
    }
    @Test
    void deactivateIfActivateTest() {
        Alarm alarm = new Alarm();
        alarm.setState(new AlarmActive());
        String code = "0";
        alarm.deactivate(code);
        assertTrue(alarm.isDeactivated());
    }

    @Test
    void alarmAlertIfPasswordIsWrongTest() {
        Alarm alarm = new Alarm();
        alarm.setState(new AlarmActive());
        String code = "54321";
        alarm.deactivate(code);
        assertTrue(alarm.isAlert());
    }

    @Test
    void alarmAlearDeactiveIfPasswordIsCorrectTest() {
        Alarm alarm = new Alarm();
        String code = "0";
        alarm.setState(new AlarmAlert());
        alarm.deactivate(code);
        assertTrue(alarm.isDeactivated());
    }
}