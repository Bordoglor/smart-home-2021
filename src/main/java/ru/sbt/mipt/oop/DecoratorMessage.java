package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.SensorEventType.*;

public class DecoratorMessage implements Manageable{

    private Manageable manageable;

    public DecoratorMessage(Manageable manageable) {
        this.manageable = manageable;
    }

    @Override
    public void manage(SmartHome smartHome, SensorEvent event) {
        if (! (event.getType() == DOOR_OPEN || event.getType() == DOOR_CLOSED ||
                event.getType() == LIGHT_ON || event.getType() == LIGHT_OFF)){
            return;
        }
        if (smartHome.getState() instanceof AlarmDeactive){
            manageable.manage(smartHome, event);
        } else if (smartHome.getState() instanceof AlarmAlert){
            System.out.println("Sending sms");
        }
    }
}