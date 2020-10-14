package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.Application.sendCommand;
import static ru.sbt.mipt.oop.SensorEventType.DOOR_CLOSED;

public class DoorHallManaging implements Manageable {

    @Override
    public void manage(SmartHome smartHome, SensorEvent event) {
        if (event.getType() == DOOR_CLOSED){
            smartHome.execute(object -> {
                if (object instanceof Room){
                    Room room = (Room) object;
                    if (room.getName().equals("hall")) {
                        room.execute(object1 -> {
                        if (object1 instanceof Door){
                            Door door = (Door) object1;
                            if (door.getId().equals(event.getObjectId())){
                                this.allLightOff(smartHome);
                            }

                        }
                    });
                }
                }
        });
    }
    }

    private void allLightOff(SmartHome smartHome) {
        smartHome.execute(object -> {
            if (object instanceof Light){
                Light light = (Light) object;
                light.setOn(false);
                SensorCommand command = new SensorCommand(CommandType.LIGHT_OFF, light.getId());
                sendCommand(command);
            }
        });
    }
}
