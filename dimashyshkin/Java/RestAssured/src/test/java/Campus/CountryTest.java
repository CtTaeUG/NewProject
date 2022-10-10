package Campus;

import Campus.Model.Country;
import io.restassured.http.ContentType;
import io.restassured.http.Cookies;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class CountryTest {

    Cookies cookies;
    String countryID;
    String countryName;
    String countryCode;

    @BeforeClass
    public void loginCampus() {

        baseURI = "https://demo.mersys.io/";

        // {"username": "richfield.edu", "password": "Richfield2020!", "rememberMe": "true"}

        Map<String, String> credential = new HashMap<>();
        credential.put("username", "richfield.edu");
        credential.put("password", "Richfield2020!");
        credential.put("rememberMe", "true");

        cookies =
                given()

                        .contentType(ContentType.JSON)
                        .body(credential)

                        .when()
                        .post("auth/login")


                        .then()
                        .log().all()
                        .statusCode(200)
                        .extract().response().getDetailedCookies()

        ;

    }

    @Test
    public void createCountry() {

        countryName = getRandomCountryName();
        countryCode = getRandomCountryCode();

        Country country = new Country();
        country.setName(getRandomCountryName()); // generate country name
        country.setCode(getRandomCountryCode()); // generate country code

        countryID =
                given()
                        .cookies(cookies)
                        .contentType(ContentType.JSON)
                        .body(country)

                        .when()
                        .post("school-service/api/countries")

                        .then()
                        .statusCode(201)
                        .log().body()
                        .extract().jsonPath().get("id")

        ;
    }

    @Test(dependsOnMethods = "createCountry")
    public void createCountryNegative() {

        Country country = new Country();
        country.setName(countryName); // generate country name
        country.setCode(countryCode); // generate country code

        given()
                .cookies(cookies)
                .contentType(ContentType.JSON)
                .body(country)

                .when()
                .post("school-service/api/countries")

                .then()
                .statusCode(400)
                //.log().body()
                .body("message", equalTo("The Country with Name \"" + countryName + "\" already exists"))
        ;
    }

    @Test(dependsOnMethods = "createCountry")
    public void createUpdate() {

        countryName = getRandomCountryName();

        Country country = new Country();
        country.setId(countryID);
        country.setName(countryName);
        country.setCode(countryCode);

        given()
                .cookies(cookies)
                .contentType(ContentType.JSON)
                .body(country)

                .when()
                .put("school-service/api/countries")

                .then()
                .statusCode(200)
                .log().body()
                .body("name", equalTo(countryName))
        ;
    }

    @Test(dependsOnMethods = "createUpdate")
    public void deleteCountryById() {

        given()
                .cookies(cookies)
                .pathParam("countryID", countryID)

                .when()
                .delete("school-service/api/countries/{countryID}")

                .then()
                .log().body()
                .statusCode(200)
        ;
    }

    @Test(dependsOnMethods = "deleteCountryById")
    public void deleteCountryByIdNegative() {

        given()
                .cookies(cookies)
                .pathParam("countryID", countryID)

                .when()
                .delete("school-service/api/countries/{countryID}")

                .then()
                .log().body()
                .statusCode(400)
        ;
    }

    @Test(dependsOnMethods = "deleteCountryById")
    public void updateCountryNegative() {


        countryName = getRandomCountryName();

        Country country = new Country();
        country.setId(countryID);
        country.setName(countryName);
        country.setCode(countryCode);

        given()
                .cookies(cookies)
                .contentType(ContentType.JSON)
                .body(country)

                .when()
                .put("school-service/api/countries")

                .then()
                .log().body()
                .statusCode(400)
                .body("message", equalTo("Country not found"))
        ;
    }

    public String getRandomCountryName() {
        return RandomStringUtils.randomAlphabetic(8).toLowerCase();
    }

    public String getRandomCountryCode() {
        return RandomStringUtils.randomAlphabetic(3).toLowerCase();

    }


}
