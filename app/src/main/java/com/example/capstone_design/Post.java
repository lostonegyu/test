package com.example.capstone_design;

public class Post {
    private String name; // 습득물 이름
    private String  time; // 게시글 올린 시간
    private String status; // 물품 상태
    private String kind; // 물품 종류

    public Post() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
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
