package ru.sbt.mipt.oop;

import org.springframework.stereotype.Component;

@Component
public class AlarmAlertSignal implements RemoteControlSignal{
    private final SmartHome smartHome;

    public AlarmAlertSignal(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public void execute() {
        smartHome.execute(o -> {
            if (o instanceof Alarm) {
                ((Alarm) o).alarmAlert();
            }
        });
    }
}
