package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.Application.sendCommand;

public class AllLightManaging {
    public static void allLightOff(SmartHome smartHome) {
            for (Room homeRoom : smartHome.getRooms()) {
                for (Light light : homeRoom.getLights()) {
                    light.setOn(false);
                    SensorCommand command = new SensorCommand(CommandType.LIGHT_OFF, light.getId());
                    sendCommand(command);
                }
            }
        }
    }

