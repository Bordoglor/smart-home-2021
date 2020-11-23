package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.SensorEventType.*;

public class DecoratorMessage implements Controllable {

    private Controllable controllable;
    private Notifier notifier;

    public DecoratorMessage(Controllable controllable, Notifier notifier) {
        this.controllable = controllable;
        this.notifier = notifier;
    }

    @Override
    public void manage(SmartHome smartHome, SensorEvent event) {
        Alarm alarm = smartHome.alarm;

        if (!(event.getType() == ALARM_ACTIVATE || event.getType() == ALARM_DEACTIVATE)){
            notifier.inform();
        }
        if (alarm.isDeactivated() == true) {
            controllable.manage(smartHome, event);
        }
    }
}
