package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.SensorEventType.*;

<<<<<<< Updated upstream
public class DecoratorMessage implements Manageable{

    private Manageable manageable;

    public DecoratorMessage(Manageable manageable) {
        this.manageable = manageable;
=======
public class DecoratorMessage implements Controllable {

    private Controllable controllable;

    public DecoratorMessage(Controllable controllable) {
        this.controllable = controllable;
>>>>>>> Stashed changes
    }

    @Override
    public void manage(SmartHome smartHome, SensorEvent event) {
<<<<<<< Updated upstream
        if (! (event.getType() == DOOR_OPEN || event.getType() == DOOR_CLOSED ||
                event.getType() == LIGHT_ON || event.getType() == LIGHT_OFF)){
            return;
        }
        if (smartHome.getState() instanceof AlarmDeactive){
            manageable.manage(smartHome, event);
        } else if (smartHome.getState() instanceof AlarmAlert){
            System.out.println("Sending sms");
        }
=======
        Alarm alarm = smartHome.alarm;
        if (!(event.getType() == ALARM_ACTIVATE || event.getType() == ALARM_DEACTIVATE)){
            System.out.println("Sending sms");
        }
        if (smartHome.getState() instanceof AlarmDeactive) {
            controllable.manage(smartHome, event);
        }
>>>>>>> Stashed changes
    }
}