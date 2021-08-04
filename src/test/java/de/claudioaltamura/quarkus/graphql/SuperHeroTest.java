package de.claudioaltamura.quarkus.graphql;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.equalTo;

import java.util.List;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

@QuarkusTest
public class SuperHeroTest {

	@Test
	void test() {
		final Response response = given().
			contentType(ContentType.JSON).
			body("{\"query\":\"{\\n allCities{\\n name\\n}\\n}\"}").
			when().
			post("/graphql").
			then().
			assertThat().
			statusCode(200).
			and().
			extract().
			response();

		final List<City> allCities = response.jsonPath().getList("data.allCities", City.class);
	}

}