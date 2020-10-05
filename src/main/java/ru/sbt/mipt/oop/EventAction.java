package ru.sbt.mipt.oop;


import java.util.List;

public class EventAction{
    private List<Manageable> managers;
    private NextEventManaging nextEvent;

    public EventAction(List<Manageable> managers, NextEventManaging nextEvent) {
        this.managers = managers;
        this.nextEvent = nextEvent;
    }

    public void actEvent(SmartHome smartHome, SensorEvent event) {
        while (event != null) {
            System.out.println("Got event: " + event);
            for (Manageable manager: managers) {
                manager.manage(smartHome, event);
            }
            event = nextEvent.getNextSensorEvent();
        }
    }
}
