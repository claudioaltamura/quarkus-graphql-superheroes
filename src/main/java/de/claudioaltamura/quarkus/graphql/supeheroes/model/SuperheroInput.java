package de.claudioaltamura.quarkus.graphql.supeheroes.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SuperheroInput {
	private String name;
	private City city;
}