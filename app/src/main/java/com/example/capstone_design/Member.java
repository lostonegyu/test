package com.example.capstone_design;

public class Member { //
    private String bmt; // 장소
    private String bln; // 이름
    private String bdt; // 날짜
    private String bpi; // 비밀번호
    private String bci; // 내용
    private String bst; // 종류
    private String stat; // 물품상태

    public Member() { }

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