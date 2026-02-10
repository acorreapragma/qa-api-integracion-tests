package com.integracionbanrural.tasks;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

import java.util.Map;

import com.integracionbanrural.interactions.ExecuteRequest;
import static net.serenitybdd.screenplay.Tasks.instrumented;


public class EnviarPeticion implements Task {

    public static EnviarPeticion alEndpoint() {
        return instrumented(EnviarPeticion.class);
    }
  
    @Override
    public <T extends Actor> void performAs(T actor) {
        String method = actor.recall("method");
        String endpoint = actor.recall("endpoint");
        Map<String, ?> headers = actor.recall("headers");


        System.out.println("======================================================");
        System.out.println(">> ENVIANDO PETICIÓN HTTP");
        System.out.println(">> Método: " + method);
        System.out.println(">> Endpoint: " + endpoint);
        System.out.println(">> Headers: " + headers);
        System.out.println("======================================================");

        actor.attemptsTo(
            ExecuteRequest.with(endpoint, headers, method)
        );
    }
}