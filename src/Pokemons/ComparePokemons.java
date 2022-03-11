package Pokemons;

import java.util.ArrayList;
import java.util.logging.Logger;

public class ComparePokemons {
    // this method returns the best pokemon from the first coach
    // and the best pokemon from the second coach,
    // both in an ArrayList
    public static ArrayList<Pokemon> bestTwoPokemons(ArrayList<Pokemon> first, ArrayList<Pokemon> second,
                                                     Logger logger) {
        ArrayList<Pokemon> bestTwo = new ArrayList<>(2);
        int scoreCoach1P1 = pokemonScore(first.get(0));
        int scoreCoach1P2 = pokemonScore(first.get(1));
        int scoreCoach1P3 = pokemonScore(first.get(2));
        int maxScore = scoreCoach1P1;
        Pokemon maxPokemon = first.get(0);
        maxPokemon = getMaxPokemon(first, maxScore, maxPokemon, scoreCoach1P2, scoreCoach1P3);
        bestTwo.add(0, maxPokemon);
        logger.info("The best pokemon from the first coach is " + maxPokemon.getName() + "!");

        int scoreCoach2P1 = pokemonScore(second.get(0));
        int scoreCoach2P2 = pokemonScore(second.get(1));
        int scoreCoach2P3 = pokemonScore(second.get(2));
        maxScore = scoreCoach2P1;
        maxPokemon = second.get(0);
        maxPokemon = getMaxPokemon(second, maxScore, maxPokemon, scoreCoach2P2, scoreCoach2P3);
        bestTwo.add(1, maxPokemon);
        logger.info("The best pokemon from the second coach is " + maxPokemon.getName() + "!");

        return bestTwo;
    }

    // this method finds the pokemon with the maximum score from a list of 3 pokemons
    private static Pokemon getMaxPokemon(ArrayList<Pokemon> pokemonList, int maxScore, Pokemon maxPokemon,
                                         int scoreP2, int scoreP3) {
        // suppose the first pokemon has the maximum score
        // it verifies if the second one has the maximum score
        if(scoreP2 >= maxScore) {
            // in case of equal scores, the pokemon that will be
            // returned will be the smallest in lexicographic order
            if(scoreP2 == maxScore) {
                if(pokemonList.get(1).getName().compareToIgnoreCase(maxPokemon.getName()) < 0) {
                    maxPokemon = pokemonList.get(1);
                }
            } else {
                maxScore = scoreP2;
                maxPokemon = pokemonList.get(1);
            }
        }
        // it then verifies if the third pokemon has the maximum score
        if (scoreP3 >= maxScore) {
            if(scoreP3 == maxScore) {
                if(pokemonList.get(2).getName().compareToIgnoreCase(maxPokemon.getName()) < 0) {
                    maxPokemon = pokemonList.get(2);
                }
            } else {
                maxPokemon = pokemonList.get(2);
            }
        }
        return maxPokemon;
    }

    // this method calculates the score for a pokemon
    private static int pokemonScore(Pokemon pokemon) {
        return pokemon.getHP() + pokemon.getNormalAttack() + pokemon.getSpecialAttack() +
                pokemon.getNormalDefense() + pokemon.getSpecialDefense();
    }
}
