package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.SensorEventType.*;
import static ru.sbt.mipt.oop.SensorEventType.DOOR_CLOSED;

public class DecoratorAlarm implements Manageable{

    private Manageable manageable;

    public DecoratorAlarm(Manageable manageable) {
        this.manageable = manageable;
    }

    @Override
    public void manage(SmartHome smartHome, SensorEvent event) {
        if ((event.getType() == LIGHT_ON || event.getType() == LIGHT_OFF) ||
                (event.getType() == DOOR_OPEN || event.getType() == DOOR_CLOSED) &&
                        (smartHome.getState() instanceof AlarmActive)){
            smartHome.alarm.alarmAlert();
            System.out.println("Alert");
        } else if (smartHome.getState() instanceof AlarmDeactive){
            manageable.manage(smartHome, event);
            }
        }
}