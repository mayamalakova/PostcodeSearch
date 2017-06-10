package com.maya.postcode.client;

import java.io.IOException;

/**
 * An exception at the postcodeclient
 */
public class PostcodeClientException extends Exception {
    public PostcodeClientException(final String message, final IOException e) {
        super(message, e);
    }
}
