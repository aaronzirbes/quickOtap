package com.peoplenet.quickotap.model;

import java.util.ArrayList;

public class Otap {
    
    private ArrayList<String> dsn;
    private ArrayList<Packages> packages;
    
    public ArrayList<String> getDsn() {return dsn;}
    public void setDsn(ArrayList<String> dsn) {this.dsn = dsn;}

    public ArrayList<Packages> getPakcages() {return packages;}
    public void setPackage(ArrayList<Packages> packages) {this.packages = packages;}

}
