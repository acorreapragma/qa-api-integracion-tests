package com.integracionbanrural.tasks;

import java.util.Map;
import java.util.stream.Collectors;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

import io.cucumber.datatable.DataTable;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class PrepararRequest implements Task {

    private final String endpoint;
    private final DataTable headersTable;

    public PrepararRequest(String endpoint, DataTable headersTable) {
        this.endpoint = endpoint;
        this.headersTable = headersTable;

    }

    public static PrepararRequest with(String endpoint, DataTable headersTable) {
        return instrumented(PrepararRequest.class, endpoint, headersTable);

    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        Map<String, String> headers = headersTable.asMaps(String.class, String.class)
                .stream()
                .collect(Collectors.toMap(
                        row -> row.get("key"),
                        row -> row.get("value")));

        actor.remember("endpoint", endpoint);
        actor.remember("headers", headers);

        stubFor(get(urlEqualTo(endpoint.replace(" ", "%20")))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("""
                                {
                                  "active": true
                                }
                                """)));

    }

}
