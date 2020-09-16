package Model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Campground {
    private Long campgroundId;
    private int parkId;
    private String name;
    private int openMonth;
    private int closingMonth;
    private BigDecimal dailyFee;

    public Campground(Long campgroundId, int parkId, String name, int openMonth, int closingMonth, BigDecimal dailyFee) {
        this.campgroundId = campgroundId;
        this.parkId = parkId;
        this.name = name;
        this.openMonth = openMonth;
        this.closingMonth = closingMonth;
        this.dailyFee = dailyFee;
    }

    public Long getCampgroundId() {
        return campgroundId;
    }

    public void setCampgroundId(Long campgroundId) {
        this.campgroundId = campgroundId;
    }

    public int getParkId() {
        return parkId;
    }

    public void setParkId(int parkId) {
        this.parkId = parkId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOpenMonth() {
        return openMonth;
    }

    public void setOpenMonth(int openMonth) {
        this.openMonth = openMonth;
    }

    public int getClosingMonth() {
        return closingMonth;
    }

    public void setClosingMonth(int closingMonth) {
        this.closingMonth = closingMonth;
    }

    public BigDecimal getDailyFee() {
        return dailyFee;
    }

    public void setDailyFee(BigDecimal dailyFee) {
        this.dailyFee = dailyFee;
    }

    @Override
    public String toString() {
        return "Campground{" +
                "campgroundId=" + campgroundId +
                ", parkId=" + parkId +
                ", name='" + name + '\'' +
                ", openMonth=" + openMonth +
                ", closingMonth=" + closingMonth +
                ", dailyFee=" + dailyFee +
                '}';
    }

}

