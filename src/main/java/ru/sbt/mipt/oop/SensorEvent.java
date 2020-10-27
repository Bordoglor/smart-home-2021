package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.DoorManaging.*;
import static ru.sbt.mipt.oop.SensorEventType.*;
import static ru.sbt.mipt.oop.SensorEventType.DOOR_CLOSED;

public class SensorEvent {
    private final SensorEventType type;
    private final String objectId;
    private String code;

    public SensorEvent(SensorEventType type, String objectId) {
        this.type = type;
        this.objectId = objectId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        if (this.getType() == ALARM_ACTIVATE || this.getType() == ALARM_DEACTIVATE){
            this.code = code;
        }
    }


    public SensorEventType getType() {
        return type;
    }

    public String getObjectId() {
        return objectId;
    }

    @Override
    public String toString() {
        return "SensorEvent{" +
                "type=" + type +
                ", objectId='" + objectId + '\'' +
                '}';
    }

}
