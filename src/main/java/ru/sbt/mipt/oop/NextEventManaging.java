package ru.sbt.mipt.oop;

import org.springframework.stereotype.Component;

import java.util.concurrent.ThreadLocalRandom;

@Component
public class NextEventManaging implements NextEventManageable{
    public SensorEvent getNextSensorEvent() {
        // pretend like we're getting the events from physical world, but here we're going to just generate some random events
        if (Math.random() < 0.05) return null; // null means end of event stream
        SensorEventType sensorEventType = SensorEventType.values()[(int) (6 * Math.random())];
        String objectId = "" + ((int) (10 * Math.random()));
        SensorEvent sensorEvent = new SensorEvent(sensorEventType, objectId);
        sensorEvent.setCode(Integer.toString(ThreadLocalRandom.current().nextInt(9999)));
        return new SensorEvent(sensorEventType, objectId);
    }
}
