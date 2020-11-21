package ru.sbt.mipt.oop;

public class AlarmAlert implements AlarmState {

    private Alarm alarm;

    @Override
    public void activate(String code) {

    }

    @Override
    public void deactivate(String code) {
        if (alarm.getCode().equals(code)) {
            alarm.setState(new AlarmDeactive());
        }
    }

    @Override
    public void alarmAlert() {
        alarm.setState(new AlarmAlert());
    }
}
