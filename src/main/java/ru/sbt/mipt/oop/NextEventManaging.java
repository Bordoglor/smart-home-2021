package ru.sbt.mipt.oop;

<<<<<<< Updated upstream
import java.util.concurrent.ThreadLocalRandom;

<<<<<<< Updated upstream
public class NextEventManaging {
=======
public class NextEventManaging implements NextEventManageable{
>>>>>>> Stashed changes
=======
import org.springframework.stereotype.Component;

import java.util.concurrent.ThreadLocalRandom;

@Component
public class NextEventManaging implements NextEventManageable{
>>>>>>> Stashed changes
    public SensorEvent getNextSensorEvent() {
        // pretend like we're getting the events from physical world, but here we're going to just generate some random events
        if (Math.random() < 0.05) return null; // null means end of event stream
        SensorEventType sensorEventType = SensorEventType.values()[(int) (6 * Math.random())];
<<<<<<< Updated upstream
<<<<<<< Updated upstream
        sensorEventType.setCode(Integer.toString(ThreadLocalRandom.current().nextInt(9999)));
=======
>>>>>>> Stashed changes
=======
>>>>>>> Stashed changes
        String objectId = "" + ((int) (10 * Math.random()));
        SensorEvent sensorEvent = new SensorEvent(sensorEventType, objectId);
        sensorEvent.setCode(Integer.toString(ThreadLocalRandom.current().nextInt(9999)));
        return new SensorEvent(sensorEventType, objectId);
    }
}
