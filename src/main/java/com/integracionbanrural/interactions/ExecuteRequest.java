package com.integracionbanrural.interactions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.rest.interactions.Delete;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.serenitybdd.screenplay.rest.interactions.Post;
import net.serenitybdd.screenplay.rest.interactions.Put;

import io.restassured.specification.RequestSpecification;
import java.util.Map;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ExecuteRequest implements Interaction {

    private final String endpoint;
    private final Map<String, ?> headers;
    private final String method;
    private Object body;

    public ExecuteRequest(String endpoint, Map<String, ?> headers, String method) {
        this.endpoint = endpoint;
        this.headers = headers;
        this.method = method;
    }

    public static ExecuteRequest with(String endpoint, Map<String, ?> headers, String method) {
        return instrumented(ExecuteRequest.class, endpoint, headers, method);
    }

    public ExecuteRequest andBody(Object body) {
        this.body = body;
        return this;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        System.out.println("=== ExecuteRequest.performAs EJECUTADO ===");
        System.out.println("Actor: " + actor.getName());
        System.out.println("HTTP Method: " + method);
        System.out.println("Endpoint: " + endpoint);
        System.out.println("Headers: " + headers);
        System.out.println("Body: " + body);
        System.out.println("======================================================");

        switch (method.toUpperCase()) {
            case "GET":
                System.out.println(">>> Ejecutando GET");
                actor.attemptsTo(Get.resource(endpoint).with(request -> {
                    request.headers(headers);
                    if (body != null) {
                        request.body(body);
                    }
                    return request;
                }));
                break;
            case "POST":
                actor.attemptsTo(Post.to(endpoint).with(request -> {
                    request.headers(headers);
                    if (body != null) {
                        request.body(body);
                    }
                    return request;
                }));
                break;
            case "PUT":
                actor.attemptsTo(Put.to(endpoint).with(request -> {
                    request.headers(headers);
                    if (body != null) {
                        request.body(body);
                    }
                    return request;
                }));
                break;
            case "DELETE":
                actor.attemptsTo(Delete.from(endpoint).with(request -> {
                    request.headers(headers);
                    if (body != null) {
                        request.body(body);
                    }
                    return request;
                }));
                break;
            default:
                throw new IllegalArgumentException("Método HTTP no soportado: " + method);
        }
        System.out.println(">>> RESPONSE AFTER CALL = " + SerenityRest.lastResponse());
    }
}
