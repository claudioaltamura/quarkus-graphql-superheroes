package de.claudioaltamura.quarkus.graphql.supeheroes.web;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;

import de.claudioaltamura.quarkus.graphql.supeheroes.model.City;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

@QuarkusTest
public class SuperheroTest {

	@Test
	void allCities() {
		final Response response = given()
				.contentType(ContentType.JSON)
				.body("{\"query\":\"{\\n allCities{\\n name\\n}\\n}\"}")
				.when()
				.post("/graphql")
				.then()
					.assertThat()
					.statusCode(200)
				.and()
					.extract()
					.response();

		final List<City> allCities = response.jsonPath().getList("data.allCities", City.class);
		assertThat(allCities)
				.isNotEmpty()
				.hasSize(2)
				.extracting(City::getName)
				.contains("Gotham City", "New York City");
	}

}