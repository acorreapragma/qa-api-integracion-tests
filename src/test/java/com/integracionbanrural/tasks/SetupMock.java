package com.integracionbanrural.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

public class SetupMock implements Task {

    private final String endpoint;
    private final int status;
    private final String body;

    public SetupMock(String endpoint, int status, String body) {
        this.endpoint = endpoint;
        this.status = status;
        this.body = body;
    }

    public static SetupMock forGetRequestTo(String endpoint) {
        return Tasks.instrumented(SetupMock.class, endpoint, 200, "{\"active\": true}");
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        stubFor(get(urlEqualTo(endpoint.replace(" ", "%20")))
                .willReturn(aResponse()
                        .withStatus(status)
                        .withHeader("Content-Type", "application/json")
                        .withBody(body)));
    }
}
