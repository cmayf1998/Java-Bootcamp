package com.techelevator.entity;

public class DayOfWeek {

    private String dailyMessage;

    public DayOfWeek(String dailyMessage){
        this.dailyMessage = dailyMessage;
    }

    public String getDailyMessage(){
        return dailyMessage;
    }
}
