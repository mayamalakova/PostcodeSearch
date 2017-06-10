package com.maya.postcode;

import com.maya.postcode.client.PostcodeClientException;
import com.maya.postcode.client.PostcodeSearchClient;

/**
 * Starting point of the application
 */
public class PostcodeSearchApplication {

    public static void main(String[] args) {
        final String message = validateArguments(args);
        if (message != null) {
            System.out.println(message);
            return;
        }
        final String postcode = String.join("", args);
        final PostcodeSearchClient postcodeClient = new PostcodeSearchClient();

        try {
            final String validationMessage = postcodeClient.validate(postcode);
            if (validationMessage != null) {
                System.out.println(validationMessage);
                return;
            }
        } catch (PostcodeClientException e) {
            System.out.println(e.getMessage());
            return;
        }

        try {
            final String details = "Location: \n" + postcodeClient.details(postcode);
            System.out.println(details);
        } catch (PostcodeClientException e) {
            System.out.println(e.getMessage());
            return;
        }

        try {
            final String suggestions = "Nearby locations: \n" + postcodeClient.nearest(postcode);
            System.out.println(suggestions);
        } catch (PostcodeClientException e) {
            System.out.println(e.getMessage());
        }
    }

    private static String validateArguments(String[] args) {
        if (args.length < 1 || args.length > 2) {
            return "Incorrect arguments. Please provide a postcode";
        }
        return null;
    }
}
