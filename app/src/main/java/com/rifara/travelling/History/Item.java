package com.rifara.travelling.History;

public class Item {
    private String name_bus, drop_off, pick_up, date, from, kode_seat, long_time, to, type;
    private int pessenger, distance, price, time_end, time_start, total_price;
    public Item(){}
    public Item(String nama_bus, String drop_off, String pick_up, String date, String from, String kode_seat, String long_time, String to, String type, int pessenger, int distance, int price, int time_end, int time_start, int total_price) {
        this.name_bus = nama_bus;
        this.drop_off = drop_off;
        this.pick_up = pick_up;
        this.date = date;
        this.from = from;
        this.kode_seat = kode_seat;
        this.long_time = long_time;
        this.to = to;
        this.type = type;
        this.pessenger = pessenger;
        this.distance = distance;
        this.price = price;
        this.time_end = time_end;
        this.time_start = time_start;
        this.total_price = total_price;
    }

    public String getNama_bus() {
        return name_bus;
    }

    public void setNama_bus(String nama_bus) {
        this.name_bus = nama_bus;
    }

    public String getDrop_off() {
        return drop_off;
    }

    public void setDrop_off(String drop_off) {
        this.drop_off = drop_off;
    }

    public String getPick_up() {
        return pick_up;
    }

    public void setPick_up(String pick_up) {
        this.pick_up = pick_up;
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

    public String getKode_seat() {
        return kode_seat;
    }

    public void setKode_seat(String kode_seat) {
        this.kode_seat = kode_seat;
    }

    public String getLong_time() {
        return long_time;
    }

    public void setLong_time(String long_time) {
        this.long_time = long_time;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPessenger() {
        return pessenger;
    }

    public void setPessenger(int pessenger) {
        this.pessenger = pessenger;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getTime_end() {
        return time_end;
    }

    public void setTime_end(int time_end) {
        this.time_end = time_end;
    }

    public int getTime_start() {
        return time_start;
    }

    public void setTime_start(int time_start) {
        this.time_start = time_start;
    }

    public int getTotal_price() {
        return total_price;
    }

    public void setTotal_price(int total_price) {
        this.total_price = total_price;
    }
}

