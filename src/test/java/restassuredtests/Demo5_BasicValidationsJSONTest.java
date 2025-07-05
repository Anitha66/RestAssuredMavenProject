package restassuredtests;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;

public class Demo5_BasicValidationsJSONTest {
    // Test Status Code

    @Test(priority = 1)
    public void testStatusCode() {
        RestAssured
            .given()
            .when()
            .get("https://jsonplaceholder.typicode.com/posts/3")
            .then()
            .statusCode(200);
    }

    // Log response
    @Test(priority = 2)
    public void testLogResponse() {
        RestAssured
            .given()
            .when()
            .get("https://jsonplaceholder.typicode.com/posts/3")
            .then()
            .log().all(); // Log the entire response
    }
    // Verifying Single Content in response body
    @Test(priority = 3)
    public void testSingleContent() {
        RestAssured
            .given()
            .when()
            .get("https://jsonplaceholder.typicode.com/posts/3")
            .then()
            .statusCode(200)
            .body("id", equalTo(3));           
    }
    // Verifying Multiple Content in response body
    @Test(priority = 4)
    public void testMultipleContent() {
        RestAssured
            .given()
            .when()
            .get("https://jsonplaceholder.typicode.com/posts/3")
            .then()
            .statusCode(200)
            .body("title", contains("molestias"));
    
}


    // Verifying Content in response header
    @Test(priority = 5)
    public void testHeaderContent() {
        RestAssured
            .given()
            .when()
            .get("https://jsonplaceholder.typicode.com/posts/3")
            .then()
            .statusCode(200)
            .header("Content-Type", "application/json; charset=utf-8");
    }
    // Setting Base URI and Base Path and Headers to the request
    @Test(priority = 6)
    public void testBaseURIAndPath() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
        RestAssured.basePath = "/posts/3";

        RestAssured
            .given()
            .header("Content-Type", "application/json; charset=utf-8")
            .when()
            .get()
            .then()
            .statusCode(200)
            .body("id", equalTo(3));
    }
}