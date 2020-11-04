package ru.sbt.mipt.oop;

import org.springframework.stereotype.Component;

@Component
public class TurnOffLightsSignal implements RemoteControlSignal{
    private final SmartHome smartHome;

    public TurnOffLightsSignal(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    private void setOffLight(Light light) {
        light.setOn(false);
        System.out.println("Light " + light.getId() + " was turned off.");
    }

    @Override
    public void execute() {
        smartHome.execute(o -> {
            if (!(o instanceof Light)) {
                return;
            }
            Light light = (Light) o;
                setOffLight(light);
        });
    }
}
