package ru.sbt.mipt.oop;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String... args) throws IOException {
        NextEventManaging nextEvent = new NextEventManaging();
        SmartHome smartHome = new SmartHomeReader().getSmartHome();
        Notifier notifier = new SMSNotifier();
        List<Controllable> managers= new ArrayList<>();
        managers.add(new DecoratorMessage(new DecoratorAlarm(new DoorManaging()), notifier));
        managers.add(new DecoratorMessage(new DecoratorAlarm(new LightManaging()), notifier));
        managers.add(new DecoratorMessage(new DecoratorAlarm(new DoorHallManaging()), notifier));
        EventAction actions = new EventAction(managers, nextEvent);
        // считываем состояние дома из файла
        // начинаем цикл обработки событий
        SensorEvent event = nextEvent.getNextSensorEvent();
        actions.actEvent(smartHome, event);
    }
}
