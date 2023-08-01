package in.reqres.tests;

import in.reqres.models.CreateUserModel;
import in.reqres.models.CreateUserResponseModel;
import in.reqres.models.UpdateUserModel;
import in.reqres.models.UpdateUserResponseModel;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static in.reqres.specs.ReqresApiSpecs.*;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReqresApiTests {

    @BeforeAll
    static public void setUp() {
        RestAssured.baseURI = "https://reqres.in";
    }

    @Test
    void createUserTest() {

        CreateUserModel userData = new CreateUserModel();
        userData.setName("morpheus");
        userData.setJob("leader");

        CreateUserResponseModel createUserResponse = step("Make request", () ->
            given(userRequestSpec)
                .body(userData)
                .when()
                .post("users")
                .then()
                .spec(createUserResponseSpec)
                .extract().as(CreateUserResponseModel.class));

        step("Check response", () -> {
            assertEquals("morpheus", createUserResponse.getName());
            assertEquals("leader", createUserResponse.getJob());
        });
    }

    @Test
    void updateUserTest() {

        UpdateUserModel userData = new UpdateUserModel();
        userData.setName("morpheus");
        userData.setJob("zion resident");

        UpdateUserResponseModel updateUserResponse = step("Make request", () ->
            given(userRequestSpec)
                .body(userData)
                .when()
                .put("users/2")
                .then()
                .spec(updateUserResponseSpec)
                .extract().as(UpdateUserResponseModel.class));

        step("Check response", () -> {
            assertEquals("morpheus", updateUserResponse.getName());
            assertEquals("zion resident", updateUserResponse.getJob());

        });
    }

    @Test
    void getUsersListTest() {

        given()
                .log().uri()
                .log().method()
                .log().body()
                .when()
                .get("/api/users?page=2")
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .body("data.size()", is(6))
                .body("data.id", everyItem(notNullValue()));
    }

    @Test
    void deleteUserTest() {

        given()
                .log().uri()
                .log().method()
                .log().body()
                .when()
                .delete("/api/users/2")
                .then()
                .log().status()
                .log().body()
                .statusCode(204);
    }

    @Test
    void singleUserNotFoundTest() {

        given()
                .log().uri()
                .log().method()
                .log().body()
                .when()
                .get("/api/users/23")
                .then()
                .log().status()
                .log().body()
                .statusCode(404);
    }
}
