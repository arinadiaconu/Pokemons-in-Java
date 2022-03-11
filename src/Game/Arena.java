package Game;

import Pokemons.Pokemon;
import Pokemons.PokemonDecorator;

import java.util.Random;
import java.util.logging.Logger;

public class Arena {
    // Singleton Pattern
    private static Arena singletonInstanceArena;

    public static Arena getSingletonInstance() {
        if(singletonInstanceArena == null) {
            singletonInstanceArena = new Arena();
        }
        return singletonInstanceArena;
    }

    // returns 0, 1 or 2 for the type of event in the arena
    private int randomEvent() {
        Random rand = new Random();
        return rand.nextInt(3);
    }

    public void startDuel(Pokemon pokemonFromFirst, Pokemon pokemonFromSecond,
                           Logger logger) throws CloneNotSupportedException {
        int randomEventNumber;
        // while the pokemons fight with Neutrel1 or Neutrel2
        while((randomEventNumber = randomEvent()) != 2) {
            if(randomEventNumber == 0) {
                // the arena chooses a fight with Neutrel1
                // the pokemons' clones will go into battle
                Pokemon pokemon1 = pokemonFromFirst.clone();
                Pokemon pokemon2 = pokemonFromSecond.clone();
                // the pokemon from the first coach fights with Neutrel 1
                if(FightNeutrel1.fight(pokemon1, logger)) {
                    logger.info("The first coach wins!");
                    logger.info("The pokemon is now boosted");
                    PokemonDecorator.boostPokemon(pokemonFromFirst);
                    logger.info(pokemonFromFirst.toString());
                }
                // the pokemon from the second coach fights with Neutrel 1
                if(FightNeutrel1.fight(pokemon2, logger)) {
                    logger.info("The second coach wins!");
                    logger.info("The pokemon is now boosted");
                    PokemonDecorator.boostPokemon(pokemonFromSecond);
                    logger.info(pokemonFromSecond.toString());
                }
            } else if (randomEventNumber == 1) {
                //the arena chooses a fight with Neutrel2
                Pokemon pokemon1 = pokemonFromFirst.clone();
                Pokemon pokemon2 = pokemonFromSecond.clone();
                // the pokemon from the first coach fights with Neutrel 2
                if(FightNeutrel2.fight(pokemon1, logger)) {
                    logger.info("The first coach wins!");
                    logger.info("The pokemon is now boosted");
                    PokemonDecorator.boostPokemon(pokemonFromFirst);
                    logger.info(pokemonFromFirst.toString());
                }
                // the pokemon from the second coach fights with Neutrel 2
                if(FightNeutrel2.fight(pokemon2, logger)) {
                    logger.info("The second coach wins!");
                    logger.info("The pokemon is now boosted");
                    PokemonDecorator.boostPokemon(pokemonFromSecond);
                    logger.info(pokemonFromSecond.toString());
                }
            }
        }
        // the arena chooses the battle between coaches
        // this event will be the last in the arena
        CoachesBattle.battle(pokemonFromFirst, pokemonFromSecond, logger);
    }
}
