package ru.sbt.mipt.oop;

import java.util.ArrayList;
import java.util.Collection;

public class SmartHome implements Actionable {
    Collection<Room> rooms;
    public Alarm alarm;

    public SmartHome() {
        rooms = new ArrayList<>();
        this.alarm = new Alarm();
    }

    public SmartHome(Collection<Room> rooms) {
        this.rooms = rooms;
        this.alarm = new Alarm();
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public AlarmState getState(){
        return alarm.getState();
    }
    public Collection<Room> getRooms() {
        return rooms;
    }

    @Override
    public void execute(Action action) {
        for (Room room: rooms){
            room.execute(action);
        }
        alarm.execute(action);
    }
}
