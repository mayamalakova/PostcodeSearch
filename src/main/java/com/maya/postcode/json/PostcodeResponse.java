package com.maya.postcode.json;

/**
 * A base postcode search response
 */
public abstract class PostcodeResponse {
    protected int status;

    private String error;

    public int getStatus() {
        return status;
    }

    public String getError() {
        return error;
    }
}
