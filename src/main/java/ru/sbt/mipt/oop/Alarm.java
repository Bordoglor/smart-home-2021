package ru.sbt.mipt.oop;

public class Alarm implements Actionable{

    private String code;
    private AlarmState alarmState;

    public Alarm() {
        this.code = "0";
        this.alarmState = new AlarmDeactive();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        if (code != null) {
            this.code = code;
        }
    }

    public AlarmState getState() {
        return alarmState;
    }

    public void setState(AlarmState alarmState) {
        this.alarmState = alarmState;
    }

    public void activate(String code) {
        if (code == null && alarmState instanceof AlarmAlert){
            return;
        }
        this.alarmState = new AlarmActive();
        this.code = code;
    }

    public void deactivate(String code) {
        if (code == null){
            return;
        }
        if (this.alarmState instanceof AlarmDeactive)
            return;
        if (this.code.equals(code)) {
            this.alarmState = new AlarmDeactive();
        } else {
            this.alarmState = new AlarmAlert();
        }
    }

    public void alarmAlert() {
        this.alarmState = new AlarmAlert();
    }

    @Override
    public void execute(Action action) {
        action.act(this);
    }
}