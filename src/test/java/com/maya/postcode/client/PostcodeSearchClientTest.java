package com.maya.postcode.client;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PostcodeSearchClientTest {
    private PostcodeSearchClient searchClient;

    @Before
    public void setUp() {
        searchClient = new PostcodeSearchClient();
    }

    @Test
    public void should_validate_invalid_postcode() throws PostcodeClientException {
        final String validateMessage = searchClient.validate("7000");
        Assert.assertNotNull(validateMessage);
    }

    @Test
    public void should_validate_invalid_characters_postcode() throws PostcodeClientException {
        final String validateMessage = searchClient.validate("70~ 00");
        Assert.assertNotNull(validateMessage);
        Assert.assertEquals("Postcode contains invalid characters", validateMessage);
    }

    @Test
    public void should_validate_valid_postcode() throws PostcodeClientException {
        final String validateMessage = searchClient.validate("CB30FA");
        Assert.assertNull(validateMessage);
    }

    @Test
    public void should_validate_valid_postcode_of_two_parts() throws PostcodeClientException {
        final String validateMessage = searchClient.validate("CB3 0FA");
        Assert.assertNull(validateMessage);
    }

    @Test
    public void should_provide_details_for_postcode() throws PostcodeClientException {
        final String details = searchClient.details("CV56LB");
        Assert.assertNotNull(details);
        Assert.assertEquals("Postcode: CV5 6LB, Country: England, Region: West Midlands", details);
    }

    @Test
    public void should_suggest_nearest_postcodes() throws PostcodeClientException {
        final String suggestions = searchClient.nearest("CV56LB");
        Assert.assertNotNull(suggestions);
    }

}