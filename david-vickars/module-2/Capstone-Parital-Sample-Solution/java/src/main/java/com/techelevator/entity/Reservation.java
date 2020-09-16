package com.techelevator.entity;

import java.time.LocalDate;
import java.util.Objects;

public class Reservation {

    private int id;

    private Site site;

    private String name;

    private LocalDate fromDate;

    private LocalDate toDate;

    private LocalDate createDate;

    public Reservation(){}

    public Reservation(int id, String name, LocalDate fromDate, LocalDate toDate, LocalDate createDate) {
        this.id = id;
        this.name = name;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.createDate = createDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Site getSite() {
        return site;
    }

    public void setSite(Site site) {
        this.site = site;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
    }

    public LocalDate getToDate() {
        return toDate;
    }

    public void setToDate(LocalDate toDate) {
        this.toDate = toDate;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "\nReservation{" +
                "id=" + id +
                ", siteId='" + site.getId() + '\'' +
                ", name='" + name + '\'' +
                ", fromDate=" + fromDate +
                ", toDate=" + toDate +
                ", createDate=" + createDate +
                "}\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reservation that = (Reservation) o;
        return id == that.id &&
                name.equals(that.name) &&
                fromDate.equals(that.fromDate) &&
                toDate.equals(that.toDate) &&
                createDate.equals(that.createDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, fromDate, toDate, createDate);
    }
}
