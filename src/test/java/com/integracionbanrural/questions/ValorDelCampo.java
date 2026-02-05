package com.integracionbanrural.questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ValorDelCampo implements Question<String> {

    private final String campo;

    public ValorDelCampo(String campo) {
        this.campo = campo;
    }

    public static ValorDelCampo de(String campo) {
        return new ValorDelCampo(campo);
    }

    @Override
    public String answeredBy(Actor actor) {
        Object path = SerenityRest.lastResponse().path(campo);
        return path != null ? path.toString() : null;
    }
}
