package Game;

import Pokemons.EnhancedPokemon;
import Pokemons.Pokemon;
import Pokemons.PokemonFactory;

import java.io.BufferedReader;
import java.io.IOException;

public class BuildPokemon {
    // this method receives the given objects for each pokemon and enhances them
    public static Pokemon build(String string, BufferedReader br, PokemonFactory pokemonFactory) {
        PokemonFactory.PokemonType type = PokemonFactory.PokemonType.valueOf(string);
        Pokemon pokemon = pokemonFactory.returnPokemon(type);

        for(int j = 1; j <= 3; j++) {
            String magicToken = null;
            try {
                magicToken = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            assert magicToken != null;
            EnhancedPokemon.enhance(pokemon, magicToken);
        }

        return pokemon;
    }
}
