package ru.sbt.mipt.oop;

import org.springframework.stereotype.Component;

@Component
public class TurnOffLightsSignal implements RemoteControlSignal{
    private final SmartHome smartHome;

    public TurnOffLightsSignal(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public void execute() {
        smartHome.execute(object -> {
            if (!(object instanceof Light)) {
                return;
            }
            Light light = (Light) object;
            light.setOn(false);
            System.out.println("Light " + light.getId() + " was turned off.");
        });
    }
}
