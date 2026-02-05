    # language: es
    Característica: Consulta de Homologacion

    @HappyPath @SmokeTest
    Escenario: Consulta Exitosa de Homologacion HapyPath
    Dado que tengo el endpoint "/mapping/PartyPersonalData/PUERTO RICO" con los headers validos
      | key              | value            |
      | Accept           | application/json |
      | X-Application    | IC               |
      | X-Channel        | BV-PYMES         |
      | X-Correlation-Id | {{$uuid}}        |
    Cuando envio una solicitud GET
    Entonces la respuesta debe tener un Status Code 200
    Y el body de la respuesta debe contener
      | active    | true |
