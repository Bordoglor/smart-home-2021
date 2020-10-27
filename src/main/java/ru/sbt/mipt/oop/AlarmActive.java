package ru.sbt.mipt.oop;

<<<<<<< Updated upstream
<<<<<<< Updated upstream
public class AlarmActive implements State{
=======
public class AlarmActive implements AlarmState {
>>>>>>> Stashed changes
=======
public class AlarmActive implements AlarmState {
>>>>>>> Stashed changes

    private Alarm alarm;

    @Override
    public void activate(String code) {
<<<<<<< Updated upstream

=======
>>>>>>> Stashed changes
    }

    @Override
    public void deactivate(String code) {
<<<<<<< Updated upstream
<<<<<<< Updated upstream
        alarm.deactivate(code);
=======
        //alarm.deactivate(code);
        alarm.setState(new AlarmDeactive());
>>>>>>> Stashed changes
=======
        alarm.setState(new AlarmDeactive());
>>>>>>> Stashed changes
    }

    @Override
    public void alarmAlert() {

    }
}
