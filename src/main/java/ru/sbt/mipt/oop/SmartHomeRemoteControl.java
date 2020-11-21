package ru.sbt.mipt.oop;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class SmartHomeRemoteControl implements RemoteControl{
    private final Map<String, RemoteControlSignal> buttons;

    public SmartHomeRemoteControl(Map<String, RemoteControlSignal> buttons) {
        this.buttons = buttons;
    }

    @Override
    public void onButtonPressed(String buttonCode) {
        if (buttons.containsKey(buttonCode)){
            buttons.get(buttonCode).execute();
        }
    }
}
