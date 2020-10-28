package ru.sbt.mipt.oop;

public class AlarmDeactive implements AlarmState {

    private Alarm alarm;

    @Override
    public void activate(String code) {
        alarm.activate(code);
    }

    @Override
    public void deactivate(String code) {

    }

    @Override
    public void alarmAlert() {

    }
}
