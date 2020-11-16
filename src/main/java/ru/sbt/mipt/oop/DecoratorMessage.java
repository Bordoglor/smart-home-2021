package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.SensorEventType.*;

public class DecoratorMessage implements Controllable {

    private Controllable controllable;

    public DecoratorMessage(Controllable controllable) {
        this.controllable = controllable;
    }

    @Override
    public void manage(SmartHome smartHome, SensorEvent event) {
        Alarm alarm = smartHome.alarm;
        if (!(event.getType() == ALARM_ACTIVATE || event.getType() == ALARM_DEACTIVATE)){
            System.out.println("Sending sms");
        }
        if (smartHome.getState() instanceof AlarmDeactive) {
            controllable.manage(smartHome, event);
        }
    }
}
