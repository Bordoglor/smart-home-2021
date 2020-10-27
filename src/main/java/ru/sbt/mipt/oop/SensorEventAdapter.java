package ru.sbt.mipt.oop;

import java.util.Map;

public class SensorEventAdapter implements EventHandler{
    private Controllable controllable;
    private SmartHome smartHome;
    private Converter converter;

    public SensorEventAdapter(Controllable mn, SmartHome smartHome, Converter converter) {
        this.controllable = mn;
        this.smartHome = smartHome;
        this.converter = converter;
    }

    @Override
    public void handleEvent(CCSensorEvent event) {
        SensorEvent sensorEvent = converter.convertEvent(event);
        controllable.manage(smartHome, sensorEvent);
    }
}