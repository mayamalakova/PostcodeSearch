package com.maya.postcode.client.handler;

import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpResponseException;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.mockito.Mockito.when;

public class PostcodeDetailsHandlerTest {
    private PostcodeDetailsHandler postcodeDetailsHandler;

    @Before
    public void setUp() {
        postcodeDetailsHandler = new PostcodeDetailsHandler();
    }

    @Test (expected = HttpResponseException.class)
    public void should_handle_error_status() throws IOException {
        final StatusLine statusLine =  createMockStatus(404, "Something went wrong");

        final HttpResponse response = Mockito.mock(HttpResponse.class);
        when(response.getStatusLine()).thenReturn(statusLine);
        postcodeDetailsHandler.handleResponse(response);
    }

    @Test (expected = ClientProtocolException.class)
    public void should_handle_no_response() throws IOException {
        final StatusLine statusLine =  createMockStatus(200, null);

        final HttpResponse response = Mockito.mock(HttpResponse.class);
        when(response.getStatusLine()).thenReturn(statusLine);
        when(response.getEntity()).thenReturn(null);
        postcodeDetailsHandler.handleResponse(response);
    }

    private StatusLine createMockStatus(final int status, final String phrase) {
        final StatusLine statusLine = Mockito.mock(StatusLine.class);
        when(statusLine.getStatusCode()).thenReturn(status);
        when(statusLine.getReasonPhrase()).thenReturn(phrase);
        return statusLine;
    }

}