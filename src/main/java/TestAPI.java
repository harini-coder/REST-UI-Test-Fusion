import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import org.json.JSONObject;

public class TestAPI {
    public static void main(String[] args) {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        RequestSpecification request = RestAssured.given();

        JSONObject jobj = new JSONObject();
        jobj.put("title", "foo");
        jobj.put("body", "bar");
        jobj.put("userId", 1);

        request.contentType(ContentType.JSON);
        request.body(jobj.toString());

        Response response = request.request(Method.POST, "/posts");

        System.out.println("Response body:");
        System.out.println(response.getBody().asString());

        System.out.println("Status code:");
        System.out.println(response.getStatusCode());
    }
}
