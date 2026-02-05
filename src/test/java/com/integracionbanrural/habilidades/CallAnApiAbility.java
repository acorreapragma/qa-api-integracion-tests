package com.integracionbanrural.habilidades;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Ability;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

public class CallAnApiAbility {

    public static Ability at(String baseUrl) {
        return CallAnApi.at(baseUrl);
    }

    public static Ability atBaseUrl() {
        return CallAnApi.at(SerenityRest.getDefaultBasePath());
    }
}
