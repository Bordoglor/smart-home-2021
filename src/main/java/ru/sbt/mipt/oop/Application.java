package ru.sbt.mipt.oop;

import java.io.IOException;

import static ru.sbt.mipt.oop.Action.actEvent;
import static ru.sbt.mipt.oop.SmartHomeReader.getSmartHome;

public class Application {

    public static void main(String... args) throws IOException {
        // считываем состояние дома из файла
        SmartHome smartHome = getSmartHome();
        // начинаем цикл обработки событий
        SensorEvent event = NextEventManaging.getNextSensorEvent();
        //getEvent(smartHome, event);
        actEvent(smartHome, event);
    }



    public static void sendCommand(SensorCommand command) {
        System.out.println("Pretent we're sending command " + command);
    }
}
