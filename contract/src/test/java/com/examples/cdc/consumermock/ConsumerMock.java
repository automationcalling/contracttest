package com.examples.cdc.consumermock;

import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.consumer.junit.PactProviderRule;
import au.com.dius.pact.core.model.RequestResponsePact;
import au.com.dius.pact.core.model.annotations.Pact;
import org.junit.Rule;

import java.util.HashMap;
import java.util.Map;

public class ConsumerMock {

    @Rule
    public PactProviderRule mockProvider
            = new PactProviderRule("Provider_Test", "localhost", 9080, this);

    @Pact(consumer = "Consumer_Test")
    public RequestResponsePact createPact(PactDslWithProvider builder) {
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        return builder
                .given("Test GET Request")
                .uponReceiving("GET REQUEST")
                .path("/employees")
                .method("GET")
                .willRespondWith()
                .status(200)
                .headers(headers)
                .body("[\n" +
                        "    {\n" +
                        "        \"id\": \"1\",\n" +
                        "        \"name\": \"Muthu\",\n" +
                        "        \"dept\": \"Development\"\n" +
                        "    }\n" +
                        "]").toPact();
    }

}
