package com.restassured;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;

public class MathjsPOSTAPITest {

    @Test
    public void ApiTest1() {
        RestAssured.baseURI="https://api.mathjs.org";
        String reqBody = "{\n" +
                "    \"expr\": [\n" +
                "      \"a = ((2+3) * (5/1)) - (3-2*7/2+2-1(9*9))\"\n" +
                "    \n" +
                "    ],\n" +
                "    \"precision\": 5\n" +
                "  }";
        Response postResponse = given().header("content-type", "application/json")
        .body(reqBody).post("/v4/");
        System.out.println(postResponse.statusCode());
        System.out.println(postResponse.getBody().asString());
        Assert.assertEquals(postResponse.getStatusCode(),200,"Expected 200"+postResponse.getStatusCode());
       // Assert.assertEquals(postResponse.jsonPath().get("result").asString(),88);
    }

    @Test
    public void ApiTest2() {
        RestAssured.baseURI="https://api.mathjs.org";
        JSONObject requestParams = new JSONObject();
        requestParams.put("expr","a = 1.2 * (2 + 4.5)");
        requestParams.put("precision",2);
        System.out.println(requestParams);
        System.out.println(requestParams.toJSONString());
        System.out.println(requestParams.toString());
        Response postResponse = given().header("content-type", "application/json")
                .body(requestParams).post("/v4/");
        System.out.println(postResponse.statusCode());
        System.out.println(postResponse.jsonPath().get("result").toString());
        //Assert.assertEquals(postResponse.getStatusCode(),200,"Expected 200"+postResponse.getStatusCode());
    }

    @Test
    public void simplejsontest() {
        RestAssured.baseURI="https://api.mathjs.org";
        JSONObject requestBody = new JSONObject();
        JSONArray exprArr = new JSONArray();
        exprArr.add("a=1");
        exprArr.add("a-1");
        requestBody.put("expr",exprArr);
        requestBody.put("precision",1);

         Response postResponse=given().header("content-type", "application/json")
                .body(requestBody.toString()).post("/v4/");
        //System.out.println(requestBody.toJSONString());
        System.out.println("------"+postResponse.asString());
        Assert.assertEquals(postResponse.statusCode(),200);
       // JSONObject responseBody = (JSONObject) postResponse.toString();
       ArrayList expRes= postResponse.jsonPath().get("result");
       Assert.assertEquals(expRes.get(0).toString(),"1");
       Assert.assertEquals(expRes.get(1).toString(),"0");
       Assert.assertEquals(postResponse.jsonPath().get("error").toString(),null);
    }
    /*
   @Test
   public void ApiTest2() {
       RestAssured.baseURI = "https://api.mathjs.org";
       String reqBody = "{\n" +
               "    \"expr\": [\n" +
               "      \"a = (2+3) * (5/1)\"\n" +
               "    \n" +
               "    ],\n" +
               "    \"precision\": 5\n" +
               "  }";
       Response postResponse = given().header("content-type", "application/json")
               .body(reqBody).post("/v4/");
       System.out.println(postResponse.statusCode());
       System.out.println(postResponse.getBody().asString());
       Assert.assertEquals(postResponse.getStatusCode(), 200, "Expected 200" + postResponse.getStatusCode());
   }
    @Test
    public void ApiTest3() {
        RestAssured.baseURI = "https://api.mathjs.org";
        String reqBody = "{\n" +
                "    \"expr\": [\n" +
                "      \"Infinity * Infinity\"\n" +
                "    ],\n" +
                "    \"precision\": 5\n" +
                "  }";
        Response postResponse = given().header("content-type", "application/json")
                .body(reqBody).post("/v4/");
        System.out.println(postResponse.statusCode());
        System.out.println(postResponse.getBody().asString());
        Assert.assertEquals(postResponse.getStatusCode(), 200, "Expected 200" + postResponse.getStatusCode());
    }
    @Test
    public void ApiTest4() {
        RestAssured.baseURI = "https://api.mathjs.org";
        String reqBody = "{\n" +
                "    \"expr\": [\n" +
                "      \"a = log(1)\"\n" +
                "    \n" +
                "    ],\n" +
                "    \"precision\": 5\n" +
                "  }";
        Response postResponse = given().header("content-type", "application/json")
                .body(reqBody).post("/v4/");
        System.out.println(postResponse.statusCode());
        System.out.println(postResponse.getBody().asString());
        Assert.assertEquals(postResponse.getStatusCode(), 200, "Expected 200" + postResponse.getStatusCode());
    }
    @Test
    public void ApiTest5() {
        RestAssured.baseURI = "https://api.mathjs.org";
        String reqBody = "{\n" +
                "    \"expr\": [\n" +
                "      \"a = 7567886 * 774653686979\"\n" +
                "    ],\n" +
                "    \"precision\": 5\n" +
                "  }";
        Response postResponse = given().header("content-type", "application/json")
                .body(reqBody).post("/v4/");
        System.out.println(postResponse.statusCode());
        System.out.println(postResponse.getBody().asString());
        Assert.assertEquals(postResponse.getStatusCode(), 200, "Expected 200" + postResponse.getStatusCode());
    }
    @Test
    public void ApiTest6() {
        RestAssured.baseURI = "https://api.mathjs.org";
        String reqBody = "{\n" +
                "    \"expr\": [\n" +
                "      \"a = 1.2 * (2 + 4.5)\",\n" +
                "      \"a / 2\",\n" +
                "      \"a/0\",\n" +
                "      \"0/a\",\n" +
                "      \"b=7*9\",\n" +
                "      \"sqrt(b)\",\n" +
                "      \"cube(b)\",\n" +
                "      \"sin(45)\",\n" +
                "      \"c= (1-2)*(2-1)/1\"\n" +
                "    ],\n" +
                "    \"precision\": 5\n" +
                "  }";
        Response postResponse = given().header("content-type", "application/json")
                .body(reqBody).post("/v4/");
        System.out.println(postResponse.statusCode());
        System.out.println(postResponse.getBody().asString());
        Assert.assertEquals(postResponse.getStatusCode(), 200, "Expected 200" + postResponse.getStatusCode());
    }*/
}
