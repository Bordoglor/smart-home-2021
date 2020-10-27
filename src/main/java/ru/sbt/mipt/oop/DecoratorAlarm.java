package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.SensorEventType.*;
import static ru.sbt.mipt.oop.SensorEventType.DOOR_CLOSED;

<<<<<<< Updated upstream
<<<<<<< Updated upstream
public class DecoratorAlarm implements Manageable{

    private Manageable manageable;

    public DecoratorAlarm(Manageable manageable) {
        this.manageable = manageable;
=======
=======
>>>>>>> Stashed changes
public class DecoratorAlarm implements Controllable {

    private Controllable controllable;

    public DecoratorAlarm(Controllable controllable) {
        this.controllable = controllable;
<<<<<<< Updated upstream
>>>>>>> Stashed changes
=======
>>>>>>> Stashed changes
    }

    @Override
    public void manage(SmartHome smartHome, SensorEvent event) {
<<<<<<< Updated upstream
<<<<<<< Updated upstream
        if ((event.getType() == LIGHT_ON || event.getType() == LIGHT_OFF) ||
                (event.getType() == DOOR_OPEN || event.getType() == DOOR_CLOSED) &&
                        (smartHome.getState() instanceof AlarmActive)){
            smartHome.alarm.alarmAlert();
            System.out.println("Alert");
        } else if (smartHome.getState() instanceof AlarmDeactive){
            manageable.manage(smartHome, event);
            }
        }
=======
=======
>>>>>>> Stashed changes
        Alarm alarm = smartHome.alarm;
        controllable.manage(smartHome, event);
        if (!(event.getType() == ALARM_ACTIVATE || event.getType() == ALARM_DEACTIVATE) && alarm.getState() instanceof AlarmActive){
            alarm.alarmAlert();
            System.out.println("Alert");
        }
    }
<<<<<<< Updated upstream
>>>>>>> Stashed changes
=======
>>>>>>> Stashed changes
}