package tests;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import lombok.Data;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tests.models.Morpheus;
import tests.models.UserData;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.get;
import static io.restassured.http.ContentType.JSON;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static tests.Specs.MorpheusSpecs.requestSpec;
import static tests.Specs.MorpheusSpecs.responsemorpheusSpec;
import static tests.Specs.Specs.request;
import static tests.Specs.Specs.responseSpec;

@Data
public class ApiTests {

  @Test
  @DisplayName("Проверка наличия списка пользователей на странице с помощью Lambok")
  public void lombokListTest() {
       UserData data = given()
                .spec(request)
                .when()
                .get("/api/unknown")
                .then()
                .spec(responseSpec)
                    .log().body()
                    .extract().as(UserData.class);
        assertEquals(1, data.getUser()[0].getId());
    }

    @Test
    @DisplayName("Создание пользователя с именем Morpheus")
    public void CreateMorpheus () {
            Morpheus morpheus = new Morpheus();
            morpheus.setName("morpheus");
            morpheus.setJob("leader");

           given()
                    .spec(requestSpec)
                    .body(morpheus)
                    .when()
                    .post("morpheusdata")
                    .then()
                    .spec(responsemorpheusSpec)
                    .body(matchesJsonSchemaInClasspath("morpheusdata.json"))
                    .extract().as(Morpheus.class);
    }

    @Test
    @DisplayName("Проверка наличия данных на странице с помощью Groovy")
    public void listTestWithGroovy() {
       given()
                .spec(request)
                .when()
                .get("/api/unknown")
                .then()
                .spec(responseSpec)
                .log().body()
                .body("data.findAll{it}.year.flatten()",
                        Matchers.hasItem(2005));
    }

    @BeforeAll
    static void setUp() {
        RestAssured.baseURI = "https://reqres.in/";
        RestAssured.filters(new AllureRestAssured());
    }
    @Test
    @DisplayName("Проверка работоспособности 404 страницы")
    void singleUserNotFound() {
        String response =
                get("/api/users/23")
                        .then()
                        .statusCode(404)
                        .extract().response().asString();

        System.out.println(response);
    }

    @Test
    @DisplayName("Успешная авторизация")
    void loginSuccessful() {
        String data = "{ \"email\": \"eve.holt@reqres.in\", \"password\": \"cityslicka\" }";
        given()
                .contentType(JSON)
                .body(data)
                .when()
                .post("/api/login")
                .then()
                .statusCode(200)
                .body("token", is(notNullValue()));
    }

    @Test
    @DisplayName("Проверка наличия списка пользователей на странице")
    void listUsers() {
        get("/api/users?page=2")
                .then()
                .statusCode(200)
                .body("data", is(notNullValue()));
    }

    @Test
    @DisplayName("Удаление данных о пользователе")
    void deleteTest() {
        String response =
                delete("/api/users/2")
                        .then()
                        .statusCode(204)
                        .extract().response().asString();
        System.out.println(response);
    }
}
