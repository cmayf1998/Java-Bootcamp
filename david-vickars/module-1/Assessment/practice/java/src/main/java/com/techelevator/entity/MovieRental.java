package com.techelevator.entity;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class MovieRental {

    private String title;

    private MovieFormat format;

    private boolean isPremium;

    public MovieRental(String title, MovieFormat format, boolean isPremium) {
        this.title = title;
        this.format = format;
        this.isPremium = isPremium;
    }

    /*
        Return $0.00 if daysLate is equal to 0.
        Return $1.99 if daysLate is equal to 1.
        Return $3.99 if daysLate is equal to 2.
        Return $19.99 if daysLate is equal to 3 or more.
     */
    public BigDecimal getLateFee(int daysLate){
       if (daysLate == 0){
           return BigDecimal.ZERO;
       } else if (daysLate == 1) {
           return new BigDecimal(1.99);
       } else if (daysLate == 2) {
           return new BigDecimal(3.99);
       } else {
           return new BigDecimal(19.99);
       }
    }

    // VHS $0.99, DVD $1.99, BluRay $2.99 add $1.00 if isPremium
    public BigDecimal getRentalPrice(){
        BigDecimal rentalPrice = format.getPrice();
        if (isPremium){
            rentalPrice = rentalPrice.add(new BigDecimal(1));
        }
        return rentalPrice;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public MovieFormat getFormat() {
        return format;
    }

    public void setFormat(MovieFormat format) {
        this.format = format;
    }

    public boolean isPremium() {
        return isPremium;
    }

    public void setPremium(boolean premium) {
        isPremium = premium;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MovieRental)) return false;
        MovieRental that = (MovieRental) o;
        return isPremium == that.isPremium &&
                Objects.equals(title, that.title) &&
                Objects.equals(format, that.format);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, format, isPremium);
    }

    @Override
    public String toString() {
        // "MOVIE - {title} - {format} {rental price}"
        return "MOVIE - " + title + " - " + format + " " + getRentalPrice().setScale(2, RoundingMode.HALF_EVEN);
    }
}
