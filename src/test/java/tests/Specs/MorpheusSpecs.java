package tests.Specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.with;

public class MorpheusSpecs {
    public static RequestSpecification requestSpec = with()
            .baseUri("https://reqres.in/api/users")
            .log().body()
            .contentType(ContentType.JSON);

    public static ResponseSpecification responsemorpheusSpec = new ResponseSpecBuilder()
            .expectStatusCode(201)
            .build();
}
