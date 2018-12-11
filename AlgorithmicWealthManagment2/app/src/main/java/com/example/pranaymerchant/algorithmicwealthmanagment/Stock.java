package com.example.pranaymerchant.algorithmicwealthmanagment;

public class Stock {

    private String name; //name of the stock
    private String stockSymbol; //stock ticker symbol
    private double latestVal;
    private double openingPrice; //opening price of the day
    private double closingPrice;
    private double weekRange; //range between the lowest the stock has gone and the highest point the stock has gone in the past year
    private double lowestVal; //lowest the stock has gone in the past 52 weeks
    private double highestVal; //highest the stock has gone in the past 52 weeks
    private double volume; //number of stocks in circulation
    private double marketCap; //how much money the company has in total
    private double PERatio; //price to earnings ratio, ratio of a company's stock price to their earnings per share

    public Stock(String symb, double latest, double open, double close, double high, double low, double vol) {
        stockSymbol = symb;
        latestVal = latest;
        openingPrice = open;
        closingPrice = close;
        lowestVal = low;
        highestVal = high;
        volume = vol;

    }

    public double getLatestValue() {
        return latestVal;
    }


    public String toString() {
        String s = "The stock " + stockSymbol + " has a latest price of " + latestVal + " has an opening price: " + openingPrice + ", closing price: " + closingPrice + ", lowestValue: " + lowestVal + ", highestVal: " + highestVal + " and a volume of " + volume;
        return s;
    }

    public String getStockSymbol() {
        return stockSymbol;
    }



}