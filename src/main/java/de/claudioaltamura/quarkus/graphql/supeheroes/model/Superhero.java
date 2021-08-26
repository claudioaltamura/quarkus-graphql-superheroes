package de.claudioaltamura.quarkus.graphql.supeheroes.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class Superhero {

	String name;
	City city;

}
