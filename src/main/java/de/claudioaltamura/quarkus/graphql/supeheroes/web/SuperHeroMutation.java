package de.claudioaltamura.quarkus.graphql.supeheroes.web;

import javax.inject.Inject;

import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Mutation;
import org.eclipse.microprofile.graphql.Name;

import de.claudioaltamura.quarkus.graphql.supeheroes.model.Superhero;
import de.claudioaltamura.quarkus.graphql.supeheroes.model.SuperheroInput;
import de.claudioaltamura.quarkus.graphql.supeheroes.service.SuperheroService;

@GraphQLApi
public class SuperHeroMutation {

	@Inject
	SuperheroService superheroService;

	@Mutation
	public Superhero createSuperhero(@Name("superhero") SuperheroInput superheroInput) {
		var superhero = new Superhero(superheroInput.getName(), superheroInput.getCity());
		superheroService.addSuperhero(superhero);
		return superhero;
	}

}
