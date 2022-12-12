package com.rifara.travelling.Model;

public class Payment {
    private String icon;

    public Payment(){

    }

    public Payment(String icon, String method) {
        this.icon = icon;
        this.method = method;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    private String method;
}
