package ru.sbt.mipt.oop;

<<<<<<< Updated upstream
import static ru.sbt.mipt.oop.SensorEventType.*;

<<<<<<< Updated upstream
public class AlarmManaging implements Manageable{
=======
public class AlarmManaging implements Controllable {
>>>>>>> Stashed changes
=======
import org.springframework.stereotype.Component;

import static ru.sbt.mipt.oop.SensorEventType.*;

@Component
public class AlarmManaging implements Controllable {
>>>>>>> Stashed changes
    @Override
    public void manage(SmartHome smartHome, SensorEvent event) {
        if (event.getType() == ALARM_ACTIVATE || event.getType() == ALARM_DEACTIVATE) {
            smartHome.execute(object -> {if (object instanceof Alarm){
                Alarm alarm = (Alarm) object;
                if (event.getType() == ALARM_ACTIVATE) {
<<<<<<< Updated upstream
<<<<<<< Updated upstream
                    String currentCode = ALARM_ACTIVATE.getCode();
                    alarm.activate(currentCode);
                } else {
                    String currentCode = ALARM_DEACTIVATE.getCode();
                    alarm.deactivate(currentCode);
=======
                    alarm.activate(event.getCode());
                } else {
                    alarm.deactivate(event.getCode());
>>>>>>> Stashed changes
=======
                    alarm.activate(event.getCode());
                } else {
                    alarm.deactivate(event.getCode());
>>>>>>> Stashed changes
                }
                    }
                } );
        }
    }
}