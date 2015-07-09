package com.peoplenet.quickotap.model;

import java.util.ArrayList;

public class Otap {

    private ArrayList<Integer> dsn;
    private ArrayList<Packages> packages;
    private int triggerType;

    public ArrayList<Integer> getDsn() {
        return dsn;
    }

    public void setDsn(ArrayList<Integer> dsn) {
        this.dsn = dsn;
    }

    public int gettriggerType() {
        return triggerType;
    }

    public void settriggerType(int triggerType) {
        this.triggerType = triggerType;
    }

    public ArrayList<Packages> getPackages() {
        return packages;
    }

    public void setPackages(ArrayList<Packages> packages) {
        this.packages = packages;
    }

}
