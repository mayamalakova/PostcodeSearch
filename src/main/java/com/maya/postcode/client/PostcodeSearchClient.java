package com.maya.postcode.client;

import com.maya.postcode.client.handler.PostcodeDetailsHandler;
import com.maya.postcode.client.handler.PostcodeNearestHandler;
import com.maya.postcode.client.handler.PostcodeValidationResponseHandler;
import com.maya.postcode.json.PostcodeDetailsResponse;
import com.maya.postcode.json.PostcodeNearestResponse;
import com.maya.postcode.json.PostcodeValidationResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;

/**
 * A client that uses basic postcode REST API services
 */
public class PostcodeSearchClient {
    private static final String POSTCODE_URL = "http://postcodes.io/postcodes";
    public static final String METHOD_VALIDATE = "validate";
    public static final String METHOD_NEAREST = "nearest";

    private HttpClient httpClient;

    public PostcodeSearchClient() {
        httpClient = HttpClients.createDefault();
    }

    public PostcodeSearchClient(final HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    /**
     * Validate the given postcode
     * @param postcode postcode to validate
     * @return a message if the postcode is invalid, null otherwise
     */
    public String validate(String postcode) throws PostcodeClientException {
        postcode = stripPostcode(postcode);
        if (!postcode.matches("^[\\w\\d]*$")) {
            return "Postcode contains invalid characters";
        }
        try {
            final PostcodeValidationResponse response = get(postcode, METHOD_VALIDATE, new PostcodeValidationResponseHandler());
            if (!response.getResult()) {
                return "The provided postcode was not found";
            }
        } catch (final IOException e) {
            throw new PostcodeClientException("Failed to validate the postcode - " + e.getMessage(), e);
        }
        return null;
    }

    /**
     * Get the details for the given postcode
     * @param postcode postcode to search for
     * @return the details about the given postcode
     */
    public String details(String postcode) throws PostcodeClientException {
        postcode = stripPostcode(postcode);
        try {
            final PostcodeDetailsResponse response = get(postcode, new PostcodeDetailsHandler());
            return response.getResult().toString();

        } catch (final IOException e) {
            throw new PostcodeClientException("Failed to retrieve details about the postcode - " + e.getMessage(), e);
        }
    }

    /**
     * Get the nearest locations to the given postcode
     * @param postcode postcode to search for
     * @return a list of the nearest postcodes and their details
     */
    public String nearest(String postcode) throws PostcodeClientException {
        postcode = stripPostcode(postcode);
        try {
            final PostcodeNearestResponse response = get(postcode, METHOD_NEAREST, new PostcodeNearestHandler());
            return response.toString();
        } catch (final IOException e) {
            throw new PostcodeClientException("Failed to find nearest postcodes - " + e.getMessage(), e);
        }
    }

    private <T> T get(final String postcode, final ResponseHandler<T> handler) throws IOException {
        final String url = String.join("/", new String[] {POSTCODE_URL, postcode});
        return getUrl(url,handler);
    }

    private  <T> T get(final String postcode, final String method, final ResponseHandler<T> handler) throws IOException {
        final String url = String.join("/", new String[] {POSTCODE_URL, postcode, method});
        return getUrl(url, handler);
    }

    private <T> T  getUrl(final String url, final ResponseHandler<T> handler) throws IOException {
        final HttpGet get = new HttpGet(url);
        return httpClient.execute(get, handler);
    }

    private String stripPostcode(final String postcode) {
        return postcode.replaceAll(" ", "");
    }

}
