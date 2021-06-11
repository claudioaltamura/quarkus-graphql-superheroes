package de.claudioaltamura.quarkus.graphql;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class SuperheroService {

	private final List<Superhero> superheroes = new ArrayList<>();

	private final List<City> cities = new ArrayList<>();

	public SuperheroService() {
		var gothamCity = new City("Gotham City", "GC");
		cities.add(gothamCity);

		var batman = new Superhero("Batman", gothamCity);
		superheroes.add(batman);

		var newYorkCity = new City("New York", "NYC");
		cities.add(newYorkCity);

		var spiderMan = new Superhero("Spider Man", newYorkCity);
		superheroes.add(spiderMan);
	}

	public List<City> getAllCities() {
		return cities;
	}

	public City getCity(int id) {
		return cities.get(id);
	}

	public List<Superhero> getAllSuperheroes() {
		return superheroes;
	}

	public Superhero getSuperhero(int id) {
		return superheroes.get(id);
	}

	public List<Superhero> getSuperheroesByCity(City city) {
		return superheroes.stream()
				.filter(hero -> hero.getCity().equals(city))
				.collect(Collectors.toList());
	}

	public void addSuperhero(Superhero superhero) {
		superheroes.add(superhero);
	}

	public Superhero deleteSuperhero(int id) {
		return superheroes.remove(id);
	}

	public List<Superhero> getSuperheroesByName(String name) {
		return superheroes.stream()
				.filter(hero -> hero.getName().equals(name))
				.collect(Collectors.toList());
	}

}
