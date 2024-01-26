package tek.api.test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import tek.api.modal.TokenRequest;
import tek.api.modal.TokenResponse;
import tek.tdd.base.ApiTestsBase;

import java.util.HashMap;
import java.util.Map;

public class GenerateTokenTest extends ApiTestsBase {
    private static final Logger LOG = LogManager.getLogger(GenerateTokenTest.class);


    @Test
    public void generateToken() {
        TokenRequest requestBody = new TokenRequest("supervisor", "tek_supervisor");
        RequestSpecification request = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(requestBody);
        Response response = request.when()
                .post("/api/token");
        LOG.info("Response info " + response.asPrettyString());
        response.then().statusCode(200);
        TokenResponse tokenResponse = response.as(TokenResponse.class);
        Assert.assertEquals(tokenResponse.getUsername(), "SUPERVISOR", "Validate username");
    }

    @Test
    public void generateTokenNegative() {
        TokenRequest requestBody = new TokenRequest("supervisor", "wrongpass");
       Response response =  RestAssured.given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when().post("/api/token");

       response.then().statusCode(200);
       LOG.info("Response " + response.asPrettyString());

       String errorMessage = response.jsonPath().get("errorMessage");
       Assert.assertEquals(errorMessage, "Password not matched" , "Validate error Message ");
    }

    @Test
    public void validateToken() {
        TokenRequest requestBody = new TokenRequest("supervisor", "tek_supervisor");
        RequestSpecification request = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(requestBody);
        Response response = request.when()
                .post("/api/token");
        LOG.info("Response info " + response.asPrettyString());
        response.then().statusCode(200);
        TokenResponse tokenResponse = response.as(TokenResponse.class);
        Assert.assertEquals(tokenResponse.getUsername(), "SUPERVISOR", "Validate username");

        RestAssured.given().contentType(ContentType.JSON)
                .queryParam("token" , tokenResponse.getToken())
                .queryParam("username", tokenResponse.getUsername())
                .when()
                .get("/api/token/verify")
                .then()
                .statusCode(200);

    }
}
