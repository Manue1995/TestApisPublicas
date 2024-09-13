package TestApis;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;

public class CreateObject {

    String path ="./Reporte/Apis.html";
    ExtentReports extent = new ExtentReports();
    ExtentSparkReporter spark = new ExtentSparkReporter(path);

    ExtentTest test;





    @Test
    public void createObjects(){

       try {


            extent.attachReporter(spark);
            test = extent.createTest("Prueba2");

            File postbody = new File("src/main/resources/CreateObject.json");

            test.log(Status.INFO, "Paso ruta del body que es" + postbody);

            RequestSpecification request = given()
                    .baseUri("https://api.restful-api.dev")
                    .basePath("/objects")
                    .header("Content-Type", "application/json")
                    .body(postbody);

            Response response = request
                    .when()
                    .post();

            test.log(Status.INFO, "Se realizo el consumo del Api");

            response.prettyPrint();
            int statusCode = response.getStatusCode();
            test.log(Status.INFO, "El status code es :" + statusCode);
            Assert.assertEquals(statusCode, 200);


            test.log(Status.PASS, "Fue exitoso el Test ");

        } catch (Exception e) {

            test.log(Status.FAIL, "Fue fallido el Test " + e);
        }


    }

    @AfterMethod
    public void afterMethod(ITestResult result) {

        if (result.getStatus() == ITestResult.FAILURE) {

            test.log(Status.FAIL, "Fue fallido el Test ");

        } else {

            test.log(Status.PASS, "Fue exitoso el Test ");
        }

        extent.flush();
    }

}
