package com.maya.postcode.client.handler;

import com.maya.postcode.json.PostcodeValidationResponse;

/**
 * Handles validate requests
 */
public class PostcodeValidationResponseHandler extends PostcodeResponseHandler<PostcodeValidationResponse> {

    @Override
    protected Class<PostcodeValidationResponse> getResponseClass() {
        return PostcodeValidationResponse.class;
    }
}
