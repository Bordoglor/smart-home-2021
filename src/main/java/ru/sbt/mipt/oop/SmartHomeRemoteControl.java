package ru.sbt.mipt.oop;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class SmartHomeRemoteControl implements RemoteControl{
    private final Map<String, RemoteControlSignal> buttons = new HashMap<>();
    private final Set<String> codes = Set.of("A", "B", "C", "D", "1", "2", "3", "4");

    public void setButton(String buttonCode, RemoteControlSignal command) {
        if (codes.contains(buttonCode) && codes != null) {
            buttons.put(buttonCode, command);
        }
    }
    @Override
    public void onButtonPressed(String buttonCode) {
            buttons.get(buttonCode).execute();
    }
}
