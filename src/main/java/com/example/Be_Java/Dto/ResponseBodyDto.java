package com.example.Be_Java.Dto;

import lombok.Data;

@Data

public class ResponseBodyDto <T>{

    private String message;
    private String messageCode;
    private T data;
    private long totalRecords;

    public ResponseBodyDto(String message, String messageCode) {
        this.messageCode = messageCode;
        this.message = message;
        this.totalRecords = 0;
    }
    public ResponseBodyDto(T data, String message, String messageCode) {
        this.data = data;
        this.messageCode = messageCode;
        this.message = message;
    }
}
