package com.integracionbanrural.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.rest.interactions.Get;

import java.util.Map;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ExecuteGet implements Interaction {

    private final String endpoint;
    private Map<String, String> headers;

    public ExecuteGet(String endpoint) {
        this.endpoint = endpoint;
    }

    public static ExecuteGet to(String endpoint) {
        return instrumented(ExecuteGet.class, endpoint);
    }

    public ExecuteGet withHeaders(Map<String, String> headers) {
        this.headers = headers;
        return this;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource(endpoint)
                        .with(request -> request.headers(headers)));
    }
}
