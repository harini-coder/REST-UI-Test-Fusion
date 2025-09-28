import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;

public class PutAPI {
    public static void main(String[] args) {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        RequestSpecification request = RestAssured.given();

        JSONObject jobj = new JSONObject();
        jobj.put("id", 1);
        jobj.put("title", "updated title");
        jobj.put("body", "updated body");
        jobj.put("userId", 1);

        request.contentType(ContentType.JSON);
        request.body(jobj.toString());

        // PUT request to update resource at /posts/1
        Response response = request.put("/posts/1");

        System.out.println("Response body:");
        System.out.println(response.getBody().asString());

        System.out.println("Status code:");
        System.out.println(response.getStatusCode());
    }
}
