package com.integracionbanrural.hooks;

import io.cucumber.java.Before;
import net.serenitybdd.model.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.model.environment.SystemEnvironmentVariables;
import net.thucydides.model.util.EnvironmentVariables;

public class SerenityHooks {

    @Before
    public void setTheStage() {

        OnStage.setTheStage(new OnlineCast());

        EnvironmentVariables environmentVariables =
                SystemEnvironmentVariables.createEnvironmentVariables();

        String baseUrl = EnvironmentSpecificConfiguration
                .from(environmentVariables)
                .getProperty("rest.base.url");

        System.out.println("======================================================");
        System.out.println(">> EJECUTANDO HOOK @Before (Screenplay)");
        System.out.println(">> Base URL configurada: " + baseUrl);
        System.out.println("======================================================");

        SerenityRest.useRelaxedHTTPSValidation();

        OnStage.theActorCalled("QA")
                .whoCan(CallAnApi.at(baseUrl))   // 🔥 CLAVE
                .remember("baseUrl", baseUrl);
    }
}