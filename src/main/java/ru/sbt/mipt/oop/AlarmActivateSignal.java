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
        smartHome.execute(o -> {
            if (o instanceof Alarm) {
                ((Alarm) o).activate("default_code");
            }
        });
    }
}
