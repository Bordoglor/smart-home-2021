package ru.sbt.mipt.oop;

import java.util.concurrent.ThreadLocalRandom;

public class NextEventManaging {
    public SensorEvent getNextSensorEvent() {
        // pretend like we're getting the events from physical world, but here we're going to just generate some random events
        if (Math.random() < 0.05) return null; // null means end of event stream
        SensorEventType sensorEventType = SensorEventType.values()[(int) (6 * Math.random())];
        sensorEventType.setCode(Integer.toString(ThreadLocalRandom.current().nextInt(9999)));
        String objectId = "" + ((int) (10 * Math.random()));
        return new SensorEvent(sensorEventType, objectId);
    }
}
