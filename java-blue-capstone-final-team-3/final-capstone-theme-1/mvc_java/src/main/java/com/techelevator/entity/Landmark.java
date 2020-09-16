package com.techelevator.entity;

import java.time.LocalTime;

public class Landmark {
    private int landmarkId;
    private int cityId;
    private String landmarkName;
    private String address;
    private DayOfWeek dayOpen;
    private DayOfWeek dayClose;
    private LocalTime openingTime;
    private LocalTime closingTime;
    private String venueType;
    private String imageUrl;
    private String description;
    private int likes;
    private int dislikes;

    public Landmark(){}

    public Landmark(int landmarkId, int cityId, String landmarkName, String address, DayOfWeek dayOpen, DayOfWeek dayClose, LocalTime openingTime, LocalTime closingTime, String venueType, String imageUrl, String description, int likes, int dislikes) {
        this.landmarkId = landmarkId;
        this.cityId = cityId;
        this.landmarkName = landmarkName;
        this.address = address;
        this.dayOpen = dayOpen;
        this.dayClose = dayClose;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
        this.venueType = venueType;
        this.imageUrl = imageUrl;
        this.description = description;
        this.likes = likes;
        this.dislikes = dislikes;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public DayOfWeek getDayOpen() {
        return dayOpen;
    }

    public void setDayOpen(DayOfWeek dayOpen) {
        this.dayOpen = dayOpen;
    }

    public DayOfWeek getDayClose() {
        return dayClose;
    }

    public void setDayClose(DayOfWeek dayClose) {
        this.dayClose = dayClose;
    }

    public int getLandmarkId() {
        return landmarkId;
    }

    public void setLandmarkId(int landmarkId) {
        this.landmarkId = landmarkId;
    }

    public String getLandmarkName() {
        return landmarkName;
    }

    public void setLandmarkName(String landmarkName) {
        this.landmarkName = landmarkName;
    }

    public LocalTime getOpeningTime() {
        return openingTime;
    }

    public void setOpeningTime(LocalTime openingTime) {
        this.openingTime = openingTime;
    }

    public LocalTime getClosingTime() {
        return closingTime;
    }

    public void setClosingTime(LocalTime closingTime) {
        this.closingTime = closingTime;
    }

    public String getVenueType() {
        return venueType;
    }

    public void setVenueType(String venueType) {
        this.venueType = venueType;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDaysOpen(int dayOpen,int dayClose){

    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getDislikes() {
        return dislikes;
    }

    public void setDislikes(int dislikes) {
        this.dislikes = dislikes;
    }
}


