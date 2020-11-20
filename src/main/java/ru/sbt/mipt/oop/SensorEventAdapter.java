package ru.sbt.mipt.oop;

import org.springframework.stereotype.Component;

import java.util.Map;

public class SensorEventAdapter {
    private final SensorEvent sensorEvent;

    public SensorEvent getSensorEvent() {
        return sensorEvent;
    }

    public SensorEventAdapter(CCSensorEvent ccSensorEvent, Map<String, SensorEventType> converterMap) {
        this.sensorEvent = new SensorEvent(converterMap
                .get(ccSensorEvent.getEventType()), ccSensorEvent.getObjectId());
    }
}