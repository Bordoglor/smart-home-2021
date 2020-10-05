package ru.sbt.mipt.oop;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//import static ru.sbt.mipt.oop.EventAction.actEvent;

public class Application {

    public static void main(String... args) throws IOException {
        NextEventManaging nextEvent = new NextEventManaging();
        SmartHome smartHome = new SmartHomeReader().getSmartHome();
        List<Manageable> managers= new ArrayList<>();
        managers.add(new DoorManaging());
        managers.add(new LightManaging());
        EventAction actions = new EventAction(managers, nextEvent);
        // считываем состояние дома из файла
        // начинаем цикл обработки событий
        SensorEvent event = nextEvent.getNextSensorEvent();
        //getEvent(smartHome, event);
        actions.actEvent(smartHome, event);
    }



    public static void sendCommand(SensorCommand command) {
        System.out.println("Pretent we're sending command " + command);
    }
}