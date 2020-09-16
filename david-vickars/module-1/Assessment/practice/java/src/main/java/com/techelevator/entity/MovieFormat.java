package com.techelevator.entity;

import java.math.BigDecimal;

public enum MovieFormat {

    VHS(new BigDecimal(0.99)),
    DVD(new BigDecimal(1.99)),
    BLURAY(new BigDecimal(2.99));

    private MovieFormat(BigDecimal price){
        this.price = price;
    }

    public static MovieFormat getFormatFromString(String format){
        format = format.toUpperCase();
        if ("VHS".equals(format)){
            return VHS;
        }
        if ("DVD".equals(format)){
            return DVD;
        }
        if ("BLU-RAY".equals(format)){
            return BLURAY;
        }
        return null;
    }

    private BigDecimal price;

    public BigDecimal getPrice() {
        return price;
    }
}
