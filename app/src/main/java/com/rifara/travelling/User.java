package com.rifara.travelling;

public class User {

    String nameBus, date, from, to, pessenger;

    public User(){}

    public User(String nameBus, String date, String from, String to, String pessenger) {
        this.nameBus = nameBus;
        this.date = date;
        this.from = from;
        this.to = to;
        this.pessenger = pessenger;
    }

    public String getNameBus() {
        return nameBus;
    }

    public void setNameBus(String nameBus) {
        this.nameBus = nameBus;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getPessenger() {
        return pessenger;
    }

    public void setPessenger(String pessenger) {
        this.pessenger = pessenger;
    }
}
