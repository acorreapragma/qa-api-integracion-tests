package com.integracionbanrural.tasks;

import com.integracionbanrural.habilidades.CallAnApiAbility;
import com.integracionbanrural.interactions.ExecuteGet;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

import java.util.Map;

public class EnviarPeticionGet implements Task {

    public static EnviarPeticionGet aServicio() {
        return Tasks.instrumented(EnviarPeticionGet.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.whoCan(CallAnApiAbility.atBaseUrl());

        String endpoint = actor.recall("endpoint");
        Map<String, String> headers = actor.recall("headers");

        actor.attemptsTo(
                ExecuteGet.to(endpoint).withHeaders(headers)
        );
    }
}
