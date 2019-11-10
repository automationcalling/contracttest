package com.examples.cdc.ProviderTest;


import au.com.dius.pact.provider.junit.PactRunner;
import au.com.dius.pact.provider.junit.Provider;
import au.com.dius.pact.provider.junit.State;
import au.com.dius.pact.provider.junit.loader.PactFolder;
import au.com.dius.pact.provider.junit.target.HttpTarget;
import au.com.dius.pact.provider.junit.target.Target;
import au.com.dius.pact.provider.junit.target.TestTarget;
import org.junit.runner.RunWith;
import org.springframework.web.context.ConfigurableWebApplicationContext;

@RunWith(PactRunner.class)
@Provider("Provider_Test")
@PactFolder("pacts")
public class ProviderVerification {

    @State("Test GET Request")
    public void toGetState() {
    }

    @TestTarget
    //public final Target ss = new HttpTarget("http", "localhost", 8080, "/employees");
    public final Target target=new HttpTarget(8080);
}
