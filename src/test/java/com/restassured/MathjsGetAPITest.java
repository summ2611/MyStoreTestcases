package com.restassured;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class MathjsGetAPITest {
    @Test
    public void MathJS_Get_api_Test() {
        Response response = given().header("content-type", "application/json").get("https://api.mathjs.org/v4/?expr=2*100");
        System.out.println("******** " + response.asString());
        Assert.assertEquals(response.statusCode(), 200, "expected 200 but found" + response.statusCode());
        Assert.assertEquals(response.body().asString(), "200", "expected 200 but found" + response.asString());
    }

    @Test
    public void MathJS_Get() {
        RestAssured.baseURI = "https://api.mathjs.org/";
        Response response = given().header("content-type", "application/json").get("/v4/?expr=2*10");
        System.out.println("******** " + response.asString());
        Assert.assertEquals(response.statusCode(), 200, "expected 200 but found" + response.statusCode());
        Assert.assertEquals(response.body().asString(), "20", "expected 20 but found" + response.asString());
    }

    @Test
    public void getAPI() {
        RestAssured.baseURI = "https://api.mathjs.org/";
        Response response = given().header("content-type", "application/json")
                .param("expr", "2*10").get("/v4/");
        System.out.println("******** " + response.asString());
        Assert.assertEquals(response.statusCode(), 200, "expected 200 but found" + response.statusCode());
        Assert.assertEquals(response.body().asString(), "20", "expected 20 but found" + response.asString());
    }

    @DataProvider
    public Object[][] testdatafile() {
        return new Object[][]{
                {"1*2", "2"},
                {"1*3", "3"},
                {"1*4", "4"},
                {"1*5", "5"},
                {"1*6", "6"}
        };
    }

    @Test(dataProvider = "testdatafile")
    public void getAPI2(String expr, String expected) {
        RestAssured.baseURI = "https://api.mathjs.org/";
        Response response = given().header("content-type", "application/json")
                .param("expr", expr).get("/v4/");
        System.out.println("******** " + response.asString());
        Assert.assertEquals(response.statusCode(), 200, "expected 200 but found" + response.statusCode());
        Assert.assertEquals(response.body().asString(), expected, "expected " + expected + " but found" + response.asString());
    }
}
