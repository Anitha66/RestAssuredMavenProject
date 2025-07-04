package restassuredtests;
import java.util.Map;
import java.util.Random;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;
public class Demo2_PostRequestTest {

    public static Map<String, Object> newUser;
    
    @BeforeClass
    public void payload() {
        // Create a new user object
         newUser = Map.of(
            "title", "Mr.",
            "body", RestUtils.getRandomAlphaNumeric(10),
            "userId", RestUtils.getRandomAlphaNumeric(2)
        );

        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
        RestAssured.basePath = "/users";
    }
    @Test
    public void testCreateUser() {
        Response response = given()
                            .header("Content-type", "application/json") // Set the content type to JSON
                            .and()
                            .body(newUser) // Attach the request body
                            .when()
                            .post("/posts") // Specify the endpoint for the POST request
                            .then()
                            .extract().response();

        // Print the response for debugging
        RestUtils.printResponse(response);
    }
    
}