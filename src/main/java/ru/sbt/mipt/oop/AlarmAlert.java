package ru.sbt.mipt.oop;

<<<<<<< Updated upstream
<<<<<<< Updated upstream
public class AlarmAlert implements State {
=======
public class AlarmAlert implements AlarmState {
>>>>>>> Stashed changes
=======
public class AlarmAlert implements AlarmState {
>>>>>>> Stashed changes

    private Alarm alarm;

    @Override
    public void activate(String code) {

    }

    @Override
    public void deactivate(String code) {
<<<<<<< Updated upstream
<<<<<<< Updated upstream
        if (alarm.getState() instanceof AlarmAlert) {
            if (alarm.getCode().equals(code)) {
                alarm.setState(new AlarmDeactive());
            }
        }

=======
        if (alarm.getCode().equals(code)) {
            alarm.setState(new AlarmDeactive());
        }
>>>>>>> Stashed changes
=======
        if (alarm.getCode().equals(code)) {
            alarm.setState(new AlarmDeactive());
        }
>>>>>>> Stashed changes
    }

    @Override
    public void alarmAlert() {
<<<<<<< Updated upstream
<<<<<<< Updated upstream
        alarm.alarmAlert();
=======
        alarm.setState(new AlarmAlert());
>>>>>>> Stashed changes
=======
        alarm.setState(new AlarmAlert());
>>>>>>> Stashed changes
    }
}
