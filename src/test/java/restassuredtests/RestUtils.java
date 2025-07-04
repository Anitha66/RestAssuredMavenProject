package restassuredtests;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import java.util.Map;
import java.util.UUID;

public class RestUtils {

    // Generate a random first name
    public static String getFirstName() {
        return "CAD" + getRandomAlphaNumeric(5);
    }

    // Generate a random last name
    public static String getLastName() {
        return "User" + getRandomAlphaNumeric(5);
    }

    // Generate a random email
    public static String getEmail() {
        return "user" + getRandomAlphaNumeric(5) + "@example.com";
    }

    // Generate a random phone number
    public static String getPhoneNumber() {
        return "555" + (int)(Math.random() * 10000000);
    }

    // Generate a random alphanumeric string of given length
    public static String getRandomAlphaNumeric(int length) {
        return UUID.randomUUID().toString().replaceAll("-", "").substring(0, length);
    }

    // Send a GET request with optional headers and query params
    public static Response sendGet(RequestSpecification reqSpec, String endpoint, Map<String, String> headers, Map<String, String> queryParams) {
        RequestSpecification request = reqSpec;
        if (headers != null) request = request.headers(headers);
        if (queryParams != null) request = request.queryParams(queryParams);
        return request.get(endpoint);
    }

    // Send a POST request with optional headers, query params, and body
    public static Response sendPost(RequestSpecification reqSpec, String endpoint, Map<String, String> headers, Map<String, String> queryParams, Object body) {
        RequestSpecification request = reqSpec;
        if (headers != null) request = request.headers(headers);
        if (queryParams != null) request = request.queryParams(queryParams);
        if (body != null) request = request.body(body);
        return request.post(endpoint);
    }

    // Extract a value from JSON response using JsonPath
    public static <T> T extractJsonValue(Response response, String jsonPath, Class<T> type) {
        return response.jsonPath().getObject(jsonPath, type);
    }

    // Print formatted response for debugging
    public static void printResponse(Response response) {
        System.out.println("Status Code: " + response.getStatusCode());
        System.out.println("Response Body:\n" + response.prettyPrint());
    }
}