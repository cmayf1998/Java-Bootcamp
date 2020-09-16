package com.techelevator.entity;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class Park {

    private int id;

    private  String name;

    private String location;

    private LocalDate establishedDate;

    private int area;

    private long visitors;

    private String description;

    private List<Campground> campgrounds;

    public Park(int id, String name, String location, LocalDate establishedDate, int area, long visitors, String description) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.establishedDate = establishedDate;
        this.area = area;
        this.visitors = visitors;
        this.description = description;
    }
    public Park(int id, String name, String location, LocalDate establishedDate, int area, long visitors) {
        this(id, name, location, establishedDate, area, visitors, "");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDate getEstablishedDate() {
        return establishedDate;
    }

    public void setEstablishedDate(LocalDate establishedDate) {
        this.establishedDate = establishedDate;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public long getVisitors() {
        return visitors;
    }

    public void setVisitors(long visitors) {
        this.visitors = visitors;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Campground> getCampgrounds() {
        return campgrounds;
    }

    public void setCampgrounds(List<Campground> campgrounds) {
        this.campgrounds = campgrounds;
    }

    @Override
    public String toString() {
        return "Name: " + name +
                "\nLocation: " + location +
                "\nEstablished Date: " + establishedDate +
                "\nArea: " + area +
                "\nVisitors: " + visitors +
                "\n" + description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Park park = (Park) o;
        return id == park.id &&
                area == park.area &&
                visitors == park.visitors &&
                name.equals(park.name) &&
                location.equals(park.location) &&
                establishedDate.equals(park.establishedDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, location, establishedDate, area, visitors);
    }
}
