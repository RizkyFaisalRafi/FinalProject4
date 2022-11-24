package com.rifara.travelling.Model;

public class Bus {
    private String namaBus, pickUp, dropOff, harga, type, waktu;


    public Bus(String namaBus, String pickUp, String dropOff, String harga, String type, String waktu) {
        this.namaBus = namaBus;
        this.pickUp = pickUp;
        this.dropOff = dropOff;
        this.harga = harga;
        this.type = type;
        this.waktu = waktu;
    }

    public Bus(){

    }

    public String getNamaBus() {
        return namaBus;
    }

    public void setNamaBus(String namaBus) {
        this.namaBus = namaBus;
    }

    public String getPickUp() {
        return pickUp;
    }

    public void setPickUp(String pickUp) {
        this.pickUp = pickUp;
    }

    public String getDropOff() {
        return dropOff;
    }

    public void setDropOff(String dropOff) {
        this.dropOff = dropOff;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getWaktu() {
        return waktu;
    }

    public void setWaktu(String waktu) {
        this.waktu = waktu;
    }
}
