package ru.sbt.mipt.oop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

class RemoteControlSignalsTest {
    private SmartHome smartHome;
    private RemoteControl remoteControl;

    @BeforeEach
    void beforeEach(){
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(ConfigurationSpring.class);
        smartHome = context.getBean(SmartHome.class);
        remoteControl = context.getBean(RemoteControl.class);
    }

    @Test
    public void remoteControlTurnOnLightsSignalTest(){
        remoteControl.onButtonPressed("A");
        smartHome.execute(object -> {
            if (!(object instanceof Light)) {
                return;
            }
            Light light = (Light) object;
            assertTrue(light.isOn());
        });
    }

    @Test
    public void remoteControlTurnOnHallLightSignalTest(){
        remoteControl.onButtonPressed("B");
        smartHome.execute(object -> {
            if (!(object instanceof Room)) {
                return;
            }
            Room room = (Room) object;
            if ("hall".equals(room.getName())) {
                room.execute(obj -> {
                    if (!(obj instanceof Light)) {
                        return;
                    }
                    Light light = (Light) obj;
                    assertTrue(light.isOn());
                });
            }
        });
    }

    @Test
    public void remoteControlCloseHallDoorSignalTest(){
        remoteControl.onButtonPressed("B");
        smartHome.execute(o -> {
            if (!(o instanceof Room)) {
                return;
            }
            Room room = (Room) o;
            if ("hall".equals(room.getName())) {
                room.execute(c -> {
                    if (c instanceof Door) {
                        Door door = (Door) c;
                        assertFalse(door.isOpen());
                    }
                });
            }
        });
    }

    @Test
    public void remoteControlAlarmActivateSignalTest(){
        remoteControl.onButtonPressed("D");
        smartHome.execute(object -> {
            if (object instanceof Alarm) {
                Alarm alarm = (Alarm) object;
                assertTrue(alarm.getState() instanceof AlarmActive);
            }
        });
    }

    @Test
    public void remoteControlAlarmAlertSignalTest(){
        remoteControl.onButtonPressed("1");
        smartHome.execute(object -> {
            if (object instanceof Alarm) {
                Alarm alarm = (Alarm) object;
                assertTrue(alarm.getState() instanceof AlarmAlert);
            }
        });
    }

    @Test
    public void remoteControlTurnOffLightsSignalTest(){
        remoteControl.onButtonPressed("2");
        smartHome.execute(object -> {
            if (!(object instanceof Light)) {
                return;
            }
            Light light = (Light) object;
            assertFalse(light.isOn());
        });
    }
}