package com.maya.postcode.client.handler;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.entity.ContentType;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;

/**
 * Handles postcode search requests
 */
public abstract class PostcodeResponseHandler<T> implements ResponseHandler<T> {

    public T handleResponse(
            final HttpResponse response) throws IOException {
        final StatusLine statusLine = response.getStatusLine();
        validateStatus(statusLine);
        final HttpEntity entity = validateBody(response);

        return parseResponse(entity);
    }

    protected T parseResponse(final HttpEntity entity) throws IOException {
        final Gson gson = new GsonBuilder().create();
        final ContentType contentType = ContentType.getOrDefault(entity);
        final Charset charset = contentType.getCharset();
        final Reader reader = new InputStreamReader(entity.getContent(), charset);
        return gson.fromJson(reader, getResponseClass());
    }

    protected abstract Class<T> getResponseClass();

    private HttpEntity validateBody(final HttpResponse response) throws ClientProtocolException {
        final HttpEntity entity = response.getEntity();
        if (entity == null) {
            throw new ClientProtocolException("Response contains no content");
        }
        return entity;
    }

    private void validateStatus(final StatusLine statusLine) throws HttpResponseException {
        if (statusLine.getStatusCode() >= 300) {
            throw new HttpResponseException(
                    statusLine.getStatusCode(),
                    statusLine.getReasonPhrase());
        }
    }
}
