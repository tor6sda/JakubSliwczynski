package com.sdacademy.jdbchibernate.przyklady;

public class Country {

    private int countryID;
    private String countryName;
    private String countryAlias;

    public Country() {

    }

    public Country(String countryName, String countryAlias) {
        this.countryName = countryName;
        this.countryAlias = countryAlias;
    }

    public Country(int countryID, String countryName, String countryAlias) {
        this.countryID = countryID;
        this.countryName = countryName;
        this.countryAlias = countryAlias;
    }

    public int getCountryID() {
        return countryID;
    }

    public void setCountryID(int countryID) {
        this.countryID = countryID;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryAlias() {
        return countryAlias;
    }

    public void setCountryAlias(String countryAlias) {
        this.countryAlias = countryAlias;
    }
}
