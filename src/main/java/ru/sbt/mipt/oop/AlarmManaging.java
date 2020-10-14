package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.SensorEventType.*;

public class AlarmManaging implements Manageable{
    @Override
    public void manage(SmartHome smartHome, SensorEvent event) {
        if (event.getType() == ALARM_ACTIVATE || event.getType() == ALARM_DEACTIVATE) {
            smartHome.execute(object -> {if (object instanceof Alarm){
                Alarm alarm = (Alarm) object;
                if (event.getType() == ALARM_ACTIVATE) {
                    String currentCode = ALARM_ACTIVATE.getCode();
                    alarm.activate(currentCode);
                } else {
                    String currentCode = ALARM_DEACTIVATE.getCode();
                    alarm.deactivate(currentCode);
                }
                    }
                } );
        }
    }
}