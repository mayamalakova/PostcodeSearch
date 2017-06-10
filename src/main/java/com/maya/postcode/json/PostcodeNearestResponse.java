package com.maya.postcode.json;

import java.util.Arrays;

/**
 * A response that contains the nearest postcodes to a postcode
 */
public class PostcodeNearestResponse extends PostcodeResponse {

    private PostcodeDetails[] result;

    public PostcodeDetails[] getResult() {
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        Arrays.stream(result).forEach(r -> builder.append(r).append("\n"));
        return builder.toString();
    }
}
