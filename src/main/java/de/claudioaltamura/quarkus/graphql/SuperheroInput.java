package de.claudioaltamura.quarkus.graphql;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SuperheroInput {
	private String name;
	private City city;
}