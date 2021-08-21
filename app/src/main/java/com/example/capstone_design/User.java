package com.example.capstone_design;

public class User {



    private String name; // 습득물 이름
    private int  time; // 게시글 올린 시간
    private String status; // 물품 상태
    private String kind; // 물품 종류

    public User(){}


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }
}
