package restassuredtests;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Demo4_DeleteRequestTest {
 
    @Test
    public void DeletePost() {
        Response response = RestAssured
                            .when()
                            .delete("https://jsonplaceholder.typicode.com/posts/3")
                            .then()
                            .statusCode(200)
                            .log().all() // Log the response for debugging
                            .extract().response();

        System.out.println("Response: " + response.asString());
    }

}
