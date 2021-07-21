package de.claudioaltamura.quarkus.graphql;

import java.util.List;

import javax.inject.Inject;

import org.eclipse.microprofile.graphql.Description;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Mutation;
import org.eclipse.microprofile.graphql.Name;
import org.eclipse.microprofile.graphql.Query;
import org.eclipse.microprofile.graphql.Source;

@GraphQLApi
public class SuperheroResource {

	@Inject
	SuperheroService superheroService;

	@Query("allCities")
	@Description("Get all cities.")
	public List<City> getAllCities() {
		return superheroService.getAllCities();
	}

	@Query
	@Description("Get a City.")
	public City getCity(@Name("cityId") int id) {
		return superheroService.getCity(id);
	}

	@Query
	@Description("Get all superheroes.")
	public List<Superhero> getAllSuperheroes() {
		return superheroService.getAllSuperheroes();
	}

	@Query
	@Description("Get a super hero.")
	public Superhero getSuperhero(@Name("heroId") int id) {
		return superheroService.getSuperhero(id);
	}

	@Mutation
	public Superhero createSuperhero(@Name("superhero") SuperheroInput superheroInput) {
		var superhero = new Superhero(superheroInput.getName(), superheroInput.getCity());
		superheroService.addSuperhero(superhero);
		return superhero;
	}

	public List<Superhero> superheroes(@Source City city) {
		return superheroService.getSuperheroesByCity(city);
	}

}