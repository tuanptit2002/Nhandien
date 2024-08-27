package com.example.Be_Java.Dto;

import lombok.Data;

@Data

public class ResponseBodyDto <T>{

    private String message;
    private String messageCode;
    private T data;
    private int page;
    private long size;
//    private long totalRecord;
    public ResponseBodyDto(String message, String messageCode) {
        this.messageCode = messageCode;
        this.message = message;
    }
    public ResponseBodyDto(T data, String message, String messageCode) {
        this.data = data;
        this.messageCode = messageCode;
        this.message = message;
    }

    public ResponseBodyDto(T data, String message, String messageCode, int page, long size) {
        this.data = data;
        this.messageCode = messageCode;
        this.message = message;
        this.page = page;
        this.size = size;
//        this.totalRecord = totalRecord;
    }
}
