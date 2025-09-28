import org.json.JSONObject;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class PostAPI {
    public static void main(String[] args) {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        JSONObject jobj = new JSONObject();
        jobj.put("title", "foo");
        jobj.put("body", "bar");
        jobj.put("userId", 1);

        given()
            .contentType("application/json")
            .body(jobj.toString())
        .when()
            .post("/posts")
        .then()
            .statusCode(201)
            .body("title", equalTo("foo"))
            .body("body", equalTo("bar"))
            .body("userId", equalTo(1));
    }
}
