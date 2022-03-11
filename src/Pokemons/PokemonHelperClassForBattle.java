package Pokemons;

import Coaches.CoachesFight;

import java.util.logging.Logger;

public class PokemonHelperClassForBattle {

    // this method verifies if the command for each pokemon in a battle
    // can be executed or if the action is not in cooldown mode
    public static void checkCommand() {
        boolean ok = false;
        while(!ok) {
            ok = (CoachesFight.firstCommand != 1) || (Game.CoachesBattle.cooldownPokemon1[0] == 0);
            if((CoachesFight.firstCommand == 2) && (Game.CoachesBattle.cooldownPokemon1[1] != 0))
                ok = false;
            if((CoachesFight.secondCommand == 1) && (Game.CoachesBattle.cooldownPokemon2[0] != 0))
                ok = false;
            if((CoachesFight.secondCommand == 2) && (Game.CoachesBattle.cooldownPokemon2[1] != 0))
                ok = false;
            // if ok is false, the program will launch the threads and they will give
            // two new commands that will be again verified until the commands can both
            // be executed safely by the two pokemons in the battle
            if(!ok) {
                Game.CoachesBattle.command = false; // resumes the threads
                try {
                    Thread.sleep(55);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Game.CoachesBattle.command = true;  // pauses the threads
            }
        }
    }

    // this method finds the winner for the battle between two pokemons
    public static void checkWinner(Pokemon pokemonFirstCoach, Pokemon pokemonSecondCoach,
                                    Logger logger) {
        if(Game.CoachesBattle.firstHP <= 0) {
            logger.info("Pokemon " + pokemonSecondCoach.getName() + " wins!");
            logger.info("The second coach wins!");
            logger.info("The pokemon is now boosted");
            PokemonDecorator.boostPokemon(pokemonSecondCoach);
            logger.info(pokemonSecondCoach.toString());
        } else {
            logger.info("Pokemon " + pokemonFirstCoach.getName() + " wins!");
            logger.info("The first coach wins!");
            logger.info("The pokemon is now boosted");
            PokemonDecorator.boostPokemon(pokemonFirstCoach);
            logger.info(pokemonFirstCoach.toString());
        }
    }
}
