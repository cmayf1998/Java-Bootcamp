package Model;

import java.time.LocalDate;

public class Reservation {
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;
    private int siteId;
    private Long reservationId;
    private LocalDate createDate;

    public Reservation(String name, LocalDate startDate, LocalDate endDate, int siteId, Long reservationId, LocalDate createDate) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.siteId = siteId;
        this.reservationId = reservationId;
        this.createDate = createDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public int getSiteId() {
        return siteId;
    }

    public void setSiteId(int siteId) {
        this.siteId = siteId;
    }

    public Long getReservationId() {
        return reservationId;
    }

    public void setReservationId(Long reservationId) {
        this.reservationId = reservationId;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }
}
