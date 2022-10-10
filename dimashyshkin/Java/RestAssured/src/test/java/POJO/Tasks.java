package POJO;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Tasks {
    /** Task 1
     * create a request to https://jsonplaceholder.typicode.com/todos/2
     * expect status 200
     * Converitng into POJO
     */

    /*
    {
        "userId": 1,
            "id": 2,
            "title": "quis ut nam facilis et officia qui",
            "completed": false
    }

     */

    @Test
    public void task1() {

        ToDo todo =
        given()

                .when()
                .get("https://jsonplaceholder.typicode.com/todos/2")

                .then()
                //.log().body()
                .statusCode(200)
                .extract().as(ToDo.class)
                ;

        System.out.println("todo = " + todo);


    }

}
