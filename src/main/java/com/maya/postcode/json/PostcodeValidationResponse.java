package com.maya.postcode.json;

/**
 * A response that contains information about the validity of a postcode
 */
public class PostcodeValidationResponse extends PostcodeResponse {
    private boolean result;

    public PostcodeValidationResponse() {
    }

    public boolean getResult() {
        return result;
    }
}
