package com.integracionbanrural.questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ValorDelCampo implements Question<Object> {

    private final String campo;

    public ValorDelCampo(String campo) {
        this.campo = campo;
    }

    public static Question<Object> de(String campo) {
        return new ValorDelCampo(campo);
    }

    @Override
    public Object answeredBy(Actor actor) {

         Object valor = SerenityRest.lastResponse()
                                   .jsonPath()
                                   .get(campo);
        
        System.out.println("======================================================");
        System.out.println(">> [QUESTION] Valor de campo en la respuesta");
        System.out.println(">> Actor      : " + actor.getName());
        System.out.println(">> Campo      : " + campo);
        System.out.println(">> Valor      : " + valor);
        System.out.println("======================================================");

        return valor;
    }
}