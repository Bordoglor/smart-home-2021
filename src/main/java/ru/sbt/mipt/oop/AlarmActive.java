package ru.sbt.mipt.oop;

public class AlarmActive implements State{

    private Alarm alarm;

    @Override
    public void activate(String code) {

    }

    @Override
    public void deactivate(String code) {
        alarm.deactivate(code);
    }

    @Override
    public void alarmAlert() {

    }
}
