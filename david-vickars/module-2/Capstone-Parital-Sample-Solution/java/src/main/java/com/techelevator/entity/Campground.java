package com.techelevator.entity;

import java.util.List;
import java.util.Objects;

public class Campground {

    private int id;

    private Park park;

    private List<Site> sites;

    private String name;

    private String monthOpen;

    private String monthClosed;

    private Money dailyFee;

    public Campground() {}

    public Campground(int id, String name, String monthOpen, String monthClosed, Money dailyFee) {
        this.id = id;
        this.name = name;
        this.monthOpen = monthOpen;
        this.monthClosed = monthClosed;
        this.dailyFee = dailyFee;
    }

    public Campground(int id, String name, String monthOpen, String monthClosed, Money dailyFee, Park park) {
        this(id, name, monthOpen, monthClosed, dailyFee);
        this.park = park;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Park getPark() {
        return park;
    }

    public void setPark(Park park) {
        this.park = park;
    }

    public List<Site> getSites() {
        return sites;
    }

    public void setSites(List<Site> sites) {
        this.sites = sites;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMonthOpen() {
        return monthOpen;
    }

    public void setMonthOpen(String monthOpen) {
        this.monthOpen = monthOpen;
    }

    public String getMonthClosed() {
        return monthClosed;
    }

    public void setMonthClosed(String monthClosed) {
        this.monthClosed = monthClosed;
    }

    public Money getDailyFee() {
        return dailyFee;
    }

    public void setDailyFee(Money dailyFee) {
        this.dailyFee = dailyFee;
    }

    @Override
    public String toString() {
        return "Name: " + name +
                "\nMonth Open: " + monthOpen +
                "\nMonth Closed: " + monthClosed +
                "\nDailyFee: " + dailyFee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Campground that = (Campground) o;
        return id == that.id &&
                name.equals(that.name) &&
                monthOpen.equals(that.monthOpen) &&
                monthClosed.equals(that.monthClosed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, monthOpen, monthClosed);
    }
}
