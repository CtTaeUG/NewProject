import POJO.Location;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;



public class ZippoTest {


    @Test
    public void test() {

        given()
                // hazırlık işlemleri (token, send body, parametre)

                .when()
                .get("http://api.zippopotam.us/us/90210")
                // link ve metodu veriyoruz

                .then()
                .log().body()
                .statusCode(200)
                .contentType(ContentType.JSON)

        // assertion ve verileri ele alma extract

        ;
    }

    @Test
    public void checkStateInResponseBody() {

        given()

                .when()
                .get("http://api.zippopotam.us/us/90210")

                .then()
                .log().body()
                .body("country", equalTo("United States"))
                .statusCode(200)

        ;
    }

    @Test
    public void bodyJsonPathTest() {

        given()

                .when()
                .get("http://api.zippopotam.us/us/90210")

                .then()
                .log().body()
                .body("places[0].state", equalTo("California"))
                .statusCode(200)

        ;
    }

    @Test
    public void bodyJsonPathTest2() {

        given()

                .when()
                .get("http://api.zippopotam.us/us/90210")

                .then()
                .log().body()
                .body("places.state", equalTo("California"))
                .statusCode(200)
        ;
    }

    @Test
    public void bodyJsonPathTest3() {

        given()

                .when()
                .get("http://api.zippopotam.us/tr/01000")

                .then()
                .log().body()
                .body("places.'place name'", hasItem("Çaputçu Köyü"))
                .statusCode(200)
        ;
    }

    @Test
    public void bodyJsonPathTest4() {

        given()

                .when()
                .get("http://api.zippopotam.us/us/90210")

                .then()
                .log().body()
                .body("places.'place name'", hasSize(1))
                .statusCode(200)
        ;
    }

    @Test
    public void combiningTest() {

        given()

                .when()
                .get("http://api.zippopotam.us/us/90210")

                .then()
                .log().body()
                .body("places.'place name'", hasSize(1))
                .body("places.state", hasItem("California"))
                .body("places[0].state", equalTo("California"))
                .statusCode(200)
        ;
    }

    @Test
    public void pathParamTest() {

        given()

                .pathParam("Country", "us")
                .pathParam("ZipKod", "90210")
                .log().uri()

                .when()
                .get("http://api.zippopotam.us/{Country}/{ZipKod}")

                .then()
                .log().body()

                .statusCode(200)
        ;
    }
    @Test
    public void pathParamTest2() {

        for (int i = 90210; i < 90213; i++) {
            given()

                    .pathParam("Country", "us")
                    .pathParam("ZipKod", i)
                    .log().uri()

                    .when()
                    .get("http://api.zippopotam.us/{Country}/{ZipKod}")

                    .then()
                    .log().body()
                    .body("places", hasSize(1))
                    .statusCode(200)
            ;
        }

    }

    @Test
    public void queryParamTest() {

        given()

                .param("page", 2)
                .log().uri()

                .when()
                .get("https://gorest.co.in/public/v1/users")

                .then()
                .log().body()
                .body("meta.pagination.page", equalTo(1))
                .statusCode(200)
        ;
    }

    @Test
    public void queryParamTest2() {
        for (int pageNo = 0; pageNo < 10; pageNo++) {
            given()

                    .param("page", pageNo)
                    .log().uri()

                    .when()
                    .get("https://gorest.co.in/public/v1/users")

                    .then()
                    .log().body()
                    .body("meta.pagination.page", equalTo(pageNo))
                    .statusCode(200)
            ;
        }
    }

    RequestSpecification requestSpecification;
    ResponseSpecification responseSpecification;

    @BeforeClass
    void Setup(){

        baseURI = "https://gorest.co.in/public/v1";

        requestSpecification = new RequestSpecBuilder()
                .log(LogDetail.URI)
                .setAccept(ContentType.JSON)
                .build();

        responseSpecification = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType(ContentType.JSON)
                .log(LogDetail.BODY)
                .build();
    }

    @Test
    public void requestResponseSpecification() {

        given()
                .param("page", 1)
                .spec(requestSpecification)

                .when()
                .get("/users")

                .then()
                .body("meta.pagination.page", equalTo(1))
                .spec(responseSpecification)
                ;
    }

    @Test
    public void extractingJsonPath() {

        String placeName=
        given()

                .when()
                .get("http://api.zippopotam.us/us/90210")

                .then()
                //.log().body()
                .statusCode(200)
                .extract().path("places[0].'place name'")
        ;

        System.out.println("placeName = " + placeName);
    }

    @Test
    public void extractingJsonPathInt() {

        int limit=
                given()

                        .when()
                        .get("https://gorest.co.in/public/v1/users")

                        .then()
                        //.log().body()
                        .statusCode(200)
                        .extract().path("meta.pagination.limit")
                ;
        Assert.assertEquals(limit, 10);
        System.out.println("limit = " + limit);
    }

    @Test
    public void extractingJsonPathInt2() {

        int id=
                given()

                        .when()
                        .get("https://gorest.co.in/public/v1/users")

                        .then()
                        //.log().body()
                        .statusCode(200)
                        .extract().path("data[2].id")
                ;

        System.out.println("id = " + id);
    }

    @Test
    public void extractingJsonPathIntList() {

        List<Integer> id=
                given()

                        .when()
                        .get("https://gorest.co.in/public/v1/users")

                        .then()
                        //.log().body()
                        .statusCode(200)
                        .extract().path("data.id") // data daki id leri bir list olarak verir
                ;

        System.out.println("id = " + id);
    }

    @Test
    public void extractingJsonPathStingList() {

        List<String> names=
                given()

                        .when()
                        .get("https://gorest.co.in/public/v1/users")

                        .then()
                        //.log().body()
                        .statusCode(200)
                        .extract().path("data.name") // data daki id leri bir list olarak verir
                ;

        System.out.println("names = " + names);
    }

    @Test
    public void extractingJsonPathFullBody() {

        Response body=
                given()

                        .when()
                        .get("https://gorest.co.in/public/v1/users")

                        .then()
                        //.log().body()
                        .statusCode(200)
                        .extract().response()
                ;

        List<Integer> ids = body.path("data.id");
        List<String> names = body.path("data.name");
        System.out.println("names = " + names);
        System.out.println("ids = " + ids);

    }


    @Test
    public void extractingJsonPOJO() {

        Location yer=
                given()

                        .when()
                        .get("http://api.zippopotam.us/us/90210")

                        .then()
                        .extract().as(Location.class)

                ;

        System.out.println("yer = " + yer);

        System.out.println("yer = " + yer.getCountry());
        System.out.println("yer.getPlaces().get(0).getPlacename() = " + yer.getPlaces().get(0).getPlacename());

    }
}

