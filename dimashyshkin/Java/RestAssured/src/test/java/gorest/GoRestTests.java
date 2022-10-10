package gorest;

import io.restassured.http.ContentType;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GoRestTests {


    @BeforeClass
    void Setuo(){
        baseURI = "https://gorest.co.in/public/v2/";
    }
    //

    @Test
    public void createUser() {

        int userID=
        given()
                // ap, metoduna gitmeden önceki hazırlıklar: token, gidecek body, paramatreler

                .header("Authorization", "Bearer 55b397c658021df2a9ed5889adf8f475788b687190dd4965aebd6f6f55f3edb0")
                .contentType(ContentType.JSON)
                .body("{\"name\":\"" + getRandomName() +"\", \"gender\":\"male\", \"email\":\"" + getRandomEmail() +"\", \"status\":\"active\"}")

                .when()
                .post("users")

                .then()
                .log().body()
                .statusCode(201)
                .contentType(ContentType.JSON)
                .extract().path("id")
                ;

        System.out.println("userID = " + userID);

    }


    @Test
    public void createUserMap() {


        Map<String, String> newUser = new HashMap<>();
        newUser.put("name", getRandomName());
        newUser.put("gender", "male");
        newUser.put("email", getRandomEmail());
        newUser.put("status", "active");

        int userID=
                given()
                        // ap, metoduna gitmeden önceki hazırlıklar: token, gidecek body, paramatreler

                        .header("Authorization", "Bearer 55b397c658021df2a9ed5889adf8f475788b687190dd4965aebd6f6f55f3edb0")
                        .contentType(ContentType.JSON)
                        .body(newUser)

                        .when()
                        .post("users")

                        .then()
                        .log().body()
                        .statusCode(201)
                        .contentType(ContentType.JSON)
                        .extract().path("id")
                ;

        System.out.println("userID = " + userID);

    }

    int userID=0;

    @Test
    public void createUserObject() {

        User newUser = new User();
        newUser.setName(getRandomName());
        newUser.setGender("male");
        newUser.setEmail(getRandomEmail());
        newUser.setStatus("active");


        userID=
                given()
                        // ap, metoduna gitmeden önceki hazırlıklar: token, gidecek body, paramatreler

                        .header("Authorization", "Bearer 55b397c658021df2a9ed5889adf8f475788b687190dd4965aebd6f6f55f3edb0")
                        .contentType(ContentType.JSON)
                        .body(newUser)

                        .when()
                        .post("users")

                        .then()
                        .log().body()
                        .statusCode(201)
                        .contentType(ContentType.JSON)
                        //.extract().path("id")
                        .extract().jsonPath().getInt("id")
                ;

        System.out.println("userID = " + userID);

    }

    @Test(dependsOnMethods = "createUserObject", priority = 1)
    public void updateUserMap() {

        Map<String,String > updateUser = new HashMap<>();
        updateUser.put("name", "ugur");

                given()
                        // ap, metoduna gitmeden önceki hazırlıklar: token, gidecek body, paramatreler

                        .header("Authorization", "Bearer 55b397c658021df2a9ed5889adf8f475788b687190dd4965aebd6f6f55f3edb0")
                        .contentType(ContentType.JSON)
                        .body(updateUser)
                        .log().body()
                        .pathParam("userID", userID)

                        .when()
                        .put("users/{userID}")

                        .then()
                        .log().body()
                        .statusCode(200)
                        .body("name", equalTo("ugur"))

                ;

        System.out.println("userID = " + userID);

    }

    @Test(dependsOnMethods = "createUserObject", priority = 2)
    public void getUserByID() {

        given()
                // ap, metoduna gitmeden önceki hazırlıklar: token, gidecek body, paramatreler

                .header("Authorization", "Bearer 55b397c658021df2a9ed5889adf8f475788b687190dd4965aebd6f6f55f3edb0")
                .contentType(ContentType.JSON)
                .log().body()
                .pathParam("userID", userID)

                .when()
                .put("users/{userID}")

                .then()
                .log().body()
                .statusCode(200)
                .body("id", equalTo(userID))

        ;

        System.out.println("userID = " + userID);

    }

    @Test(dependsOnMethods = "createUserObject", priority = 3)
    public void deleteUserByID() {

        given()
                // ap, metoduna gitmeden önceki hazırlıklar: token, gidecek body, paramatreler

                .header("Authorization", "Bearer 55b397c658021df2a9ed5889adf8f475788b687190dd4965aebd6f6f55f3edb0")
                .contentType(ContentType.JSON)
                .log().body()
                .pathParam("userID", userID)

                .when()
                .delete("users/{userID}")

                .then()
                .log().body()
                .statusCode(204)

        ;

        System.out.println("userID = " + userID);

    }

    @Test(dependsOnMethods = "deleteUserByID")
    public void deleteUserByIDNegative() {

        given()
                // ap, metoduna gitmeden önceki hazırlıklar: token, gidecek body, paramatreler

                .header("Authorization", "Bearer 55b397c658021df2a9ed5889adf8f475788b687190dd4965aebd6f6f55f3edb0")
                .contentType(ContentType.JSON)
                .log().body()
                .pathParam("userID", userID)

                .when()
                .delete("users/{userID}")

                .then()
                .log().body()
                .statusCode(404)

        ;

        System.out.println("userID = " + userID);

    }

    public String getRandomEmail(){
        return RandomStringUtils.randomAlphabetic(8)+"@gmail.com";
    }

    public String getRandomName(){
        return RandomStringUtils.randomAlphabetic(8);
    }

    class User{

        String name;
        String gender;
        String email;
        String status;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
    }
}
