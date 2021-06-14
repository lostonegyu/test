package com.example.capstone_design;

public class Member {
    private String bmt;
    private String bln;
    private String bdt;
    private String bpi;
    private String bci;
    private String bst;
    private String stat;



    public Member() {
    }

    public String getBmt() {
        return bmt;
    }

    public void setBmt(String bmt) {
        this.bmt = bmt;
    }

    public String getBdt() {
        return bdt;
    }

    public void setBdt(String bdt) {
        this.bdt = bdt;
    }

    public String getBpi() {
        return bpi;
    }

    public void setBpi(String bpi) {
        this.bpi = bpi;
    }

    public String getBci() {
        return bci;
    }

    public void setBci(String bci) {
        this.bci = bci;
    }

    public String getBst() {
        return bst;
    }

    public void setBst(String bst) {
        this.bst = bst;
    }

    public String getStat()  {return stat; }

    public void setStat(String stat) { this.stat = stat; }

    public String getBln()  {return bln; }

    public void setBln(String bln) { this.bln = bln; }
}