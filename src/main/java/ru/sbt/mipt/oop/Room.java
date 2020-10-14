package ru.sbt.mipt.oop;

import java.util.Collection;

public class Room implements Actionable {
    private Collection<Light> lights;
    private Collection<Door> doors;
    private static String name;

    public Room(Collection<Light> lights, Collection<Door> doors, String name) {
        this.lights = lights;
        this.doors = doors;
        this.name = name;
    }

    public Collection<Light> getLights() {
        return lights;
    }

    public Collection<Door> getDoors() {
        return doors;
    }

    public static String getName() {
        return name;
    }

    @Override
    public void execute(Action action) {
        for (Light light: lights){
            action.act(light);
        }
        for (Door door: doors){
            action.act(door);
        }
        action.act(this);
    }
}
