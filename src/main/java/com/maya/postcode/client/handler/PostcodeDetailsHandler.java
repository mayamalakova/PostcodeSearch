package com.maya.postcode.client.handler;

import com.maya.postcode.json.PostcodeDetailsResponse;

/**
 * Handles postcode details
 */
public class PostcodeDetailsHandler extends PostcodeResponseHandler<PostcodeDetailsResponse> {
    @Override
    protected Class<PostcodeDetailsResponse> getResponseClass() {
        return PostcodeDetailsResponse.class;
    }
}
