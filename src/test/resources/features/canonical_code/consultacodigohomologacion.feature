#language: es
Característica: Consulta de Homologacion

@SmokeTest
Escenario: Consulta Exitosa de Homologacion HapyPath
Dado que tengo el endpoint "/mapping/PartyPersonalData/MARRUECOS" con los headers validos:
  | key              | value            |
  | Accept           | application/json |
  | X-Application    | IC               |
  | X-Channel        | BV-PYMES         |
  | X-Correlation-Id | 75e52d2e-6710-4e1f-929f-f55d4cd53474  |
Cuando envio una solicitud GET
Entonces la respuesta debe tener un Status Code 200
Y el body de la respuesta debe contener
  | active    | true |
    