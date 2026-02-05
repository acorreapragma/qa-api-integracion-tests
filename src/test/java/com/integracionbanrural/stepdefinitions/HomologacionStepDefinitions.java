package com.integracionbanrural.stepdefinitions;

import com.integracionbanrural.questions.ElStatusCode;
import com.integracionbanrural.questions.ValorDelCampo;
import com.integracionbanrural.tasks.EnviarPeticionGet;
import com.integracionbanrural.tasks.PrepararRequest;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import java.util.Map;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;

public class HomologacionStepDefinitions {
        @Dado("que tengo el endpoint {string} con los headers validos")
        public void que_tengo_el_endpoint_con_headers(String endpoint, DataTable dataTable) {
                theActorInTheSpotlight().attemptsTo(PrepararRequest.with(endpoint, dataTable));
        }

        @Cuando("envio una solicitud GET")
        public void envio_una_solicitud_get() {
                theActorInTheSpotlight().attemptsTo(EnviarPeticionGet.aServicio());
        }

        @Entonces("la respuesta debe tener un Status Code {int}")
        public void validar_status_code(Integer statusCode) {
                theActorInTheSpotlight().should(
                                seeThat("el status code", ElStatusCode.es(), equalTo(statusCode)));
        }

        @Y("el body de la respuesta debe contener")
        public void validar_body(DataTable expectedValues) {
                Map<String, String> expectedBody = expectedValues.asMap(String.class, String.class);
                expectedBody.forEach((campo, valorEsperado) -> {
                        theActorInTheSpotlight().should(
                                        seeThat("el valor del campo " + campo, ValorDelCampo.de(campo),
                                                        equalTo(valorEsperado)));
                });
        }
}
