package ru.sbt.mipt.oop;

public class AlarmActive implements AlarmState {

    private Alarm alarm;

    @Override
    public void activate(String code) {
    }

    @Override
    public void deactivate(String code) {
        alarm.setState(new AlarmDeactive());
    }

    @Override
    public void alarmAlert() {

    }
}
