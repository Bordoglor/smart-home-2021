package ru.sbt.mipt.oop;

import org.springframework.stereotype.Component;

@Component
public class TurnOnLightsSignal implements RemoteControlSignal{
    private final SmartHome smartHome;

    public TurnOnLightsSignal(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    private void setOnLight(Light light) {
        light.setOn(true);
        System.out.println("Light " + light.getId() + " was turned on.");
    }

    @Override
    public void execute() {
        smartHome.execute(o -> {
            if (!(o instanceof Light)) {
                return;
            }
            Light light = (Light) o;
            setOnLight(light);
        });
    }
}
