package ru.sbt.mipt.oop;

public class Alarm implements State, Actionable{

    private String code;
    private State state;

    public Alarm() {
        this.code = "0";
        this.state = new AlarmDeactive();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        if (code != null) {
            this.code = code;
        }
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    @Override
    public void activate(String code) {
        if (code == null && state instanceof AlarmAlert){
            return;
        }
        this.state = new AlarmActive();
        this.code = code;
    }

    @Override
    public void deactivate(String code) {
        if (this.state instanceof AlarmDeactive)
            return;
        if (this.code.equals(code)) {
            this.state = new AlarmDeactive();
        } else {
            this.state = new AlarmAlert();
        }
    }

    @Override
    public void alarmAlert() {
        this.state = new AlarmAlert();
    }

    @Override
    public void execute(Action action) {
        action.perform(this);
    }
}
