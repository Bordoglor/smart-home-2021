package ru.sbt.mipt.oop;

import org.springframework.stereotype.Component;

@Component
public class TurnOnLightsSignal implements RemoteControlSignal{
    private final SmartHome smartHome;

    public TurnOnLightsSignal(SmartHome smartHome) {
        this.smartHome = smartHome;
    }


    @Override
    public void execute() {
        smartHome.execute(object -> {
            if (!(object instanceof Light)) {
                return;
            }
            Light light = (Light) object;
            light.setOn(true);
            System.out.println("Light " + light.getId() + " was turned on.");
        });
    }
}
