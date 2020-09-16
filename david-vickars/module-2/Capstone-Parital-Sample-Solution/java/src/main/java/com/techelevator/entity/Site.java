package com.techelevator.entity;

import java.util.List;
import java.util.Objects;

public class Site {

    private int id;

    private Campground campground;

    private List<Reservation> reservations;

    private int siteNumber;

    private int maxOccupancy;

    private boolean accessible;

    private int maxRvLength;

    private boolean utilities;

    public Site(){}

    public Site(int id, int siteNumber, int maxOccupancy, boolean accessible,
                int maxRvLength, boolean utilities) {
        this.id = id;
        this.siteNumber = siteNumber;
        this.maxOccupancy = maxOccupancy;
        this.accessible = accessible;
        this.maxRvLength = maxRvLength;
        this.utilities = utilities;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Campground getCampground() {
        return campground;
    }

    public void setCampground(Campground campground) {
        this.campground = campground;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public int getSiteNumber() {
        return siteNumber;
    }

    public void setSiteNumber(int siteNumber) {
        this.siteNumber = siteNumber;
    }

    public int getMaxOccupancy() {
        return maxOccupancy;
    }

    public void setMaxOccupancy(int maxOccupancy) {
        this.maxOccupancy = maxOccupancy;
    }

    public boolean isAccessible() {
        return accessible;
    }

    public void setAccessible(boolean accessible) {
        this.accessible = accessible;
    }

    public int getMaxRvLength() {
        return maxRvLength;
    }

    public void setMaxRvLength(int maxRvLength) {
        this.maxRvLength = maxRvLength;
    }

    public boolean isUtilities() {
        return utilities;
    }

    public void setUtilities(boolean utilities) {
        this.utilities = utilities;
    }

    @Override
    public String toString() {
        return "\nSite{" +
                "id=" + id +
                ", siteNumber=" + siteNumber +
                ", maxOccupancy=" + maxOccupancy +
                ", accessible=" + accessible +
                ", maxRvLength=" + maxRvLength +
                ", utilities=" + utilities +
                ", reservations=" + reservations +
                "}\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Site site = (Site) o;
        return id == site.id &&
                siteNumber == site.siteNumber &&
                maxOccupancy == site.maxOccupancy &&
                accessible == site.accessible &&
                maxRvLength == site.maxRvLength &&
                utilities == site.utilities;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, siteNumber, maxOccupancy, accessible, maxRvLength, utilities);
    }
}
