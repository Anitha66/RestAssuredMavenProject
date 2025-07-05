package restassuredtests;

import java.util.Map;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class Demo3_PUTRequestTest {
    public static Map<String, Object> newUser;
    @BeforeClass
    public void payload() {
        // Create a new user object
         newUser = Map.of(
            "title", "Mr.",
            "body", "Anitha" +RestUtils.getRandomAlphaNumeric(10),
            "userId", RestUtils.getRandomAlphaNumeric(2)
        );

        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
        
    }
    @Test
    public void testCreateUser() {
        Response response = given()
                            .header("Content-type", "application/json") // Set the content type to JSON
                            .and()
                            .body(newUser) // Attach the request body
                            .when()
                            .put("/posts/3") // Specify the endpoint for the POST request
                            .then()
                            .extract().response();

        // Print the response for debugging
        RestUtils.printResponse(response);
    }
}
