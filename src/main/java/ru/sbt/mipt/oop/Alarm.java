package ru.sbt.mipt.oop;

<<<<<<< Updated upstream
public class Alarm implements State, Actionable{

    private String code;
    private State state;

    public Alarm() {
        this.code = "0";
        this.state = new AlarmDeactive();
=======
public class Alarm implements AlarmState, Actionable{

    private String code;
    private AlarmState alarmState;

    public Alarm() {
        this.code = "0";
        this.alarmState = new AlarmDeactive();
>>>>>>> Stashed changes
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        if (code != null) {
            this.code = code;
        }
    }

<<<<<<< Updated upstream
    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
=======
    public AlarmState getState() {
        return alarmState;
    }

    public void setState(AlarmState alarmState) {
        this.alarmState = alarmState;
>>>>>>> Stashed changes
    }

    @Override
    public void activate(String code) {
<<<<<<< Updated upstream
        if (code == null && state instanceof AlarmAlert){
            return;
        }
        this.state = new AlarmActive();
=======
        if (code == null && alarmState instanceof AlarmAlert){
            return;
        }
        this.alarmState = new AlarmActive();
>>>>>>> Stashed changes
        this.code = code;
    }

    @Override
    public void deactivate(String code) {
<<<<<<< Updated upstream
        if (this.state instanceof AlarmDeactive)
            return;
        if (this.code.equals(code)) {
            this.state = new AlarmDeactive();
        } else {
            this.state = new AlarmAlert();
=======
        if (this.alarmState instanceof AlarmDeactive)
            return;
        if (this.code.equals(code)) {
            this.alarmState = new AlarmDeactive();
        } else {
            this.alarmState = new AlarmAlert();
>>>>>>> Stashed changes
        }
    }

    @Override
    public void alarmAlert() {
<<<<<<< Updated upstream
        this.state = new AlarmAlert();
=======
        this.alarmState = new AlarmAlert();
>>>>>>> Stashed changes
    }

    @Override
    public void execute(Action action) {
<<<<<<< Updated upstream
        action.perform(this);
=======
        action.act(this);
>>>>>>> Stashed changes
    }
}
