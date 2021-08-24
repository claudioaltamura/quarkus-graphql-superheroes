package de.claudioaltamura.quarkus.graphql.supeheroes;

import de.claudioaltamura.quarkus.graphql.supeheroes.web.SuperheroTest;
import io.quarkus.test.junit.NativeImageTest;

@NativeImageTest
public class NativeSuperheroIT extends SuperheroTest {

    // Execute the same tests but in native mode.
}