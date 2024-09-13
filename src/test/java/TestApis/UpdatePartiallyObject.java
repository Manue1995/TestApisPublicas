package TestApis;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;

public class UpdatePartiallyObject {

    @Test
    public void updatePartiallyObjects(){

        File putBody = new File("src/main/resources/patchObject.json");


        RequestSpecification request = given()
                .baseUri("https://api.restful-api.dev")
                .basePath("/objects")
                .header("Content-Type","application/json")
                .body(putBody);


        Response response = request
                .when()
                .patch("/ff80818191df581b0191df7e2dd60084");


        response.prettyPrint();
        int   statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode,200);

    }



}
