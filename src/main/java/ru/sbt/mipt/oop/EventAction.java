package ru.sbt.mipt.oop;


import java.util.List;

public class EventAction{
    private List<Controllable> managers;
    private NextEventManaging nextEvent;

    public EventAction(List<Controllable> managers, NextEventManaging nextEvent) {
        this.managers = managers;
        this.nextEvent = nextEvent;
    }

    public void actEvent(SmartHome smartHome, SensorEvent event) {
        while (event != null) {
            System.out.println("Got event: " + event);
            for (Controllable manager: managers) {
                manager.manage(smartHome, event);
            }
            event = nextEvent.getNextSensorEvent();
        }
    }
}
