package de.claudioaltamura.quarkus.graphql.supeheroes;

import de.claudioaltamura.quarkus.graphql.supeheroes.web.SuperHeroTest;
import io.quarkus.test.junit.NativeImageTest;

@NativeImageTest
public class NativeSuperHeroIT extends SuperHeroTest {

    // Execute the same tests but in native mode.
}