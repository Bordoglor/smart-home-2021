package ru.sbt.mipt.oop;

import static main.java.ru.sbt.mipt.oop.EventManaging.eventManage;

public class Action {
    public static void actEvent(SmartHome smartHome, SensorEvent event) {
        while (event != null) {
            eventManage(smartHome, event);
            event = NextEventManaging.getNextSensorEvent();
        }
    }
}
