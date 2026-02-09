package com.integracionbanrural.questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ElStatusCode implements Question<Integer> {

    public static Question<Integer> es() {
        return new ElStatusCode();
    }

    @Override
    public Integer answeredBy(Actor actor) {
        
        System.out.println(">> AQUI SI ENTRA");

        int statusCode = SerenityRest.lastResponse().statusCode();

        System.out.println("======================================================");
        System.out.println(">> [QUESTION] Status Code de la respuesta");
        System.out.println(">> Actor        : " + actor.getName());
        System.out.println(">> Status Code  : " + statusCode);
        System.out.println("======================================================");
        
        return SerenityRest.lastResponse().statusCode();

    }
}
