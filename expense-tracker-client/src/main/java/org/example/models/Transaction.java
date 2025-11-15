package org.example.models;

import java.time.LocalDate;

public class Transaction {
    private int id;
    private TransactionCategory transactionCategory;
    private String transactionName;
    private double transactionAmount;
    private LocalDate transactionDate;
    private String transactionType;
    private String locationName;
    private Double latitude;
    private Double longitude;

    public Transaction(int id, TransactionCategory transactionCategory, String transactionName,
                       double transactionAmount, LocalDate transactionDate, String transactionType,  String locationName,
     Double latitude,
     Double longitude) {
        this.id = id;
        this.transactionCategory = transactionCategory;
        this.transactionName = transactionName;
        this.transactionAmount = transactionAmount;
        this.transactionDate = transactionDate;
        this.transactionType = transactionType;
        this.locationName = locationName;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public int getId() {
        return id;
    }

    public TransactionCategory getTransactionCategory() {
        return transactionCategory;
    }

    public void setTransactionCategory(TransactionCategory transactionCategory) {
        this.transactionCategory = transactionCategory;
    }

    public String getTransactionName() {
        return transactionName;
    }

    public void setTransactionName(String transactionName) {
        this.transactionName = transactionName;
    }

    public double getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getLocationName() {return locationName;}

    public void setLocationName(String locationName) {this.locationName = locationName;}

    public Double getLatitude() {return latitude;}

    public void setLatitude(Double latitude) {this.latitude = latitude;}

    public Double getLongitude() {return longitude;}
}