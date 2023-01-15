package com.shao.rawinterface.entity;

public class ResponseEntity {
    private int code;
    private String status;
    private String data;

    public ResponseEntity() {
    }

    public ResponseEntity(int code, String status, String data) {
        this.code = code;
        this.status = status;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public String getStatus() {
        return status;
    }

    public String getData() {
        return data;
    }
}
