package TestApis;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetWhitParams {



    @Test
    public void getWhitParames(){


        RequestSpecification request = given()
                .baseUri("https://api.restful-api.dev")
                .basePath("/objects")
                .formParam("id","1")
                .formParam("id","2"); // o con esta linea formParam("id",4,5);


        Response response = request
                .when()
                .get(); //Trae el objeto con el id"4"


        response.prettyPrint();
        int   statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode,200);

    }

}
