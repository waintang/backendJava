package com.example.practice.util;


public class HttpResponseException extends Exception  {

    /**
     * 响应状态
     */
    private int responseCode;

    /**
     * 响应body
     */
    private String responseBody;

    public HttpResponseException(int responseCode, String message) {
        this(responseCode, null, message);
    }

    public HttpResponseException(int responseCode, String responseBody, String message) {
        super(message);
        this.responseCode = responseCode;
        this.responseBody = responseBody;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public String getResponseBody() {
        return responseBody;
    }
}
