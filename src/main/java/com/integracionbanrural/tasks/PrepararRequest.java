package com.integracionbanrural.tasks;

import io.cucumber.datatable.DataTable;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import java.util.Map;

public class PrepararRequest implements Task {

    private final String endpoint;
    private final DataTable headers;

    public PrepararRequest(String endpoint, DataTable headers) {
        this.endpoint = endpoint;
        this.headers = headers;
    }

    public static Performable with(String endpoint, DataTable headers) {
        return Tasks.instrumented(PrepararRequest.class, endpoint, headers);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        System.out.println("======================================================");
        System.out.println(">> EJECUTANDO TAREA: PrepararRequest...");
        System.out.println(">> Endpoint recibido: " + endpoint);
        System.out.println(">> Headers recibidos: " + headers.asMap(String.class, String.class));
        System.out.println("======================================================");

        // Guardamos el endpoint en la memoria del actor para que la tarea EnviarPeticion lo use
        actor.remember("endpoint", endpoint);

        Map<String, String> headersMap = headers.asMap(String.class, String.class);

        // Guardamos los headers en la memoria del actor para que la tarea EnviarPeticion los use
        actor.remember("headers", headersMap);

        // Le damos al actor la habilidad de llamar a la API con la URL base
        actor.whoCan(
            CallAnApi.at(actor.recall("baseUrl"))
        );
    }
}