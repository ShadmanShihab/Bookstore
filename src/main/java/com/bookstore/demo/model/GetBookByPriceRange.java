package com.bookstore.demo.model;

public class GetBookByPriceRange {
    private int lowerLimit;
    private int upperLimit;

    public GetBookByPriceRange(int lowerLimit, int upperLimit){
        this.lowerLimit = lowerLimit;
        this.upperLimit = upperLimit;
    }

    public int getLowerLimit() {
        return lowerLimit;
    }

    public void setLowerLimit(int lowerLimit) {
        this.lowerLimit = lowerLimit;
    }

    public int getUpperLimit() {
        return upperLimit;
    }

    public void setUpperLimit(int upperLimit) {
        this.upperLimit = upperLimit;
    }
}
