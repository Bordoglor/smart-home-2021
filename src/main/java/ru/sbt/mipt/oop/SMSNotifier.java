package ru.sbt.mipt.oop;

public class SMSNotifier implements Notifier{
    @Override
    public void inform() {
        System.out.println("Sending sms");
    }
}
