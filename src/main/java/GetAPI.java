import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GetAPI {
    public static void main(String[] args) {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        Response response =
            given()                            // GIVEN: request setup (headers, params, etc)
            .when()                           // WHEN: action - GET request
                .get("/posts/1")
            .then()                           // THEN: assertions or extract response
                .statusCode(200)
                .body("userId", equalTo(1))
                .body("id", equalTo(1))
                .body("title", notNullValue())
                .extract()
                .response();

        // Parse response if you want to do something else with it
        JsonPath jp = response.jsonPath();

        System.out.println("Title from response: " + jp.getString("title"));
    }
}
