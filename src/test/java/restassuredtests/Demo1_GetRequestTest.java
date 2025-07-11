package restassuredtests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*;

public class Demo1_GetRequestTest {

    @Test
    public void testGetUsers() {
        Response response = RestAssured
            .given()
            .when()
            .get("https://jsonplaceholder.typicode.com/posts/3")
            .then()
            .statusCode(200)
            .body("id", equalTo(3))
            .extract().response();

        System.out.println("Response: " + response.asString());
    }
}