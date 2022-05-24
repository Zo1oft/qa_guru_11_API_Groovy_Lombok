package tests;

import io.restassured.RestAssured;
import lombok.Data;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.get;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

@Data
public class ApiTests {

    @BeforeAll
    static void setUp() {
        RestAssured.baseURI = "https://reqres.in/";
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
