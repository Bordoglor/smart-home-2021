package ru.sbt.mipt.oop;

<<<<<<< Updated upstream
<<<<<<< Updated upstream
public class AlarmDeactive implements State{
=======
public class AlarmDeactive implements AlarmState {
>>>>>>> Stashed changes
=======
public class AlarmDeactive implements AlarmState {
>>>>>>> Stashed changes

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
