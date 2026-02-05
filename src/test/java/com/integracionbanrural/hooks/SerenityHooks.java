package com.integracionbanrural.hooks;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static com.github.tomakehurst.wiremock.client.WireMock.configureFor;

public class SerenityHooks {

    private static WireMockServer wireMockServer;

    @Before
    public void setUp() {
        if (wireMockServer == null) {
            wireMockServer = new WireMockServer(WireMockConfiguration.wireMockConfig().dynamicPort());
            wireMockServer.start();
        }
        configureFor("localhost", wireMockServer.port());
        SerenityRest.setDefaultBasePath("http://localhost:" + wireMockServer.port());
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("QA");
    }

    @After
    public void tearDown() {
        if (wireMockServer != null && wireMockServer.isRunning()) {
            wireMockServer.stop();
            wireMockServer = null;
        }
    }
}
