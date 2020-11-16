package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.SensorEventType.*;
import static ru.sbt.mipt.oop.SensorEventType.DOOR_CLOSED;

public class DecoratorAlarm implements Controllable {

    private Controllable controllable;

    public DecoratorAlarm(Controllable controllable) {
        this.controllable = controllable;
    }

    @Override
    public void manage(SmartHome smartHome, SensorEvent event) {
        Alarm alarm = smartHome.alarm;
        controllable.manage(smartHome, event);
        if (!(event.getType() == ALARM_ACTIVATE || event.getType() == ALARM_DEACTIVATE) && alarm.getState() instanceof AlarmActive){
            alarm.alarmAlert();
            System.out.println("Alert");
        }
    }
}
