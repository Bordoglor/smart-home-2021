package ru.sbt.mipt.oop;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class Converter {
    Map<String, SensorEventType> hashMap = new HashMap<>();

    public Converter(){
        hashMap.put("LightIsOn", SensorEventType.LIGHT_ON);
        hashMap.put("LightIsOff", SensorEventType.LIGHT_OFF);
        hashMap.put("DoorIsOpen", SensorEventType.DOOR_OPEN);
        hashMap.put("DoorIsClosed", SensorEventType.DOOR_CLOSED);
        hashMap.put("DoorIsLocked", SensorEventType.ALARM_ACTIVATE);
        hashMap.put("DoorIsUnlocked", SensorEventType.ALARM_DEACTIVATE);
    }

    public SensorEvent convertEvent(CCSensorEvent event) {
        return new SensorEvent(hashMap.get(event.getEventType()), event.getObjectId());
    }
}
