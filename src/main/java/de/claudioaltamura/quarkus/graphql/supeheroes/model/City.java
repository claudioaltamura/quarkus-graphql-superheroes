package de.claudioaltamura.quarkus.graphql.supeheroes.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class City {
	String name;
	String symbol;
}
