package com.shao.rawinterface.entity;

public class ResponseEntity {
    private int code;
    private String message;
    private String data;

    public ResponseEntity() {
    }

    public ResponseEntity(int code, String message, String data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getData() {
        return data;
    }
}
