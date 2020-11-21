package ru.sbt.mipt.oop;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

public class Converter implements EventHandler {
    private Controllable controllable;
    private SmartHome smartHome;
    private Map<String, SensorEventType> converterMap;

    public Converter(Controllable controllable, SmartHome smartHome, Map<String, SensorEventType> converterMap) {
        this.controllable = controllable;
        this.smartHome = smartHome;
        this.converterMap = converterMap;
    }

    @Override
    public void handleEvent(CCSensorEvent event) {
        SensorEvent sensorEvent = new SensorEventAdapter(event, converterMap).getSensorEvent();
        controllable.manage(smartHome, sensorEvent);
    }
}
