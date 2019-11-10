package com.examples.cdc.client;

import au.com.dius.pact.consumer.junit.PactVerification;
import com.examples.cdc.consumermock.ConsumerMock;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class ClientTest extends ConsumerMock {

    @Test
    @PactVerification()
    public void invokeMokeusingClient() {
        ResponseEntity<String> response = new RestTemplate()
                .getForEntity(mockProvider.getUrl() + "/employees", String.class);
        Assert.assertEquals(response.getStatusCodeValue(), 200);
        Assert.assertTrue(response.getHeaders().get("Content-Type").contains("application/json"));
    }
}
