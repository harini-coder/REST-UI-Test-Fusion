import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetAPI {
    public static void main(String[] args) {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        RequestSpecification request = RestAssured.given();

        // Make GET request to /posts/1
        Response response = request.get("/posts/1");

        System.out.println("Response body:");
        System.out.println(response.getBody().asString());

        System.out.println("Status code:");
        System.out.println(response.getStatusCode());
    }
}
