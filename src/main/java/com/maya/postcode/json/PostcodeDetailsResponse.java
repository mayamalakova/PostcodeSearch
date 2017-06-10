package com.maya.postcode.json;

/**
 * A response that contains details about a postcode
 */
public class PostcodeDetailsResponse extends PostcodeResponse {

    private PostcodeDetails result;

    public PostcodeDetailsResponse() {
    }

    public PostcodeDetails getResult() {
        return result;
    }
}
