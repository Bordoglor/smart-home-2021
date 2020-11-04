package ru.sbt.mipt.oop;

import org.springframework.stereotype.Component;

import static ru.sbt.mipt.oop.SensorEventType.LIGHT_OFF;
import static ru.sbt.mipt.oop.SensorEventType.LIGHT_ON;

public class LightManaging implements Controllable {
    public void manage(SmartHome smartHome, SensorEvent event) {
        // событие от источника света
        System.out.println("Got event: " + event);
        if (event.getType() == LIGHT_ON || event.getType() == LIGHT_OFF) {
            smartHome.execute(object -> {if (object instanceof Light){
                Light light = (Light) object;
                if (light.getId().equals(event.getObjectId())) {
                    if (event.getType() == LIGHT_ON) {
                        light.setOn(true);
                        System.out.println("Light " + light.getId() + " was turned on.");
                    } else {
                        light.setOn(false);
                        System.out.println("Light " + light.getId() + " was turned off.");
                    }
                }
            }
            } );
        }
    }
}
