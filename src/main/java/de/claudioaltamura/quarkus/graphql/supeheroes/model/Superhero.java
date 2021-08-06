package de.claudioaltamura.quarkus.graphql.supeheroes.model;

import lombok.Data;

@Data
public class Superhero {

	private final String name;
	private final City city;

}
