package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.SensorEventType.*;

public class AlarmManaging implements Controllable {

    @Override
    public void manage(SmartHome smartHome, SensorEvent event) {
        if (event.getType() == ALARM_ACTIVATE || event.getType() == ALARM_DEACTIVATE) {
            smartHome.execute(object -> {if (object instanceof Alarm){
                Alarm alarm = (Alarm) object;
                if (event.getType() == ALARM_ACTIVATE) {
                    alarm.activate(event.getCode());
                } else {
                    alarm.deactivate(event.getCode());
                }
                    }
                } );
        }
    }
}
