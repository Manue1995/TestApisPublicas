package TestApis;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetSingleObject {




    @Parameters({"id","ExpecteStatusCode"})
    @Test
    public void getSingleObjects(String id, int ExpecteStatusCode){


        RequestSpecification request = given()
                .baseUri("https://api.restful-api.dev")
                .basePath("/objects");


        Response response = request
                .when()
                .get(id); //Trae el objeto con el id"4"

        response.prettyPrint();
        int   statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode,ExpecteStatusCode);


       /* JSONObject jsonResponse = new JSONObject(response.asString());
        String name = jsonResponse.getString("name");  // Extrae la informacion segun paramaetrizada en la llave
        System.out.println(name);

        JSONObject jsonData =  jsonResponse.getJSONObject("data");
        String cpuModel =  jsonData.getString("CPU model");
        System.out.println(cpuModel);

          */
    }




}
