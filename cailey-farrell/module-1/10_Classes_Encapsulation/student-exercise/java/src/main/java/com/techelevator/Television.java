package com.techelevator;

public class Television {
    private boolean isOn;
    private int currentChannel;
    private int currentVolume;

    public Television() {
        this.isOn = false;
        this.currentVolume = 2;
        this.currentChannel = 3;
    }

    public boolean isOn() {
        return isOn;
    }

    public int getCurrentChannel() {
        return currentChannel;
    }

    public int getCurrentVolume() {
        return currentVolume;
    }

    public void turnOff() {
        isOn = false;
    }

    public void turnOn() {
        isOn = true;
    }

    public void changeChannel(int newChannel) {
        if (isOn && newChannel >= 3 && newChannel <= 18) {
            currentChannel = newChannel;
        }
    }

    public void channelUp() {
        if (isOn) {
            if (currentChannel >= 18) {
                currentChannel = 3;
            } else currentChannel++;
        }
    }

    public void channelDown() {
        if (isOn) {
            if (currentChannel <= 3) {
                currentChannel = 18;
            } else currentChannel--;
        }
    }

   public void raiseVolume() {
        if (isOn) {
            if (currentVolume <= 10) {
                currentVolume++;
            }
        }
    }

    public void lowerVolume() {
        if (isOn) {
            if (currentVolume > 0) {
                currentVolume--;
            }
        }
    }
}
