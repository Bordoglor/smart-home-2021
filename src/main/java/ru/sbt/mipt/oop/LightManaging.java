package ru.sbt.mipt.oop;

<<<<<<< Updated upstream
=======
import org.springframework.stereotype.Component;

>>>>>>> Stashed changes
import static ru.sbt.mipt.oop.SensorEventType.LIGHT_OFF;
import static ru.sbt.mipt.oop.SensorEventType.LIGHT_ON;

public class LightManaging implements Controllable {
<<<<<<< Updated upstream


=======
>>>>>>> Stashed changes
    public void manage(SmartHome smartHome, SensorEvent event) {
        // событие от источника света
        System.out.println("Got event: " + event);
        if (event.getType() == LIGHT_ON || event.getType() == LIGHT_OFF) {
            smartHome.execute(object -> {if (object instanceof Light){
                Light light = (Light) object;
                if (light.getId().equals(event.getObjectId())) {
                    if (event.getType() == LIGHT_ON) {
                        light.setOn(true);
                    } else {
                        light.setOn(false);
                    }
                }
            }
            } );
        }
    }
}
