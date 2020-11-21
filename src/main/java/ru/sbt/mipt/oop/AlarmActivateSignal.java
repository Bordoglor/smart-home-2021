package ru.sbt.mipt.oop;

import org.springframework.stereotype.Component;

@Component
public class AlarmActivateSignal implements RemoteControlSignal{
    private final SmartHome smartHome;

    public AlarmActivateSignal(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public void execute() {
        smartHome.execute(object -> {
            if (object instanceof Alarm) {
                Alarm alarm = (Alarm) object;
                alarm.activate("0");
            }
        });
    }
}
