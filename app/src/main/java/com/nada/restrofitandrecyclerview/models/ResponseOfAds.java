package com.nada.restrofitandrecyclerview.models;

import java.util.List;

public class ResponseOfAds {

    // TODO: Step 2

    private List<Ad> data;
    private String code;
    private String message;

    public List<Ad> getData() {
        return data;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
