package com.maya.postcode.client.handler;

import com.maya.postcode.json.PostcodeNearestResponse;

/**
 * Handles nearest postcodes requests
 */
public class PostcodeNearestHandler extends PostcodeResponseHandler<PostcodeNearestResponse> {

    @Override
    protected Class getResponseClass() {
        return PostcodeNearestResponse.class;
    }
}
