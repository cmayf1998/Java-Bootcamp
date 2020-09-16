package Model;

import java.time.LocalDate;

public class Park {

    private Long parkId;
    private String name;
    private String location;
    private LocalDate dateEstablished;
    private double area;
    private int annualVisitorCount;
    private String description;

    public Park(Long parkId, String name, String location, LocalDate dateEstablished, double area, int annualVisitorCount, String description) {
        this.parkId = parkId;
        this.name = name;
        this.location = location;
        this.dateEstablished = dateEstablished;
        this.area = area;
        this.annualVisitorCount = annualVisitorCount;
        this.description = description;
    }

    public Long getParkId() {
        return parkId;
    }

    public void setParkId(Long parkId) {
        this.parkId = parkId;
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

    public LocalDate getDateEstablished() {
        return dateEstablished;
    }

    public void setDateEstablished(LocalDate dateEstablished) {
        this.dateEstablished = dateEstablished;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public int getAnnualVisitorCount() {
        return annualVisitorCount;
    }

    public void setAnnualVisitorCount(int annualVisitorCount) {
        this.annualVisitorCount = annualVisitorCount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Park{" +
                "parkId=" + parkId +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", dateEstablished=" + dateEstablished +
                ", area=" + area +
                ", annualVisitorCount=" + annualVisitorCount +
                ", description='" + description + '\'' +
                '}';
    }
}
